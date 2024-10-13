package com.jatin.model;

import com.jatin.enums.Constraints;
import com.jatin.enums.DataType;

public class TableHeader {
    private String columnName;
    private DataType dataType;
    private Constraints columnConstraints;

    public TableHeader(String columnName, DataType dataType, Constraints columnConstraints) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.columnConstraints = columnConstraints;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public Constraints getColumnConstraints() {
        return columnConstraints;
    }

    public void setColumnConstraints(Constraints columnConstraints) {
        this.columnConstraints = columnConstraints;
    }
}
