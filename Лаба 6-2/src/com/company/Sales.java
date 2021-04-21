package com.company;

public class Sales {

    private int id;
    private Product product;
    private String data;
    private int quantity;
    private float sum;

    public Sales(int Id,Product pr,String Data,int Quantity){
        this.id=Id;
        this.product=pr;
        this.data=Data;
        this.quantity=Quantity;
        this.sum=Quantity*pr.getPrice();
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getData() {
        return data;
    }

    public float getSum() {
        return sum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
