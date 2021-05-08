package com.example.demoAutorisa;

public class Cart {
    private String name;
    private int quantity;

    public Cart(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Cart() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
