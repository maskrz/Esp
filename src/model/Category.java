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
public class Category implements Comparable {

    private int id;
    private String name;
    private ArrayList<Translate> tl;

    public Category(int i, String n) {
        id = i;
        name = n;
        tl = new ArrayList();
    }

    Category() {
        tl = new ArrayList();
    }
    
    public void addTranslate(Translate t) {
        tl.add(t);
    }

    @Override
    public String toString() {
        return getName();
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Category)) {
            throw new ClassCastException("Invalid object");
        }

        String oName = ((Category) o).getName();

        return this.name.compareTo(oName);
    }

    /**
     * @return the tl
     */
    public ArrayList<Translate> getTl() {
        return tl;
    }

    /**
     * @param tl the tl to set
     */
    public void setTl(ArrayList<Translate> tl) {
        this.tl = tl;
    }
    
}
