package com.company;

public class Deliveries {
    private int id;
    private String distributor;
    private Product product;
    private String producer;
    private int number;

    Deliveries(int id,String distributor,Product product,String producer,int number){
        this.id=id;
        this.distributor=distributor;
        this.product=product;
        this.producer=producer;
        this.number=number;
    }

    public Product getProduct() {
        return product;
    }

    public String getDistributor() {
        return distributor;
    }

    public int getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
