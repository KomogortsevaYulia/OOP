package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MyTableModelProduct extends AbstractTableModel {

    private List<Product> data;

    public MyTableModelProduct(){
        DBWorker.initDB();
        data=DBWorker.selectProduct();
        DBWorker.closeDB();
    }
    public void update(){
        DBWorker.initDB();
        data=DBWorker.selectProduct();
        DBWorker.closeDB();
        this.fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return data.size();
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id product";
            case 1:
                return "Name";
            case 2:
                return "Price";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Float.class;
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product p= data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getName();
            case 2:
                return p.getPrice();
        }
        return null;
    }
    public void addRow(Product p){
        DBWorker.initDB();
        DBWorker.addProduct(p);
        DBWorker.closeDB();
        update();
    }
    public void changeRow(int id,Product p){
        DBWorker.initDB();
        DBWorker.changeProduct(id,p);
        DBWorker.closeDB();
        update();
    }
    public void deleteRow(int id){
        DBWorker.initDB();
        DBWorker.deleteProduct(id);
        DBWorker.closeDB();
        update();
    }
    public int getRow(int id){
        int y=0;
        for (int i = 0; i < data.size(); i++) {
            if (id==data.get(i).getId()){
                y=i;
            }
        }
        return y;
    }
    public Object[] getId() {
        DBWorker.initDB();
        List<Product> l=DBWorker.selectProduct();
        String[] j=new String[l.size()];
        for (int i = 0; i < l.size(); i++) {
            j[i]=l.get(i).getId()+"  "+l.get(i).getName();
        }
        DBWorker.closeDB();
        return j;
    }
}
