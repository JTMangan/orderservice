package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.model.Refund;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository {
    private List<Order> orders = new ArrayList<>();


    public Order findByOrderId(int id) {
        return orders.stream().filter(x -> x.getOrderId() == id).findAny().orElse(null);
    }

    public int create(Order order){
        int id = orders.size() + 1;
        order.setOrderId(id);
        orders.add(order);
        return id;
    }

    public void update(Refund refund){
        Order x = findByOrderId(refund.getOrder_id());
        if (x != null){
            x.refundItem(refund.getItem_id(), refund.getReason());
        } else {
            throw new IllegalStateException("order id is not valid");
        }
    }

    public void delete(int id){
        Order x = findByOrderId(id);
        if(x != null){
            orders.remove(x);
        } else {
            throw new IllegalStateException("customer id is not valid");
        }
    }
}
