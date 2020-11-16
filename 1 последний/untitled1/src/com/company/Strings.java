package com.company;
class Strings {
    private String S;
    public Strings() {  //конструктор по умолчанию//
        this.S ="beautiful beach";
    }
    public Strings(String S) {//конструктор с параметрами
        this.S = "rat";
    }
    public Strings(Strings String) {     //конструктор копирования
        this.S = String.S;
    }


    public String getS() {
        return S;
    }
    public void setS(String s) {
        this.S = s;
    }

}
