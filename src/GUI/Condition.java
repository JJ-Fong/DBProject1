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
    
    private String id;
    private String column;
    private boolean maxValue;
    private boolean maxValueInc;
    private boolean minValue;
    private boolean minValueInc;
    private boolean distinct;
    private boolean equal;
    private String value;

    public Condition(String id, String column, boolean maxValue, boolean maxValueInc, boolean minValue, boolean minValueInc, boolean distinct, boolean equal, String value) {
        this.id = id;
        this.column = column;
        this.maxValue = maxValue;
        this.maxValueInc = maxValueInc;
        this.minValue = minValue;
        this.minValueInc = minValueInc;
        this.distinct = distinct;
        this.equal = equal;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    
    
    
}
