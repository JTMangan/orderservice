package edu.iu.c322.orderservice.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

public class Item {
    @NotEmpty(message = "name cannot be empty.")
    private String name;
    private int itemId;
    private int quantity;
    private int price;

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity && itemId == item.itemId && price == item.price && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, itemId, quantity, price);
    }
}
