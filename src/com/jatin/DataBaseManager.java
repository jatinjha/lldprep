package com.jatin;

import com.jatin.execeptions.NameAlreadyExistsException;
import com.jatin.model.DataBase;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class DataBaseManager {

//    Design In-memory SQL-like Database where:-
//    It should be possible to create or delete tables in a database.
//    The supported column types are string and int.
//    It should be possible to insert records in a table.
//    It should be possible to print all records in a table.
//    It should be possible to filter and display records whose column values match a given value.

    HashMap<String, DataBase> databaseNameVsDateBase;
    private volatile DataBaseManager dataBaseManagerInstance;


    private DataBaseManager(){
       databaseNameVsDateBase = new HashMap<>();
    }


    public DataBaseManager getInstance(){
        DataBaseManager temporaryInstance = dataBaseManagerInstance;
        if(Objects.isNull(temporaryInstance)){
            synchronized (this){
                temporaryInstance = dataBaseManagerInstance;
                if(Objects.isNull(temporaryInstance)) {
                    dataBaseManagerInstance = new DataBaseManager();
                }
            }
        }
        return dataBaseManagerInstance;
    }

    public DataBase createDataBase(String dataBaseName) throws NameAlreadyExistsException {
        if(databaseNameVsDateBase.containsKey(dataBaseName)){
           throw new NameAlreadyExistsException("this db name is already present");
        }

        String dataBaseId = UUID.randomUUID().toString();
        DataBase dataBase = new DataBase(dataBaseId,dataBaseName);
        databaseNameVsDateBase.put(dataBaseName,dataBase);
        return dataBase;
    }

}
