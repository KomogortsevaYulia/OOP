package com.company;
//класс -ребенок по отношению к классу Transport
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
    public String OutputInfo() {
        StringBuilder str=new StringBuilder("Поезд   ");
        str.append("Номер поезда: "+this.getNumber()+";  ");
        str.append("Тип: "+this.getType()+";  ");
        str.append("Количество вагонов: "+this.getCarriage()+";  ");
        str.append("Состояние: "+this.getCondition()+";  ");
        str.append("Средняя скорость: "+this.getSpeed()+";  ");
        return str.toString();
    }
}
