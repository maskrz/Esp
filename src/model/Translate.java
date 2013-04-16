/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Skrzypek
 */
public class Translate {
    private int id;
    private String polish;
    private String spanish;
    private String type;
    private String note;
    private ArrayList<Category> cl;
    
    public Translate() {
        cl = new ArrayList();
    }
    
    public Translate(int i, String p, String s) {
        id = i;
        polish = p;
        spanish = s;
        cl = new ArrayList();
    }
    
    public Translate(int i, String p, String s, String t, String n) {
        id = i;
        polish = p;
        spanish = s;
        type = t;
        note = n;
        cl = new ArrayList();
    }
    
    @Override
    public String toString() {
        String t = "";
        String n = "";
        if(getType() == null) t = " ";
        else t = " "+ getType() + " ";
        if(getNote() == null) n = " ";
        else n = " "+ getNote() + " ";
        return getId() + " "+getPolish() + " <-> " +t + getSpanish() + n ;
    }
    
    public void addCategory(Category c) {
        cl.add(c);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the polish
     */
    public String getPolish() {
        return polish;
    }

    /**
     * @param polish the polish to set
     */
    public void setPolish(String polish) {
        this.polish = polish;
    }

    /**
     * @return the spanish
     */
    public String getSpanish() {
        return spanish;
    }

    /**
     * @param spanish the spanish to set
     */
    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the cl
     */
    public ArrayList<Category> getCl() {
        return cl;
    }

    /**
     * @param cl the cl to set
     */
    public void setCl(ArrayList<Category> cl) {
        this.cl = cl;
    }
    
}
