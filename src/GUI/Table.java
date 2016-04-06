/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;

/**
 *
 * @author Javier Fong
 */
public class Table {
    String name;
    int size;
    
    ArrayList<Atributo> atributes; 
    ArrayList<primaryKey> primaryKeys; 
    ArrayList<foreignKey> foreignKeys;
    ArrayList<Condition> conditions;
    ArrayList checkString; 

    public Table() {
        this.name = "";
        this.size = 0;
        this.atributes = new ArrayList<>();
        this.primaryKeys = new ArrayList<>();
        this.foreignKeys = new ArrayList<>();
        this.conditions = new ArrayList<>();
        this.checkString = new ArrayList();
    }

    
    public Table(String name, int size, ArrayList<Atributo> atributes, ArrayList<primaryKey> primaryKeys, ArrayList<foreignKey> foreignKeys, ArrayList<Condition> conditions, ArrayList checkString) {
        this.name = name;
        this.size = size;
        this.atributes = atributes;
        this.primaryKeys = primaryKeys;
        this.foreignKeys = foreignKeys;
        this.conditions = conditions;
        this.checkString = checkString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Atributo> getAtributes() {
        return atributes;
    }

    public void setAtributes(ArrayList<Atributo> atributes) {
        this.atributes = atributes;
    }

    public ArrayList<primaryKey> getPrimaryKeys() {
        return primaryKeys;
    }

    public void setPrimaryKeys(ArrayList<primaryKey> primaryKeys) {
        this.primaryKeys = primaryKeys;
    }

    public ArrayList<foreignKey> getForeignKeys() {
        return foreignKeys;
    }

    public void setForeignKeys(ArrayList<foreignKey> foreignKeys) {
        this.foreignKeys = foreignKeys;
    }

    public ArrayList<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<Condition> conditions) {
        this.conditions = conditions;
    }

    public ArrayList getCheckString() {
        return checkString;
    }

    public void setCheckString(ArrayList checkString) {
        this.checkString = checkString;
    }
    
    
    
}
