package com.company;
public class Menu {
    //наш лист,с которым будем работать
    public static RusRailway List =new RusRailway();
    public static void mainMenu() {
        //создаем записи
        List.add(new CarTransport("Toyota",2010,"В гараже",85));
        List.add(new CarTransport("BMW",2010,"В пути",110));
        List.add(new TrainTransport(100 ,"Грузовой",12,"В пути",85));
        List.add(new TrainTransport(1 ,"Почтовый",21,"Ремонт",90));
        List.add(new ExpressTrain(25 ,"Пассажирский",2,"В пути",150));
        List.add(new ExpressTrain(12 ,"Грузовой",15,"В гараже",140));
        int key1;
        do {
            System.out.println("Имеется список транспортных средств компании РЖД,выберите действие:");
            System.out.println("1.Вывести список;");
            System.out.println("2.Добавить запись;");
            System.out.println("3.Найти запись");
            System.out.println("4.Изменить запись");
            System.out.println("5.Удалить запись");
            System.out.println("0.Выход;");
            //проверка что ввели число
            key1=CheckInput.InputInt();
            switch (key1) {
                case 1:
                    //вывод листа
                    List.print();
                    break;
                case 2: {
                    //добавить запись
                    System.out.println("В какой раздел добавить запись?");
                    System.out.println("1.Автомобиль;");
                    System.out.println("2.Поезд;");
                    System.out.println("3.Экспресс;");
                    int key = CheckInput.InputInt();
                    while (key > 3 || key < 0) {
                        System.out.println("Вводите только числа 0,1,2,3 .Повторите ввод: ");
                        key = CheckInput.InputInt();
                    }
                    List.add(CheckInput.Input(key));
                    System.out.println("Запись добавлена");
                    break;
                }
                case 3:
                    //найти запись
                    search();
                    break;
                case 4: {
                    //изменить запись
                    System.out.println("Какую запись изменить?");
                    System.out.println("Запись №");
                    int id = CheckInput.InputInt();
                    //если запись ,номер которой ввел пользователь, существует
                    if (id < List.size() || (id > 0)) {
                        System.out.print("Изменить состояние на:");
                        //вызов метода изменения записи(элемент списка ,на что менять)
                        List.getTransport(id).setCondition(CheckInput.InputStr());
                        System.out.println("Измененный:" );
                        List.print1(id);
                    }
                    if (id > List.size() || (id < 0)) System.out.println("Нет такой записи");
                    break;
                }
                case 5: {
                    //удалить запись
                    System.out.println("Какую запись удалить?");
                    System.out.print("Запись №");
                    //чтение номера записи
                    int id = CheckInput.InputInt();
                    //если запись,номер которой ввел пользователь, существует
                    if (id <= List.size() || (id > 0)) {
                        //вызов метода удаления записи(элемент списка)
                        List.remove(List.getTransport(id));
                        }
                    if (id-1 > List.size() || (id <= 0)) System.out.println("Нет такой записи");
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        } while (key1!=0);
        System.out.println("До скорой встречи!");
    }
    //метод для поиска записи
    private static void search(){
        //какой критерий,выражается цифрой
        int whatCriterion = 0;
        //выражение по которому искать
        String criterion = null;
        System.out.println("1.Поиск по всем данным");
        System.out.println("2.Поиск по критериям");
        System.out.println("3.Поиск по номеру записи");
        System.out.println("0.Выход");
        switch (CheckInput.InputInt()) {
            case 1: {
                System.out.println("Что будем искать?");
                System.out.println("1.Автомобиль;");
                System.out.println("2.Поезд;");
                System.out.println("3.Экспресс");
                //проверка на ввод
                int key=CheckInput.InputInt();
                while (key>3||key<1){
                    System.out.println("Вводите только числа 1,2,3 .Повторите ввод: ");
                    key=CheckInput.InputInt();
                }
                //вызывается метод проверки есть ли такая запись в листе
                if (List.search(key,CheckInput.Input(key))) {
                    System.out.println("Запись найдена");
                }
                else System.out.println("Запись не найдена");
                break;
            }
            case 2: {
                System.out.println("Что будем искать?");
                System.out.println("1.Автомобиль;");
                System.out.println("2.Поезд;");
                System.out.println("3.Экспресс");
                int key=CheckInput.InputInt();
                while (key>3||key<1){
                    System.out.println("Вводите только числа 1,2,3 .Повторите ввод: ");
                    key=CheckInput.InputInt();
                }
                //выбор по критериям
                switch (key) {
                    case 1: {
                        System.out.println("Поиск по");
                        System.out.println("1.Модели автомобиля");
                        System.out.println("2.Году выпуска");
                        System.out.println("3.Состоянию");
                        System.out.println("4.Средней скорости");
                        System.out.println("0.Выход");
                        int key2 = CheckInput.InputInt();
                        //выбор поиска по критериям для автомобиля
                        //переменная whatCriterion от 1 до 4 ,каждая цифра для своего критерия
                        switch (key2) {
                            case 1: {
                                System.out.print("Модель автомобиля:");
                                whatCriterion = 1;
                                break;
                            }
                            case 2: {
                                System.out.print("Год выпуска:");
                                whatCriterion = 2;
                                break;
                            }
                            case 3: {
                                System.out.print("Состояние:");
                                whatCriterion = 3;
                                break;
                            }
                            case 4: {
                                System.out.print("Средняя скорость:");
                                whatCriterion = 4;
                                break;
                            }
                            case 0:
                                break;
                            default:
                                System.out.println("Нет такого пункта");
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Поиск по");
                        System.out.println("1.Номеру поезда");
                        System.out.println("2.Типу");
                        System.out.println("3.Количеству вагонов");
                        System.out.println("4.Состоянию");
                        System.out.println("5.Средней скорости");
                        System.out.println("0.Выход");
                        int key2 = CheckInput.InputInt();
                        //выбор поиска по критериям для поезда
                        //переменная whatCriterion от 1 до 5 ,каждая цифра для своего критерия
                        switch (key2) {
                            case 1: {
                                System.out.print("Номер поезда:");
                                whatCriterion = 1;
                                break;
                            }
                            case 2: {
                                System.out.print("Тип:");
                                whatCriterion = 2;
                                break;
                            }
                            case 3: {
                                System.out.print("Количество вагонов:");
                                whatCriterion = 3;
                                break;
                            }
                            case 4: {
                                System.out.print("Состояние:");
                                whatCriterion = 4;
                                break;
                            }
                            case 5: {
                                System.out.print("Средняя скорость:");
                                whatCriterion = 5;
                                break;
                            }
                            case 0:
                                break;
                            default:
                                System.out.println("Нет такого пункта");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Поиск по");
                        System.out.println("1.Номеру экспресса");
                        System.out.println("2.Типу");
                        System.out.println("3.Количеству вагонов");
                        System.out.println("4.Состоянию");
                        System.out.println("5.Средней скорости");
                        System.out.println("0.Выход");
                        int key2 = CheckInput.InputInt();
                        //выбор поиска по критериям для экспресса
                        //переменная whatCriterion от 1 до 5 ,каждая цифра для своего критерия
                        switch (key2) {
                            case 1: {
                                System.out.print("Номер экспресса:");
                                whatCriterion = 1;
                                break;
                            }
                            case 2: {
                                System.out.print("Тип:");
                                whatCriterion = 2;
                                break;
                            }
                            case 3: {
                                System.out.print("Количество вагонов:");
                                whatCriterion = 3;
                                break;
                            }
                            case 4: {
                                System.out.print("Состояние:");
                                whatCriterion = 4;
                                break;
                            }
                            case 5: {
                                System.out.print("Средняя скорость:");
                                whatCriterion = 5;
                                break;
                            }
                            case 0:
                                break;
                            default:
                                System.out.println("Нет такого пункта");
                        }
                        break;
                    }
                    default:
                        System.out.println("Нет такого пункта");
                }
                //в свитчах нашли по какому критерию будем искать
                //далее считываем что будем искать в найденном критерии
                criterion = CheckInput.InputStr();
                //вызывается метод поиска по критерию (ключ-что ищем  машина,поезд,экпресс),какой критерий,что быдем искать в данном критерии)
                if (List.searchCriterion(key, whatCriterion, criterion) == false) {
                    System.out.println("Записи не найдены");
                }
                break;
            }
            case 3: {
                //поиск по номеру записи
                System.out.print("Запись №");
                int id = CheckInput.InputInt();
                //если такая запись существует,то она найдена,и выводим ее
                if(id<= List.size()&(id>0)) {
                    System.out.println("Запись найдена");
                    List.print1(id);
                }
                else   System.out.println("Нет такой записи");
                break;
            }
            case 0:
                break;
            default:
                System.out.println("Нет такого пункта");
        }
    }

}
