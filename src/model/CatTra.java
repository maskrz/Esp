/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Skrzypek
 */
public class CatTra {
    private int id;
    private Category category;
    private Translate translate;
    
    public CatTra(int i1, Category i2, Translate i3) {
        id = i1;
        category = i2;
        translate = i3;
    }
    
    @Override
    public String toString() {
        return "" + id + " "+ category + " "+ translate;
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
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the translate
     */
    public Translate getTranslate() {
        return translate;
    }

    /**
     * @param translate the translate to set
     */
    public void setTranslate(Translate translate) {
        this.translate = translate;
    }   
    
}
