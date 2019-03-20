package com.alxizr.recyclerviewmultipleviewholdersapp.Adapters.DataObjects;

public class SingleItem3 {
    private Number age;

    public SingleItem3() {
        age = -1983;
    }//default constructor

    public SingleItem3(Number _number) {
        this.setNumber(_number);
    }//constructor

    public Number getNumber() {
        return this.age;
    }

    public void setNumber(Number _number) {
        this.age = _number;
    }
}
