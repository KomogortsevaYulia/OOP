package com.company.Logic;

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
