package com.jatin;

import com.jatin.execeptions.DataBaseDoesNotExistException;
import com.jatin.execeptions.NameAlreadyExistsException;
import com.jatin.model.DataBase;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;

public class DataBaseManager {

    HashMap<String, DataBase> databaseNameVsDateBase;
    private static volatile DataBaseManager dataBaseManagerInstance;
    private static Object mutex = new Object();


    private DataBaseManager(){
       databaseNameVsDateBase = new HashMap<>();
    }


    public static DataBaseManager getInstance(){
        DataBaseManager temporaryInstance = dataBaseManagerInstance;
        if(Objects.isNull(temporaryInstance)){
            synchronized (mutex){
                temporaryInstance = dataBaseManagerInstance;
                if(Objects.isNull(temporaryInstance)) {
                    temporaryInstance = dataBaseManagerInstance = new DataBaseManager();
                }
            }
        }
        return temporaryInstance;
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

    public void printAllDataBase(){
        for(String dbName : databaseNameVsDateBase.keySet()){
            System.out.println("db name ->"+dbName);
        }
    }

    public void removeDataBase(String dbName){
        if(!databaseNameVsDateBase.containsKey(dbName)){
            throw new DataBaseDoesNotExistException("database does not exist with name"+dbName);
        }
        databaseNameVsDateBase.remove(dbName);
    }

}
