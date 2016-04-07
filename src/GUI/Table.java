/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*Universidad del Valle de Guatemala
Prof. Sergio Molina
Proyecto No. 1 - CC3040 Bases de Datos
Integrantes: 
Mario Barrientos - Carné No. 13039
Javier Fong - Carné No. 13118
William Fuentes - Carné No. 13324
*/

package GUI;

/**
 *
 * @author William
 */
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
    ArrayList<Check> checks;
     

    public Table() {
        this.name = "";
        this.size = 0;
        this.atributes = new ArrayList<>();
        this.primaryKeys = new ArrayList<>();
        this.foreignKeys = new ArrayList<>();
        this.checks = new ArrayList<>();
    }

    /**
     *
     * @param name
     * @param size
     * @param atributes
     * @param primaryKeys
     * @param foreignKeys
     * @param conditions
     * @param checkString
     */
    public Table(String name, int size, ArrayList<Atributo> atributes, ArrayList<primaryKey> primaryKeys, ArrayList<foreignKey> foreignKeys, ArrayList<Check> checks) {
        this.name = name;
        this.size = size;
        this.atributes = atributes;
        this.primaryKeys = primaryKeys;
        this.foreignKeys = foreignKeys;
        this.checks = checks;

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

    public ArrayList<Check> getChecks() {
        return checks;
    }

    public void setChecks(ArrayList<Check> checks) {
        this.checks = checks;
    }

 
    
    
}
