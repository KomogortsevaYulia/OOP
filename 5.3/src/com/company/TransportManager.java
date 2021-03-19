package com.company;

import java.util.ArrayList;
import java.util.List;

public class TransportManager {
    private List<Transport> TransportList=new ArrayList();

    public void add(Transport tr) {
        this.TransportList.add(tr);
    }
    public void remove(int i){
        this.TransportList.remove(i);
    }
    public int size() {
        return this.TransportList.size();
    }
    public Transport get(int index) {
        return TransportList.get(index);
    }


    public Transport set(int id,Transport transp) {
        return TransportList.set(id,transp);
    }
}
