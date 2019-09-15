package com.yang.order.entity;


public class Menu {
    private long id;
    private String name;
    private double price;
    private String flavor;
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Menu(long id, String name, double price, String flavor, Type type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.flavor = flavor;
        this.type = type;
    }

    public Menu() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
