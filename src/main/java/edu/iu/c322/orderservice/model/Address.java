package edu.iu.c322.orderservice.model;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private String state;

    private String city;
    private int postalCode;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return postalCode == address.postalCode && state.equals(address.state) && city.equals(address.city) && id == address.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, city, postalCode);
    }
}
