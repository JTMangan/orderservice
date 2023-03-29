package edu.iu.c322.orderservice.model;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;

public class Order {
    private int customerId;
    private float total;
    @Valid
    private Address shippingAddress;
    private List<Item> Items;
    @Valid
    private Payment payment;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return Items;
    }

    public void setItems(List<Item> items) {
        Items = items;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return customerId == order.customerId && Float.compare(order.total, total) == 0 && shippingAddress.equals(order.shippingAddress) && Items.equals(order.Items) && payment.equals(order.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, total, shippingAddress, Items, payment);
    }
}
