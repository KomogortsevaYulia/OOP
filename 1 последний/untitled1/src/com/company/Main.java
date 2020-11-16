package com.company;

public class Main {
    public static void main(String[] args) {

        Strings String1=new Strings("I am not young enough to know everything");
        Strings String2=new Strings();
        Strings String3=new Strings(String1);
        System.out.println(String1);
        System.out.println(String2);
        System.out.println(String3);
        String3.setS("Life is like riding a bicycle . To keep your balance you must keep moving");
        System.out.println();
        System.out.println(String1);
        System.out.println(String2);
        System.out.println(String3);
        System.out.println("Строка:"+String1.getS());
        int center;
        if (String1.getS().length() % 2 == 0)           //Если длинна строки четная то
            center =(String1.getS().length() / 2)-1;        //центральный индекс равен половине длинне строки-1
        else                                 //иначе
            center = (String1.getS().length() / 2) ;   //центральный индекс равен половине длинне строки
        String results =String1.getS().substring(String1.getS().lastIndexOf(" ", center),  String1.getS().indexOf(" ", center));
        if (results.indexOf(" ")==-1)  System.out.println("Центрального слова не существует");
        else System.out.println("Центральное слово:"+results);

    }
}



