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
