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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Javier Fong
 */
public class toPostFix {
    
    public toPostFix(){
    } 
    
    private static final Map<String, Integer> precedenceMap;
    static {
        Map<String, Integer> map = new HashMap<String, Integer>(); 
        map.put("(", 1);
        map.put(")", 1);
        map.put("AND", 2);
        map.put("OR", 2);
        map.put("<", 3); 
        map.put("<=", 3); 
        map.put(">", 3); 
        map.put(">=", 3); 
        map.put("<>", 3); 
        map.put("=", 3); 
        map.put("NOT", 4); 
        precedenceMap = Collections.unmodifiableMap(map);
    }
    
    private static Integer getPrecedence(String s){
        Integer precedence = precedenceMap.get(s);
        return precedence == null ? 5 : precedence; 
    }
    
    public ArrayList<String> InfixToPostfix(String exp) { 
        ArrayList<String> postFix = new ArrayList<>(); 
        exp = exp.toUpperCase(); 
        Stack<String> stack = new Stack<String>(); 
        int i = 0;
        String seg = ""; 
        while ( i < exp.length()) {
            String current = (String.valueOf(exp.charAt(i)));
            if (current.equals("(")) {
                
            } else if (current.equals(")")){
                
            } else if (current.equals("<")) {
                
            } else if (current.equals(">")) {
                
            } else if (current.equals("=")) {
                
            } else {
                seg = seg.concat(current); 
                if (seg.endsWith("AND")) { 
                    
                } else if (seg.endsWith("OR")) { 
                    
                } else if (seg.endsWith("NOT")) { 
                    
                } 
            } 
        }
        return postFix; 
    }
}
