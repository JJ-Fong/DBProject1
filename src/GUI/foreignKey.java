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

import java.util.ArrayList;

/**
 *
 * @author Javier Fong
 */
public class foreignKey {
    String name; 
    ArrayList atributes; 
    String referenceTable;
    ArrayList referenceAtributes; 

    public foreignKey() {
        this.name = "";
        this.atributes = new ArrayList();
        this.referenceTable = "";
        this.referenceAtributes = new ArrayList();
    }

    public foreignKey(String name, ArrayList atributes, String referenceTable, ArrayList referenceAtributes) {
        this.name = name;
        this.atributes = atributes;
        this.referenceTable = referenceTable;
        this.referenceAtributes = referenceAtributes;
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

    public String getReferenceTable() {
        return referenceTable;
    }

    public void setReferenceTable(String referenceTable) {
        this.referenceTable = referenceTable;
    }

    public ArrayList getReferenceAtributes() {
        return referenceAtributes;
    }

    public void setReferenceAtributes(ArrayList referenceAtributes) {
        this.referenceAtributes = referenceAtributes;
    }
    
    
}
