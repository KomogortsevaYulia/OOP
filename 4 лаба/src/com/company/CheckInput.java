package com.company;

import java.util.Scanner;
//класс для проверки ввода
public class CheckInput {
    private static Scanner in = new Scanner(System.in);
    //метод для ввода "обьекта абстрактного класса Transport"
    //но это невозможно,а имеется в виду для ввода детей и внуков класса Transport
    public static Transport Input(int key) {
        switch (key) {
            case 1: {
                //ввод обьекта класса CarTransport
                System.out.print("Модель автомобиля: ");
                String model = CheckInput.InputStr();
                System.out.print("Год выпуска:");
                int years = CheckInput.InputInt();
                System.out.print("Состояние:");
                String condition = CheckInput.InputStr();
                System.out.print("Средняя скорость:");
                int speed = CheckInput.InputInt();
                return (new CarTransport(model, years, condition, speed));
            }
            case 2: {
                //ввод обьекта класса TrainTransport
                System.out.print("Номер поезда:");
                int number = CheckInput.InputInt();
                System.out.print("Тип: ");
                String type = CheckInput.InputStr();
                System.out.print("Количество вагонов:");
                int carriage = CheckInput.InputInt();
                System.out.print("Состояние:");
                String condition = CheckInput.InputStr();
                System.out.print("Средняя скорость:");
                int speed = CheckInput.InputInt();
                return (new TrainTransport(number, type, carriage, condition, speed));
            }
            case 3:
                {
                //ввод обьекта класса ExpressTrain
                System.out.print("Номер экпресса:");
                int number = InputInt();
                System.out.print("Тип: ");
                String type = InputStr();
                System.out.print("Количество вагонов:");
                int carriage = InputInt();
                System.out.print("Состояние:");
                String condition = InputStr();
                System.out.print("Средняя скорость:");
                int speed = InputInt();
                return (new ExpressTrain(number, type, carriage, condition, speed));
                }
        }
        return null;
    }
    //метод для проверки что в консоли ввели число
    public static int InputInt(){
        int read ;
        try{
            read = Integer.parseInt(in.nextLine());
        }catch (NumberFormatException ex){
            System.out.print("Вводите только числа,пожалуйста.Повторите ввод: ");
            read=InputInt();
        }
        return read;
    }
    //метод для проверки что в консоли ввели строку
    public static String InputStr(){
        String rez=null;
        try{
            rez=in.nextLine();
            int i=1/rez.length();
        }
        catch (ArithmeticException e) {
            System.out.println("Вы ничего не ввели.Повторите ввод:");
            InputStr();
        }
        return rez;
    }

}
