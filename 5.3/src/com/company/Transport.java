package com.company;

public abstract class Transport {
    //поля и метод абстрактного класса,их наследую дети и внуки
    protected String condition;
    protected int speed;
    public  abstract String[] OutputInfo();
    protected int id;
    //конструктор по умолчанию
    public Transport(){
        this.id=count;
        count++;
    }
    private static int count=0;
    //геттеры и сеттеры
    public int getId() {
        return id;
    }
    public int getSpeed() {
        return speed;
    }
    public String getCondition() {
        return condition;
    }
}
