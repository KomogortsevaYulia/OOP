package com.company;
//класс внук по отношению к классу Transport
//класс-ребенок по отношению к классу TrainTransport
public class ExpressTrain extends TrainTransport {
    //все поля наслудуются от TrainTransport
    //конструктор с параметром
    public ExpressTrain(int number, String type, int carriage, String condition, int speed) {
        super(number, type, carriage, condition, speed);
    }
    //переопределенный метод для вывода информации
    @Override
    public String OutputInfo() {
        StringBuilder str=new StringBuilder("Экспресс-поезд     ");
        str.append("Номер экпресса: "+this.getNumber()+";  ");
        str.append("Тип: "+this.getType()+";  ");
        str.append("Количество вагонов: "+this.getCarriage()+";  ");
        str.append("Состояние: "+this.getCondition()+";  ");
        str.append("Средняя скорость: "+this.getSpeed()+";  ");
        return str.toString();
    }

}