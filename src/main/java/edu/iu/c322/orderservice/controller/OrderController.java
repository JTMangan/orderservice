package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.model.Item;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.model.Refund;
import edu.iu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository repository;

    public OrderController(OrderRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Order> findAll(){
        return repository.findAll();
    }
    @GetMapping("/order/{id}")
    public Optional<Order> findByOrderId(@PathVariable int id){
        return repository.findById(id);
    }

    @GetMapping("/{customer_id}")
    public List<Order> findByCustomerId(@PathVariable int customer_id){
        List<Order> orders = repository.findByCustomerId(customer_id);
        return orders;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@Valid @RequestBody Order order) {
        for(int i = 0; i < order.getItems().size(); i++){
            order.getItems().get(i).setOrder(order);
        }

        Order newOrder = repository.save(order);
        return newOrder.getOrderId();
    }

    @PutMapping("/return")
    public void update(@Valid @RequestBody Refund refund){
        Optional<Order> optionalOrder = this.findByOrderId(refund.getOrder_id());
        Order order = optionalOrder.orElse(null);
        if (!order.equals(null)) {
            List<Item> newItems = order.getItems();
            newItems.remove(newItems.stream().filter(x -> x.getId() == refund.getItem_id()).findAny().orElse(null));
            System.out.println(newItems.size());
            System.out.println(refund.getReason());
            order.setItems(newItems);
            repository.save(order);
        }
    }

    @DeleteMapping("/order/{id}")
    public void delete(@PathVariable int id){
        Optional<Order> optionalOrder = this.findByOrderId(id);
        Order order = optionalOrder.orElse(null);
        if (!order.equals(null)) {
            repository.delete(order);
        }
    }
}
