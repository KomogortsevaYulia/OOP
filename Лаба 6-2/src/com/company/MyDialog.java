package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDialog {
    public static void ChangeProduct(Product p) {
        JDialog dialog=new JDialog();
        dialog.setTitle("Изменение товара");
        JPanel Pane1=new JPanel(new GridLayout(3,2));
        JTextField id=new JTextField();id.setText(String.valueOf(p.getId()));
        JTextField name=new JTextField();name.setText(p.getName());
        JTextField price= new JTextField();price.setText(String.valueOf(p.getPrice()));
        Pane1.add(new JLabel("Id товара:"));Pane1.add(id);
        Pane1.add(new JLabel("Имя:"));Pane1.add(name);
        Pane1.add(new JLabel("Цена:"));Pane1.add(price);
        JButton changeProduct=new JButton("Изменить");
        changeProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    boolean exist=false;
                    for (int i=0;i<MyFrame.Products.getRowCount();i++) {
                        if (Integer.parseInt(id.getText()) == Integer.parseInt(String.valueOf(MyFrame.Products.getValueAt(i, 0)))){
                            exist=true;
                        }
                    }
                    if(exist){
                        JOptionPane.showMessageDialog(dialog,
                                " Уже существует продукт с таким ID!",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE);
                    }else{
                        MyFrame.Products.changeRow(p.getId(),new Product(
                                Integer.parseInt(id.getText()),
                                String.valueOf(name.getText()),
                                Float.valueOf(price.getText())
                        ));
                        dialog.dispose();
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog,
                            " Можно вводить только целые числа",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
                id.setText("");
                name.setText("");
                price.setText("");
            }
        });
        dialog.add(Pane1,BorderLayout.CENTER);
        dialog.add(changeProduct,BorderLayout.SOUTH);
        dialog.setSize(200,200);
        dialog.setModal(true);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.pack();
    }

    public static void AddProduct() {
        JDialog dialog=new JDialog();
        dialog.setTitle("Добавление товара");
        JPanel Pane1=new JPanel(new GridLayout(3,2));
        JTextField id=new JTextField();
        JTextField name=new JTextField();
        JTextField price= new JTextField();
        Pane1.add(new JLabel("Id товара:"));Pane1.add(id);
        Pane1.add(new JLabel("Имя:"));Pane1.add(name);
        Pane1.add(new JLabel("Цена:"));Pane1.add(price);
        JButton addCatalog=new JButton("Добавить");
        addCatalog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    boolean exist=false;
                    for (int i=0;i<MyFrame.Products.getRowCount();i++) {
                        if (Integer.parseInt(id.getText()) == Integer.parseInt(String.valueOf(MyFrame.Products.getValueAt(i, 0)))){
                            exist=true;
                        }
                    }
                    if(exist){
                        JOptionPane.showMessageDialog(dialog,
                                " Уже существует продукт с таким ID!",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE);
                    }else{
                    MyFrame.Products.addRow(new Product(
                            Integer.parseInt(String.valueOf(id.getText())),
                            String.valueOf(name.getText()),
                            Float.valueOf(price.getText())
                    ));
                    dialog.dispose();
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog,
                            " Можно вводить только целые числа",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
                id.setText("");
                name.setText("");
                price.setText("");
            }
        });
        dialog.add(Pane1,BorderLayout.CENTER);
        dialog.add(addCatalog,BorderLayout.SOUTH);
        dialog.setSize(300,200);
        dialog.setModal(true);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.pack();
    }

    public static void AddSale() {
        JDialog dialog=new JDialog();
        dialog.setTitle("Добавление продажи");
        JPanel Pane1=new JPanel(new GridLayout(4,2));
        JTextField id=new JTextField();
        JTextField data=new JTextField();
        SpinnerModel n = new SpinnerNumberModel(0, 0, 500, 10);
        JSpinner number   = new JSpinner(n);
        Pane1.add(new JLabel("Id продажи:"));Pane1.add(id);
        Pane1.add(new JLabel("Выберите товар справа в таблице:"));Pane1.add(new JLabel("   "));
        Pane1.add(new JLabel("Дата:"));Pane1.add(data);
        Pane1.add(new JLabel("Количество:"));Pane1.add(number);
        JButton addSale=new JButton("Добавить");
        MyTableModelProduct Products=new MyTableModelProduct();
        JTable tableProducts=new JTable(Products);
        addSale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int row= tableProducts.getSelectedRow();
                    if (row==-1){
                        JOptionPane.showMessageDialog(dialog,
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
                    MyFrame.Sales.addRow(new Sales(
                            Integer.parseInt(id.getText()),
                            p,
                            String.valueOf(data.getText()),
                            Integer.parseInt(String.valueOf( number.getValue()))
                    ));
                    dialog.dispose();
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog,
                            " Можно вводить только целые числа",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
                id.setText("");
                data.setText("");
                number.setValue(0);
            }
        });
        dialog.add(Pane1,BorderLayout.CENTER);
        dialog.add(addSale,BorderLayout.SOUTH);
        dialog.add(new JScrollPane(tableProducts),BorderLayout.EAST);
        dialog.add(new JLabel("    "),BorderLayout.WEST);
        dialog.setSize(700,200);
        dialog.setModal(true);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.pack();
    }

    public static void AddDeliveries() {
        JDialog dialog=new JDialog();
        dialog.setTitle("Добавление поставки");
        JPanel Pane1=new JPanel(new GridLayout(5,2));
        JTextField id=new JTextField();
        JTextField distributor=new JTextField();
        JTextField producer=new JTextField();
        SpinnerModel n = new SpinnerNumberModel(0, 0, 500, 10);
        JSpinner number   = new JSpinner(n);
        Pane1.add(new JLabel("Id поставки:"));Pane1.add(id);
        Pane1.add(new JLabel("Выберите товар справа в таблице:"));Pane1.add(new JLabel("   "));
        Pane1.add(new JLabel("Поставщик:"));Pane1.add(distributor);
        Pane1.add(new JLabel("Производитель:"));Pane1.add(producer);
        Pane1.add(new JLabel("Количество:"));Pane1.add(number);
        JButton addDeliveries=new JButton("Добавить");
        MyTableModelProduct Products=new MyTableModelProduct();
        JTable tableProducts=new JTable(Products);
        addDeliveries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int row= tableProducts.getSelectedRow();
                    if (row==-1){
                        JOptionPane.showMessageDialog(dialog,
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
                    MyFrame.Deliveries.addRow(new Deliveries(
                            Integer.parseInt(id.getText()),
                            String.valueOf(distributor.getText()),
                            p,
                            String.valueOf(producer.getText()),
                            Integer.parseInt(String.valueOf( number.getValue()))
                    ));
                    dialog.dispose();
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog,
                            " Можно вводить только целые числа",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
                id.setText("");
                distributor.setText("");
                number.setValue(0);
                producer.setText("");
            }
        });
        dialog.add(Pane1,BorderLayout.CENTER);
        dialog.add(addDeliveries,BorderLayout.SOUTH);
        dialog.add(new JScrollPane(tableProducts),BorderLayout.EAST);
        dialog.add(new JLabel("    "),BorderLayout.WEST);
        dialog.setSize(700,200);
        dialog.setModal(true);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.pack();
    }
    public static void ChangeDeliveries(Deliveries s){
        JDialog dialog=new JDialog();
        dialog.setTitle("Изменение продажи");
        JPanel Pane1=new JPanel(new GridLayout(5,2));
        JTextField id=new JTextField();id.setText(String.valueOf(s.getId()));
        JTextField distributor=new JTextField();distributor.setText(s.getDistributor());
        JTextField producer=new JTextField();producer.setText(s.getProducer());
        SpinnerModel n = new SpinnerNumberModel(0, 0, 500, 10);
        JSpinner number   = new JSpinner(n);number.setValue(s.getNumber());
        Pane1.add(new JLabel("Id поставки:"));Pane1.add(id);
        Pane1.add(new JLabel("Выберите товар справа в таблице:"));Pane1.add(new JLabel("   "));
        Pane1.add(new JLabel("Поставщик:"));Pane1.add(distributor);
        Pane1.add(new JLabel("Производитель:"));Pane1.add(producer);
        Pane1.add(new JLabel("Количество:"));Pane1.add(number);
        JButton changeSale=new JButton("Изменить");
        MyTableModelProduct Product=new MyTableModelProduct();
        JTable tableProduct=new JTable(Product);
        int e=Product.getRow(s.getProduct().getId());
        tableProduct.setRowSelectionInterval(e,e);
        changeSale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int row= tableProduct.getSelectedRow();
                    if (row==-1){
                        JOptionPane.showMessageDialog(dialog,
                                " Вы ничего не выбрали",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Product p= new Product(
                            Integer.parseInt(String.valueOf( Product.getValueAt(tableProduct.getSelectedRow(),0))),
                            String.valueOf(Product.getValueAt(tableProduct.getSelectedRow(),1)),
                            Float.valueOf(String.valueOf( Product.getValueAt(tableProduct.getSelectedRow(),2)))
                    );
                    MyFrame.Deliveries.changeRow(s.getId(),new Deliveries(
                            Integer.parseInt(id.getText()),
                            String.valueOf(distributor.getText()),
                            p,
                            String.valueOf(producer.getText()),
                            Integer.parseInt(String.valueOf( number.getValue()))
                    ));
                    dialog.dispose();
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog,
                            " Можно вводить только целые числа",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
                id.setText("");
                distributor.setText("");
                number.setValue(0);
            }
        });
        dialog.add(Pane1,BorderLayout.CENTER);
        dialog.add(changeSale,BorderLayout.SOUTH);
        dialog.add(new JScrollPane(tableProduct),BorderLayout.EAST);
        dialog.add(new JLabel("    "),BorderLayout.WEST);
        dialog.setSize(700,200);
        dialog.setModal(true);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.pack();
    }
    public static void ChangeSale(Sales s){
        JDialog dialog=new JDialog();
        dialog.setTitle("Изменение продажи");
        JPanel Pane1=new JPanel(new GridLayout(5,2));
        JTextField id=new JTextField();id.setText(String.valueOf(s.getId()));
        JTextField data=new JTextField();data.setText(s.getData());
        SpinnerModel n = new SpinnerNumberModel(0, 0, 500, 10);
        JSpinner number   = new JSpinner(n);number.setValue(s.getQuantity());
        Pane1.add(new JLabel("Id продажи:"));Pane1.add(id);
        Pane1.add(new JLabel("Выберите товар справа в таблице:"));Pane1.add(new JLabel("   "));
        Pane1.add(new JLabel("Дата:"));Pane1.add(data);
        Pane1.add(new JLabel("Количество:"));Pane1.add(number);
        JButton changeSale=new JButton("Изменить");
        MyTableModelProduct Product=new MyTableModelProduct();
        JTable tableProduct=new JTable(Product);
        int e=Product.getRow(s.getProduct().getId());
        tableProduct.setRowSelectionInterval(e,e);
        changeSale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int row= tableProduct.getSelectedRow();
                    if (row==-1){
                        JOptionPane.showMessageDialog(dialog,
                                " Вы ничего не выбрали",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Product p= new Product(
                            Integer.parseInt(String.valueOf( Product.getValueAt(tableProduct.getSelectedRow(),0))),
                            String.valueOf(Product.getValueAt(tableProduct.getSelectedRow(),1)),
                            Float.valueOf(String.valueOf( Product.getValueAt(tableProduct.getSelectedRow(),2)))
                    );
                    MyFrame.Sales.changeRow(s.getId(),new Sales(
                                    Integer.parseInt(id.getText()),
                                    p,
                                    String.valueOf(data.getText()),
                                    Integer.parseInt(String.valueOf( number.getValue()))
                            ));
                    dialog.dispose();
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog,
                            " Можно вводить только целые числа",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
                id.setText("");
                data.setText("");
                number.setValue(0);
            }
        });
        dialog.add(Pane1,BorderLayout.CENTER);
        dialog.add(changeSale,BorderLayout.SOUTH);
        dialog.add(new JScrollPane(tableProduct),BorderLayout.EAST);
        dialog.add(new JLabel("    "),BorderLayout.WEST);
        dialog.setSize(700,200);
        dialog.setModal(true);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.pack();
    }
}
