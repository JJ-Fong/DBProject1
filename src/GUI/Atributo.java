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
public class Atributo {
    String nombre;
    String tipo;
    int tamanio;
    int indice;  

    public Atributo() {
        this.nombre = "";
        this.tipo = "";
        this.tamanio = 0;
        this.indice = 0;
    }

    public Atributo(String nombre, String tipo, int tamaño, int indice) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamanio = tamaño;
        this.indice = indice;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    } 

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    
}
