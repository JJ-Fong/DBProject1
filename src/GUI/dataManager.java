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
public interface dataManager {
    //Metodos para DDL
    /*
    Param: name, nombre de una base de datos
    
    existDB(String) regresa true si la base de datos existe
    y false si la base de datos no existe
    */
    
    public boolean existDB(String name);
    
    /*
    Param:  name, nombre de una base de datos
          
    createDB(String) crea la base de datos STRING vacia
    */
    
    public void createDB(String name);
    
    /*
    Param:  actual, nombre de una base de datos
            nuevo, nuevo nombre de la base de datos
    
    cambia el nombre de la base de datos ACTUAL por NUEVO
    */
    public void renameDB(String actual, String nuevo);
    
    /*
    Muestra todas las bases de datos existentes
    */
    public ArrayList showDB(); 
    
    /*
    Param:  actual, nombre de una base de datos
            nuevo, nuevo nombre de la base de datos
    
    cambia el nombre de la base de datos ACTUAL por NUEVO
    */
    public void dropDB(String name);
    
    /*
    params: name, nombre de la base de datos
    
    Selecciona la base de datos sobre la que se 
    ejecutaran los querys
    */
    public void selectDB(String name);
    
    
    /*
    params: TableName, nombre de la tabla
    
    busca la tabla TABLENAME en la base de datos seleccionda
    */
    public boolean existTable(String TableName);
    
    
    /*
    params: atributos, lista de atributos
            
    crea la tabla TABLENAME con los atributos en la
    lista ATRIBUTOS en la base de datos actual; 
    */
    public void createTable(Table newTable); 
    
    /*
    params: actual, nombre de una tabla en la base de datos actual
            nuevo, nuevo nombre de la tabla en la base de datos actual
    
    cambia el nombre de la tabla ACTUAL por NUEVO
    */
    public void renameTable(String oldName, String newName);
    
    /*
    params: TableName, nombre de la tabla a modificar
            nuevo, atributo a agregar a la tabla
    
    Agrega una columna NUEVO en la tabla TableName
    */
    public void addColumn(String TableName,Atributo nuevo, ArrayList<primaryKey> primaryKeys, ArrayList<foreignKey> foreignKeys, ArrayList<Check> conditions);
    
    /*
    params: TableName, nombre de la tabla
            primKey | forKey
    
    Dependiendo del segun el segundo paramatro ejecuta diferente procedimiento.
    El segundo parametro puede ser una llave primaria o una llave foranea.
    */
    public void addConstraint(String TableName, primaryKey primKey);
    public void addConstraint(String TableName, foreignKey forKey);
    
    
    /*
    params: TableName, nombre de la table 
            pk, is primary key
            fk, is foreign key
            ColName, nombre del atributo que se le desea agregar el restriccion
    
    Sobrescribe las costraints actuales de COLNAME de la tabla TABLENAME
    */
    public void dropConstraint(String TableName, String idConstraint); 
    
    /*
    params: TableName, nombre de la tabla
            columna, nombre de columna en la tabla
    
    Elimina la columna COLUMNA de la tabla TABLENAME
    */
    public void dropColumn(String TableName, String column);
    
    
    /*
    params: TableName, nombre de una tabla
    
    Elimina la tabla TABLENAME de la base de datos actual
    */
    public void dropTable(String TableName);
    
    /*
    Regresa las tablas de la base de datos actual
    */
    public ArrayList<Table> showTables(); 
    
    /*
    params: TableName, nombre de la tabla
    
    Regresa las columnas de la tabla TABLENAME
    */
    public ArrayList<Atributo> showColumns(String TableName);
    
    //Metodos para DML
    
        /*
    params: NomTabla (nombre de la Tabla), columns (atributos de cada tabla), values(arreglo de valores de cada tabla con su tipo y su ID)
    Hace el insert de todos los registros en una tabla.
    */
    public void insertIntoTable(String nomTabla, ArrayList<String> columns, ArrayList values);
    
    /*
    params: NomTabla (nombre de la Tabla), columns (atributos de cada tabla), values(arreglo de valores de cada tabla con su tipo y su ID)
    Hace el update de los registros seleccionados en una tabla.
    */

//Falta ver la condicion del WHERE
    public void updateTable (String nomTabla, ArrayList<String> columns, ArrayList values);
    
    /*
    params: NomTabla (nombre de la Tabla)
    Hace el delelte de todos los registros seleccionados en una tabla.
    */
    //Falta ver la condicion del WHERE
    public void deleteFromTable (String nomTabla);
}
