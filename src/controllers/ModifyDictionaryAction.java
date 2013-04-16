/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gui.ModifyDictionary;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import model.Category;
import model.DBActionHelper;
import model.Database;
import model.Translate;

/**
 *
 * @author Skrzypek
 */
public class ModifyDictionaryAction {
    ModifyDictionary md;
    private Database db;
    DBActionHelper dbah;
    
    public ModifyDictionaryAction(Database db) {
        md = new ModifyDictionary(this);
        this.db = db;
        dbah = new DBActionHelper();
    }
    
    public void newWord() {
        md.setVisible(true);
        md.listCategories.setModel(createCategoriesModel());
        
    }
    
    public DefaultListModel createCategoriesModel() {
        DefaultListModel dlm = new DefaultListModel();
        ArrayList<Category> cl = getDb().getCl();
         Collections.sort(cl);
        for (Category c : cl) {
            dlm.addElement(c.getName());
        }
        return dlm;
    }

    public boolean categoryExists(String newCat) {
        ArrayList<Category> cl = getDb().getCl();
        for(Category c: cl) {
            if(c.getName().equals(newCat)) return true;
        }
        return false;
    }

    public void addCategoryToDB(String newCat) throws ClassNotFoundException {
        dbah.addCategory(newCat);
        int id = dbah.getCategoryId(newCat);
        db.addCategory(new Category(id, newCat));
        md.listCategories.setModel(createCategoriesModel());
    }

    public boolean transalteExists(Translate t) {
        ArrayList<Translate> tl = getDb().getTl();
        for(Translate tr: tl) {
            if(tr.getPolish().equals(t.getPolish())) return true;
            if(tr.getSpanish().equals(t.getSpanish())) return true;
        }
        return false;
    }

    public void addTranslateToDB(Translate t) throws ClassNotFoundException {
        dbah.addTranslate(t);
        getDb().addTranslate(t);
        md.listCategories.setModel(createCategoriesModel());
    }

    /**
     * @return the db
     */
    public Database getDb() {
        return db;
    }
    
}
