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
 * @author William
 */
public class Check {
    ArrayList<Condition> condi;
    String nombreCons;
    String checkString;
    String error; 
    
    public Check(ArrayList<Condition> condi, String nombreCons) {
        this.condi = condi;
        this.nombreCons = nombreCons;
    }

    public ArrayList<Condition> getCondi() {
        return condi;
    }

    public void setCondi(ArrayList<Condition> condi) {
        this.condi = condi;
    }

    public String getNombreCons() {
        return nombreCons;
    }

    public void setNombreCons(String nombreCons) {
        this.nombreCons = nombreCons;
    }

    public String getCheckString() {
        return checkString;
    }

    public void setCheckString(String checkString) {
        this.checkString = checkString;
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
        exp = this.toSimpleString(exp);
        exp = exp.toUpperCase(); 
        Stack<String> stack = new Stack<String>(); 
        int i = 0;
        String seg = ""; 
        int idsFound = 1;
        boolean colFound = false;
        boolean valFound = false; 
        while ( i < exp.length()) {
            String current = (String.valueOf(exp.charAt(i)));
            if (current.equals("(")) {
                if (seg.length() > 0) {
                    postFix.add(seg); 
                    seg = ""; 
                }
                stack.push(current); 
            } else if (current.equals(")")){
                if (seg.length() > 0) {
                    postFix.add(seg); 
                    seg = ""; 
                }
                String pop = ""; 
                while (!pop.equals("(")) { 
                    pop = stack.pop();
                    if (!pop.equals("(")) postFix.add(pop); 
                }
            } else if (current.equals("<")) {
                String next = String.valueOf(exp.charAt(i+1)); 
                
                if ((next.equals("=")||next.equals(">"))) {
                    i++; 
                    current = current.concat(next);
                }
                if (seg.length() > 0) {
                    postFix.add(seg); 
                    seg = ""; 
                }
                
                String top = stack.peek(); 
                int precedenceTop = precedenceMap.get(top);
                int precedenceCurrent = precedenceMap.get(current);
                while (precedenceTop > precedenceCurrent) { 
                    top = stack.pop(); 
                    postFix.add(top);
                    top = stack.peek(); 
                    precedenceTop = precedenceMap.get(top);
                }
                stack.push(current); 
            } else if (current.equals(">")) {
                String next = String.valueOf(exp.charAt(i+1)); 
                
                if (next.equals("=")) {
                    i++; 
                    current = current.concat(next);
                }
                
                if (seg.length() > 0) {
                    postFix.add(seg); 
                    seg = ""; 
                }
                String top = stack.peek(); 
                int precedenceTop = precedenceMap.get(top);
                int precedenceCurrent = precedenceMap.get(current);
                while (precedenceTop > precedenceCurrent) { 
                    top = stack.pop(); 
                    postFix.add(top);
                    top = stack.peek(); 
                    precedenceTop = precedenceMap.get(top);
                }
                stack.push(current);
            } else if (current.equals("=")) {
                if (seg.length() > 0) {
                    postFix.add(seg); 
                    seg = ""; 
                }
                String top = stack.peek(); 
                int precedenceTop = precedenceMap.get(top);
                int precedenceCurrent = precedenceMap.get(current);
                while (precedenceTop > precedenceCurrent) { 
                    top = stack.pop(); 
                    postFix.add(top);
                    top = stack.peek(); 
                    precedenceTop = precedenceMap.get(top);
                }
                stack.push(current);
            } else if (current.equals("A")){
                i++;
                current = current.concat(String.valueOf(exp.charAt(i)));
                i++;
                current = current.concat(String.valueOf(exp.charAt(i)));
                if (seg.length() > 0) {
                    postFix.add(seg); 
                    seg = ""; 
                }
                String top = stack.peek(); 
                int precedenceTop = precedenceMap.get(top);
                int precedenceCurrent = precedenceMap.get(current);
                while (precedenceTop > precedenceCurrent) { 
                    top = stack.pop(); 
                    postFix.add(top);
                    top = stack.peek(); 
                    precedenceTop = precedenceMap.get(top);
                }
                stack.push(current);
            }  else if (current.equals("O")){
                i++;
                current = current.concat(String.valueOf(exp.charAt(i)));
                if (seg.length() > 0) {
                    postFix.add(seg); 
                    seg = ""; 
                }
                String top = stack.peek(); 
                int precedenceTop = precedenceMap.get(top);
                int precedenceCurrent = precedenceMap.get(current);
                while (precedenceTop > precedenceCurrent) { 
                    top = stack.pop(); 
                    postFix.add(top);
                    top = stack.peek(); 
                    precedenceTop = precedenceMap.get(top);
                }
                stack.push(current);
            } else if (current.equals("N")){
                i++;
                current = current.concat(String.valueOf(exp.charAt(i)));
                i++;
                current = current.concat(String.valueOf(exp.charAt(i)));
                if (seg.length() > 0) {
                    postFix.add(seg); 
                    seg = ""; 
                }
                String top = stack.peek(); 
                int precedenceTop = precedenceMap.get(top);
                int precedenceCurrent = precedenceMap.get(current);
                while (precedenceTop > precedenceCurrent) { 
                    top = stack.pop(); 
                    postFix.add(top);
                    top = stack.peek(); 
                    precedenceTop = precedenceMap.get(top);
                }
                stack.push(current);
            } else { 
                seg = seg.concat(current);
            } 
            i++;
        }
        return postFix; 
    }
    
    private String toSimpleString(String exp) { 
        for (int i = 0; i < condi.size(); i++){
            Condition temp = condi.get(i); 
            String symbol = ""; 
            if (temp.isDistinct()) symbol = "<>"; 
            if (temp.isEqual()) symbol = "="; 
            if (temp.isMinValue()) symbol = ">"; 
            if (temp.isMinValueInc()) symbol= ">="; 
            if (temp.isMaxValue()) symbol= "<" ; 
            if (temp.isMaxValueInc()) symbol= "<=" ;
            
            String tempExp = temp.getColumn()+symbol+temp.getValue();
            exp = exp.replace(tempExp, String.valueOf(temp.getId()));
        }
        return exp; 
    }
    private Condition getConditionById(int id) {
        Condition cond = new Condition(); 
        boolean found = false;
        int i = 0; 
        while (!found && (i < condi.size())) { 
            cond = condi.get(i);
            found = (cond.getId() == id); 
            i++;
        }
        return cond; 
    }
    
    public static void main(String[] args) {
        Condition temp1 = new Condition();
        temp1.setId(1);
        temp1.setColumn("ID1");
        temp1.setEqual(true);
        temp1.setValue("50");
        
        Condition temp2 = new Condition();
        temp2.setId(2);
        temp2.setColumn("ID2");
        temp2.setMaxValue(true);
        temp2.setValue("5");
        
        Condition temp3 = new Condition();
        temp3.setId(3);
        temp3.setColumn("ID3");
        temp3.setMinValue(true);
        temp3.setValue("10");
        
        
        
        ArrayList<Condition> t = new ArrayList<>();
        t.add(temp1);
        t.add(temp2);
        t.add(temp3);
        
        Check chk = new Check(t,"name"); 
        String exp = "(((ID1=50)AND(ID2<5))or(ID3>10))"; 
        System.out.println(chk.toSimpleString(exp));
        ArrayList<String> post = chk.InfixToPostfix(exp);
        System.out.println(post.toString());
        
    }
    
}
