package com.company;


import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class MyTableModel extends AbstractTableModel {
    public static TransportManager List =new TransportManager();

    public MyTableModel() {
        List.add(new CarTransport("Toyota", 2010, "В гараже", 85));
        List.add(new CarTransport("BMW", 2010, "В пути", 110));
        List.add(new TrainTransport(100, "Грузовой", 12, "В пути", 85));
        List.add(new TrainTransport(1, "Почтовый", 21, "Ремонт", 90));
        List.add(new ExpressTrain(38, "Грузовой", 12, "В пути", 85));
        List.add(new ExpressTrain(1, "Почтовый", 21, "Ремонт", 90));
        List.add(new CarTransport("Audi", 1999, "В гараже", 45));
        List.add(new CarTransport("Ford", 2007, "В пути", 110));
        List.add(new TrainTransport(28, "Грузовой", 52, "В пути", 20));
        List.add(new TrainTransport(1, "Почтовый", 3, "Ремонт", 95));
        List.add(new ExpressTrain(16, "Грузовой", 45, "В пути", 89));
        List.add(new ExpressTrain(1, "Почтовый", 47, "Ремонт", 110));
        List.add(new CarTransport("Hyundai", 2010, "В гараже", 85));
        List.add(new CarTransport("Kia", 2010, "В пути", 110));
        List.add(new TrainTransport(15, "Грузовой", 762, "В пути", 115));
        List.add(new TrainTransport(166, "Почтовый", 11, "Ремонт", 90));
        List.add(new ExpressTrain(99, "Грузовой", 10, "В пути", 85));
        List.add(new ExpressTrain(2, "Почтовый", 29, "Ремонт", 90));
        List.add(new CarTransport("Nissan", 2003, "В гараже", 85));
        List.add(new CarTransport("Skoda", 2000, "В пути", 110));
        List.add(new TrainTransport(160, "Грузовой", 18, "В пути", 675));
        List.add(new TrainTransport(52, "Почтовый", 29, "Ремонт", 80));
        List.add(new ExpressTrain(69 ,"Грузовой", 52, "В пути", 65));
        List.add(new ExpressTrain(1, "Почтовый", 61, "Ремонт", 112));
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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transport transp= List.get(rowIndex);
        if (transp instanceof CarTransport){
            switch (columnIndex) {
                case 0:
                    return rowIndex;
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
                    return rowIndex;
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
                    return rowIndex;
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
