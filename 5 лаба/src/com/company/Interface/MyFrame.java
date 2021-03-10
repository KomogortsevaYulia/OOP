package com.company.Interface;
import com.company.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame {
    public static JPanel ControlPanel = new JPanel(new GridLayout(1,5));  //панель управления(верхняя)
    public static JPanel  OperationPanel = new JPanel();                             //панель процесса(справа)
    public static JScrollPane scrollPanel ;                                          //панель с таблицой
    public static JPanel DeletePanelSimple = new JPanel(new GridLayout(2, 1));                                  //панель которая удаляет запись
    public static JPanel DeletePanelId = new JPanel(new GridLayout(3, 1));
    public static JPanel DeletePanelFind = new JPanel(new GridLayout(3, 1));
    public static JPanel AddPanel = new JPanel(new GridLayout(2,1));                                     //панель которая добавляет запись
    public static JPanel FindSimplePanel = new JPanel(new GridLayout(3, 1));
    public static JPanel FindCriterionPanel = new JPanel(new GridLayout(2, 1));
    public static JPanel FindCar = new JPanel(new GridLayout(5, 2));
    public static JPanel FindExpress = new JPanel(new GridLayout(6, 2));
    public static JPanel FindTrain=new JPanel(new GridLayout(6,2));
    public static JPanel AddCar = new JPanel(new GridLayout(5, 2));
    public static JPanel AddExpress = new JPanel(new GridLayout(6, 2));
    public static JPanel AddTrain=new JPanel(new GridLayout(6,2));
    public static RusRailway List =new RusRailway();
    public static String[] columnNames = {"№","Вид", "Состояние", "Модель", "Скорость", "Тип", "Год", "Номер поезда", "Число вагонов"};
    public static JTable t;
    public static int index=-1;
    public MyFrame() {

        super("Транспорт");

        AddList();
        t =new JTable(FromSheetToArray(), columnNames) ;
        scrollPanel = new JScrollPane(t);
        scrollPanel.setPreferredSize((new Dimension(1000, 500)));
        t.repaint();
        t.revalidate();
        scrollPanel.repaint();
        scrollPanel.revalidate();

        t.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                index=e.getID();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        CreatePanelAdd();
        CreatePanelFind();
        CreatePanelDelete();
        CreateControlPanel();

        //////////редактируем и добавляем в frame 3 панели
        this.setMinimumSize(new Dimension(1250, 600));
        this.setLayout(new BorderLayout());
        add(scrollPanel,BorderLayout.WEST);
        add(OperationPanel,BorderLayout.CENTER);
        add(ControlPanel,BorderLayout.NORTH);
        ControlPanel.setVisible(true);
        OperationPanel.setVisible(true);
        scrollPanel.setVisible(true);

    }

    public static String[][] FromSheetToArray(){
        /////////////////////панель с таблицей
        String[][] data=new String[List.size()+1][9] ;
        for (int i=0;i<List.size()+1;i++){
                data[i][0]=String.valueOf(i);
            Transport t=List.getTransport(i);
                if (t instanceof CarTransport){
                    data[i][1]= "Машина";
                    data[i][2]= t.getCondition();
                    data[i][3]= ((CarTransport) t).getModel();
                    data[i][4]=String.valueOf( t.getSpeed());
                    data[i][5]= "";
                    data[i][6]= String.valueOf(((CarTransport) t).getYears());
                    data[i][7]= "";
                    data[i][8]= "";
                }else if (t instanceof ExpressTrain){
                data[i][1]= "Экспресс";
                data[i][2]= t.getCondition();
                data[i][3]= "";
                data[i][4]= String.valueOf( t.getSpeed());
                data[i][5]= ((ExpressTrain) t).getType();
                data[i][6]= "";
                data[i][7]=String.valueOf(((ExpressTrain)t).getNumber());
                data[i][8]=String.valueOf(((ExpressTrain) t).getCarriage());
            }
                    else if (t instanceof TrainTransport){
                data[i][1]= "Поезд";
                    data[i][2]= t.getCondition();
                    data[i][3]= "";
                    data[i][4]= String.valueOf( t.getSpeed());
                    data[i][5]= ((TrainTransport) t).getType();
                    data[i][6]= "";
                    data[i][7]=String.valueOf(((TrainTransport)t).getNumber());
                    data[i][8]=String.valueOf(((TrainTransport) t).getCarriage());
            }
        }
        return  data;
    }

    public static void CreateControlPanel(){
        //////////////////////создаем кнопки панели управления
        JButton Delete = new JButton("Удалить");
        JButton AddNote = new JButton("Добавить");
        JButton Find = new JButton("Найти");
        JButton Change = new JButton("Изменить");
        JButton Refresh = new JButton("Обновить");
        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperationPanel.removeAll();
                OperationPanel.setLayout(new GridLayout(3,1));
                OperationPanel.add(DeletePanelSimple);
                OperationPanel.add(DeletePanelId);
                OperationPanel.add(DeletePanelFind);
                OperationPanel.repaint();
                OperationPanel.revalidate();
            }
        });
        AddNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.OperationPanel.removeAll();
                MyFrame.OperationPanel.setLayout(new GridLayout(2,1));
                MyFrame.OperationPanel.add(MyFrame.AddPanel);
                MyFrame.OperationPanel.repaint();
                MyFrame.OperationPanel.revalidate();
            }
        });
        Find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.OperationPanel.removeAll();
                OperationPanel.setLayout(new GridLayout(2,1));
                OperationPanel.add(FindSimplePanel);
                OperationPanel.add(FindCriterionPanel);
                MyFrame.OperationPanel.repaint();
                MyFrame.OperationPanel.revalidate();
            }
        });
        Change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.OperationPanel.removeAll();
                MyFrame.OperationPanel.repaint();
                MyFrame.OperationPanel.revalidate();
            }
        });
        Refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.OperationPanel.removeAll();
                scrollPanel.removeAll();
                scrollPanel = new JScrollPane(t);
                scrollPanel.repaint();
                scrollPanel.revalidate();
                MyFrame.OperationPanel.repaint();
                MyFrame.OperationPanel.revalidate();
            }
        });
        //////////////добавляем в панель управления кнопки
        ControlPanel.add(Delete);
        ControlPanel.add(AddNote);
        ControlPanel.add(Find);
        ControlPanel.add(Change);
        ControlPanel.add(Refresh);
    }
    public static void AddList(){
        {
            List.add(new CarTransport("Toyota", 2010, "В гараже", 85));
            List.add(new CarTransport("BMW", 2010, "В пути", 110));
            List.add(new TrainTransport(100, "Грузовой", 12, "В пути", 85));
            List.add(new TrainTransport(1, "Почтовый", 21, "Ремонт", 90));
            List.add(new ExpressTrain(25, "Пассажирский", 2, "В пути", 150));
            List.add(new ExpressTrain(12, "Грузовой", 15, "В гараже", 140));
            List.add(new CarTransport("Toyota", 2010, "В гараже", 85));
            List.add(new CarTransport("Toyota", 2010, "В гараже", 85));
            List.add(new CarTransport("BMW", 2010, "В пути", 110));
            List.add(new TrainTransport(100, "Грузовой", 12, "В пути", 85));
            List.add(new TrainTransport(1, "Почтовый", 21, "Ремонт", 90));
            List.add(new ExpressTrain(25, "Пассажирский", 2, "В пути", 150));
            List.add(new ExpressTrain(12, "Грузовой", 15, "В гараже", 140));
            List.add(new CarTransport("Toyota", 2010, "В гараже", 85));
            List.add(new CarTransport("Toyota", 2010, "В гараже", 85));
            List.add(new CarTransport("BMW", 2010, "В пути", 110));
            List.add(new TrainTransport(100, "Грузовой", 12, "В пути", 85));
            List.add(new TrainTransport(1, "Почтовый", 21, "Ремонт", 90));
            List.add(new ExpressTrain(25, "Пассажирский", 2, "В пути", 150));
            List.add(new ExpressTrain(12, "Грузовой", 15, "В гараже", 140));
            List.add(new CarTransport("Toyota", 2010, "В гараже", 85));
            List.add(new CarTransport("Toyota", 2010, "В гараже", 85));
            List.add(new CarTransport("BMW", 2010, "В пути", 110));
            List.add(new TrainTransport(100, "Грузовой", 12, "В пути", 85));
            List.add(new TrainTransport(1, "Почтовый", 21, "Ремонт", 90));
            List.add(new ExpressTrain(25, "Пассажирский", 2, "В пути", 150));
            List.add(new ExpressTrain(12, "Грузовой", 15, "В гараже", 140));
            List.add(new CarTransport("Toyota", 2010, "В гараже", 85));
        }
    }
    public static void CreatePanelAdd(){
        {
            JLabel L1 = new JLabel("Выберите, что вы хотите добавить");
            String s1[] = {"Машина", "Поезд", "Эспресс"};
            JComboBox c = new JComboBox(s1);
            AddPanel.add(L1);
            AddPanel.add(c);
            c.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    c.setSelectedItem(e.getActionCommand());
                    OperationPanel.removeAll();
                    OperationPanel.add(AddPanel);
                    if (c.getSelectedItem().equals("Машина")) {
                        MyFrame.OperationPanel.add(MyFrame.AddCar);
                    }
                    if (c.getSelectedItem().equals("Поезд")) {
                        MyFrame.OperationPanel.add(MyFrame.AddTrain);
                    }
                    if (c.getSelectedItem().equals("Эспресс")) {
                        MyFrame.OperationPanel.add(MyFrame.AddExpress);
                    }
                    MyFrame.OperationPanel.repaint();
                    MyFrame.OperationPanel.revalidate();
                }
            });}    //панель добавления
        {
            JLabel L2 = new JLabel("Модель:");
            String s2[] = {"Audi", "BMW", "Ford", "Honda", " Hyundai", "Kia", "Lada(ВАЗ)", "Mazda", "Mercedes-Benz", "Mitsubishi", "Nissan", "Renault", "Skoda", "Toyota"};
            JComboBox c2 = new JComboBox(s2);
            JLabel L3 = new JLabel("Год выпуска:");
            JTextField t1 = new JTextField();
            JLabel L4 = new JLabel("Состояние:");
            String s3[] = {"В пути", "В гараже", "Ремонт"};
            JComboBox c1 = new JComboBox(s3);
            JLabel L5 = new JLabel("Средняя скорость:");
            JTextField t2 = new JTextField();
            JButton ADDCAR = new JButton("Добавить");
            JButton BACK = new JButton("Назад");
            ADDCAR.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List.add(new CarTransport((String)c2.getSelectedItem(),Integer.parseInt(t1.getText()),(String) c1.getSelectedItem(),Integer.parseInt(t2.getText())));
                    JTable r=new JTable(FromSheetToArray(), columnNames);
                    scrollPanel = new JScrollPane(r);
                    scrollPanel.repaint();
                    scrollPanel.revalidate();
                    OperationPanel.removeAll();
                    OperationPanel.repaint();
                    OperationPanel.revalidate();
                }
            });
            BACK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OperationPanel.removeAll();
                    OperationPanel.add(AddPanel);
                    OperationPanel.repaint();
                    OperationPanel.revalidate();
                }
            });
            AddCar.add(L2);
            AddCar.add(c2);
            AddCar.add(L3);
            AddCar.add(t1);
            AddCar.add(L4);
            AddCar.add(c1);
            AddCar.add(L5);
            AddCar.add(t2);
            AddCar.add(ADDCAR);
            AddCar.add(BACK);
        }   //панель добавления машины
        {
            JLabel L22 = new JLabel("Номер экспресса:");
            JTextField t22 = new JTextField();
            JLabel L32 = new JLabel("Тип:");
            String s22[] = {"Грузовой", "Пассажирский", "Почтовый"};
            JComboBox c22 = new JComboBox(s22);
            JLabel L12 = new JLabel("Количество вагонов:");
            JTextField t12 = new JTextField();
            JLabel L42 = new JLabel("Состояние:");
            String s32[] = {"В пути", "В гараже", "Ремонт"};
            JComboBox c12 = new JComboBox(s32);
            JLabel L52 = new JLabel("Средняя скорость:");
            JTextField t52 = new JTextField();
            JButton ADDEX = new JButton("Добавить");
            JButton BACK = new JButton("Назад");
            BACK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OperationPanel.removeAll();
                    OperationPanel.add(AddPanel);
                    OperationPanel.repaint();
                    OperationPanel.revalidate();
                }
            });
            AddExpress.add(L22);
            AddExpress.add(t22);
            AddExpress.add(L32);
            AddExpress.add(c22);
            AddExpress.add(L12);
            AddExpress.add(t12);
            AddExpress.add(L42);
            AddExpress.add(c12);
            AddExpress.add(L52);
            AddExpress.add(t52);
            AddExpress.add(ADDEX);
            AddExpress.add(BACK);
        }   //панель добавления экспресса
        {
            JLabel L21 = new JLabel("Номер поезда:");
            JTextField t21 = new JTextField();
            JLabel L31 = new JLabel("Тип:");
            String s21[] = {"Грузовой", "Пассажирский", "Почтовый"};
            JComboBox c21 = new JComboBox(s21);
            JLabel L11 = new JLabel("Количество вагонов:");
            JTextField t11 = new JTextField();
            JLabel L41 = new JLabel("Состояние:");
            String s31[] = {"В пути", "В гараже", "Ремонт"};
            JComboBox c11 = new JComboBox(s31);
            JLabel L51 = new JLabel("Средняя скорость:");
            JTextField t51 = new JTextField();
            JButton ADDTRAIN = new JButton("Добавить");
            JButton BACK = new JButton("Назад");
            BACK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OperationPanel.removeAll();
                    OperationPanel.add(AddPanel);
                    OperationPanel.repaint();
                    OperationPanel.revalidate();
                }
            });
            AddTrain.add(L21);
            AddTrain.add(t21);
            AddTrain.add(L31);
            AddTrain.add(c21);
            AddTrain.add(L11);
            AddTrain.add(t11);
            AddTrain.add(L41);
            AddTrain.add(c11);
            AddTrain.add(L51);
            AddTrain.add(t51);
            AddTrain.add(ADDTRAIN);
            AddTrain.add(BACK);
        }   //панель добавления поезда
    }
    public static void CreatePanelFind(){
        {
            JLabel FcL1 = new JLabel("Модель:");
            String s2[] = {"Audi", "BMW", "Ford", "Honda", " Hyundai", "Kia", "Lada(ВАЗ)", "Mazda", "Mercedes-Benz", "Mitsubishi", "Nissan", "Renault", "Skoda", "Toyota"};
            JComboBox FcC1 = new JComboBox(s2);
            JLabel FcL2 = new JLabel("Год выпуска:");
            JTextField FcT1 = new JTextField();
            JLabel FcL3 = new JLabel("Состояние:");
            String s3[] = {"В пути", "В гараже", "Ремонт"};
            JComboBox FcC2 = new JComboBox(s3);
            JLabel FcL4 = new JLabel("Средняя скорость:");
            JTextField FcT2 = new JTextField();
            JButton FINDCar = new JButton("Найти");
            JButton BACK = new JButton("Назад");
            BACK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OperationPanel.removeAll();
                    OperationPanel.setLayout(new GridLayout(2,1));
                    OperationPanel.add(FindSimplePanel);
                    OperationPanel.add(FindCriterionPanel);
                    OperationPanel.repaint();
                    OperationPanel.revalidate();
                }
            });
            FindCar.add(FcL1);
            FindCar.add(FcC1);
            FindCar.add(FcL2);
            FindCar.add(FcT1);
            FindCar.add(FcL3);
            FindCar.add(FcC2);
            FindCar.add(FcL4);
            FindCar.add(FcT2);
            FindCar.add( FINDCar);
            FindCar.add(BACK);
        }   //панель поиска машины
        {
            JLabel FeL1 = new JLabel("Номер экспресса:");
            JTextField FeT1 = new JTextField();
            JLabel FeL2 = new JLabel("Тип:");
            String s22[] = {"Грузовой", "Пассажирский", "Почтовый"};
            JComboBox FeC1 = new JComboBox(s22);
            JLabel FeL3 = new JLabel("Количество вагонов:");
            JTextField FeT2 = new JTextField();
            JLabel FeL4 = new JLabel("Состояние:");
            String s32[] = {"В пути", "В гараже", "Ремонт"};
            JComboBox FeC2 = new JComboBox(s32);
            JLabel FeL5 = new JLabel("Средняя скорость:");
            JTextField FeT3 = new JTextField();
            JButton FindEX = new JButton("Найти");
            JButton BACK = new JButton("Назад");
            BACK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OperationPanel.removeAll();
                    OperationPanel.setLayout(new GridLayout(2,1));
                    OperationPanel.add(FindSimplePanel);
                    OperationPanel.add(FindCriterionPanel);
                    OperationPanel.repaint();
                    OperationPanel.revalidate();
                }
            });
            FindEX.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            FindExpress.add(FeL1);
            FindExpress.add(FeT1);
            FindExpress.add(FeL2);
            FindExpress.add(FeC1);
            FindExpress.add(FeL3);
            FindExpress.add(FeT2);
            FindExpress.add(FeL4);
            FindExpress.add(FeC2);
            FindExpress.add(FeL5);
            FindExpress.add(FeT3);
            FindExpress.add(FindEX);
            FindExpress.add(BACK);
        }   //панель поиска экспресса
        {
            JLabel FtL1 = new JLabel("Номер поезда:");
            JTextField FtT1 = new JTextField();
            JLabel FtL2 = new JLabel("Тип:");
            String s21[] = {"Грузовой", "Пассажирский", "Почтовый"};
            JComboBox FtC1 = new JComboBox(s21);
            JLabel FtL3 = new JLabel("Количество вагонов:");
            JTextField FtT2 = new JTextField();
            JLabel FtL4 = new JLabel("Состояние:");
            String s31[] = {"В пути", "В гараже", "Ремонт"};
            JComboBox FtC2 = new JComboBox(s31);
            JLabel FtL5 = new JLabel("Средняя скорость:");
            JTextField FtT3 = new JTextField();
            JButton FindTRAIN = new JButton("Найти");
            JButton BACK = new JButton("Назад");
            BACK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OperationPanel.removeAll();
                    OperationPanel.setLayout(new GridLayout(2,1));
                    OperationPanel.add(FindSimplePanel);
                    OperationPanel.add(FindCriterionPanel);
                    OperationPanel.repaint();
                    OperationPanel.revalidate();
                }
            });
            FindTrain.add(FtL1);
            FindTrain.add(FtT1);
            FindTrain.add(FtL2);
            FindTrain.add(FtC1);
            FindTrain.add(FtL3);
            FindTrain.add(FtT2);
            FindTrain.add(FtL4);
            FindTrain.add(FtC2);
            FindTrain.add(FtL5);
            FindTrain.add(FtT3);
            FindTrain.add(FindTRAIN);
            FindTrain.add(BACK);
        }   //панель поиска поезда
        {
            JLabel L103 = new JLabel("Введите номер записи:");
            JTextField t103 = new JTextField();
            JButton findId=new JButton("Найти");
            FindSimplePanel.add(L103);
            FindSimplePanel.add(t103);
            FindSimplePanel.add(findId);
            JLabel w=new JLabel("Что вы хотите найти?");
            String s1[] = {"Машина", "Поезд", "Эспресс"};
            JComboBox c1 = new JComboBox(s1);
            FindCriterionPanel.add(w);
            FindCriterionPanel.add(c1);
            c1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OperationPanel.removeAll();
                    OperationPanel.setLayout(new GridLayout(2,1));
                    OperationPanel.add(FindSimplePanel);
                    if (c1.getSelectedItem().equals("Машина")) {
                        OperationPanel.add(FindCar);
                    }
                    if (c1.getSelectedItem().equals("Поезд")) {
                        OperationPanel.add(FindTrain);
                    }
                    if (c1.getSelectedItem().equals("Эспресс")) {
                        OperationPanel.add(FindExpress);
                    }
                    OperationPanel.repaint();
                    OperationPanel.revalidate();
                }
            });
        }   //панель поиска
    }
    public static void CreatePanelDelete(){
        {
            JLabel L100 = new JLabel("Выберите запись в таблице слева");
            JButton DELETE=new JButton("Удалить");
            DeletePanelSimple.add(L100);
            DeletePanelSimple.add(DELETE);
            DELETE.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List.remove(List.getTransport(index));
                    index= -1;
                    scrollPanel.removeAll();
                    scrollPanel = new JScrollPane(new JTable(FromSheetToArray(), columnNames));
                    scrollPanel.repaint();
                    scrollPanel.revalidate();
                    OperationPanel.removeAll();
                    OperationPanel.repaint();
                    OperationPanel.revalidate();
                }
            });
            JLabel L101 = new JLabel("Введите номер записи:");
            JTextField t100 = new JTextField();
            JButton DELETEID=new JButton("Удалить");
            DeletePanelId.add(L101);
            DeletePanelId.add(t100);
            DeletePanelId.add(DELETEID);
            DELETEID.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int id=Integer.parseInt((t100.getText()));
                    List.remove(List.getTransport(5));
                    scrollPanel.removeAll();
                    scrollPanel = new JScrollPane(new JTable(FromSheetToArray(), columnNames));
                    scrollPanel.repaint();
                    scrollPanel.revalidate();
                    OperationPanel.removeAll();
                    OperationPanel.repaint();
                    OperationPanel.revalidate();
                }
            });
            JLabel L102 = new JLabel("Тут должен быть поиск по критериям и удаление");
            DeletePanelFind.add(L102);
        }
    }
}
