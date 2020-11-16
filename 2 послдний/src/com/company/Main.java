package com.company;

public class Main {
    public static void main(String[] args) {
        //создание обьекта String1 с начальным значением задаваемым конструктором с параметром
        Strings String1=new Strings("I am not young enough to know everything");
        //создание обьекта String2 с начальным значением задаваемым конструктором по умолчанию
        Strings String2=new Strings();
        //создание обьекта String3 с начальным значением задаваемым конструктором с параметром
        Strings String3=new Strings("Life is like riding a bicycle . To keep your balance you must keep moving ");

        System.out.println();
        System.out.println("Задание:выведите слово с центральным символом");
        System.out.println("Строка:"+String1.getS());
        //вызов метода для решения первой задачи
        System.out.println(Strings.getResult1(String1.getS()));

        System.out.println();
        System.out.println("Задание:найти символы с повторением,меньше 10%");
        System.out.println("Строка: "+String2.getS());
        //вызов метода для решения второй задачи
        System.out.println(Strings.getResult2(String2.getS()));

        System.out.println();
        System.out.println();
        System.out.println("Задание:найти слова одинаковые по длинне с первым словом");
        System.out.println("Строка:  "+String3.getS());
        //вызов метода для решения третьей задачи
        System.out.println(Strings.getResult3(String3.getS()));

        //код для тестирования
        /*
        Strings test1=new Strings();                       //использование конструктора  по умолчанию
        Strings test2=new Strings("Это проверка");         //использование конструктора  с параметрами
        Strings test3=new Strings(test1);                  //использование конструктора копирования
        System.out.println("test1(адрес;содержимое): "+test1+" ; "+test1.getS());
        System.out.println("test2(адрес;содержимое): "+test2+" ; "+test2.getS());
        System.out.println("test3(адрес;содержимое): "+test3+" ; "+test3.getS());
         */
    }
}
