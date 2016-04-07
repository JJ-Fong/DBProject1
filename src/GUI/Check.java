/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;

/**
 *
 * @author William
 */
public class Check {
    ArrayList<Condition> condi;
    String nombreCons;
    String checkString;

    public Check(ArrayList<Condition> condi, String nombreCons) {
        this.condi = condi;
        this.nombreCons = nombreCons;
    }

    public ArrayList<Condition> getCondi() {
        return condi;
    }

    public void setCondi(ArrayList<Condition> condi) {
        this.condi = condi;
    }

    public String getNombreCons() {
        return nombreCons;
    }

    public void setNombreCons(String nombreCons) {
        this.nombreCons = nombreCons;
    }

    public String getCheckString() {
        return checkString;
    }

    public void setCheckString(String checkString) {
        this.checkString = checkString;
    }
    
    
}
