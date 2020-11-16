package com.company;

class Strings {
    private String S;

    public Strings(String S) {                                     //конструктор с параметрами
        this.S = S;
    }
    public Strings() {                                             //конструктор по умолчанию
        this.S = "beautiful beach";
    }
    public Strings(Strings S) {                               //конструктор копирования
        this.S = S.S;
    }

    public String getS() {                                         //Возвращение атрибута
        return S;
    }
    public void setS(String s) {                                   //изменение атрибута
        this.S = s;
    }
    public static int  GetCenter(String S){                        //метод возвращающий центральный индекс в строке
        int center;
        if(S.length()%2==0)                                            //Если длинна строки четная то
             center =(S.length()/2)-1;                                  //центральный индекс равен половине длинне строки-1
        else                                                           //иначе
            center =(S.length()/2);                                    //центральный индекс равен половине длинне строки
        return center;
    }
    public static String  getResult1(String S) {                    //метод выполняющий задание 1
        String rez="";
        int center=GetCenter(S);                                   //нахождение центрального индекса
        //нахождение слова из строки от центрального символа влево и вправо до пробела
        String results = S.substring(S.lastIndexOf(" ", center), S.indexOf(" ", center));
        if (results.indexOf(" ") == -1) {                          //если центральный символ равен пробелу
            rez="Центрального слова не существует";//то центрального слова не существует
        }
        else {                                                     //иначе
            rez="Центральное слово:" + results;    //центральное слово найдено
        }
        return rez;
    }
    public static String getResult2(String S){                       //метод выполняющий задание 2
        String rez="";
        char[] mas = S.toCharArray();                              //преобразование строки в массив символов
        char[] result = new char[S.length()];                      //создание массива для итоговых символов
        int t = 0;                                                 //переменная отвечающая за наличие повторяющихся символов
        for (int i = 0; i < S.length(); i++) {                     //цикл на перебор символов в строке
            double number = 0;                                     //переменная количества повторяющейся буквы
            for (int j = 0; j < S.length(); j++) {                 //цикл на перебор символов в строке
                if (mas[i] == mas[j]) {                            //если символы равны
                    number++;                                      //то количество повторений увеличивается на 1
                }
            }
            if ((100 * number / S.length()) < 10)                  //если процент повторений меньше 10
            {
                result[t] = mas[i];                                //то символ записываем в массив с результатом
                t = t + 1;                                         //увеличиваем наличие повторяющихся символов меньше 10%
            }
        }
        if (t == 0) {                                              //если нет повторяющихся символов меньше 10%
            rez="Нет повторяющихся символов меньше 10%";//то сообщаем об этом
        }
        else {                                                     //иначе
            rez="Символы: ";                          //вывод массива с повторяющимися символами меньше 10%
            for (int i = 0; i < t; i++) {
                rez=rez+result[i] + ",";
            }
        }
        return rez;
    }
    public static String getResult3(String S) {                      //метод выполняющий задание 3
        String rez="";
        String[] str = S.split(" ");                         //создаем массив слов взятых из строки
        int length = str[0].length();                              //длинна первого слова
        rez="Слова такой же длинны как и первое ("+str[0]+") :  ";
        int t=0;                                                   //счетчик для наличия искомых слов
        for(int i = 1; i < str.length; i++)                        //Цикл перебора слов до окончания строки
        {
            if (length == str[i].length())                         //если длинна  первого слова равна длине выбранного слова
            {
                rez=rez+str[i]+", ";
                t=t+1;                                              //счетчик увеличивается
            }
        }
        if (t==0) {                                                //если счетчик для наличия искомых слов равен 0
            rez="Слов одинаковой длинны не существует."; //то слов одинаковой длинны не существует
        }
        return rez;
    }
}