/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
