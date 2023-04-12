package edu.iu.c322.orderservice.model;

import java.util.Objects;

public class Refund {
    int order_id;
    int item_id;
    String reason;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refund aReturn = (Refund) o;
        return order_id == aReturn.order_id && item_id == aReturn.item_id && reason.equals(aReturn.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, item_id, reason);
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
