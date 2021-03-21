package com.company.Logic;

public class TrainTransport extends Transport {
    //поля класса TrainTransport
    protected String type;
    protected int carriage;
    protected int number;
    //конструктор с параметром
    public TrainTransport(int number,String type,int carriage,String condition,int speed){
        this.number=number;
        this.type=type;
        this.carriage=carriage;
        this.condition=condition;
        this.speed=speed;
    }
    //геттеры
    public String getType() {
        return type;
    }
    public int getNumber() {
        return number;
    }
    public int getCarriage() {
        return carriage;
    }

    //переопределенный метод для вывода информации
    @Override
    public String[] OutputInfo() {
        String [] str=new String[5];
        str[0]=String.valueOf(this.getNumber());
        str[1]=this.getType();
        str[2]=String.valueOf(this.getCarriage());
        str[3]=this.getCondition();
        str[4]=String.valueOf(this.getSpeed());
        return str;
    }
}
