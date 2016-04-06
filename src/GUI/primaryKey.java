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
public class primaryKey {
    String name; 
    ArrayList atributes; 

    public primaryKey() {
        this.name = "";
        this.atributes = new ArrayList(); 
    }

    public primaryKey(String name, ArrayList atributes) {
        this.name = name;
        this.atributes = atributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getAtributes() {
        return atributes;
    }

    public void setAtributes(ArrayList atributes) {
        this.atributes = atributes;
    }
    
}
