package com.company;
import java.util.Scanner;

public class Menu {
    public static Scanner in = new Scanner(System.in);

    public static void mainMenu() {
        int key1=0;
        do {
            System.out.println("Выберите:");
            System.out.println("1.Вывести слово с центральным символом;");
            System.out.println("2.Найти симолы с повторением меньше 10%;");
            System.out.println("3.Найти слова одинаковые по длинне с n-ым словом;");
            System.out.println("4.Выход;");
            System.out.print("Введите номер : ");
            //ввели и проверили что бы это было число
            key1=InputInt();
            switch (key1) {
                case 1:
                    //задание1
                    MakeTask1();
                    break;
                case 2:
                    //задание2
                    MakeTask2();
                    break;
                case 3:
                    //задание3
                    MakeTask3();
                    break;
                case 4:
                    //выход
                    break;
                default:
                    //если введут не 1,2,3 или 4 ,то такого пункта нет и заново попросит ввести
                    //а не выйдет из программы потому что ключ будет не равен 4
                    System.out.println("Нет такого пункта");
            }
        } while (key1!=4);
        System.out.println("До скорой встречи!");
    }

    //делает задание 1
    public static void  MakeTask1() {
        //выводит меню ввода
        printMenuInput();
        //читает и проверят на число
        int keyInput = InputInt();
        //создаем обьект,необходимый для решения
        Strings String1=new Strings();
        switch (keyInput) {
            case 1:
                //ввод с консоли
                System.out.print("Введите предложение:");
                String1.setS(InputStr());
                //вывод результата
                OutputData(Strings.getResult1(String1.getS()));
                break;
            case 2:
                //ввод с файла
                //если файл не пустой то считать данные оттуда и найти и вывести результат
                if(WorkWithFile.strFromTxtFile("Inputfile.txt")!=null){
                    String1.setS(WorkWithFile.strFromTxtFile("Inputfile.txt"));
                    OutputData(Strings.getResult1(String1.getS()));
                }
                break;
            default:
                System.out.println("Нет такого пункта");
        }
    }

    //делает задание 2
    public static void  MakeTask2() {
        printMenuInput();
        int keyInput = InputInt();
        Strings String2=new Strings();
        switch (keyInput) {
            case 1:
                //ввод с консоли
                System.out.print("Введите предложение:");
                String2.setS(InputStr());
                //вывод результата
                OutputData(Strings.getResult2(String2.getS()));
                break;
            case 2:
                //ввод с файла
                //если файл не пустой то считать данные оттуда и найти и вывести результат
                if(WorkWithFile.strFromTxtFile("Inputfile.txt")!=null){
                    String2.setS(WorkWithFile.strFromTxtFile("Inputfile.txt"));
                    OutputData(Strings.getResult2(String2.getS()));
                }
                break;
            default:
                System.out.println("Нет такого пункта");
        }
    }

    //делает задание 3
    public static void  MakeTask3() {
        printMenuInput();
        int NumberWord=0;
        Strings String3=new Strings();
        int keyInput = InputInt();
        switch (keyInput) {
            case 1:
                //ввод с консоли
                System.out.print("Введите предложение:");
                String3.setS(InputStr());
                System.out.print("С длинной какого слова будем сравнивать?:");
                //проверка на число
                NumberWord=InputInt()-1;
                //массив слов из файла
                //если номер слова из файла больше чем количество слов или меньше
                while  ((NumberWord> String3.getS().split(" ").length)||((NumberWord<0))){
                    System.out.print("Слова с таким номером не существует,введите еще раз");
                    NumberWord=InputInt()-1;
                }
                //вывод результата
                OutputData(Strings.getResult3(String3.getS(), NumberWord));
                break;
            case 2:
                //ввод с файла
                //если файл не пустой то считать данные оттуда и найти и вывести результат
                if(WorkWithFile.strFromTxtFile("Inputfile.txt")!=null) {
                    String s = WorkWithFile.strFromTxtFile("Inputfile.txt");
                    //в обьект записываем данные из файла до черты |
                    String3.setS(s.substring(0, s.indexOf("|")));
                    //массив из слов в предложение
                    //длинна всей строки
                    int t = s.length();
                    //номер слова из файла
                    NumberWord = Integer.parseInt(s.substring(s.indexOf("|") + 1, t)) - 1;
                    //если номер слова из файла больше чем количество слов или меньше
                    if ((NumberWord > String3.getS().split(" ").length) || (NumberWord < 0)) {
                        OutputData("Слова с таким номером не существует");
                    } else {
                        //вывод результата
                        OutputData(Strings.getResult3(String3.getS(), NumberWord));
                    }
                }
                break;
            default:
                System.out.println("Нет такого пункта");
        }
    }

    //метод для проверки что в консоли ввели число
    public static int InputInt(){
        int read ;
        try{
            read = Integer.parseInt(in.nextLine());
        }catch (NumberFormatException ex){
            System.out.print("Вводите только числа,пожалуйста");
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

    //вывод результата
    public static void OutputData(String rezult) {
        System.out.println("Выберите, куда вывести результат:");
        System.out.println("1.В консоль;");
        System.out.println("2.В текстовый файл;");
        //опять ввели и проверили число ли это
        int keyOutput=InputInt();
        switch (keyOutput){
            case 1:
                //вывод в консоль
                System.out.println(rezult);
                break;
            case 2:
                //вывод в файл
                WorkWithFile.strToTxtFile(rezult,"Outputfile.txt");
                break;
            default:
                //если ввели не 1 и 2 ,то попросит ввести еще раз
                System.out.println("Нет такого пункта,повторите ввод");
                OutputData(rezult);
        }
    }

    //вывод меню ввода на консоль
    public static void printMenuInput() {
        System.out.println("Выберите, откуда взять информацию:");
        System.out.println("1.Ввод с консоли;");
        System.out.println("2.Ввод из файла;");

    }
}
