package com.company.Logic;

public class CarTransport extends Transport {
    //поля класса CarTransport
    protected int years;
    protected String model;
    //геттеры
    public String getModel() {
        return model;
    }
    public int getYears() {
        return years;
    }
    //конструктор с пармаметром
    public CarTransport(String model, int years, String condition, int speed) {
        this.model=model;
        this.years=years;
        this.condition=condition;
        this.speed=speed;
    }
    //переопределенный метод для вывода информации
    @Override
    public String[] OutputInfo() {
        String [] str=new String[4];
        str[0]=this.getModel();
        str[1]=String.valueOf(this.getYears());
        str[2]=this.getCondition();
        str[3]=String.valueOf(this.getSpeed());
        return str;
    }
}
