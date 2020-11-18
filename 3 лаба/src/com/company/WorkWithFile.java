package com.company;

import java.io.*;

public class WorkWithFile {
    //чтение из файла
    public static String strFromTxtFile(String filename){
        String s=null;
        try(BufferedReader br=new BufferedReader(new FileReader(filename))){
            s=br.readLine();
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения");
        }
        return s;
    }

    //запись в файл
    public static void strToTxtFile(String str, String filename){

        try(BufferedWriter br=new BufferedWriter(new FileWriter(filename))){
            br.write(str);
        }
        catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }

}
