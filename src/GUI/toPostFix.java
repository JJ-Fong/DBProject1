/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
            seg = seg.concat(String.valueOf(exp.charAt(i)));
            if (seg.)
            i++; 
        }
        return postFix; 
    }
}
