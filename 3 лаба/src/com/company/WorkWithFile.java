package com.company;
import java.io.*;
public class WorkWithFile {
    //чтение из файла
    public static String strFromTxtFile(String filename){
        String rez;
        try(BufferedReader br=new BufferedReader(new FileReader(filename))){
            StringBuffer sb = new StringBuffer();
            rez=br.readLine();
            for (int i=0;i<rez.length();i++){
                sb.append(rez.charAt(i));
            }
             rez=sb.toString();
        }
        catch (NullPointerException e) {
            System.out.println("Файл пустой");
            rez=null;
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения");
            rez=null;
        }
        return rez;
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
