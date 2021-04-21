package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MyTableModelExistence  extends AbstractTableModel {

    private List<Product> data;

    public MyTableModelExistence(){
        DBWorker.initDB();
        data=DBWorker.selectExistence();
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
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
