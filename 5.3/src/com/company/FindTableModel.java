package com.company;

import javax.swing.table.AbstractTableModel;

public class FindTableModel extends AbstractTableModel {

    TransportManager List;

    public FindTableModel(TransportManager list){
        List=list;
    }
    @Override
    public int getRowCount() {
        return List.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transport transp= List.get(rowIndex);
        if (transp instanceof CarTransport){
            switch (columnIndex) {
                case 0:
                    return transp.getId();
                case 1:
                    return "Машина";
                case 2:
                    return transp.getCondition();
                case 3:
                    return ((CarTransport) transp).getModel();
                case 4:
                    return transp.getSpeed();
                case 6:
                    return ((CarTransport) transp).getYears();
            }
        }

        if (transp instanceof ExpressTrain){
            switch (columnIndex) {
                case 0:
                    return transp.getId();
                case 1:
                    return "Экспресс";
                case 2:
                    return transp.getCondition();
                case 5:
                    return ((TrainTransport) transp).getType();
                case 4:
                    return transp.getSpeed();
                case 7:
                    return ((TrainTransport) transp).getNumber();
                case 8:
                    return ((TrainTransport) transp).getCarriage();
            }
        }
        if (transp instanceof TrainTransport){
            switch (columnIndex) {
                case 0:
                    return transp.getId();
                case 1:
                    return "Поезд";
                case 2:
                    return transp.getCondition();
                case 5:
                    return ((TrainTransport) transp).getType();
                case 4:
                    return transp.getSpeed();
                case 7:
                    return ((TrainTransport) transp).getNumber();
                case 8:
                    return ((TrainTransport) transp).getCarriage();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "№";
            case 1:
                return "Вид";
            case 2:
                return "Состояние";
            case 3:
                return "Модель";
            case 4:
                return "Скорость";
            case 5:
                return "Тип";
            case 6:
                return "Год";
            case 7:
                return "Номер";
            case 8:
                return "Число вагонов";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Integer.class;
            case 5:
                return String.class;
            case 6:
                return Integer.class;
            case 7:
                return Integer.class;
            case 8:
                return Integer.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void setValueAt(Transport t, int rowIndex) {
        List.set(rowIndex,t);
        this.fireTableDataChanged();
    }

    public Transport getValueAt(int rowIndex) {
        return List.get(rowIndex);
    }

    public void AddValueAt(Transport transp) {
        List.add(transp);
        this.fireTableDataChanged();
    }

    public void DeleteValueAt(int i) {
        List.remove(i);
        this.fireTableDataChanged();
    }
}
