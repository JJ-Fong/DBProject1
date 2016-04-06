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
    int indice = 0;
    
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
        
        /*MI ARRAY DE PRIMARY KEYS*/
        ArrayList<primaryKey> pri = new ArrayList();
        /*MI ARRAY DE FOREIGN KEY*/
        ArrayList<foreignKey> fore = new ArrayList();
        if(!cons.isEmpty()){
            for(sqlParser.ConstraintContext o: cons){
                if(o.getChild(1).getText().equals("primary")){
                    String nameC=o.getChild(0).getText();
                    ArrayList nombres = new ArrayList();
                    ArrayList<Constraint> temp = (ArrayList<Constraint>) this.visitCPK((sqlParser.CPKContext)o);
                    for (Constraint temp1 : temp) {
                        nombres.add(temp1.getNombre());                    
                    }
                    primaryKey pr = new primaryKey(nameC,nombres);
                    primary.add(pr);
                }
                if(o.getChild(1).getText().equals("foreign")){
                    String nameC=o.getChild(0).getText();
                    ArrayList nombresPropios = new ArrayList();
                    ArrayList nomAtri = new ArrayList();
                    String nameT = null;
                    ArrayList<Constraint> temp = (ArrayList<Constraint>) this.visitCFK((sqlParser.CFKContext)o);
                    for (Constraint temp1 : temp) {
                        nombresPropios.add(temp1.getNombre());
                    }
                    if(o.getChild(o.getChildCount()-1).getText().contains("references")){
                        ArrayList<Constraint> temp2 = (ArrayList<Constraint>) this.visitReferences((sqlParser.ReferencesContext)o.getChild(o.getChildCount()-1));
                        for (Constraint temp3 : temp2) {
                            nomAtri.add(temp3.getNombre());
                            nameT=temp3.getNameT();
                        }
                    }
                    foreignKey fo = new foreignKey(nameC,nombresPropios,nameT,nomAtri);
                    fore.add(fo);
                }
            }
            Table tabla = new Table();
            tabla.setPrimaryKeys(primary);
            tabla.setForeignKeys(fore);

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
    public Object visitAddConstraintTB(sqlParser.AddConstraintTBContext ctx) {
        return super.visitAddConstraintTB(ctx); //To change body of generated methods, choose Tools | Templates.
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
    
    
    
}
