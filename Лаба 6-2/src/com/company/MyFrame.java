package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFrame extends JFrame {
    public static MyTableModelDeliveries Deliveries =new MyTableModelDeliveries();
    public static JTable tableDeliveries =new JTable(Deliveries);
    public static MyTableModelProduct Products=new MyTableModelProduct();
    public static JTable tableProducts=new JTable(Products);
    public static MyTableModelSales Sales=new MyTableModelSales();
    public static JTable tableSales=new JTable(Sales);
    public static MyTableModelExistence Existence=new MyTableModelExistence();
    public static JTable tableExistence=new JTable(Existence);

    public MyFrame(){
        super("Supermarket");
        /*DBWorker.initDB();
        Products.addRow(new Product(1,"Шоколадка ",155));
        Products.addRow(new Product(2,"Батончик Corny",70));
        Products.addRow(new Product(3,"Молоко Домик в деревне",120));
        Products.addRow(new Product(4,"Сыр Моцарелла",259));
        Products.addRow(new Product(6,"Вода Байкал",100));
        Sales.addRow(new Sales(1,new Product(1005,"Шоколадка Alpen Gold",155),"20.01.05",5));
        Sales.addRow(new Sales(2,new Product(2,"Батончик Corny",70),"20.05.05",5));
        Sales.addRow(new Sales(3,new Product(6,"Вода Байкал",100),"20.01.05",8));
        Sales.addRow(new Sales(4,new Product(4,"Сыр Моцарелла",259),"20.01.05",5));
        Sales.addRow(new Sales(5,new Product(2,"Батончик Corny",70),"20.09.05",5));
        Sales.addRow(new Sales(6,new Product(6,"Вода Байкал",100),"20.01.05",8));
        Deliveries.addRow(new Deliveries(1,"Яшкино",new Product(1,"Бананы",188),"Мон`дэлис Русь",300));
        Deliveries.addRow(new Deliveries(2,"dfvsdf",new Product(6,"Молоко Домик в деревне",120),"Вимм-Билль-Данн",1000));
        Deliveries.addRow(new Deliveries(3,"Яшкино",new Product(3,"Бананы",188),"Мон`дэлис Русь",100));
        Deliveries.addRow(new Deliveries(4,"BIO",new Product(1,"Бананы",188),"Мон`дэлис Русь",300));
        Deliveries.addRow(new Deliveries(5,"dfvsdf",new Product(4,"Сыр Моцарелла",259),"Вимм-Билль-Данн",1000));
        Deliveries.addRow(new Deliveries(6,"ИП занзибар",new Product(3,"Бананы",188),"Мон`дэлис Русь",100));
        DBWorker.closeDB();*/

        add(CreatePaneTitle(), BorderLayout.NORTH);
        add(CreatePaneLower(),BorderLayout.SOUTH);
        add(CreatePaneData(),BorderLayout.CENTER);
        setSize(new Dimension(1000,650));
        setLocationRelativeTo(null);
    }

    public static JPanel CreatePaneLower(){
        JButton Exit=new JButton("Выйти");
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton Reference=new JButton("Справка");
        JLabel j=new JLabel("");
        Timer timer = new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Date current = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss     dd.MM.yyyy");
                String message = formatter.format(current);
                j.setText(message+"                    ");
                j.repaint();
                j.revalidate();
            }
        });
        timer.start();
        JPanel PaneTimer=new JPanel();
        PaneTimer.add(j);
        j.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel PaneLower = new JPanel(new FlowLayout());
        PaneLower.add(Exit);
        PaneLower.add(Reference);
        PaneLower.setPreferredSize(new Dimension(1000,40));
        PaneLower.add(j);
        PaneLower.setBackground(Color.white);
        return PaneLower;
    }

    public static JPanel CreatePaneTitle(){
        JPanel PaneTitle = new JPanel();
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("C:\\Юлия\\Институт\\2 курс\\ООП\\Лабы\\Лаба 6.1\\out\\production\\Лаба 6.1\\com\\company\\2.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            PaneTitle.add(picLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PaneTitle.setMinimumSize(new Dimension(1000,200));
        return PaneTitle;
    }

    public static JTabbedPane CreatePaneData(){

        JTabbedPane Data = new JTabbedPane(JTabbedPane.TOP);
        JPanel PaneСategories = new JPanel();
        JPanel PaneProduct = new JPanel();
        JPanel PaneSales = new JPanel();
        JPanel PaneExistence = new JPanel();

        PaneСategories.setLayout(new BoxLayout(PaneСategories, BoxLayout.X_AXIS));
        PaneСategories.add(CreatePaneActionsDeliveries(),BorderLayout.WEST);
        PaneСategories.add(new JScrollPane(tableDeliveries),BorderLayout.CENTER);
        Data.addTab("Поставки", PaneСategories);

        PaneProduct.setLayout(new BoxLayout(PaneProduct, BoxLayout.X_AXIS));
        PaneProduct.add(CreatePaneActionsProduct(),BorderLayout.WEST);
        PaneProduct.add(new JScrollPane(tableProducts),BorderLayout.CENTER);
        Data.addTab("Товары", PaneProduct);

        PaneSales.setLayout(new BoxLayout(PaneSales, BoxLayout.X_AXIS));
        PaneSales.add(CreatePaneActionsSales(),BorderLayout.WEST);
        PaneSales.add(new JScrollPane(tableSales),BorderLayout.CENTER);
        Data.addTab("Продажи", PaneSales);

        PaneExistence.setLayout(new BoxLayout(PaneExistence, BoxLayout.X_AXIS));
        PaneExistence.add(CreatePaneActionsExistence(),BorderLayout.WEST);
        PaneExistence.add(new JScrollPane(tableExistence),BorderLayout.CENTER);
        Data.addTab("Наличие", PaneExistence);

        return Data;
    }

    public static JPanel CreatePaneActionsDeliveries(){
        JPanel PaneActionsDeliveries=new JPanel();
        PaneActionsDeliveries.setLayout(new BoxLayout(PaneActionsDeliveries, BoxLayout.Y_AXIS));
        PaneActionsDeliveries.setPreferredSize(new Dimension(400,500));
        JButton add=new JButton("Добавить запись");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialog.AddDeliveries();
            }
        });
        JButton change=new JButton("Изменить запись");
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row= tableDeliveries.getSelectedRow();
                if (row==-1){
                    JOptionPane.showMessageDialog(PaneActionsDeliveries,
                            " Вы ничего не выбрали",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Deliveries d=new Deliveries(
                        Integer.parseInt(String.valueOf(Deliveries.getValueAt(row,0))),
                        String.valueOf(Deliveries.getValueAt(row,1)),
                        new Product(
                                Integer.parseInt(String.valueOf(Deliveries.getValueAt(row,2))),
                                String.valueOf(Deliveries.getValueAt(row,3)),
                                0
                        ),
                        String.valueOf(Deliveries.getValueAt(row,4)) ,
                        Integer.parseInt(String.valueOf(Deliveries.getValueAt(row,5)))
                );
                MyDialog.ChangeDeliveries(d);
            }
        });
        JButton delete=new JButton("Удалить запись");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row= tableDeliveries.getSelectedRow();
                if (row==-1){
                    JOptionPane.showMessageDialog(PaneActionsDeliveries,
                            " Вы ничего не выбрали",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int id= (int) Deliveries.getValueAt(row,0);
                Deliveries.deleteRow(id);
            }
        });
        add.setAlignmentX(CENTER_ALIGNMENT);
        change.setAlignmentX(CENTER_ALIGNMENT);
        delete.setAlignmentX(CENTER_ALIGNMENT);
        PaneActionsDeliveries.add(add);
        PaneActionsDeliveries.add(change);
        PaneActionsDeliveries.add(delete);
        return PaneActionsDeliveries;
    }
    public static JPanel CreatePaneActionsProduct(){
        JPanel PaneActionsProduct=new JPanel();
        PaneActionsProduct.setLayout(new BoxLayout(PaneActionsProduct, BoxLayout.Y_AXIS));
        PaneActionsProduct.setPreferredSize(new Dimension(400,500));
        JButton add=new JButton("Добавить запись");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialog.AddProduct();
            }
        });
        JButton change=new JButton("Изменить запись");
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row= tableProducts.getSelectedRow();
                if (row==-1){
                    JOptionPane.showMessageDialog(PaneActionsProduct,
                            " Вы ничего не выбрали",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Product p= new Product(
                        Integer.parseInt(String.valueOf( Products.getValueAt(row,0))),
                        String.valueOf(Products.getValueAt(row,1)),
                        Float.valueOf(String.valueOf( Products.getValueAt(row,2)))
                );
                MyDialog.ChangeProduct(p);
            }
        });
        JButton delete=new JButton("Удалить запись");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tableProducts.getSelectedRow();
                if (row==-1){
                    JOptionPane.showMessageDialog(PaneActionsProduct,
                            " Вы ничего не выбрали",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int id= (int) Products.getValueAt(row,0);
                Products.deleteRow(id);
                Deliveries.update();
                Sales.update();
                Existence.update();
            }
        });
        add.setAlignmentX(CENTER_ALIGNMENT);
        change.setAlignmentX(CENTER_ALIGNMENT);
        delete.setAlignmentX(CENTER_ALIGNMENT);
        PaneActionsProduct.add(add);
        PaneActionsProduct.add(change);
        PaneActionsProduct.add(delete);
        return PaneActionsProduct;
    }
    public static JPanel CreatePaneActionsSales(){
        JPanel PaneActionsSales=new JPanel();
        PaneActionsSales.setLayout(new BoxLayout(PaneActionsSales, BoxLayout.Y_AXIS));
        PaneActionsSales.setPreferredSize(new Dimension(400,500));
        JButton add=new JButton("Добавить запись");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialog.AddSale();
            }
        });
        add.setAlignmentX(CENTER_ALIGNMENT);
        JButton change=new JButton("Изменить запись");
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row= tableSales.getSelectedRow();
                if (row==-1){
                    JOptionPane.showMessageDialog(PaneActionsSales,
                            " Вы ничего не выбрали",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Sales p= new Sales(
                        Integer.parseInt(String.valueOf(Sales.getValueAt(row,0))),
                        new Product( Integer.parseInt(String.valueOf( Sales.getValueAt(row,1))),
                                String.valueOf(Sales.getValueAt(row,2)),
                                Float.valueOf(String.valueOf(Sales.getValueAt(row,5)))),
                        String.valueOf(Sales.getValueAt(row,3)),
                        Integer.valueOf(String.valueOf(Sales.getValueAt(row,5)))
                );
                MyDialog.ChangeSale(p);
            }
        });
        change.setAlignmentX(CENTER_ALIGNMENT);
        JButton delete=new JButton("Удалить запись");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row= tableSales.getSelectedRow();
                if (row==-1){
                    JOptionPane.showMessageDialog(PaneActionsSales,
                            " Вы ничего не выбрали",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int id= (int) Sales.getValueAt(row,0);
                Sales.deleteRow(id);
            }
        });
        delete.setAlignmentX(CENTER_ALIGNMENT);
        PaneActionsSales.add(add);
        PaneActionsSales.add(change);
        PaneActionsSales.add(delete);
        return PaneActionsSales;
    }
    public static JPanel CreatePaneActionsExistence() {
        JPanel PaneActionsExistence=new JPanel();
        PaneActionsExistence.setLayout(new BoxLayout(PaneActionsExistence, BoxLayout.Y_AXIS));
        PaneActionsExistence.setPreferredSize(new Dimension(400,500));
        PaneActionsExistence.add(new JLabel("*Тут будет что то*"));
        return PaneActionsExistence;
    }
}
