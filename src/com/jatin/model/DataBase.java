package com.jatin.model;

import java.util.HashMap;

public class DataBase {
    private String name;
    private String id;
    HashMap<String,Table> tableNameVsTable;

    public DataBase(String id , String dataBaseName){
        this.name = dataBaseName;
        this.id = id;
        tableNameVsTable = new HashMap<>();
    }

    public createTable(){

    }
}
