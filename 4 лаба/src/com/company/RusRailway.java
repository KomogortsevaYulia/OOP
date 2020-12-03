package com.company;

import java.util.ArrayList;
//класс для работы с динамическим массивом "Транспорт компании РЖД"
public class RusRailway {
    private final static ArrayList<Transport> RusRailwayTransports=new ArrayList();
    //добавление записи в лист/массив
    public void add(Transport transport) {
        this.RusRailwayTransports.add(transport);
    }
    //вывод списка/массива/листа
    public void print() {
        for (Transport transport:RusRailwayTransports) {
            System.out.println(transport.OutputInfo());
        }
    }
    //геттер
    public Transport getTransport(int id) {
        for (Transport tr:RusRailwayTransports) {
            if (tr.getId()==id){
                return tr;
            }
        }
        return  null;
    }
    //метод для удаления записи
    public void remove(Transport transport){
        this.RusRailwayTransports.remove(transport);
    }
    //метод для изменения записи
    public void record(Transport transport, String conditionNew){
        transport.setCondition(conditionNew);
        System.out.println("Измененный:" );
        System.out.println(transport.OutputInfo());
    }
    //метод для поиска по целому обьекту
    public  boolean search(int key,Transport transp) {
        boolean rez = false;
        //перебор записей листа
        for (var transport : RusRailwayTransports) {
            switch (key){
                case 1:
                    //если элемент списка принадлежит классу CarTransport
                    if (transport instanceof CarTransport) {
                        //если элемент списка совпадает с элементом которых запрашивали
                        if (transport.getCondition().equals(transp.getCondition()) &&
                                transport.getSpeed() == transp.getSpeed() &&
                                ((CarTransport) transport).getYears() == ((CarTransport) transp).getYears() &&
                                ((CarTransport) transport).getModel().equals(((CarTransport) transp).getModel())) {
                            //возвращаем правду
                            rez = true;
                        }
                    }
                    break;
                case 2:
                    //если элемент списка принадлежит классу TrainTransport
                    if (transport instanceof TrainTransport) {
                        //если элемент списка совпадает с элементом которых запрашивали
                        if (((TrainTransport) transport).getNumber() == ((TrainTransport) transp).getNumber() &&
                                ((TrainTransport) transport).getType().equals(((TrainTransport) transp).getType()) &&
                                ((TrainTransport) transport).getCarriage() == ((TrainTransport) transp).getCarriage() &&
                                transport.getCondition().equals(transp.condition) && transport.getSpeed() == transp.getSpeed()) {
                            //возвращаем правду
                            rez = true;
                        }
                    }
                    break;
                case 3:
                    //если элемент списка принадлежит классу ExpressTrain
                    if (transport instanceof ExpressTrain) {
                        //если элемент списка совпадает с элементом которых запрашивали
                        if (((ExpressTrain) transport).getNumber() == ((ExpressTrain) transp).getNumber() &&
                                ((ExpressTrain) transport).getType().equals(((ExpressTrain) transp).getType()) &&
                                ((ExpressTrain) transport).getCarriage() == ((ExpressTrain) transp).getCarriage() &&
                                transport.getCondition().equals(transp.getCondition()) &&
                                transport.getSpeed() == transp.getSpeed()) {
                            //возвращаем правду
                            rez = true;
                        }
                    }
                    break;
            }
        }
        //возвращаем "правду" если нашли, и "ложь" если не нашли
        return rez;
    }
    //метод для поиска по отдельным критериям
    public boolean searchCriterion(int key,int whatCriterion,String criterion){
        boolean result=false;
        //перебор записей листа
        for (var transport : RusRailwayTransports) {
            switch (key){
                case 1:
                {
                    //если элемент списка принадлежит классу CarTransport
                    //то находим нужный нам критерий для поиска
                    // сравниваем есть ли по этому критерию элемент с нужным значением критерия
                    //и выводим его
                    if (transport instanceof CarTransport) {
                        if (whatCriterion == 1) {
                            if (((CarTransport) transport).getModel().equals(criterion)) {
                                result = true;
                                System.out.println(((CarTransport) transport).OutputInfo());
                            }
                        }
                        else
                        if (whatCriterion == 2) {
                            if (((CarTransport) transport).getYears() ==Integer.parseInt(criterion)) {
                                result = true;
                                System.out.println(((CarTransport) transport).OutputInfo());
                            }
                        }
                        else
                        if (whatCriterion == 3) {
                            if (transport.getCondition().equals(criterion)) {
                                result = true;
                                System.out.println(((CarTransport) transport).OutputInfo());
                            }
                        }
                        else
                        if (whatCriterion == 4) {
                            if (transport.getSpeed() == Integer.parseInt(criterion)) {
                                result = true;
                                System.out.println(((CarTransport) transport).OutputInfo());
                            }
                        }
                    }
                }
                    break;
                case 2:
                {
                    //если элемент списка принадлежит классу TrainTransport
                    //то находим нужный нам критерий для поиска
                    // сравниваем есть ли по этому критерию элемент с нужным значением критерия
                    //и выводим его
                    if (transport instanceof TrainTransport) {
                        if (whatCriterion == 1) {
                            if (((TrainTransport) transport).getNumber()==Integer.parseInt(criterion)) {
                                result = true;
                                System.out.println(((TrainTransport) transport).OutputInfo());
                            }
                        }
                        else
                        if (whatCriterion == 2) {
                            if (((TrainTransport) transport).getType().equals(criterion)) {
                                result = true;
                                System.out.println(((TrainTransport) transport).OutputInfo());
                            }
                        }
                        else
                        if (whatCriterion == 3) {
                            if (((TrainTransport) transport).getCarriage()==Integer.parseInt(criterion)) {
                                result = true;
                                System.out.println(((TrainTransport) transport).OutputInfo());
                            }
                        }
                        else
                        if (whatCriterion == 4) {
                            if (transport.getCondition().equals(criterion)) {
                                result = true;
                                System.out.println(((TrainTransport) transport).OutputInfo());
                            }
                        }
                        else
                        if (whatCriterion == 5) {
                            if (transport.getSpeed() == Integer.parseInt(criterion)) {
                                result = true;
                                System.out.println(((TrainTransport) transport).OutputInfo());
                            }
                        }
                    }
                }
                    break;
                case 3:
                {
                    //если элемент списка принадлежит классу ExpressTrain
                    //то находим нужный нам критерий для поиска
                    // сравниваем есть ли по этому критерию элемент с нужным значением критерия
                    //и выводим его
                    if (transport instanceof ExpressTrain) {
                        if (whatCriterion == 1) {
                            if (((ExpressTrain) transport).getNumber()==Integer.parseInt(criterion)) {
                                result = true;
                                System.out.println(((ExpressTrain) transport).OutputInfo());
                            }
                        }
                        else
                        if (whatCriterion == 2) {
                            if (((ExpressTrain) transport).getType().equals(criterion)) {
                                result = true;
                                System.out.println(((ExpressTrain) transport).OutputInfo());
                            }
                        }
                        else
                        if (whatCriterion == 3) {
                            if (((ExpressTrain) transport).getCarriage()==Integer.parseInt(criterion)) {
                                result = true;
                                System.out.println(((ExpressTrain) transport).OutputInfo());
                            }
                        }
                        else
                        if (whatCriterion == 4) {
                            if (transport.getCondition().equals(criterion)) {
                                result = true;
                                System.out.println(((ExpressTrain) transport).OutputInfo());
                            }
                        }
                        else
                        if (whatCriterion == 5) {
                            if (transport.getSpeed() == Integer.parseInt(criterion)) {
                                result = true;
                                System.out.println(((ExpressTrain) transport).OutputInfo());
                            }
                        }
                    }
                }
                    break;
            }
        }
        //возвращаем "правду" если нашли, и "ложь" если не нашли
        return result;
    }
    //метод возвращающий размер листа
    public int size() {
        return this.RusRailwayTransports.size();
    }
}
