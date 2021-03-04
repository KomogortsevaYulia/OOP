package com.company;
//абстрактный класс(родитель)
public abstract class Transport {
    //поля и метод абстрактного класса,их наследуют дети и внуки
    protected String condition;
    protected int speed;
    public  abstract String OutputInfo();
    protected int id;
    //конструктор по умолчанию
    public Transport(){
        this.id=count;
        count++;
    }
    private static int count=1;
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
    public void setCondition(String condition) {
        this.condition = condition;
    }

}
