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
import javax.swing.JOptionPane;
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
                found = (name.toUpperCase().equals(dbName.toUpperCase())); 
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
            msg.add(path+" not found");
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
                    msg.add("DB "+name.toUpperCase()+" CREATED");
                }
            } catch (Exception e) {
                    msg.add("DB CREATION MALFUNCTION");
            }
        }  else {
            msg.add("DB "+name.toUpperCase()+" already exist");
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
                msg.add("DB "+newName+" already exist");
            }    
        } else { 
            msg.add("DB "+oldName+" doesn't exist");
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
        msg.add("BASES DE DATOS:");
        msg.add("");
        for (Object obj: DBList) {
            JSONObject jobj = (JSONObject) obj;
            list.add(jobj.get("name"));
            msg.add(String.valueOf(jobj.get("name")));
            
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
                
                int opc = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar la DB "+name+"?"); 
                if (opc == 0) {
                    this.deleteDirectory(file);
                    DBList.remove(index); 
                    this.writeIn(DBList.toJSONString(), "data\\DBMetaData.json");
                    msg.add("DB "+name+" DELETED");
                }
            } catch (IOException ex) {}
            
            
        } else {
            msg.add("DB "+name+" doesn't exist");
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
            
            msg.add("DB "+name+" SELECTED");
        } else {
            msg.add("DB "+name+" doesn't exist");
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
            msg.add("No DB selected");
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
                    msg.add("ATRIBUTE "+temp.getNombre()+" DECLARED MULTIPLE TIMES IN THE TABLE "+newTable.getName());
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
                                msg.add("ID "+name+" IN PRIMARY KEY "+tempPK.getName()+" DOESN'T EXIST");
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
                    msg.add("TABLE "+newTable.getName()+" CAN'T HAVE MULTIPLE PRIMARY KEYS");
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
                                msg.add("COLUMN "+atName+" DOESN'T EXIST IN TABLE "+newTable.getName());
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
                                                allGood = references.contains(attrName); 
                                                if (allGood) { 
                                                    JSONObject refAttr = new JSONObject(); 
                                                    refAttr.put("name", attrName); 
                                                    refAtributes.add(refAttr); 
                                                } else {
                                                    msg.add(tempFk.getReferenceTable()+" PRIMARY KEY DOESN'T CONTAIN "+attrName+" ATRIBUTE");
                                                }
                                                k++;
                                            }
                                        } else {
                                            msg.add("REFERENCE IDS DO NOT MATCH TABLE "+tempFk.getReferenceTable()+" PRIMARY KEY ATTRIBUTES");
                                        }
                                    } else {
                                        msg.add("REFERENCE TABLE "+tempFk.getReferenceTable()+" DOESN'T HAVE PRIMARY KEY CONSTRAINT");
                                    }
                                } else { 
                                    msg.add("REFERENCE IDS DO NOT MATCH LOCAL IDS IN QUANTITY");
                                }
                            } else { 
                                msg.add("REFERENCE TABLE "+tempFk.getReferenceTable()+" DOESN'T EXIST IN DB "+actual.getName());
                            }
                        }
                    } else {
                        msg.add(tempFk.getName()+" ID DECLARED MULTIPLE TIMES");
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
                            if (!allGood) msg.add(String.valueOf(thisA.get("name"))+" ISN'T THE SAME TYPE OF "+String.valueOf(thisA.get("name")));
                            
                            if (allGood && (thisType.equals("char"))) { 
                                int thisSize = (int) thisA.get("size");
                                long refSize = (long) refA.get("size");
                                allGood = (thisSize == refSize); 
                                if (!allGood) msg.add(String.valueOf(thisA.get("name"))+" ISN'T THE SAME SIZE OF "+String.valueOf(thisA.get("name")));
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
                //CHECK VALIDATION 
                if (allGood) { 
                    ArrayList<Check> checksDecl = new ArrayList<>(); 
                    if (newTable.getChecks() != null) checksDecl = newTable.getChecks();
                    int j = 0; 
                    while ( allGood && (j < checksDecl.size())) {
                        Check tempChk = checksDecl.get(j); 
                        allGood = ! (existColumn(tempChk.getNombreCons(),primary)||existColumn(tempChk.getNombreCons(),foreign)||existColumn(tempChk.getNombreCons(),condition)); 
                        if (allGood) {
                            JSONObject ConditionObj = new JSONObject(); 
                            ArrayList<Condition> conditionsArray = tempChk.getCondi();
                            int k = 0; 
                            while( allGood && ( k < conditionsArray.size())) {
                                Condition tempCon = conditionsArray.get(k); 
                                String conColumn = tempCon.getColumn();
                                //existe la columna a la que se le impone el check
                                allGood = existColumn(conColumn, atributes); 
                                if (allGood) { 
                                    JSONObject column = (JSONObject) atributes.get(getIndex(conColumn,atributes));
                                    String columnType = (String) column.get("type"); 
                                    //Si es value no es una variable
                                    if (!tempCon.getValueType().equals("id")) {
                                        allGood = columnType.equals(tempCon.getValueType());
                                        if (allGood) {
                                            ConditionObj.put("id", tempCon.getId());
                                            ConditionObj.put("column", tempCon.getColumn());
                                            ConditionObj.put("value", tempCon.getValue());
                                            ConditionObj.put("valueType", tempCon.getValueType());
                                            if (tempCon.isDistinct()) ConditionObj.put("symbol", "<>"); 
                                            if (tempCon.isEqual()) ConditionObj.put("symbol", "="); 
                                            if (tempCon.isMinValue()) ConditionObj.put("symbol", ">"); 
                                            if (tempCon.isMinValueInc()) ConditionObj.put("symbol", ">="); 
                                            if (tempCon.isMaxValue()) ConditionObj.put("symbol", "<"); 
                                            if (tempCon.isMaxValueInc()) ConditionObj.put("symbol", "<=");
                                            String exp = tempChk.getCheckString();
                                            toPostFix pf = new toPostFix(); 
                                            
                                            condition.add(ConditionObj);
                                        } else {
                                            if (tempCon.getValueType().equals("float") || tempCon.getValueType().equals("int") ) {
                                                if (columnType.equals("float") || columnType.equals("int")) {
                                                    allGood = true; 
                                                }
                                            } else { 
                                                System.out.println(conColumn+" and "+tempCon.getValue()+" are not the same type nor can they be cast");
                                            }
                                        }
                                    } else {
                                        
                                    }
                                } else {
                                    System.out.println("COLUMN "+conColumn+" IN CHECK "+tempChk.getNombreCons()+" DOESN'T EXIST");
                                }
                            }
                        } else {
                            System.out.println(tempChk.getNombreCons()+" ID ALREADY EXIST IN TABLE "+newTable.getName()); 
                        }
                        j++;
                    }
                }
                table.put("atributes", atributes);
                table.put("primary", primary); 
                table.put("foreign", foreign);
                table.put("condition", condition);
            }
            if (allGood) { 
                try {
                JSONArray TList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json"); 
                if (!(TList == null)) {
                    TList.add(table); 
                    
                    this.writeIn(TList.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                    
                    FileWriter file = new FileWriter(actual.getDirPath()+"\\"+tName+".json");
                    file.close();
                    msg.add("TABLE "+tName.toUpperCase()+" CREATED");
                    }
                } catch (Exception e) {
                        msg.add("TABLE CREATION MALFUNCTION");
                }
            }
        } else { 
            msg.add("TABLE "+tName+" ALREADY EXIST IN DB "+actual.getName()); 
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
            if (!existTable(newTableName)) {
                    
                JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                int index = getIndex(TableName,TableList);
                JSONObject tabla = (JSONObject) TableList.get(index);
                tabla.put("name", newTableName);

                TableList.remove(index);
                TableList.add(tabla);

                this.writeIn(TableList.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                File file = new File(actual.getDirPath()+"\\"+TableName+".json");
                File filew = new File(actual.getDirPath()+"\\"+newTableName+".json");
                file.renameTo(filew);
                    
            } else {
                msg.add("TABLE "+newTableName+" ALREADY EXIST");
            }
        } else {
            msg.add("TABLE "+TableName+" DOESN'T EXIST");
        }
    }

    @Override
    public void dropColumn(String TableName, String columna) {
        
    }

    @Override
    public void dropTable(String TableName) {
        if (existTable(TableName)) { 
            JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            int tableIndex = getIndex(TableName, TableList); 
            JSONObject table = (JSONObject) TableList.get(tableIndex); 
            JSONArray primary = (JSONArray) table.get("primary");
            
            boolean related = false; 
            if (primary.size() > 0) {
                int i = 0; 
                while(!related && (i < TableList.size())){
                    JSONObject tempTable = (JSONObject) TableList.get(i);
                    JSONArray foreign = (JSONArray) tempTable.get("foreign");
                    int j = 0; 
                    while (!related && (j < foreign.size())) {
                        JSONObject tempFk = (JSONObject) foreign.get(j); 
                        String refTable = (String) tempFk.get("table");
                        related = TableName.equals(refTable);
                        j++;
                    }
                    i++;
                }
            }
            
            if (!related) { 
                TableList.remove(tableIndex);
                this.writeIn(TableList.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                File file = new File (actual.getDirPath()+"\\"+TableName+".json");
                file.delete();
                System.out.println("TABLE "+TableName+" DROPPED SUCCESFULLY");
            } else {
                System.out.println("RELATIONSHIP FOUND WITH THIS TABLE AND OTHER TABLE");
            }
        } else {
            System.out.println("TABLE "+TableName+" DOESN'T EXIST IN DB "+actual.getName());
        }
    }

    @Override
    public ArrayList<Table> showTables() {
        ArrayList list = new ArrayList(); 
        if (actual != null) {
            JSONArray DBList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            msg.add("TABLAS:");
            msg.add("");
            int c = DBList.size();
            for (Object obj: DBList) {
                JSONObject jobj = (JSONObject) obj;
                String cName = (String) jobj.get("name");
                list.add((cName));
                msg.add((cName));
            } 
            if (c == 0) msg.add("DB "+actual.getName()+" IS EMPTY");
        } else {
            msg.add("DATABASE NOT SELECTED");
        }
        return list; 
        
    }

    @Override
    public ArrayList<Atributo> showColumns(String TableName) {
        ArrayList list = new ArrayList(); 
        if (actual != null) {
        JSONArray DBList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
        if (existTable(TableName)) { 
            msg.add("ESTRUCTURA TABLA "+TableName+":");
            msg.add("");
            for (Object obj: DBList) {
                JSONObject jobj = (JSONObject) obj;
                String objName = (String) jobj.get("name"); 
                if (objName.equals(TableName)) { 
                    JSONArray atributes = (JSONArray) jobj.get("atributes"); 
                    for (Object atr: atributes) {
                        JSONObject atobj = (JSONObject) atr;
                        list.add(atobj.get("name"));
                        msg.add(String.valueOf(atobj.get("name")));
                    }
                } 
            } 
        } else {
           msg.add(" TABLE "+TableName+" DOESN'T EXIST IN DB "+actual.getName());
        }
        } else {
            msg.add("DATABASE NOT SELECTED");
        }
        return list; 
    }

    @Override
    public void addColumn(String TableName, Atributo nuevo, ArrayList<primaryKey> primaryKeys, ArrayList<foreignKey> foreignKeys, ArrayList<Check> conditions) {
    
    }

    @Override
    public void addConstraint(String TableName, primaryKey primKey) {
    
    }

    @Override
    public void addConstraint(String TableName, foreignKey forKey) {
    
    }

    public void addConstraint(String TableName, Check check) { 
        
    }
    @Override
    public void dropConstraint(String TableName, String idConstraint) {
        if (existTable(TableName)) {
            JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            int tableIndex = getIndex(TableName,TableList); 
            JSONObject table = (JSONObject) TableList.get(tableIndex); 
            
            JSONArray primary = (JSONArray) table.get("primary"); 
            JSONArray foreign = (JSONArray) table.get("foreign"); 
            JSONArray condition = (JSONArray) table.get("condition"); 
            
            if (existColumn(idConstraint, primary)) {
                boolean found = false;
                String relTable = ""; 
                for (int i = 0; i < TableList.size(); i++) { 
                    JSONObject tempCond = (JSONObject) TableList.get(i); 
                    JSONArray tempForeign = (JSONArray) tempCond.get("foreign"); 
                    for (int j = 0; j < tempForeign.size(); j++){
                        JSONObject ForeignObj = (JSONObject) tempForeign.get(j); 
                        JSONArray references = (JSONArray) ForeignObj.get("references"); 
                        found = (existColumn(idConstraint,references)); 
                        if (found) relTable = (String) tempCond.get("name");
                    }
                }
                if (!found) { 
                    primary.remove(0); 
                    table.put("primary", primary);
                    System.out.println("PRIMARY KEY "+idConstraint+" REMOVED SUCCESFULLY FROM TABLE "+TableName);
                } else {
                    System.out.println("PRIMARY KEY "+idConstraint+" CANT BE DROPED, IT IS FOREIGN KEY IN TABLE "+relTable);
                }
            } else if (existColumn(idConstraint, foreign)) {
                int index = getIndex(idConstraint, foreign); 
                foreign.remove(index); 
                table.put("foreign", foreign);
                System.out.println("FOREIGN KEY "+idConstraint+" REMOVED SUCCESFULLY FROM TABLE "+TableName);
            } else if (existColumn(idConstraint, condition)) { 
                int index = getIndex(idConstraint, condition); 
                condition.remove(index);
                table.put("condition", condition);
                System.out.println("CONDITION "+idConstraint+" REMOVED SUCCESFULLY FROM TABLE "+TableName);
            }
            
            TableList.remove(tableIndex);
            TableList.add(table); 
            this.writeIn(TableList.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
        } else {
            System.out.println(TableName+" DOESN'T EXIST IN DB "+actual.getName());
        }
    }
    
    public String toString() { 
        String finalMsg = "";
        for (int i = 0; i < msg.size(); i++) finalMsg = finalMsg.concat(msg.get(i)+"\n");
        msg.clear();
        return finalMsg; 
    }
    
    
    private boolean eval(ArrayList<Value> valores, Check conditions) {
        
        return false; 
    }
    
    }
