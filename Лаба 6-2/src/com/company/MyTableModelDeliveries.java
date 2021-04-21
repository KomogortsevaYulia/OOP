package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MyTableModelDeliveries extends AbstractTableModel {

    private List<Deliveries> data;

    public MyTableModelDeliveries(){
        DBWorker.initDB();
        data=DBWorker.selectDeliveries();
        DBWorker.closeDB();
    }
    public void update(){
        DBWorker.initDB();
        data=DBWorker.selectDeliveries();
        DBWorker.closeDB();
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Integer.class;
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Deliveries c= data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getDistributor();
            case 2:
                return c.getProduct().getId();
            case 3:
                return c.getProduct().getName();
            case 4:
                return c.getProducer();
            case 5:
                return c.getNumber();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id deliveries";
            case 1:
                return "Distributor";
            case 2:
                return "Id product";
            case 3:
                return "Name";
            case 4:
                return "Producer";
            case 5:
                return "Number";
        }
        return null;
    }
    public void addRow(Deliveries p){
        DBWorker.initDB();
        DBWorker.addDeliveries(p);
        DBWorker.closeDB();
        update();
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    public void changeRow(int id,Deliveries p){
        DBWorker.initDB();
        DBWorker.changeDeliveries(id,p);
        DBWorker.closeDB();
        update();
    }
    public void deleteRow(int id){
        DBWorker.initDB();
        DBWorker.deleteDeliveries(id);
        DBWorker.closeDB();
        update();
    }
}
