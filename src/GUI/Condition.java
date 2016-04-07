/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author mariobsdd
 */
public class Condition {
    String nomeCons;
    private int id;
    private String column;
    private boolean maxValue=false;
    private boolean maxValueInc=false;
    private boolean minValue=false;
    private boolean minValueInc=false;
    private boolean distinct=false;
    private boolean equal=false;
    private String valueType; 
    private String value;



    public Condition() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public boolean isMaxValue() {
        return maxValue;
    }

    public void setMaxValue(boolean maxValue) {
        this.maxValue = maxValue;
    }

    public boolean isMaxValueInc() {
        return maxValueInc;
    }

    public void setMaxValueInc(boolean maxValueInc) {
        this.maxValueInc = maxValueInc;
    }

    public boolean isMinValue() {
        return minValue;
    }

    public void setMinValue(boolean minValue) {
        this.minValue = minValue;
    }

    public boolean isMinValueInc() {
        return minValueInc;
    }

    public void setMinValueInc(boolean minValueInc) {
        this.minValueInc = minValueInc;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isEqual() {
        return equal;
    }

    public void setEqual(boolean equal) {
        this.equal = equal;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNomeCons() {
        return nomeCons;
    }

    public void setNomeCons(String nomeCons) {
        this.nomeCons = nomeCons;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }
}
