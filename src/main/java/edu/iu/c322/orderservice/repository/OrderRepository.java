package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();


    public Order findByCustomerId(int id) {
        return orders.stream().filter(x -> x.getCustomerId() == id).findAny().orElse(null);
    }

    public int create(Order order){
        int id = orders.size() + 1;
        order.setCustomerId(id);
        orders.add(order);
        return id;
    }

//    public void update(Order order, int id){
//        Order x = findByCustomerId(id);
//        if (x != null){
//            x.setName(order.getName());
//            x.setEmail(order.getEmail());
//        } else {
//            throw new IllegalStateException("customer id is not valid");
//        }
//    }

    public void delete(int id){
        Order x = findByCustomerId(id);
        if(x != null){
            orders.remove(x);
        } else {
            throw new IllegalStateException("customer id is not valid");
        }
    }
}
