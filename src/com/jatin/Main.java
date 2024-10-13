package com.jatin;

import com.jatin.enums.Constraints;
import com.jatin.enums.DataType;
import com.jatin.model.DataBase;
import com.jatin.model.Table;
import com.jatin.model.TableHeader;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	//    write your code here
    //    Design In-memory SQL-like Database where:-
    //    It should be possible to create or delete tables in a database.
    //    The supported column types are string and int.
    //    It should be possible to insert records in a table.
    //    It should be possible to print all records in a table.
    //    It should be possible to filter and display records whose column values match a given value.


     DataBaseManager dataBaseManager = DataBaseManager.getInstance();
     DataBase dataBase1 = dataBaseManager.createDataBase("employee");
     DataBase dataBase2 = dataBaseManager.createDataBase("expense");
     DataBase dataBase3 = dataBaseManager.createDataBase("products");

     dataBaseManager.printAllDataBase();

     dataBaseManager.removeDataBase("expense");

     System.out.print("post deletion");
     dataBaseManager.printAllDataBase();

     List<TableHeader> tableHeaderList = new ArrayList<>();
     tableHeaderList.add(new TableHeader("name", DataType.STRING, Constraints.STRING_LENGTH_20));
     tableHeaderList.add(new TableHeader("salary", DataType.INTEGER, Constraints.INT_MAX_VALUE_1024));

     Table table = dataBase1.createTable("EmpData",tableHeaderList);
     try{
       table.insertRowInTable(List.of("jj1",10000002));
       table.insertRowInTable(List.of("jj2",10093882));
     }catch (Exception ex){
      System.out.println("exception ->"+ex.getMessage());
     }


    }
}
