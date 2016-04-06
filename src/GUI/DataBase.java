/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Javier Fong
 */
public class DataBase {
    String name; 
    long tables; 
    String dirPath; 
    
    public DataBase() {
        this.name = "";
        this.tables = 0; 
        this.dirPath = ""; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTables() {
        return tables;
    }

    public void setTables(long tables) {
        this.tables = tables;
    }

    public String getDirPath() {
        return dirPath;
    }

    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }
    
    
}
