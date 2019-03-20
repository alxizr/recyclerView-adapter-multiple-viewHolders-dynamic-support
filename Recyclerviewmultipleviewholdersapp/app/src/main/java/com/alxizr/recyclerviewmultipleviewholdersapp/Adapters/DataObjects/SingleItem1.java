package com.alxizr.recyclerviewmultipleviewholdersapp.Adapters.DataObjects;

public class SingleItem1 {
    private String name;
    private Number age;

    public SingleItem1(){
        name = new String("default name");
        age = -1983;
    }//default constructor


    public SingleItem1(Number _number, String _string){
        this.setNumber(_number);
        this.setString(_string);
    }//constructor


    public String getString(){
        return this.name;
    }

    public Number getNumber(){
        return this.age;
    }

    public void setString(String _string){
        this.name = new String(_string);
    }

    public void setNumber(Number _number){
        this.age = _number;
    }
}
