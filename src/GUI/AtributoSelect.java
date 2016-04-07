/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
