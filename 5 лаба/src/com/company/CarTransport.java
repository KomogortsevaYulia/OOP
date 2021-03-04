package com.company;
//класс -ребенок по отношению к классу Transport
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
    public String OutputInfo() {
        StringBuilder str=new StringBuilder("Автомобиль    ");
        str.append("Модель: "+this.getModel()+";  ");
        str.append("Год выпуска: "+this.getYears()+";  ");
        str.append("Состояние: "+this.getCondition()+";  ");
        str.append("Средняя скорость: "+this.getSpeed()+";  ");
        return  str.toString();
    }
}
