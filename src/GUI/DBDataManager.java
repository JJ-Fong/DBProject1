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
        if (actual == null) { 
            msg.add("NO DB SELECTED");
        } else { 
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
                            JSONArray checkConditions = new JSONArray();
                            JSONObject chekObj = new JSONObject(); 
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
                                            allGood = columnType.toUpperCase().equals(tempCon.getValueType().toUpperCase());
                                            if (allGood) {
                                                ConditionObj.put("id", tempCon.getId());
                                                ConditionObj.put("column", tempCon.getColumn());
                                                ConditionObj.put("value", tempCon.getValue());
                                                ConditionObj.put("valueType", tempCon.getValueType());
                                                if (tempCon.isDistinct()) ConditionObj.put("symbol", "<>");
                                                if (tempCon.isEqual()) ConditionObj.put("symbol", "=");
                                                if (tempCon.isMaxValue()) ConditionObj.put("symbol", "<");
                                                if (tempCon.isMinValue()) ConditionObj.put("symbol", ">");
                                                if (tempCon.isMaxValueInc()) ConditionObj.put("symbol", "<=");
                                                if (tempCon.isMinValueInc()) ConditionObj.put("symbol", ">=");
                                                checkConditions.add(ConditionObj); 
                                            } else {
                                                if (tempCon.getValueType().equals("float") || tempCon.getValueType().equals("int") ) {
                                                    if (columnType.equals("float") || columnType.equals("int")) {
                                                        allGood = true;
                                                        ConditionObj.put("id", tempCon.getId());
                                                        ConditionObj.put("column", tempCon.getColumn());
                                                        ConditionObj.put("value", tempCon.getValue());
                                                        ConditionObj.put("valueType", tempCon.getValueType());
                                                        checkConditions.add(ConditionObj);    
                                                    }
                                                } else { 
                                                    msg.add(conColumn+" and "+tempCon.getValue()+" are not the same type nor can they be cast");
                                                }
                                            }
                                        } else {

                                        }
                                    } else {
                                        msg.add("COLUMN "+conColumn+" IN CHECK "+tempChk.getNombreCons()+" DOESN'T EXIST");
                                    }
                                    k++;
                                }
                            } else {
                                msg.add(tempChk.getNombreCons()+" ID ALREADY EXIST IN TABLE "+newTable.getName()); 
                            }
                            if (allGood) { 
                                chekObj.put("name", tempChk.getNombreCons());
                                chekObj.put("conditions", checkConditions); 
                                chekObj.put("checkString", tempChk.getCheckString());
                                condition.add(chekObj);
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
        if (actual != null) { 
            if(existTable(TableName)) { 
                if (existColumn(columna,TableName)) { 
                    JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                    JSONObject table = (JSONObject) TableList.get(getIndex(TableName, TableList));
                    
                    JSONArray atributes = (JSONArray) table.get("atributes");
                    JSONArray primary = (JSONArray) table.get("primary");
                    JSONObject pk = (JSONObject) primary.get(0);
                    JSONArray pkAtributes = (JSONArray) pk.get("atributes");
                    if (existColumn(columna,pkAtributes)) {
                        boolean related = false; 
                        int i = 0;
                        while(!related && (i < TableList.size())) { 
                            JSONObject tempTable = (JSONObject) TableList.get(i);
                            JSONArray foreignK = (JSONArray) tempTable.get("foreign");
                            int j = 0; 
                            while (!related && (j < foreignK.size())) { 
                                JSONObject fk = (JSONObject) foreignK.get(j);
                                String refTable = (String) fk.get("table"); 
                                related = refTable.equals(TableName); 
                            }
                            i++;
                        }
                        if (related) { 
                            msg.add("COLUMN "+columna+" CANT BE DROPEED, IT HAS A CONSTRAINT OVER IT");
                        } else {
                            int index = getIndex(columna, atributes); 
                            atributes.remove(index);
                            table.put("atributes", atributes);
                            TableList.remove(getIndex(TableName, TableList)); 
                            TableList.add(table);
                            this.writeIn(TableList.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                        }
                    } else {
                        int index = getIndex(columna, atributes); 
                        atributes.remove(index);
                        table.put("atributes", atributes);
                        TableList.remove(getIndex(TableName, TableList)); 
                        TableList.add(table);
                        this.writeIn(TableList.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                        }
                } else { 
                    msg.add("COLUMN "+columna+" DOESN'T EXIST IN TABLE "+TableName);
                }
            } else {
                msg.add("TABLE "+TableName+" DOESN'T EXIST IN DB "+actual.getName());
            }
        } else {
            msg.add("NO DB SELECTED");
        }
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
                msg.add("TABLE "+TableName+" DROPPED SUCCESFULLY");
            } else {
                msg.add("RELATIONSHIP FOUND WITH THIS TABLE AND OTHER TABLE");
            }
        } else {
            msg.add("TABLE "+TableName+" DOESN'T EXIST IN DB "+actual.getName());
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
        if (actual != null) {
            if (existTable(TableName)) { 
                JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                JSONObject Table = (JSONObject) TableList.get(getIndex(TableName,TableList)); 
                JSONArray primary = (JSONArray) Table.get("primary");
                JSONArray atributes = (JSONArray) Table.get("atributes");
                JSONArray foreign = (JSONArray) Table.get("foreign");
                JSONArray condition= (JSONArray) Table.get("condition");
                if (primary.size()  > 0) {
                    msg.add("TABLE "+TableName+" CAN'T HAVE MORE THAN ONE PRIMARY KEY");
                } else { 
                    JSONObject prim = new JSONObject(); 
                    JSONArray primAtr = new JSONArray(); 
                    boolean allGood = true; 
                    ArrayList key = primKey.getAtributes(); 
                    int i = 0; 
                    
                    allGood = !(existColumn(primKey.getName(),atributes)||existColumn(primKey.getName(),primary)||existColumn(primKey.getName(),foreign)||existColumn(primKey.getName(),condition));
                    if (!allGood) msg.add("ID "+primKey.getName()+" ALREADY EXIST IN TABLE "+TableName);
                    while(allGood && (i < key.size())) { 
                        String atr = String.valueOf(key.get(i)); 
                        allGood = existColumn(atr,atributes); 
                        if (allGood) {
                            JSONObject PKatr = new JSONObject(); 
                            PKatr.put("name", atr); 
                            primAtr.add(PKatr); 
                        }
                        i++; 
                    }
                    if (allGood) {
                        prim.put("name",primKey.getName());
                        prim.put("atributes", primAtr); 
                        primary.add(prim);
                        Table.put("primary", primary); 
                        TableList.remove(getIndex(TableName,TableList));
                        TableList.add(Table);
                        this.writeIn(TableList.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                    } else {
                        msg.add("ATRIBUTE IN NEW PK KEY DOESN'T EXIST");
                    }
                }
            } else {
                msg.add("TABLE "+TableName+" DOESN'T EXIST");
            }
        } else { 
            msg.add("NO DB SELECTED");
        }
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
                    msg.add("PRIMARY KEY "+idConstraint+" REMOVED SUCCESFULLY FROM TABLE "+TableName);
                } else {
                    msg.add("PRIMARY KEY "+idConstraint+" CANT BE DROPED, IT IS FOREIGN KEY IN TABLE "+relTable);
                }
            } else if (existColumn(idConstraint, foreign)) {
                int index = getIndex(idConstraint, foreign); 
                foreign.remove(index); 
                table.put("foreign", foreign);
                msg.add("FOREIGN KEY "+idConstraint+" REMOVED SUCCESFULLY FROM TABLE "+TableName);
            } else if (existColumn(idConstraint, condition)) { 
                int index = getIndex(idConstraint, condition); 
                condition.remove(index);
                table.put("condition", condition);
                msg.add("CONDITION "+idConstraint+" REMOVED SUCCESFULLY FROM TABLE "+TableName);
            }
            
            TableList.remove(tableIndex);
            TableList.add(table); 
            this.writeIn(TableList.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
        } else {
            msg.add(TableName+" DOESN'T EXIST IN DB "+actual.getName());
        }
    }
    
    public String toString() { 
        String finalMsg = "";
        for (int i = 0; i < msg.size(); i++) finalMsg = finalMsg.concat(msg.get(i)+"\n");
        msg.clear();
        return finalMsg; 
    }
    
    
    private boolean eval(ArrayList<Value> valores, Check conditions) {
        String exp = conditions.getCheckString(); 
        ArrayList<String> postFix = conditions.InfixToPostfix(exp);
        for (int i = 0; i < postFix.size(); i++) {
            String subExp = postFix.get(i);
            try { 
                Integer id = Integer.parseInt(subExp);
                
            } catch (Exception e) {}
        }
        return true; 
    }
    
    
public ArrayList<String> getTableColumns (String TableName){
        ArrayList<String> columns = new ArrayList<>();
        if (existTable(TableName)){
            JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            int index = getIndex(TableName,TableList);
            JSONObject tabla = (JSONObject) TableList.get(index);
            JSONArray atributos = (JSONArray) tabla.get("atributes");
            for (Object atributo : atributos) {
                JSONObject obj = (JSONObject) atributo;
                columns.add((String) obj.get("name")); 
            }
        }
        else{
            msg.add("ERROR. La Tabla "+TableName+" no existe.");
        }
        return columns;
    }
    
    public ArrayList<String> getColumnsType(String TableName){
        ArrayList<String> types = new ArrayList<>();
        if (existTable(TableName)){
            JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            int index = getIndex(TableName,TableList);
            JSONObject tabla = (JSONObject) TableList.get(index);
            JSONArray atributos = (JSONArray) tabla.get("atributes");
            for (Object atributo : atributos) {
                JSONObject obj = (JSONObject) atributo;
                types.add((String) obj.get("type")); 
            }
        }
        else{
            msg.add("ERROR. La Tabla "+TableName+" no existe.");
        }
        return types;
    }
    
    public ArrayList<Long> getColumnsIndex(String TableName){
        ArrayList<Long> indexs = new ArrayList<>();
        if (existTable(TableName)){
            JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            int index = getIndex(TableName,TableList);
            JSONObject tabla = (JSONObject) TableList.get(index);
            JSONArray atributos = (JSONArray) tabla.get("atributes");
            for (Object atributo : atributos) {
                JSONObject obj = (JSONObject) atributo;
                indexs.add((Long) obj.get("index")); 
            }
        }
        else{
            msg.add("ERROR. La Tabla "+TableName+" no existe.");
        }
        return indexs;
    }
    
    public ArrayList<Long> getColumnsSize(String TableName){
        ArrayList<Long> size = new ArrayList<>();
        if (existTable(TableName)){
            JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            int index = getIndex(TableName,TableList);
            JSONObject tabla = (JSONObject) TableList.get(index);
            JSONArray atributos = (JSONArray) tabla.get("atributes");
            for (Object atributo : atributos) {
                JSONObject obj = (JSONObject) atributo;
                size.add((Long) obj.get("size")); 
            }
        }
        else{
            msg.add("ERROR. La Tabla "+TableName+" no existe.");
        }
        return size;
    }
    
    public ArrayList<String> getnamePK(String TableName){
        ArrayList<String> PK = new ArrayList<>();
        
        if (existTable(TableName)){
            JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            int index = getIndex(TableName, TableList);
            JSONObject tabla = (JSONObject) TableList.get(index);
            JSONArray pkArray = (JSONArray) tabla.get("primary");
            if (pkArray.size()>0){
               JSONObject pk  = (JSONObject)pkArray.get(0);
               JSONArray atributes = (JSONArray) pk.get("atributes");
               for (int i = 0; i < atributes.size(); i++) {
                   JSONObject obj  = (JSONObject)atributes.get(i);
                   PK.add((String) obj.get("name"));
               }   
            }
        }
        else{
            msg.add("ERROR. La Tabla "+TableName+" no existe.");
        }
        return PK;
    }
    
    public ArrayList<String> getnameFK (String TableName){
        ArrayList<String> FK = new ArrayList<>();
        
        if (existTable(TableName)){
            JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            int index = getIndex(TableName, TableList);
            JSONObject tabla = (JSONObject) TableList.get(index);
            JSONArray fkArray = (JSONArray) tabla.get("foreign");
            if (fkArray.size()>0){
                JSONObject fk  = (JSONObject)fkArray.get(0);
                JSONArray atributes = (JSONArray) fk.get("atributes");
                for (int i = 0; i < atributes.size(); i++) {
                    JSONObject obj  = (JSONObject)atributes.get(i);
                    FK.add((String) obj.get("name"));
                }
            }
        }
        else{
            msg.add("ERROR. La Tabla "+TableName+" no existe.");
        }
        return FK;
    }
    
    public ArrayList<Value> InfoTabla(String TableName){
        
        Value val;
        ArrayList<Value> values = new ArrayList<>();
        if(existTable(TableName)){
            JSONArray TableList = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
            int index = getIndex(TableName, TableList);
            JSONObject tabla = (JSONObject) TableList.get(index);
            JSONArray atributos = (JSONArray) tabla.get("atributes");
            for (Object atributo : atributos) {
                JSONObject obj = (JSONObject) atributo;
                //Value(String tipo, String value)
                //donde: TIPO = int, char, date, float
                //      VALUE = nombre de la columna que tiene con ese tipo.
                val=new Value((String)obj.get("type"),(String)obj.get("name"));
                values.add(val);
            }
        }
        else{
            msg.add("ERROR. La Tabla "+TableName+" no existe.");
        }
        
        return values;
    }
    
    @Override
    public void insertIntoTable (String nomTabla, ArrayList<String> columns, ArrayList values){
        boolean error = false;
        int insrows = 0;
        ArrayList<String> columnasTabla = getTableColumns(nomTabla);
        ArrayList<String> tiposTabla = getColumnsType(nomTabla);
        ArrayList<Long> indices = getColumnsIndex(nomTabla);
        JSONObject obj = new JSONObject();
        if (existTable(nomTabla)){
            if (columns.isEmpty()){//cuando se hace un insert y no se especifican a que columnas van a ingresar valores
                if (columnasTabla.size() == values.size()){
                    JSONArray tabla = getJsonArray(actual.getDirPath()+"\\"+nomTabla+".json");
                    JSONArray bd = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                    for (int i = 0; i < columnasTabla.size(); i++) {
                        //valido de que el tipo de dato que le estoy metiendo sea del mismo tipo de la columna.
                        Value val = (Value) values.get(i);
                        //msg.add(tiposTabla.get(i) +" "+ indices.get(i)+" "+ val.getTipo());
                        if (tiposTabla.get(i).equals(val.getTipo())){
                            if (tiposTabla.get(i).equals("date") || val.getTipo().equals("date")){
                                dateManager revDate = new dateManager();
                                if(revDate.defensive(val.getValue())){
                                    obj.put(columnasTabla.get(i), val.getValue());
                                }
                                else{
                                    msg.add("ERROR. La fecha "+ val.getValue()+ "es invalida.");
                                    error = true;
                                }
                            }
                            if(tiposTabla.get(i).equals("char") || val.getTipo().equals("char")){
                                //valido el tamanio del CHAR.
                                ArrayList<Long> sizes = getColumnsSize(nomTabla);
                                int tamActual = sizes.get(i).intValue();
                                if (val.getValue().length()-2> tamActual){
                                    msg.add("ERROR. El tamaño del CHAR que se desea insertar ("+val.getValue()+") supera el tamaño permitido de este atributo ("+tamActual+")");
                                    error = true;
                                }
                                else{
                                    obj.put(columnasTabla.get(i), val.getValue());
                                }
                            }
                            if(tiposTabla.get(i).equals("int")&&val.getTipo().equals("int")){
                                obj.put(columnasTabla.get(i), val.getValue());
                            }
                            else if (tiposTabla.get(i).equals("float")&&val.getTipo().equals("float")){
                                obj.put(columnasTabla.get(i), val.getValue());
                            }
                        }
                        else{
                            //A CONTINUACION VALIDO EL FORMATO DE VALORES EN EL CASO DE INT Y FLOAT. 
                            //SE HACE LA CONVERSION DE TIPOS PARA LAS COLUMNAS.
                            if (tiposTabla.get(i).equals("int") && val.getTipo().equals("float")) {
                                float newvalue = Float.parseFloat(val.getValue());
                                int nv = (int)newvalue;
                                String NV = String.valueOf(nv);
                                obj.put(columnasTabla.get(i), val.getValue());
                            }
                            else if(tiposTabla.get(i).equals("float")&& val.getTipo().equals("int")){
                                obj.put(columnasTabla.get(i), val.getValue()+".0");
                            }
                            else{
                                msg.add("ERROR. No se puede insertar un valor de tipo "+val.getTipo()+" en una columna de tipo "+tiposTabla.get(i));   
                                error = true;
                            }
                        }
                    }
                    //escribo en el JSON de la Tabla
                    tabla.add(obj);
                    this.writeIn(tabla.toJSONString(), actual.getDirPath()+"\\"+nomTabla+".json");
                    insrows+=1;
                    //Escribo en el JSON de la METADATA de la BASE DE DATOS
                    int index = getIndex(nomTabla, bd);
                    JSONObject tablaInfo = (JSONObject) bd.get(index);
                    long size = (long) tablaInfo.get("size");
                    tablaInfo.put("size", size+1); //cambio el size porque aumenta en uno.
                    bd.remove(index);
                    bd.add(tablaInfo);
                    this.writeIn(bd.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                }
                else if (columnasTabla.size()>values.size()){ //donde hay mas columnas que valores en el value. (NULLs)
                    JSONArray tabla = getJsonArray(actual.getDirPath()+"\\"+nomTabla+".json");
                    JSONArray bd = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                    //debo de poner NULL en donde ya no hayan valores.
                    for (int i = 0; i < columnasTabla.size(); i++) {
                        
                        if (tiposTabla.get(i).equals(((Value)values.get(i)).getTipo())){
                            if (tiposTabla.get(i).equals("date") || ((Value)values.get(i)).getTipo().equals("date")){
                                dateManager revDate = new dateManager();
                                if(revDate.defensive(((Value)values.get(i)).getValue())){
                                    if (values.size()>=i){
                                        String elem = ((Value)values.get(i)).getValue();
                                        values.remove(i);
                                        obj.put(columnasTabla.get(i), elem);
                                        //obj.put(columnasTabla.get(i), val.getValue());
                                    }
                                    else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                        //inserto valores null cuando hagan falta.
                                        obj.put(columnasTabla.get(i),null);
                                    }
                                }
                                else{
                                    msg.add("ERROR. La fecha "+ ((Value)values.get(i)).getValue()+ "es invalida.");
                                    error = true;
                                }
                            }
                            if(tiposTabla.get(i).equals("char") || ((Value)values.get(i)).getTipo().equals("char")){
                                //valido el tamanio del CHAR.
                                ArrayList<Long> sizes = getColumnsSize(nomTabla);
                                int tamActual = sizes.get(i).intValue();
                                if (((Value)values.get(i)).getValue().length()-2> tamActual){
                                    msg.add("ERROR. El tamaño del CHAR que se desea insertar ("+((Value)values.get(i)).getValue()+") supera el tamaño permitido de este atributo ("+tamActual+")");
                                    error = true;
                                }
                                else{
                                    if (values.size()>=i){
                                        String elem = ((Value)values.get(i)).getValue();
                                        values.remove(i);
                                        obj.put(columnasTabla.get(i), elem);
                                        //obj.put(columnasTabla.get(i), val.getValue());
                                    }
                                    else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                        //inserto valores null cuando hagan falta.
                                        obj.put(columnasTabla.get(i),null);
                                    }
                                }
                            }
                            if(tiposTabla.get(i).equals("int")&&((Value)values.get(i)).getTipo().equals("int")){
                                if (values.size()>=i){
                                        String elem = ((Value)values.get(i)).getValue();
                                        values.remove(i);
                                        obj.put(columnasTabla.get(i), elem);
                                        //obj.put(columnasTabla.get(i), val.getValue());
                                    }
                                    else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                        //inserto valores null cuando hagan falta.
                                        obj.put(columnasTabla.get(i),null);
                                    }
                            }
                            else if (tiposTabla.get(i).equals("float")&&((Value)values.get(i)).getTipo().equals("float")){
                                if (values.size()>=i){
                                        String elem = ((Value)values.get(i)).getValue();
                                        values.remove(i);
                                        obj.put(columnasTabla.get(i), elem);
                                        //obj.put(columnasTabla.get(i), val.getValue());
                                    }
                                    else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                        //inserto valores null cuando hagan falta.
                                        obj.put(columnasTabla.get(i),null);
                                    }
                            }
                        }
                        else{
                            //A CONTINUACION VALIDO EL FORMATO DE VALORES EN EL CASO DE INT Y FLOAT. 
                            //SE HACE LA CONVERSION DE TIPOS PARA LAS COLUMNAS.
                            if (tiposTabla.get(i).equals("int") && ((Value)values.get(i)).getTipo().equals("float")) {
                                float newvalue = Float.parseFloat(((Value)values.get(i)).getValue());
                                int nv = (int)newvalue;
                                String NV = String.valueOf(nv);
                                if (values.size()>=i){
                                        String elem = ((Value)values.get(i)).getValue();
                                        values.remove(i);
                                        obj.put(columnasTabla.get(i), elem);
                                        //obj.put(columnasTabla.get(i), val.getValue());
                                    }
                                    else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                        //inserto valores null cuando hagan falta.
                                        obj.put(columnasTabla.get(i),null);
                                    }
                            }
                            else if(tiposTabla.get(i).equals("float")&& ((Value)values.get(i)).getTipo().equals("int")){
                                if (values.size()>=i){
                                        String elem = ((Value)values.get(i)).getValue();
                                        values.remove(i);
                                        obj.put(columnasTabla.get(i), elem);
                                        //obj.put(columnasTabla.get(i), val.getValue());
                                    }
                                    else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                        //inserto valores null cuando hagan falta.
                                        obj.put(columnasTabla.get(i),null);
                                    }
                            }
                            else{
                                msg.add("ERROR. No se puede insertar un valor de tipo "+((Value)values.get(i)).getTipo()+" en una columna de tipo "+tiposTabla.get(i));   
                                error = true;
                            }
                        }
                        
                    }
                    //escribo en el JSON de la Tabla
                    tabla.add(obj);
                    this.writeIn(tabla.toJSONString(), actual.getDirPath()+"\\"+nomTabla+".json");
                    insrows+=1;
                    //Escribo en el JSON de la METADATA de la BASE DE DATOS
                    int index = getIndex(nomTabla, bd);
                    JSONObject tablaInfo = (JSONObject) bd.get(index);
                    long size = (long) tablaInfo.get("size");
                    tablaInfo.put("size", size+1); //cambio el size porque aumenta en uno.
                    bd.remove(index);
                    bd.add(tablaInfo);
                    this.writeIn(bd.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                }
                else{
                    msg.add("ERROR. No se pueden insertar mas valores de la cantidad de columnas de la tabla.");
                    error = true;
                }
            }
            //****************************************PARTE DOS DEL INSERTTT**********************************
        else{ //cuando si incluyen que valores de que columnas quieren insertar
               if (columns.size()>columnasTabla.size()) {
                   msg.add("ERROR. No se pueden seleccionar mas columnas de las que tiene la tabla solicitada.");
                   error = true;
               }
               else{
                   if (columns.size() == values.size()) {
                       if (values.size()>columnasTabla.size()){
                            msg.add("ERROR. Se pretende insertar mas valores a la tabla que la misma cantidad de columnas de la misma.");
                            error = true;
                        }
                        else if (columnasTabla.size()>values.size()){ //cuando hay que reemplazar con nulls
                            JSONArray tabla = getJsonArray(actual.getDirPath()+"\\"+nomTabla+".json");
                            JSONArray bd = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                            for (int i = 0; i < columns.size(); i++) {
                                 for (int j = 0; j < columnasTabla.size(); j++) {
                                     //Value val = (Value) values.get(i);
                                     if ((columns.get(i).equals(columnasTabla.get(j))) && columnasTabla.contains(columns.get(i))){
                                         if(values.size()>0 && i<=values.size()){
                                             if((tiposTabla.get((indices.get(j)).intValue()-1)).equals(((Value)values.get(i)).getTipo())){
                                                //cuando tienen el mismo tipo ambos, se valida el formato de cada uno de los tipos correspondientes.
                                                if ((tiposTabla.get((indices.get(j)).intValue()-1)).equals("date") || ((Value)values.get(i)).getTipo().equals("date")){
                                                     dateManager revDate = new dateManager();
                                                     if(revDate.defensive(((Value)values.get(i)).getValue())){
                                                         //obj.put(columnasTabla.get(i), val.getValue());
                                                       if (values.size()>=i){
                                                           String elem = ((Value)values.get(i)).getValue();
                                                           values.remove(i);
                                                           obj.put(columnasTabla.get(i), elem);
                                                           //obj.put(columnasTabla.get(i), val.getValue());
                                                       }
                                                       else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                                           //inserto valores null cuando hagan falta.
                                                           obj.put(columnasTabla.get(i),null);
                                                       }
                                                        tabla.add(obj);
                                                        this.writeIn(tabla.toJSONString(), actual.getDirPath()+"\\"+nomTabla+".json");
                                                        insrows+=1;
                                                        //Escribo en el JSON de la METADATA de la BASE DE DATOS
                                                        int index = getIndex(nomTabla, bd);
                                                        JSONObject tablaInfo = (JSONObject) bd.get(index);
                                                        long size = (long) tablaInfo.get("size");
                                                        tablaInfo.put("size", size+1); //cambio el size porque aumenta en uno.
                                                        bd.remove(index);
                                                        bd.add(tablaInfo);
                                                        this.writeIn(bd.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");    
                                                   }
                                                     else{
                                                         msg.add("ERROR. La fecha "+ ((Value)values.get(i)).getValue()+ "es invalida.");
                                                         error = true;
                                                     }
                                                 }
                                                 if((tiposTabla.get((indices.get(j)).intValue()-1)).equals("char") || ((Value)values.get(i)).getTipo().equals("char")){
                                                     //valido el tamanio del CHAR.
                                                     ArrayList<Long> sizes = getColumnsSize(nomTabla);
                                                     int tamActual = sizes.get(i).intValue();
                                                     if (((Value)values.get(i)).getValue().length()-2> tamActual){
                                                         msg.add("ERROR. El tamaño del CHAR que se desea insertar ("+((Value)values.get(i)).getValue()+") supera el tamaño permitido de este atributo ("+tamActual+")");
                                                         error = true;
                                                     }
                                                     else{
                                                       if (values.size()>=i){
                                                           String elem = ((Value)values.get(i)).getValue();
                                                           values.remove(i);
                                                           obj.put(columnasTabla.get(i), elem);
                                                           //obj.put(columnasTabla.get(i), val.getValue());
                                                       }
                                                       else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                                           //inserto valores null cuando hagan falta.
                                                           obj.put(columnasTabla.get(i),null);
                                                       }
                                                       tabla.add(obj);
                                                        this.writeIn(tabla.toJSONString(), actual.getDirPath()+"\\"+nomTabla+".json");
                                                        insrows+=1;
                                                        //Escribo en el JSON de la METADATA de la BASE DE DATOS
                                                        int index = getIndex(nomTabla, bd);
                                                        JSONObject tablaInfo = (JSONObject) bd.get(index);
                                                        long size = (long) tablaInfo.get("size");
                                                        tablaInfo.put("size", size+1); //cambio el size porque aumenta en uno.
                                                        bd.remove(index);
                                                        bd.add(tablaInfo);
                                                        this.writeIn(bd.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json"); 
                                                     }
                                                     
                                                 }
                                                 if((tiposTabla.get((indices.get(j)).intValue()-1)).equals("int")&&((Value)values.get(i)).getTipo().equals("int")){
                                                       if (values.size()>=i){
                                                           String elem = ((Value)values.get(i)).getValue();
                                                           values.remove(i);
                                                           obj.put(columnasTabla.get(i), elem);
                                                           //obj.put(columnasTabla.get(i), val.getValue());
                                                       }
                                                       else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                                           //inserto valores null cuando hagan falta.
                                                           obj.put(columnasTabla.get(i),null);
                                                       }
                                                       tabla.add(obj);
                                                        this.writeIn(tabla.toJSONString(), actual.getDirPath()+"\\"+nomTabla+".json");
                                                        insrows+=1;
                                                        //Escribo en el JSON de la METADATA de la BASE DE DATOS
                                                        int index = getIndex(nomTabla, bd);
                                                        JSONObject tablaInfo = (JSONObject) bd.get(index);
                                                        long size = (long) tablaInfo.get("size");
                                                        tablaInfo.put("size", size+1); //cambio el size porque aumenta en uno.
                                                        bd.remove(index);
                                                        bd.add(tablaInfo);
                                                        this.writeIn(bd.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json"); 
                                                 }
                                                 else if ((tiposTabla.get((indices.get(j)).intValue()-1)).equals("float")&&((Value)values.get(i)).getTipo().equals("float")){
                                                     if (values.size()>=i){
                                                           String elem = ((Value)values.get(i)).getValue();
                                                           values.remove(i);
                                                           obj.put(columnasTabla.get(i), elem);
                                                           //obj.put(columnasTabla.get(i), val.getValue());
                                                       }
                                                       else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                                           //inserto valores null cuando hagan falta.
                                                           obj.put(columnasTabla.get(i),null);
                                                       }
                                                        tabla.add(obj);
                                                        this.writeIn(tabla.toJSONString(), actual.getDirPath()+"\\"+nomTabla+".json");
                                                        insrows+=1;
                                                        //Escribo en el JSON de la METADATA de la BASE DE DATOS
                                                        int index = getIndex(nomTabla, bd);
                                                        JSONObject tablaInfo = (JSONObject) bd.get(index);
                                                        long size = (long) tablaInfo.get("size");
                                                        tablaInfo.put("size", size+1); //cambio el size porque aumenta en uno.
                                                        bd.remove(index);
                                                        bd.add(tablaInfo);
                                                        this.writeIn(bd.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json"); 
                                                 }
                                            }
                                            else{
                                                //LOS TIPOS SON DISTINTOS
                                                //SE HACE LA CONVERSION DE TIPOS PARA LAS COLUMNAS.
                                                 if ((tiposTabla.get((indices.get(j)).intValue()-1)).equals("int") && ((Value)values.get(i)).getTipo().equals("float")) {
                                                     float newvalue = Float.parseFloat(((Value)values.get(i)).getValue());
                                                     int nv = (int)newvalue;
                                                     String NV = String.valueOf(nv);
                                                     if (values.size()>=i){
                                                           String elem = ((Value)values.get(i)).getValue();
                                                           values.remove(i);
                                                           obj.put(columnasTabla.get(i), elem);
                                                           //obj.put(columnasTabla.get(i), val.getValue());
                                                       }
                                                       else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                                           //inserto valores null cuando hagan falta.
                                                           obj.put(columnasTabla.get(i),null);
                                                       }
                                                    tabla.add(obj);
                                                    this.writeIn(tabla.toJSONString(), actual.getDirPath()+"\\"+nomTabla+".json");
                                                    insrows+=1;
                                                    //Escribo en el JSON de la METADATA de la BASE DE DATOS
                                                    int index = getIndex(nomTabla, bd);
                                                    JSONObject tablaInfo = (JSONObject) bd.get(index);
                                                    long size = (long) tablaInfo.get("size");
                                                    tablaInfo.put("size", size+1); //cambio el size porque aumenta en uno.
                                                    bd.remove(index);
                                                    bd.add(tablaInfo);
                                                    this.writeIn(bd.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json"); 
                                                 }
                                                 else if((tiposTabla.get((indices.get(j)).intValue()-1)).equals("float")&& ((Value)values.get(i)).getTipo().equals("int")){
                                                     if (values.size()>=i){
                                                           String elem = ((Value)values.get(i)).getValue();
                                                           values.remove(i);
                                                           obj.put(columnasTabla.get(i), elem);
                                                           //obj.put(columnasTabla.get(i), val.getValue());
                                                       }
                                                       else if(values.size()<i &&(columnasTabla.size()>=0)){ //cuando hay mas columnas que valores especificados en el insert.
                                                           //inserto valores null cuando hagan falta.
                                                           obj.put(columnasTabla.get(i),null);
                                                       }
                                                     tabla.add(obj);
                                                    this.writeIn(tabla.toJSONString(), actual.getDirPath()+"\\"+nomTabla+".json");
                                                    insrows+=1;
                                                    //Escribo en el JSON de la METADATA de la BASE DE DATOS
                                                    int index = getIndex(nomTabla, bd);
                                                    JSONObject tablaInfo = (JSONObject) bd.get(index);
                                                    long size = (long) tablaInfo.get("size");
                                                    tablaInfo.put("size", size+1); //cambio el size porque aumenta en uno.
                                                    bd.remove(index);
                                                    bd.add(tablaInfo);
                                                    this.writeIn(bd.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json"); 
                                                 }
                                                 else{
                                                     msg.add("ERROR. No se puede insertar un valor de tipo "+((Value)values.get(i)).getTipo()+" en una columna de tipo "+tiposTabla.get(i));   
                                                     error = true;
                                                 }
                                            }
                                         }
                                         else{
                                             obj.put(columnasTabla.get(i),null);
                                             tabla.add(obj);
                                            this.writeIn(tabla.toJSONString(), actual.getDirPath()+"\\"+nomTabla+".json");
                                            insrows+=1;
                                            //Escribo en el JSON de la METADATA de la BASE DE DATOS
                                            int index = getIndex(nomTabla, bd);
                                            JSONObject tablaInfo = (JSONObject) bd.get(index);
                                            long size = (long) tablaInfo.get("size");
                                            tablaInfo.put("size", size+1); //cambio el size porque aumenta en uno.
                                            bd.remove(index);
                                            bd.add(tablaInfo);
                                            this.writeIn(bd.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");    
                                         }
                                         
                                     }
                                     else{
                                        
                                         if (columnasTabla.contains(columns.get(i))){
                                             if(!columns.contains(columnasTabla.get(j))){
                                                columns.add(columnasTabla.get(j));    
                                             }
                                         }
                                         else{
                                            msg.add("ERROR. Se esta especificando una columna ("+columns.get(i)+") que no existe en la tabla .");
                                            error = true;   
                                         }
                                     }
                                 }
                             }                        
                        }
                        else{//cuando son del mismo tamaño
                             JSONArray tabla = getJsonArray(actual.getDirPath()+"\\"+nomTabla+".json");
                             JSONArray bd = getJsonArray(actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");
                            for (int i = 0; i < columns.size(); i++) {
                                 Value val = (Value) values.get(i);
                                 for (int j = 0; j < columnasTabla.size(); j++) {
                                     if (columns.get(i).equals(columnasTabla.get(j))){
                                         if((tiposTabla.get((indices.get(j)).intValue()-1)).equals(val.getTipo())){
                                             //cuando tienen el mismo tipo ambos, se valida el formato de cada uno de los tipos correspondientes.
                                             if ((tiposTabla.get((indices.get(j)).intValue()-1)).equals("date") || val.getTipo().equals("date")){
                                                  dateManager revDate = new dateManager();
                                                  if(revDate.defensive(val.getValue())){
                                                      obj.put(columnasTabla.get(i), val.getValue());
                                                  }
                                                  else{
                                                      msg.add("ERROR. La fecha "+ val.getValue()+ "es invalida.");
                                                      error = true;
                                                  }
                                              }
                                              if((tiposTabla.get((indices.get(j)).intValue()-1)).equals("char") || val.getTipo().equals("char")){
                                                  //valido el tamanio del CHAR.
                                                  ArrayList<Long> sizes = getColumnsSize(nomTabla);
                                                  int tamActual = sizes.get(i).intValue();
                                                  if (val.getValue().length()-2> tamActual){
                                                      msg.add("ERROR. El tamaño del CHAR que se desea insertar ("+val.getValue()+") supera el tamaño permitido de este atributo ("+tamActual+")");
                                                      error = true;
                                                  }
                                                  else{
                                                      obj.put(columnasTabla.get(i), val.getValue());
                                                  }
                                              }
                                              if((tiposTabla.get((indices.get(j)).intValue()-1)).equals("int")&&val.getTipo().equals("int")){
                                                  obj.put(columnasTabla.get(i), val.getValue());
                                              }
                                              else if ((tiposTabla.get((indices.get(j)).intValue()-1)).equals("float")&&val.getTipo().equals("float")){
                                                  obj.put(columnasTabla.get(i), val.getValue());
                                              }
                                         }
                                         else{
                                             //LOS TIPOS SON DISTINTOS
                                             //SE HACE LA CONVERSION DE TIPOS PARA LAS COLUMNAS.
                                              if ((tiposTabla.get((indices.get(j)).intValue()-1)).equals("int") && val.getTipo().equals("float")) {
                                                  float newvalue = Float.parseFloat(val.getValue());
                                                  int nv = (int)newvalue;
                                                  String NV = String.valueOf(nv);
                                                  obj.put(columnasTabla.get(i), val.getValue());
                                              }
                                              else if((tiposTabla.get((indices.get(j)).intValue()-1)).equals("float")&& val.getTipo().equals("int")){
                                                  obj.put(columnasTabla.get(i), val.getValue()+".0");
                                              }
                                              else{
                                                  msg.add("ERROR. No se puede insertar un valor de tipo "+val.getTipo()+" en una columna de tipo "+tiposTabla.get(i));   
                                                  error = true;
                                              }
                                         }
                                     }
                                     else{
                                         msg.add("ERROR. Se esta especificando una columna que no existe en la tabla ("+columns.get(i)+").");
                                         error = true;
                                     }
                                 }
                             }
                            //escribo en el JSON de la Tabla
                             tabla.add(obj);
                             this.writeIn(tabla.toJSONString(), actual.getDirPath()+"\\"+nomTabla+".json");
                             insrows+=1;
                             //Escribo en el JSON de la METADATA de la BASE DE DATOS
                             int index = getIndex(nomTabla, bd);
                             JSONObject tablaInfo = (JSONObject) bd.get(index);
                             long size = (long) tablaInfo.get("size");
                             tablaInfo.put("size", size+1); //cambio el size porque aumenta en uno.
                             bd.remove(index);
                             bd.add(tablaInfo);
                             this.writeIn(bd.toJSONString(), actual.getDirPath()+"\\"+actual.getName()+"MetaData.json");    
                        }
                    }
                    else{
                        msg.add("ERROR. La cantidad de columnas especificadas deben de ser igual a la cantidad de elementos en la clausula VALUE.");
                        error = true;
                    }   
                }
            }
        }
        else{
            msg.add("ERROR. La tabla a la cual se quiere hacer insert ("+nomTabla +") no existe.");
            error = true;
        }
        if (error) {
                msg.add("ERROR. El INSERT ("+ insrows+ ") NO se ha realizado con exito.");
            }
        else{
            msg.add("El INSERT ("+insrows+") se ha realizado con exito.");
        }
    }
    
    @Override
    public void updateTable (String nomTabla, ArrayList<String> columns, ArrayList values){
        boolean error = false;
        int rowsupt=0;
        
        if(columns.isEmpty()){
            error = true;
        }
        else{//cuando no hay error.
            if (existTable(nomTabla)){
                
            }
            else{
                error = true;
            }
        }
        
        
        if (error) {
            msg.add("UPDATE ("+rowsupt+") realizado con exito.");
        }
        else{
            msg.add("ERROR. UPDATE ("+rowsupt+") no se ha realizado con exito.");
        }
    }
    
    @Override
    public void deleteFromTable (String nomTabla){
        boolean error = false;
        int rowsdel = 0;
        
        if (existTable(nomTabla)){
            
        }
        else{
            error = true;
        }
        
        if (error) {
            msg.add("DELETE ("+rowsdel+") realizado con exito.");
        }
        else{
            msg.add("ERROR. DELETE ("+rowsdel+") no se ha realizado con exito.");
        }
    }
}
