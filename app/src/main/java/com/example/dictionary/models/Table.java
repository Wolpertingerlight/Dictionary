package com.example.dictionary.models;

import java.util.ArrayList;

public class Table {
    private String tableName;
    private ArrayList<String> firstColumn;
    private ArrayList<String> secondColumn;

    public Table(String tableName) {
        this.tableName = tableName;
        firstColumn = new ArrayList<>();
        secondColumn = new ArrayList<>();

    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public ArrayList<String> getFirstColumn() {
        return firstColumn;
    }
    public void setFirstColumn(ArrayList<String> firstColumn) {
        this.firstColumn = firstColumn;
    }
    public void addToFirstColumn(String item) {this.firstColumn.add(item);}

    public ArrayList<String> getSecondColumn() {
        return secondColumn;
    }
    public void setSecondColumn(ArrayList<String> secondColumn) { this.secondColumn = secondColumn; }
    public void addToSecondColumn(String item) {this.secondColumn.add(item);}
}
