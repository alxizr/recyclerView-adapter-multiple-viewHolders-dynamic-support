package com.alxizr.recyclerviewmultipleviewholdersapp.Adapters.DataObjects;

public class SingleItem2 {
    private String name;

    public SingleItem2(){
        name = new String("default name");
    }//default constructor


    public SingleItem2(String _string){
        this.setString(_string);
    }//constructor


    public String getString(){
        return this.name;
    }

    public void setString(String _string){
        this.name = new String(_string);
    }
}
