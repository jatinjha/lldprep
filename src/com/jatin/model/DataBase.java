package com.jatin.model;

import com.jatin.execeptions.InvalidRowValueException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DataBase {
    private String name;
    private String id;
    HashMap<String,Table> tableNameVsTable;
    private Date createdAt;

    public DataBase(String id , String dataBaseName){
        this.name = dataBaseName;
        this.id = id;
        this.tableNameVsTable = new HashMap<>();
        this.createdAt = new Date();
    }

    public Table createTable(String tableName , List<TableHeader> columns) {
        if(tableNameVsTable.containsKey(tableName)){
            return tableNameVsTable.get(tableName);
        }

        Table table = new Table(tableName,columns);
        tableNameVsTable.put(tableName,table);
        return table;
    }

    public int insertRowInTable(Table table , List<Object> rowValues) throws InvalidRowValueException {
        return table.insertRowInTable(rowValues);
    }
}
