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

/**
 *
 * @author William
 */
public class Value {
    String tipo;
    String value;
    String id;

    public Value(String tipo, String value, String id) {
        this.tipo = tipo;
        this.value = value;
        this.id = id;
    }
    
    public Value(String tipo, String value){
        this.tipo = tipo;
        this.value = value;
    }

    public Value() {
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
