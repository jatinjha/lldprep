package com.jatin.model;

import com.jatin.execeptions.InvalidColumnException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TableRow {
    private int rowId;
    private HashMap<String, Object> columnVsValue;
    private Date createdAt;
    private Date updatedAt;

    public TableRow(int rowId , HashMap<String,Object> columnVsValue){
        this.rowId = rowId;
        this.columnVsValue = columnVsValue;
    }

    public void updateTable(List<String> columns , List<Object> values){
        for(int i=0 ; i<columns.size() ; i++){
            String column = columns.get(i);
            Object value = columnVsValue.getOrDefault(column,null);
            if(Objects.isNull(value)){
                throw new InvalidColumnException("invalid column in query");
            }
            columnVsValue.put(column,value);
        }
    }

    public int getRowId() {
        return rowId;
    }

    public HashMap<String, Object> getColumnVsValue() {
        return columnVsValue;
    }
}
