package com.jatin.model;

import com.jatin.enums.Constraints;
import com.jatin.execeptions.InvalidRowValueException;

import java.util.*;

public class Table {
    private String name;
    private int rowPoint;
    private List<TableHeader> tableHeaderList;
    private List<TableRow> tableRowList;
    private Date createdAt;
    private Date updatedAt;

    public Table(String name , List<TableHeader> columns){
        rowPoint = 0;
        this.tableHeaderList = columns;
        this.tableRowList = new ArrayList<>();
        createdAt = new Date();
        this.name = name;
    }

    public int insertRowInTable(List<Object> rowValues) throws InvalidRowValueException{
        if(!validateRowValues(rowValues)){
            throw new InvalidRowValueException("incorrect row value is present");
        }


        HashMap<String,Object> columnVsRows = new HashMap<>();
        for(int i=0 ; i<tableHeaderList.size() ; i++){
            columnVsRows.put(tableHeaderList.get(i).getColumnName(),rowValues.get(i));
        }
        TableRow row = new TableRow(rowPoint,columnVsRows);
        tableRowList.add(rowPoint,row);
        rowPoint++;
        return row.getRowId();
    }

    public void printTable(){
        for(int i=0 ; i<tableHeaderList.size() ; i++){
            System.out.print(tableHeaderList.get(i).getColumnName()+" ");
        }
        System.out.println("");
        for(int i=0 ; i<tableRowList.size() ; i++){
            HashMap<String,Object> tableRow = tableRowList.get(i).getColumnVsValue();
            for(Object keyVal : tableRow.values()){
                System.out.print(keyVal.toString()+" ");
            }
            System.out.println("");
        }
    }

    public void deleteRowInTable(int rowId) throws InvalidRowValueException{
        if(rowId < 0 || rowId >= rowPoint){
            throw new InvalidRowValueException("invaliid row");
        }
        tableRowList.remove(rowId);
    }

    private boolean validateRowValues(List<Object> rowValues){
          return true;
//        implement this method
//        for(int i=0 ; i<rowValues.size() ; i++){
//            Constraints contraintForThisCell = tableHeaderList.get(i).getColumnConstraints();
//            switch (contraintForThisCell){
//                case :
//                case :
//            }
//        }
    }

}
