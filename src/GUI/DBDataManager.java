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
    ArrayList<String> msg; 
    
    /* CONSTRUCTOR */ 
    public DBDataManager() {
        actual = null; //SE COMIENZA SI CONOCER LA BASE DE DATOS
        msg = new ArrayList<>(); 
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
            System.out.println("DB "+name+" doesn't exist");
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
            
            System.out.println("DB "+name+" SELECTED");
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
                    found = (TableName.toUpperCase().equals(tName.toUpperCase())); 
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
        /* VER QUE NO EXISTA LA TABLA EN LA DB ACTUAL*/
        if (!existTable(tName)) { 
            JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            JSONObject table = new JSONObject(); 
            table.put("name", newTable.getName()); 
            table.put("size", 0);
            
            JSONArray atributes = new JSONArray();  
            JSONArray primary = new JSONArray();  
            JSONArray foreign = new JSONArray();  
            JSONArray condition = new JSONArray();  
            //ATRIBUTE VALIDATION
            /* QUE NO SE REPITAN ATRIBUTOS (NOMBRES) */ 
            ArrayList<Atributo> atributos = newTable.getAtributes(); 
            boolean allGood = true; 
            int i = 0; 
            while ((i < atributos.size()) && allGood) { 
                Atributo temp = atributos.get(i); 
                allGood = !existColumn(temp.getNombre(), atributes); 
                if (allGood) { 
                    JSONObject atr = new JSONObject(); 
                    atr.put("name", temp.getNombre());
                    atr.put("size", temp.getTamanio());
                    atr.put("index", temp.getIndice());
                    atr.put("type", temp.getTipo()); 
                    atributes.add(atr); 
                } else { 
                    System.out.println("ATRIBUTE "+temp.getNombre()+" DECLARED MULTIPLE TIMES IN THE TABLE "+newTable.getName());
                }
                i++; 
            }
            table.put("atributes", atributes); 
            //PRIMARY KEY VALIDATION 
            if (allGood) { 
                //CHECK IF THERES MORE THAN 1 PRIMARY KEY
                ArrayList<primaryKey> pks = new ArrayList<>(); 
                if (newTable.getPrimaryKeys() != null) pks = newTable.getPrimaryKeys();
                allGood = (pks.size() <= 1); 
                if (allGood){ 
                    if (pks.size() == 1){
                        primaryKey tempPK = pks.get(0); 
                        JSONObject jsonPK = new JSONObject(); 
                        ArrayList body = tempPK.getAtributes(); 
                        JSONArray atrib = new JSONArray(); 
                        i = 0;
                        while (allGood && (i < body.size())) { 
                            String name = String.valueOf(body.get(i)); 
                            allGood = existColumn(name,atributes); 
                            if (allGood) {
                                JSONObject obj = new JSONObject(); 
                                obj.put("name", name);
                                atrib.add(obj); 
                            } else {
                                System.out.println("ID "+name+" IN PRIMARY KEY "+tempPK.getName()+" DOESN'T EXIST");
                            }
                            i++;
                        }
                        if (allGood) {
                            jsonPK.put("name", tempPK.getName()); 
                            jsonPK.put("atributes", atrib);
                            primary.add(jsonPK);
                        }
                    }
                } else { 
                    System.out.println("TABLE "+newTable.getName()+" CAN'T HAVE MULTIPLE PRIMARY KEYS");
                }    
            }
            table.put("primary", primary); 
            //FOREIGN KEY VALIDATION
            if (allGood) { 
                ArrayList<foreignKey> fks = new ArrayList<>(); 
                if (newTable.getForeignKeys() != null) fks = newTable.getForeignKeys();
                i = 0; 
                while (allGood && (i < fks.size())) { 
                    foreignKey tempFk = fks.get(i);
                    ArrayList fields = tempFk.getAtributes(); 
                    ArrayList references = tempFk.getReferenceAtributes(); 
                    JSONObject foreignK = new JSONObject(); 
                    JSONArray thisAtributes = new JSONArray(); 
                    JSONArray refAtributes = new JSONArray(); 
                    allGood = !(existColumn(tempFk.getName(),foreign) || existColumn(tempFk.getName(),primary));
                    if (allGood) { 
                        int j = 0; 
                        //CHECK IF ALL ATRIBUTES EXIST
                        while (allGood && (j < fields.size())) { 
                            String atName = String.valueOf(fields.get(j)); 
                            allGood = existColumn(atName,atributes); 
                            if (allGood) { 
                                JSONObject obj = new JSONObject(); 
                                obj.put("name", atName);
                                thisAtributes.add(obj); 
                            } else {
                                System.out.println("COLUMN "+atName+" DOESN'T EXIST IN TABLE "+newTable.getName());
                            }
                            j++;
                        }
                        //check reference table exist
                        if (allGood) {  
                            allGood = existTable(tempFk.getReferenceTable()) && allGood; 
                            if (allGood) {
                                //check reference attributes match local foreign key in quantity
                                allGood = (fields.size() == references.size()); 
                                if (allGood) { 
                                    JSONArray dbTables = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                                    int index = getIndex(tempFk.getReferenceTable(),dbTables); 
                                    JSONObject refTable = (JSONObject) dbTables.get(index); 
                                    JSONArray refPrimary = (JSONArray) refTable.get("primary");
                                    //check if reference table has primary key to reference
                                    if (refPrimary.size() == 1) { 
                                        JSONObject refPK = (JSONObject) refPrimary.get(0); 
                                        JSONArray refPKAtributes = (JSONArray) refPK.get("atributes");
                                        //check if reference primary key match refences id in quiantity
                                        allGood = (refPKAtributes.size() == references.size()); 
                                        if (allGood) {
                                            int k = 0; 
                                            while (allGood && (k < references.size())) { 
                                                JSONObject attr = (JSONObject) refPKAtributes.get(k); 
                                                String attrName = (String) attr.get("name"); 
                                                allGood = attrName.contains(attrName); 
                                                if (allGood) { 
                                                    JSONObject refAttr = new JSONObject(); 
                                                    refAttr.put("name", attrName); 
                                                    refAtributes.add(refAttr); 
                                                } else {
                                                    System.out.println(tempFk.getReferenceTable()+" PRIMARY KEY DOESN'T CONTAIN "+attrName+" ATRIBUTE");
                                                }
                                                k++;
                                            }
                                        } else {
                                            System.out.println("REFERENCE IDS DO NOT MATCH TABLE "+tempFk.getReferenceTable()+" PRIMARY KEY ATTRIBUTES");
                                        }
                                    } else {
                                        System.out.println("REFERENCE TABLE "+tempFk.getReferenceTable()+" DOESN'T HAVE PRIMARY KEY CONSTRAINT");
                                    }
                                } else { 
                                    System.out.println("REFERENCE IDS DO NOT MATCH LOCAL IDS IN QUANTITY");
                                }
                            } else { 
                                System.out.println("REFERENCE TABLE "+tempFk.getReferenceTable()+" DOESN'T EXIST IN DB "+actual.getName());
                            }
                        }
                    } else {
                        System.out.println(tempFk.getName()+" ID DECLARED MULTIPLE TIMES");
                    }
                    //check if primary key and local id are the same type
                    if (allGood) {
                        int j = 0; 
                        while(allGood && (j < thisAtributes.size())) {
                            JSONObject thisAtt = (JSONObject) thisAtributes.get(getIndex((String)fields.get(j),thisAtributes));
                            JSONObject refAtt = (JSONObject) refAtributes.get(getIndex((String)references.get(j),refAtributes));
                            
                            JSONArray dbTables = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json"); 
                            JSONObject refTable = (JSONObject) dbTables.get(getIndex(tempFk.getReferenceTable(),dbTables)); 
                            JSONArray refAtts = (JSONArray) refTable.get("atributes"); 
                            
                            JSONObject thisA = (JSONObject) atributes.get(getIndex((String) thisAtt.get("name"), atributes));
                            JSONObject refA = (JSONObject) refAtts.get(getIndex((String) refAtt.get("name"), refAtts));
                            
                            String thisType = (String) thisA.get("type");
                            String refType = (String) refA.get("type");
                            
                            allGood = thisType.equals(refType); 
                            if (!allGood) System.out.println(String.valueOf(thisA.get("name"))+" ISN'T THE SAME TYPE OF "+String.valueOf(thisA.get("name")));
                            
                            if (allGood && (thisType.equals("char"))) { 
                                String thisSize = (String) thisA.get("size");
                                String refSize = (String) refA.get("size");
                                allGood = (thisSize.equals(refSize)); 
                                if (!allGood) System.out.println(String.valueOf(thisA.get("name"))+" ISN'T THE SAME SIZE OF "+String.valueOf(thisA.get("name")));
                            }
                            j++;
                        }
                    }
                    if (allGood) {
                        foreignK.put("name", tempFk.getName());
                        foreignK.put("atributes", thisAtributes);
                        foreignK.put("table", tempFk.getReferenceTable());
                        foreignK.put("refences", refAtributes);
                        foreign.add(foreignK);
                    }
                    i++;
                }
                table.put("atributes", atributes);
                table.put("primary", primary); 
                table.put("foreign", foreign);
            }
            if (allGood) { 
                try {
                JSONArray TList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json"); 
                if (!(TList == null)) {
                    TList.add(table); 
                    
                    this.writeIn(TList.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                    
                    FileWriter file = new FileWriter(actual.getDirPath()+"\\"+tName+".json");
                    file.close();
                    System.out.println("TABLE "+tName.toUpperCase()+" CREATED");
                    }
                } catch (Exception e) {
                        System.out.println("TABLE CREATION MALFUNCTION");
                }
            }
        } else { 
            System.out.println("TABLE "+tName+" ALREADY EXIST IN DB "+actual.getName()); 
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
        while ((i < list.size())&&(!found)) { 
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
