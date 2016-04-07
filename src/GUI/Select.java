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

import java.util.ArrayList;

/**
 *
 * @author William
 */
public class Select {
    ArrayList namesTB;
    ArrayList<AtributoSelect> namesColumn;

    public Select() {
    }

    public Select(ArrayList namesTB, ArrayList<AtributoSelect> namesColumn) {
        this.namesTB = namesTB;
        this.namesColumn = namesColumn;
    }

    public ArrayList getNamesTB() {
        return namesTB;
    }

    public void setNamesTB(ArrayList namesTB) {
        this.namesTB = namesTB;
    }

    public ArrayList<AtributoSelect> getNamesColumn() {
        return namesColumn;
    }

    public void setNamesColumn(ArrayList<AtributoSelect> namesColumn) {
        this.namesColumn = namesColumn;
    }
    
    
    
}
