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
public class Database {
    private ArrayList<Translate> tl;
    private ArrayList<Category> cl;
    
    public Database() {
        tl = new ArrayList();
        cl = new ArrayList();
    }
    
    public void fillDatabase() throws ClassNotFoundException {
        DBActionHelper dbah = new DBActionHelper();
        dbah.fillDB(this);
    }
    
    public void addCategory(Category c) {
        cl.add(c);
    }
    
    public void addTranslate(Translate t) {
        tl.add(t);
    }
    
    public Translate getTranslateS(String w) {
        for(Translate t : tl) {
            if(t.getPolish().equals(w)) return t;
        }
        return null;
    }
    
    public Translate getTranslateP(String w) {
        for(Translate t : tl) {
            if(t.getSpanish().equals(w)) return t;
        }
        return null;
    }
    
    public Translate getTranslateWithId(int id) {
        for(Translate t : tl) {
            if(t.getId() == id) return t;
        }
        return null;
    }
    
    public Category getCategoryWithId(int id) {
        for(Category c : cl) {
            if(c.getId() == id) return c;
        }
        return null;
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

    public Category getCategoryWithName(String cat) {
        for(Category c : cl) {
            if(c.getName().equals(cat)) return c;
        }
        return null;
    }
    
}
