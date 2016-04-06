/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;



import GUI.Atributo;
import GUI.foreignKey;
import GUI.primaryKey;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class column {
    ArrayList<primaryKey> primary;
    ArrayList<foreignKey> fore;
    Atributo at;

    public column(ArrayList<primaryKey> primary, ArrayList<foreignKey> fore,Atributo at) {
        this.primary = primary;
        this.fore = fore;
        this.at=at;
    }

    public ArrayList<primaryKey> getPrimary() {
        return primary;
    }

    public void setPrimary(ArrayList<primaryKey> primary) {
        this.primary = primary;
    }

    public ArrayList<foreignKey> getFore() {
        return fore;
    }

    public void setFore(ArrayList<foreignKey> fore) {
        this.fore = fore;
    }

    public Atributo getAt() {
        return at;
    }

    public void setAt(Atributo at) {
        this.at = at;
    }
    
    
    
}
