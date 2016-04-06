/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Javier Fong
 */
public class DBDataManager implements dataManager{
    DataBase actual; //BASE DE DATOS ACTUAL 
    
    /* CONSTRUCTOR */ 
    public DBDataManager() {
        actual = null; //SE COMIENZA SI CONOCER LA BASE DE DATOS
    }
    
    /*
    params: fileName, nombre del archivo que deseamos obtener
    
    regresa el jsonArray que esta en el archivo FILENAME
    */
    private JSONArray getJsonArray(String fileName) {
        JSONArray jsonArray = new JSONArray();
        try {
            JSONParser parser = new JSONParser();
            FileReader file = new FileReader(fileName);
            jsonArray = (JSONArray) parser.parse(file);
            file.close();
        } catch (IOException ex) {
        } catch (ParseException ex) {
        }
        return jsonArray; 
    }
    
    private int getIndex(String name, JSONArray array) {
        boolean found = false; 
        int i = 0; 
        //RECORRE EL ARRAY array HASTA QUE ENCUENTRA UN ELEMENTO CON EL NOMBRE name
        while ((i<array.size())&&!found) {
            //SELECCIONA UNO POR UNO
            JSONObject obj = (JSONObject) array.get(i);
            //COMPARA EL NOMBRE DEL ELEMENTO ACTUAL CON EL QUE SE BUSCA
            found = name.equals(obj.get("name"));
            if (!found) i++;
        }
        if (!found) i = -1; 
        return i; 
    }
    
    @Override
    public boolean existDB(String name) {
        boolean found = false;
        //OBTIENE EL JSONARRAY EN EL ARCHIVO data\\DBMetaData.json (master)
        JSONArray jsonArray = getJsonArray("data\\DBMetaData.json");
        if (!(jsonArray == null))  {    
            int i = 0;
            //RECORRE EL ARRAY HASTA ENCONTRAR UN OBJETO CON EL NOMBRE name
            while ((i < jsonArray.size())&&(!found)) {
                JSONObject db = (JSONObject) jsonArray.get(i);
                String dbName = (String) db.get("name");
                found = (name.equals(dbName)); 
                i++;
            }
        }
        return found;
    }
    /*
    params: text, Texto que se desea guardar en el archivo
            path, Archivo donde se desea guardar el texto
    
    ESCRIBE EL TEXTO text EN EL ARCHIVO path
    */
    private void writeIn(String text, String path){
        try { 
            FileWriter filew = new FileWriter(path); 
            BufferedWriter bufw = new BufferedWriter(filew); 
            bufw.write(text);
            bufw.close();
        } catch (Exception e) {
            System.out.println(path+" not found");
        }
    }
    
    @Override
    public void createDB(String name) {
        if (!existDB(name) ) {
            try {
                JSONArray DBList = getJsonArray("data\\DBMetaData.json"); 
                if (!(DBList == null)) {
                    JSONObject db = new JSONObject(); 
                    db.put("name", name);
                    db.put("tables", 0);
                    db.put("path", "data\\"+name+"_metadata"); 
                    
                    DBList.add(db); 
                    
                    this.writeIn(DBList.toJSONString(), "data\\DBMetaData.json");
                    
                    String path = "data\\"+name+"_metadata"; 
                    File dir = new File(path); 
                    dir.mkdir();
                    
                    FileWriter file = new FileWriter("data\\"+name+"_metadata\\"+name+"MetaData.json");
                    file.close();
                    System.out.println("DB "+name.toUpperCase()+" CREATED");
                }
            } catch (Exception e) {
                    System.out.println("DB CREATION MALFUNCTION");
            }
        }  else {
            System.out.println("DB "+name.toUpperCase()+" already exist");
        }
    }

    @Override
    public void renameDB(String oldName, String newName) {
        if (existDB(oldName)) {
            if (!existDB(newName)) { 
                FileWriter filew = null; 
                JSONArray DBList = getJsonArray("data\\DBMetaData.json"); 
                int index = getIndex(oldName, DBList); 
                    
                JSONObject db = (JSONObject) DBList.get(index);
                //RENOMBRAR META DATA DE LA BASE DE DATOS
                String mdName = (String) db.get("path") + "\\" + oldName + "MetaData.json";
                String newMdName = (String) db.get("path") + "\\" + newName + "MetaData.json";
                File innerMD = new File(mdName);
                File newInnerMD = new File (newMdName); 
                innerMD.renameTo(newInnerMD);

                //RENOMBRAR DIRECTORIO
                File dir = new File("data\\"+oldName+"_metadata");
                File newDir = new File("data\\"+newName+"_metadata");

                dir.renameTo(newDir);

                //RENOMBRAR EN MASTER 
                db.put("name", newName); 
                db.put("path", "data\\"+newName+"_metadata");
                DBList.remove(index);
                DBList.add(db);
                this.writeIn(DBList.toJSONString(), "data\\DBMetaData.json");
            
            } else {
                System.out.println("DB "+newName+" already exist");
            }    
        } else { 
            System.out.println("DB "+oldName+" doesn't exist");
        }
    }
    
    public void deleteDirectory(File file) throws IOException{
        if(file.isDirectory()){
            if(file.list().length==0){
                file.delete();
            }else{
                String files[] = file.list();
                for (String temp : files) {
                    File fileDelete = new File(file, temp);
                    deleteDirectory(fileDelete);
        	}
                if(file.list().length==0){
           	    file.delete();
        	}
            }
    	}else{
            file.delete();
    	}
    }
    
    @Override
    public ArrayList showDB() {
        ArrayList list = new ArrayList(); 
        JSONArray DBList = getJsonArray("data\\DBMetaData.json");
        for (Object obj: DBList) {
            JSONObject jobj = (JSONObject) obj;
            list.add(jobj.get("name")); 
        }
        return list; 
    }

    @Override
    public void dropDB(String name) {
        if (existDB(name)) {
            JSONArray DBList = getJsonArray("data\\DBMetaData.json"); 
            int index = getIndex(name,DBList);
            JSONObject obj = (JSONObject) DBList.get(index);
            File file = new File((String) obj.get("path"));
            
            try {
                this.deleteDirectory(file);
            } catch (IOException ex) {}
            
            DBList.remove(index); 
            this.writeIn(DBList.toJSONString(), "data\\DBMetaData.json");
            System.out.println("DB "+name+" DELETED");
        } else {
            System.out.println("DB "+actual+" doesn't exist");
        }
    }

    @Override
    public void selectDB(String name) {
        if (existDB(name)) {
            JSONArray DBList = getJsonArray("data\\DBMetaData.json");
            int index = getIndex(name,DBList);
            JSONObject obj = (JSONObject) DBList.get(index);
            actual = new DataBase(); 
            actual.setName((String) obj.get("name"));
            actual.setDirPath((String) obj.get("path"));
            actual.setTables((long)obj.get("tables"));
            
            System.out.println(obj.toJSONString());
        } else {
            System.out.println("DB "+name+" doesn't exist");
        }
    }

    @Override
    public boolean existTable(String TableName) {
        if ( actual != null) { 
            boolean found = false;
            JSONArray jsonArray = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            if (!(jsonArray == null))  {    
                int i = 0;
                while ((i < jsonArray.size())&&(!found)) {
                    JSONObject table = (JSONObject) jsonArray.get(i);
                    String tName = (String) table.get("name");
                    found = (TableName.equals(tName)); 
                    i++;
                }
            }
            return found;
        } else {
            System.out.println("No DB selected");
            return false; 
        }
    }

    @Override
    public void createTable(Table newTable){
        String tName = newTable.getName(); 
        if (!existTable(tName)) { 
            JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            JSONObject table = new JSONObject(); 
            table.put("name", newTable.getName()); 
            table.put("size", newTable.getSize());
            
            JSONArray atributes = new JSONArray(); 
            JSONArray primaryKeys = new JSONArray(); 
            JSONArray foreignKeys = new JSONArray(); 
            JSONArray conditions = new JSONArray(); 
            JSONArray checkString = new JSONArray(); 
            
            ArrayList<Atributo> atr = newTable.getAtributes(); 
            ArrayList<primaryKey> pks = newTable.getPrimaryKeys(); 
            ArrayList<foreignKey> fks = newTable.getForeignKeys(); 
            ArrayList ckl = newTable.getCheckString(); 
            
            boolean allGood = true; 
            
            //AGREGA ATRIBUTOS DE LA TABLA
            int i = 0; 
            while (allGood && (i < atr.size())) {
                Atributo temp = atr.get(i); 
                allGood = !existColumn(temp.getNombre(),atributes); 
                if (allGood) { 
                    JSONObject obj = new JSONObject(); 
                    obj.put("name", temp.getNombre()); 
                    obj.put("type", temp.getTipo());
                    obj.put("size", temp.getTamanio());
                    obj.put("index", temp.getIndice());
                    atributes.add(obj);
                } else {
                    System.out.println("ATRIBUTE "+temp.getNombre()+" DECLARED MULTIPLE TIMES");
                }
                i++; 
            }
            
            i = 0; 
            //AGREGA PRIMARY KEYS DE LA TABLA
            allGood = (pks.size() == 1); 
            if (!allGood) System.out.println("Solo se puede declarar un conjunto de llaves primarias por tabla");
            while (allGood && (i < pks.size())) { 
                primaryKey temp = new primaryKey(); 
                int j = 0; 
                ArrayList fields = temp.getAtributes();
                JSONArray body = new JSONArray(); 
                while (allGood && (j < fields.size())) { 
                    allGood = existColumn((String) fields.get(j),atributes); 
                    if (allGood) { 
                        JSONObject obj = new JSONObject(); 
                        obj.put("name", fields.get(j));
                        body.add(obj); 
                    }
                    j++; 
                }
                if (allGood) { 
                    allGood = !(existColumn(temp.getName(),primaryKeys)||existColumn(temp.getName(),foreignKeys));
                    if (allGood) { 
                        JSONObject obj = new JSONObject(); 
                        obj.put("name", temp.getName()); 
                        obj.put("reference", body); 
                    } else { 
                        System.out.println("CONSTRAINT ID "+temp.getName()+" DECLARED MULTIPLE TIMES");
                    }
                } else {
                    System.out.println("ATRIBUTE "+fields.get(j)+" DOESN'T EXIST"); 
                }
                i++;
            }
            
            i = 0;
            //AGREGA FOREIGN KEYS DE LA TABLA
            while (allGood && ( i < fks.size())) { 
                foreignKey temp = new foreignKey(); 
                int j = 0; 
                ArrayList fields = temp.getAtributes(); 
                JSONArray body = new JSONArray(); 
                //VERIFICAR QUE EXISTEN LAS COLUMNAS EN LA TABLA ACTUAL
                while (allGood && (j < fields.size())) { 
                    allGood = existColumn((String) fields.get(j),atributes); 
                    if (allGood) { 
                        JSONObject obj = new JSONObject(); 
                        obj.put("name", fields.get(j));
                        body.add(obj); 
                    }
                    j++; 
                }
                //VERIFICAR QUE EL ID DE ESTA LLAVE FORANEA NO EXISTA YA
                if (allGood) {
                    allGood = !(existColumn(temp.getName(),primaryKeys)||existColumn(temp.getName(),foreignKeys));
                    if (allGood) { 
                        JSONObject obj = new JSONObject(); 
                        obj.put("name", temp.getName()); 
                        obj.put("atributes", body); 
                        
                        allGood = !existTable(temp.getReferenceTable());
                        if (allGood) {
                            obj.put("table", temp.getReferenceTable());
                            int k = 0; 
                            ArrayList ref = temp.getReferenceAtributes(); 
                            while (allGood && (k < ref.size())) { 
                                //Existe la columna a la que se esta referenciando; 
                                allGood = existColumn((String) ref.get(k), temp.getReferenceTable()); 
                                if (allGood) {
                                    
                                } else {
                                    System.out.println("COLUMN "+ref.get(k)+" DOESN'T EXIST IN TABLE "+temp.getReferenceTable());
                                }
                            }
                        } else {
                            System.out.println("REFERENCE TABLE IN FOREIGN KEY "+temp.getName()+" DOESN'T EXIST");
                        }
                    } else { 
                        System.out.println("CONSTRAINT ID "+temp.getName()+" DECLARED MULTIPLE TIMES");
                    }
                } else {
                    System.out.println("ATRIBUTE "+fields.get(j)+" DOESN'T EXIST"); 
                }
                i++;
            }
        }
    }
    
    private boolean existColumn(String cName, String table) { 
        boolean found = false; 
        if (existTable(table)){
            JSONArray tableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            int index = this.getIndex(table, tableList) ; 
            JSONObject tableObj = (JSONObject) tableList.get(index);
            JSONArray atributes = (JSONArray) tableObj.get("atributes"); 
            found = existColumn(cName,atributes);
        }
        return found; 
    }

    private boolean existColumn(String cName, JSONArray list) {
        boolean found = false;
        int i = 0; 
        while ((i < 0)&&(!found)) { 
            JSONObject obj = (JSONObject) list.get(i); 
            String objName = (String) obj.get("name"); 
            found = cName.equals(objName); 
            i++;
        }
        return found; 
    }
    
    @Override
    public void renameTable(String TableName, String newTableName) {
        if (existTable(TableName)) { 
            try {
                JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                int index = getIndex(TableName,TableList);
                JSONObject tabla = (JSONObject) TableList.get(index);
                tabla.put("name", newTableName);
               
                TableList.remove(index);
                TableList.add(tabla);
                
                this.writeIn(TableList.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                File file = new File(actual.getDirPath()+"\\"+TableName+"MetaData.json");
                file.delete();
                
                FileWriter filew = new FileWriter(actual.getDirPath()+"\\"+newTableName+"MetaData.json");
                filew.close();
            } catch (IOException ex) {
            }
            
        } else {
            System.out.println("TABLE "+TableName+" DOESN'T EXIST");
        }
    }

    @Override
    public void dropColumn(String TableName, String columna) {
    
    }

    @Override
    public void dropTable(String TableName) {
    
    }

    @Override
    public ArrayList<Table> showTables() {
        
        return new ArrayList(); 
    }

    @Override
    public ArrayList<Atributo> showColumns(String TableName) {
        
        return new ArrayList(); 
    }

    @Override
    public void addColumn(String TableName, Atributo nuevo, ArrayList<primaryKey> primaryKeys, ArrayList<foreignKey> foreignKeys, ArrayList<Condition> conditions) {
    
    }

    @Override
    public void addConstraint(String TableName, primaryKey primKey) {
    
    }

    @Override
    public void addConstraint(String TableName, foreignKey forKey) {
    
    }

    @Override
    public void dropConstraint(String TableName, String idConstraint) {
    
    }
    
    }
