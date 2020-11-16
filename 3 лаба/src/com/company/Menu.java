package com.company;
import java.util.Scanner;

public class Menu {
    public static Scanner in = new Scanner(System.in);

    public static int InputKey(){
        int read = 0;
        try{
            read = Integer.parseInt(in.nextLine());
        }catch (NumberFormatException ex){
            System.out.print("Вводите только значения пунктов меню,пожалуйста");
            read=InputKey();
        }
        return read;
    }
    public static int InputWord(String s){
        int read;
        try{
            read = Integer.parseInt(in.nextLine())-1;

        }catch (NumberFormatException ex){
            System.out.print("Вводите только цифры");
            read =InputWord(s);
        }
        return read;
    }

    public static void menu() {
        int key;
        int key2;
        do {
            printMenu1();
            System.out.print("Введите номер меню: ");
            key=InputKey();
            switch (key) {
                case 1:
                    Strings String1=InputData(key);
                    OutputData( Strings.getResult1 ( String1.getS() ));
                    break;
                case 2:
                    Strings String2=InputData(key);
                    OutputData( Strings.getResult2 ( String2.getS() ));
                    break;
                case 3:
                    Strings String3= new Strings();
                    int word=0;
                    switch (key2){
                        case 1:
                            System.out.print("Введите предложение:");
                            String3.setS(in.nextLine());
                            System.out.print("С длинной какого слова будем сравнивать?:");
                            word=InputWord(String3.getS());
                            String[] ArrWord=String3.getS().split(" ");

                            break;
                        case 2:
                            String s=WorkWithFile.strFromTxtFile("Inputfile.txt");
                            String3.setS(s.substring(0,s.indexOf("|")));
                            int t= s.length();
                            word=Integer.parseInt(s.substring(s.indexOf("|")+1,t))-1;

                            break;
                        default:
                            System.out.println("Нет такого пункта");
                    }
                    OutputData(Strings.getResult3(String3.getS(), word));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        } while (key!=4);
    }

    public static void printMenu1() {
            System.out.println("Выберите:");
            System.out.println("1.Вывести слово с центральным символом;");
            System.out.println("2.Найти симолы с повторением меньше 10%;");
            System.out.println("3.Найти слова одинаковые по длинне с n-ым словом;");
            System.out.println("4.Выход;");
    }
    public static void printMenu2() {
        System.out.println("Выберите, откуда взять информацию:");
        System.out.println("1.Ввод с консоли;");
        System.out.println("2.Ввод из файла;");
    }
    public static Strings InputData(int key) {
        Strings rez=new Strings();
        printMenu2();
        int key2 = InputKey();
        switch (key2) {
            case 1:
                System.out.print("Введите предложение:");
                rez.setS(in.nextLine());
                break;
            case 2:
                rez.setS(WorkWithFile.strFromTxtFile("Inputfile.txt"));
                break;
            default:
                System.out.println("Нет такого пункта");
        }
        return rez;
    }

    public static void OutputData(String rezult) {
        System.out.println("Выберите, куда вывести результат:");
        System.out.println("1.В консоль;");
        System.out.println("2.В текстовый файл;");
        int key3=InputKey();
        switch (key3){
            case 1:
                System.out.println(rezult);
                break;
            case 2:
                WorkWithFile.strToTxtFile(rezult,"Outputfile.txt");
                break;
            default:
                System.out.println("Нет такого пункта");
        }
    }
}
