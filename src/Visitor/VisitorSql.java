/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import GUI.*;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author William
 * @param <T>
 */
public class VisitorSql <T> extends sqlBaseVisitor{
    ArrayList errores = new ArrayList();
    String enUso="";
    DBDataManager mn = new DBDataManager();
    ArrayList<Condition> condition = new ArrayList();
    int indice = 0;
    int indiceC=1;
    
    public ArrayList getErrores() {
        return errores;
    }

    public void setErrores(ArrayList errores) {
        this.errores = errores;
    }

    @Override
    public Object visitTodo(sqlParser.TodoContext ctx) {
        
        return super.visitTodo(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCasitodo(sqlParser.CasitodoContext ctx) {
        return super.visitCasitodo(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitCreateDB(sqlParser.CreateDBContext ctx) {
        String nombreDB = ctx.getChild(2).getText();
        if(mn.existDB(nombreDB)){
            errores.add("ERROR: " + "------Linea "+ctx.getStart().getLine() + " -----"+ "La base de datos: --- " + nombreDB + " --- ya existe.");
        }
        else{
            mn.createDB(nombreDB);
        }
        return (T)""; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitAlterDB(sqlParser.AlterDBContext ctx) {
        String nomActual = ctx.getChild(2).getText();
        String nomNuevo = ctx.getChild(5).getText();
        if(!mn.existDB(nomActual)){
            errores.add("ERROR: " + "------Linea "+ctx.getStart().getLine() + " -----"+ "La base de datos: --- " + nomActual+ " --- no existe.");
        }
        else{
            if(!mn.existDB(nomNuevo)){
                mn.renameDB(nomActual,nomNuevo);
            }
            else{
                errores.add("ERROR: " + "------Linea "+ctx.getStart().getLine() + " -----"+ "La base de datos: --- " + nomActual+ " --- ya existe.");
            }
            
        }
        return (T)""; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitShowDB(sqlParser.ShowDBContext ctx) {
        ArrayList allDB= mn.showDB();
        /*------------OJO---------------*/
        /*falta agregarlas a algun frame o algo*/
        return (T) ""; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    @Override
    public T visitDropDB(sqlParser.DropDBContext ctx) {
        String nombreDB = ctx.getChild(2).getText();
        if(!mn.existDB(nombreDB)){
            errores.add("ERROR: " + "------Linea "+ctx.getStart().getLine() + " -----"+ "La base de datos: --- " + nombreDB + " --- no existe.");
        }
        else{
            mn.dropDB(nombreDB);
        }
        return (T) ""; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitUseDB(sqlParser.UseDBContext ctx) {
        String nombreDB = ctx.getChild(2).getText();
        if(!mn.existDB(nombreDB)){
            errores.add("ERROR: " + "------Linea "+ctx.getStart().getLine() + " -----"+ "La base de datos: --- " + nombreDB + " --- no existe.");
        }
        else{
            mn.selectDB(nombreDB);
            enUso=nombreDB;
        }
        return (T)""; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitCreateTB(sqlParser.CreateTBContext ctx) {
        String nombreTB = ctx.getChild(2).getText();
        if(!mn.existTable(nombreTB)){
            int hijo = ctx.getChildCount()-2;
            ParseTree ctxn = ctx.getChild(hijo);
            Table tabla = (Table) this.visitConstraints((sqlParser.ConstraintsContext) ctxn);
            tabla.setName(nombreTB);
            ArrayList<Atributo> atributos = new ArrayList();
            List <sqlParser.AtributoContext>atributosI = ctx.atributo();

            if(!atributosI.isEmpty()){
                for(sqlParser.AtributoContext o: atributosI){
                    atributos.add((Atributo)this.visitAtributo(o));  
                }
            }
            tabla.setAtributes(atributos);
            mn.createTable(tabla);
        }
        else{
            errores.add("ERROR: " + "------Linea "+ctx.getStart().getLine() + " -----"+ "La base de datos: --- " + nombreTB + " --- ya existe.");
        }
        indice=1;
        
        return (T)""; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitAtributo(sqlParser.AtributoContext ctx) {
        indice = indice+1;
        String nombreA = ctx.getChild(0).getText();
        Type ty = (Type)this.visitTipo((sqlParser.TipoContext) ctx.getChild(1));
        String tipo = ty.getNombre();
        int tam= ty.getTamaño();
        Atributo atr= new Atributo(nombreA,tipo,tam,indice);
        return (T) atr; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitTipo(sqlParser.TipoContext ctx) {
        String nomTipo;
        nomTipo = ctx.getChild(0).getText();
        if("char".equals(nomTipo) || "CHAR".equals(nomTipo) || "Char".equals(nomTipo)){
            int tam;
            tam = Integer.parseInt(ctx.getChild(2).getText());
            Type ty = new Type(nomTipo,tam);
            return (T) ty;
        } 
        else {
            Type ty = new Type(nomTipo,0);
            return (T) ty;
        }
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitConstraints(sqlParser.ConstraintsContext ctx) {
        List <sqlParser.ConstraintContext> cons = ctx.constraint();
        ArrayList<Constraint> consG = new ArrayList();
        ArrayList<primaryKey> primary = new ArrayList();
        String ni = "";
        /*MI ARRAY DE PRIMARY KEYS*/
        ArrayList<primaryKey> pri = new ArrayList();
        /*MI ARRAY DE FOREIGN KEY*/
        ArrayList<foreignKey> fore = new ArrayList();
        /*MI ARRAY DE CHECKS*/
        ArrayList<Check> check = new ArrayList();
        if(!cons.isEmpty()){
            for(sqlParser.ConstraintContext o: cons){
                String esC = o.getChild(1).getText();
                esC=esC.toUpperCase();
                if(esC.equals("PRIMARY")){
                    String nameC=o.getChild(0).getText();
                    ArrayList nombres = new ArrayList();
                    ArrayList<Constraint> temp = (ArrayList<Constraint>) this.visitCPK((sqlParser.CPKContext)o);
                    for (Constraint temp1 : temp) {
                        nombres.add(temp1.getNombre());                    
                    }
                    primaryKey pr = new primaryKey(nameC,nombres);
                    primary.add(pr);
                }
                if(esC.equals("FOREIGN")){
                    String nameC=o.getChild(0).getText();
                    ArrayList nombresPropios = new ArrayList();
                    ArrayList nomAtri = new ArrayList();
                    String nameT = null;
                    ArrayList<Constraint> temp = (ArrayList<Constraint>) this.visitCFK((sqlParser.CFKContext)o);
                    for (Constraint temp1 : temp) {
                        nombresPropios.add(temp1.getNombre());
                    }
                    esC = o.getChild(o.getChildCount()-1).getText();
                    esC=esC.toUpperCase();
                    if(esC.contains("REFERENCES")){
                        ArrayList<Constraint> temp2 = (ArrayList<Constraint>) this.visitReferences((sqlParser.ReferencesContext)o.getChild(o.getChildCount()-1));
                        for (Constraint temp3 : temp2) {
                            nomAtri.add(temp3.getNombre());
                            nameT=temp3.getNameT();
                        }
                    }
                    foreignKey fo = new foreignKey(nameC,nombresPropios,nameT,nomAtri);
                    fore.add(fo);
                }
                
                if(esC.equals("CHECK")){
                    String nameC=o.getChild(0).getText();
                    ni = (String)this.visitExp((sqlParser.ExpContext) o.getChild(2));
                    Condition g = new Condition();
                    Check ch = new Check(condition,nameC);
                    ch.setCheckString(ni);
                    check.add(ch);
                    indiceC=1;
                }
            }
            Table tabla = new Table();
            tabla.setPrimaryKeys(primary);
            tabla.setForeignKeys(fore);
            tabla.setChecks(check);
            condition.clear();
            return (T) tabla; //To change body of generated methods, choose Tools | Templates.

        }
        else{
            Table tabla = new Table();
            tabla.setPrimaryKeys(null);
            tabla.setForeignKeys(null);
            return (T) tabla;
        }
        
    }

    @Override
    public T visitCPK(sqlParser.CPKContext ctx) {
        int hijo = ctx.getChildCount()-2;
        ParseTree ctxn = ctx.getChild(hijo);
        ArrayList idsI = (ArrayList) this.visitConjuntoId((sqlParser.ConjuntoIdContext)ctxn);
        ArrayList<Constraint> consG = new ArrayList();
        for(Object o: idsI){
            String id = (String) o;
            Constraint con = new Constraint(id,true,false,false);
            consG.add(con);
        }
        return (T) consG; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitCFK(sqlParser.CFKContext ctx) {
        int hijo = ctx.getChildCount()-3;
        ParseTree ctxn = ctx.getChild(hijo);
        ArrayList idsI = (ArrayList) this.visitConjuntoId((sqlParser.ConjuntoIdContext)ctxn);
        ArrayList<Constraint> consG = new ArrayList();
        for(Object o: idsI){
            String id = (String) o;
            Constraint con = new Constraint(id,false,true,false);
            consG.add(con);
        }
        
        return (T) consG; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    @Override
    public T visitConjuntoId(sqlParser.ConjuntoIdContext ctx) {
        ArrayList ids = new ArrayList();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String nomb = ctx.getChild(i).getText();
            if(!nomb.equals(",")){
                ids.add(nomb);
            }
        }
        return (T) ids; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitReferences(sqlParser.ReferencesContext ctx) {
        int hijo = ctx.getChildCount()-2;
        String nameT = ctx.getChild(1).getText();
        ParseTree ctxn = ctx.getChild(hijo);
        ArrayList idsI = (ArrayList) this.visitConjuntoId((sqlParser.ConjuntoIdContext)ctxn);
        ArrayList<Constraint> consG = new ArrayList();
        for(Object o: idsI){
            String id = (String) o;
            Constraint con = new Constraint(id,false,false,true);
            con.setNameT(nameT);
            consG.add(con);
        }
        return (T) consG;
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitRenameTB(sqlParser.RenameTBContext ctx) {
        String nomActual = ctx.getChild(2).getText();
        String nomNuevo = ctx.getChild(ctx.getChildCount()-1).getText();
        if(!mn.existTable(nomActual)){
            errores.add("ERROR: " + "------Linea "+ctx.getStart().getLine() + " -----"+ "La tabla: --- " + nomActual + " --- no existe.");
        }
        else{
            if(mn.existTable(nomNuevo)){
                errores.add("ERROR: " + "------Linea "+ctx.getStart().getLine() + " -----"+ "La tabla: --- " + nomActual + " --- ya existe.");
            }
            else{
                mn.renameTable(nomActual, nomNuevo);
            }
        }
        mn.renameTable(nomActual, nomNuevo);
        return (T)""; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitDropTB(sqlParser.DropTBContext ctx) {
        String nameTB = ctx.getChild(2).getText();
        if(mn.existTable(nameTB)){
            mn.dropTable(nameTB);
        }
        else{
            errores.add("ERROR: " + "------Linea "+ctx.getStart().getLine() + " -----"+ "La tabla: --- " + nameTB + " --- no existe.");
        }
        
        return (T)""; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitShowColums(sqlParser.ShowColumsContext ctx) {
        String nameTB= ctx.getChild(3).getText();
        if(mn.existTable(nameTB)){
            /*************OJO******************************** 
         ************ SE DEBE UNIR A ALGO DE LA GUI**************/
            mn.showColumns(nameTB);
        }
        else{
            errores.add("ERROR: " + "------Linea "+ctx.getStart().getLine() + " -----"+ "La tabla: --- " + nameTB + " --- no existe.");
        }
        return (T)""; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public T visitAlterTB(sqlParser.AlterTBContext ctx) {
        String nameTB = ctx.getChild(2).getText();
        List <sqlParser.TableActionContext> acTable = ctx.tableAction();
        for(sqlParser.TableActionContext o:acTable){
            if(o.getText().contains("ADDCOLU")){
                column col = (column) this.visitAddColumnTB((sqlParser.AddColumnTBContext) o);
                mn.addColumn(nameTB, col.getAt(), col.getPrimary(), col.getFore(), null);
            }
            else if(o.getText().contains("ADDCONST")){
                this.visitAddConstraintTB((sqlParser.AddConstraintTBContext) o);
            }
            else if(o.getText().contains("DROPCOL")){
                String nameCol = (String) this.visitDropColumnTB((sqlParser.DropColumnTBContext) o);
                mn.dropColumn(nameTB, nameCol);
            }
            else{
               String nameCons = (String) this.visitDropConstraintTB((sqlParser.DropConstraintTBContext) o);
               mn.dropConstraint(nameTB, nameCons);
            }
        }
        return (T)""; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    @Override
    public T visitAddColumnTB(sqlParser.AddColumnTBContext ctx) {
        String nomCol = ctx.getChild(2).getText();
        Type type = (Type)this.visitTipo((sqlParser.TipoContext) ctx.getChild(3));
        String tip= type.getNombre();
        int size=type.getTamaño();
        Atributo at= new Atributo(nomCol,tip,size,indice);
        Table tab = (Table)this.visitConstraints((sqlParser.ConstraintsContext) ctx.getChild(ctx.getChildCount()-1));
        if(tab!=null){
            column col = new column(tab.getPrimaryKeys(),tab.getForeignKeys(),at);
            return (T)col; //To change body of generated methods, choose Tools | Templates.
        }
        else{
            column col = new column(null,null,at);
            return (T)col; //To change body of generated methods, choose Tools | Templates. 
        }
        
    }

    
    /*SOLO ESTE FALTA PARA COMPLETAR MI TAREA*/
    @Override
    public T visitAddConstraintTB(sqlParser.AddConstraintTBContext ctx) {
        ArrayList<Constraint> consG = new ArrayList();
        ArrayList<primaryKey> primary = new ArrayList();
        
        String ni="";
        /*MI ARRAY DE PRIMARY KEYS*/
        ArrayList<primaryKey> pri = new ArrayList();
        /*MI ARRAY DE FOREIGN KEY*/
        ArrayList<foreignKey> fore = new ArrayList();
        /*MI ARRAY DE CHECKS*/
        ArrayList<Check> check = new ArrayList();
        sqlParser.ConstraintContext o = (sqlParser.ConstraintContext) ctx.getChild(ctx.getChildCount()-1);
        String esC = o.getChild(1).getText();
        esC=esC.toUpperCase();
        if(esC.equals("PRIMARY")){
            String nameC=o.getChild(0).getText();
            ArrayList nombres = new ArrayList();
            ArrayList<Constraint> temp = (ArrayList<Constraint>) this.visitCPK((sqlParser.CPKContext)o);
            for (Constraint temp1 : temp) {
                nombres.add(temp1.getNombre());                    
            }
            primaryKey pr = new primaryKey(nameC,nombres);
            primary.add(pr);
        }
        if(esC.equals("FOREIGN")){
            String nameC=o.getChild(0).getText();
            ArrayList nombresPropios = new ArrayList();
            ArrayList nomAtri = new ArrayList();
            String nameT = null;
            ArrayList<Constraint> temp = (ArrayList<Constraint>) this.visitCFK((sqlParser.CFKContext)o);
            for (Constraint temp1 : temp) {
                nombresPropios.add(temp1.getNombre());
            }
            esC = o.getChild(o.getChildCount()-1).getText();
            esC=esC.toUpperCase();
            if(esC.contains("REFERENCES")){
                ArrayList<Constraint> temp2 = (ArrayList<Constraint>) this.visitReferences((sqlParser.ReferencesContext)o.getChild(o.getChildCount()-1));
                for (Constraint temp3 : temp2) {
                    nomAtri.add(temp3.getNombre());
                    nameT=temp3.getNameT();
                }
            }
            foreignKey fo = new foreignKey(nameC,nombresPropios,nameT,nomAtri);
            fore.add(fo);
        }

        if(esC.equals("CHECK")){
            String nameC=o.getChild(0).getText();
            ni = (String)this.visitExp((sqlParser.ExpContext) o.getChild(2));
            Condition g = new Condition();
            Check ch = new Check(condition,nameC);
            ch.setCheckString(ni);
            check.add(ch);
            indiceC=1;
        }
        Table tabla = new Table();
        tabla.setPrimaryKeys(primary);
        tabla.setForeignKeys(fore);
        tabla.setChecks(check);
        condition.clear();
        indiceC=1;
        return (T) tabla; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitDropColumnTB(sqlParser.DropColumnTBContext ctx) {
        String nomCol = ctx.getChild(2).getText();
        return (T) nomCol; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitDropConstraintTB(sqlParser.DropConstraintTBContext ctx) {
        String nomCons = ctx.getChild(2).getText();
        return (T) nomCons; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitShowTB(sqlParser.ShowTBContext ctx) {
        /*************OJO******************************** 
         ************ SE DEBE UNIR A ALGO DE LA GUI**************/
        mn.showTables();
        return (T)""; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitExp(sqlParser.ExpContext ctx) {
        String cadena = ctx.getText();
        System.out.println(cadena);
        for(int i=0; i<ctx.getChildCount();i++){
            this.visit(ctx.getChild(i));
        }
        return (T) cadena;
    }

    @Override
    public T visitExpEq(sqlParser.ExpEqContext ctx) {
        String nameCol = ctx.getChild(0).getText();
        String operador  = ctx.getChild(1).getText();
        String valor = ctx.getChild(2).getText();
        Condition cond = new Condition();
        cond.setId(indiceC);
        cond.setColumn(nameCol);
        cond.setValue(valor);
        if(operador.equals("=")){
            cond.setEqual(true);
        }
        else{
            cond.setDistinct(true);
        }
        indiceC=indiceC+1;
        condition.add(cond);
        return (T)cond; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitExpGL(sqlParser.ExpGLContext ctx) {
        String nameCol = ctx.getChild(0).getText();
        String operador  = ctx.getChild(1).getText();
        String valor = ctx.getChild(2).getText();
        Condition cond = new Condition();
        cond.setId(indiceC);
        cond.setColumn(nameCol);
        cond.setValue(valor);
        if(operador.equals(">")){
            cond.setMinValue(true);
        }
        if(operador.equals("<")){
            cond.setMaxValue(true);
        }
        if(operador.equals(">=")){
            cond.setMinValueInc(true);
        }
        if(operador.equals("<=")){
            cond.setMaxValue(true);
        }
        indiceC=indiceC+1;
        condition.add(cond);
        return (T)""; //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public T visitLiteralString(sqlParser.LiteralStringContext ctx) {
        String nameCol = ctx.getText();
        return (T)nameCol; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    /*PARA EL DML*/

    @Override
    public T visitInsert(sqlParser.InsertContext ctx) {
        String nombreTB = ctx.getChild(1).getText();
        ArrayList columnas = new ArrayList();
        ArrayList<Value> values = new ArrayList();
        List<sqlParser.FormatValueContext> val = ctx.formatValue();
        if(!ctx.getChild(3).getText().toUpperCase().equals("VALUES")){
            columnas = (ArrayList)(T)this.visitVariosId((sqlParser.VariosIdContext) ctx.getChild(3));
        }
        for(sqlParser.FormatValueContext o:val){
            Value valu;
            valu = (Value) this.visitFormatValue(o);
            values.add(valu);
        }
        
        return (T)values; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitVariosId(sqlParser.VariosIdContext ctx) {
        ArrayList ids = new ArrayList();
            for(int i=0; i<ctx.getChildCount();i++){
            if(!ctx.getChild(i).getText().equals(",") && !ctx.getChild(i).getText().equals("(") && !ctx.getChild(i).getText().equals(")")){
                ids.add(ctx.getChild(i).getText());
            }
        }
        return (T)ids; //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public T visitFormatValue(sqlParser.FormatValueContext ctx) {
        String text = ctx.getText();
        for(int i=0; i<ctx.getChildCount();i++){
            return (T) this.visit(ctx.getChild(i));
        }
        return (T) ""; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitEntero(sqlParser.EnteroContext ctx) {
        String tipo = "int";
        String value = ctx.getText();
        Value val = new Value(tipo,value);
        return (T)val; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitCharacter(sqlParser.CharacterContext ctx) {
        String tipo = "char";
        String value = ctx.getText();
        Value val = new Value(tipo,value);
        return (T)val; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitDecimal(sqlParser.DecimalContext ctx) {
        String tipo = "float";
        String value = ctx.getText();
        Value val = new Value(tipo,value);
        return (T)val; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitFecha(sqlParser.FechaContext ctx) {
        String tipo = "date";
        String value = ctx.getText();
        Value val = new Value(tipo,value);
        return (T)val; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T visitNullType(sqlParser.NullTypeContext ctx) {
        String tipo = "null";
        String value = ctx.getText();
        Value val = new Value(tipo,value);
        return (T)val; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
