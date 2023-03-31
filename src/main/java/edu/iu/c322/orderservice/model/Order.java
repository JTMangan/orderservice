package edu.iu.c322.orderservice.model;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;

public class Order {
    private int orderId;
    private float total;
    @Valid
    private Address shippingAddress;
    private List<Item> items;
    @Valid
    private Payment payment;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void refundItem(int itemId, String reason){
        Item item = items.stream().filter(x -> x.getItemId() == itemId).findAny().orElse(null);
        if(item != null){
            System.out.println(item.getName() + " is being refunded for $" + (item.getPrice()*item.getQuantity()));
            System.out.println("Refund reason: " + reason);
            items.remove(item);
        } else {
            throw new IllegalStateException("item id is not valid");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Float.compare(order.total, total) == 0 && shippingAddress.equals(order.shippingAddress) && items.equals(order.items) && payment.equals(order.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, total, shippingAddress, items, payment);
    }
}
