package com.company;
public class Main {
    public static RusRailway List =new RusRailway();
    public static void main(String[] args) {
            //создаем записи
            List.add(new CarTransport("Toyota",2010,"В гараже",85));
            List.add(new CarTransport("BMW",2010,"В пути",110));
            List.add(new TrainTransport(100 ,"Грузовой",12,"В пути",85));
            List.add(new TrainTransport(1 ,"Почтовый",21,"Ремонт",90));
            List.add(new ExpressTrain(25 ,"Пассажирский",2,"В пути",150));
            List.add(new ExpressTrain(12 ,"Грузовой",15,"В гараже",140));
    }
}
