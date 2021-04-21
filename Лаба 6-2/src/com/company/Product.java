package com.company;

public class Product {
    private int id;
    private String name;
    private float price;

    public Product(int Id,String Name,float Price){
        this.id=Id;
        this.name=Name;
        this.price=Price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
}
