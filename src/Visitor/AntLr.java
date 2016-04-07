/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import java.util.Arrays;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

/**
 *
 * @author William
 */
public class AntLr {
    String progra;
    String msg;
    VisitorSql semantico;
    public AntLr(String progra) {
        this.progra = progra;
        msg = "";
    }

    public AntLr(){
        semantico = new VisitorSql();
    }; 
    
    public String getProgra() {
        return progra;
    }

    public void setProgra(String progra) {
        this.progra = progra;
    }
    
    public TreeViewer Lexer_Parser(){
        
           /* ***************************************************
            ******************************************************
            ******************COMIENZA EL LEXER*******************
            ******************************************************
            ******************************************************
            */
        CharStream input = new ANTLRInputStream(progra);
        sqlLexer lexer = new sqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
            /* ***************************************************
            ******************************************************
            *****************COMIENZA EL PARSER*******************
            ******************************************************
            ******************************************************
            */
        sqlParser parser = new sqlParser(tokens);
        parser.removeErrorListeners();
        DescriptiveErrorListener errorListener = new DescriptiveErrorListener();
        parser.addErrorListener(errorListener);
        
        
        
        /*Comienza el recorrido del arbol 
          y muestro el arbol que se genera*/
        ParseTree tree = parser.todo();
        if (errorListener.isEmpty()) { 
            semantico.visit(tree);
        }
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
        viewer.setScale(1.5);
        msg = semantico.toString(); 

        return viewer;
    }
    
    public String toString() { 
        return msg;
    }
}
