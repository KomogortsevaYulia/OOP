package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MyTableModelSales extends AbstractTableModel {
    private List<Sales> data;

    public MyTableModelSales(){
        DBWorker.initDB();
        data=DBWorker.selectSales();
        DBWorker.closeDB();
    }

    public void update(){
        DBWorker.initDB();
        data=DBWorker.selectSales();
        DBWorker.closeDB();
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id sales";
            case 1:
                return "Id product";
            case 2:
                return "Name";
            case 3:
                return "Data";
            case 4:
                return "Price";
            case 5:
                return "Quantity";
            case 6:
                return "Sum";
        }
        return null;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Float.class;
            case 5:
                return Integer.class;
            case 6:
                return Float.class;
        }
        return null;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sales c= data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getProduct().getId();
            case 2:
                return c.getProduct().getName();
            case 3:
                return c.getData();
            case 4:
                return c.getProduct().getPrice();
            case 5:
                return c.getQuantity();
            case 6:
                return c.getSum();
        }
        return null;
    }
    public void addRow(Sales s){
        DBWorker.initDB();
        DBWorker.addSales(s);
        DBWorker.closeDB();
        update();
    }
    public void changeRow(int id,Sales s){
        DBWorker.initDB();
        DBWorker.changeSales(id,s);
        DBWorker.closeDB();
        update();
    }
    public void deleteRow(int id){
        DBWorker.initDB();
        DBWorker.deleteSales(id);
        DBWorker.closeDB();
        update();
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
