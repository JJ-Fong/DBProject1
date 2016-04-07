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
public class Asignacion {
    String nameColumna;
    String value;
    String tipo;

    public Asignacion(String nameColumna, String value, String tipo) {
        this.nameColumna = nameColumna;
        this.value = value;
        this.tipo = tipo;
    }

    public Asignacion() {
    }

    public String getNameColumna() {
        return nameColumna;
    }

    public void setNameColumna(String nameColumna) {
        this.nameColumna = nameColumna;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}

