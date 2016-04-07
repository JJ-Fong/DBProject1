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

/**
 *
 * @author William
 */
public class AtributoSelect {
    String nameColumn;
    String nameTB;

    public AtributoSelect( String nameTB,String nameColumn) {
        this.nameColumn = nameColumn;
        this.nameTB = nameTB;
    }

    public AtributoSelect() {
    }

    
    public String getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }

    public String getNameTB() {
        return nameTB;
    }

    public void setNameTB(String nameTB) {
        this.nameTB = nameTB;
    }
    
    
}
