/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import model.Category;
import model.Database;
import model.Translate;

/**
 *
 * @author Skrzypek
 */
public class DictionaryController {

    Database db;

    public DictionaryController(Database d) {
        db = d;
    }

    public void sortDictionary(ArrayList<Translate> tl, int i) {
        if (i == 0) {
            Collections.sort(tl, new Comparator<Translate>() {

                public int compare(Translate t1, Translate t2) {
                    return t1.getPolish().compareTo(t2.getPolish());
                }
            });
        }
        if(i == 1) {
             Collections.sort(tl, new Comparator<Translate>() {

                public int compare(Translate t1, Translate t2) {
                    return t1.getSpanish().compareTo(t2.getSpanish());
                }
            });
        }
    }

    public DefaultComboBoxModel createCategoriesModel() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        dcbm.addElement("Wszystkie");
        ArrayList<Category> cl = db.getCl();
         Collections.sort(cl);
        for (Category c : cl) {
            dcbm.addElement(c.getName());
        }
        return dcbm;
    }
//    public DefaultListModel createWordsModel (int index, ArrayList<Translate> tl) {
//        DefaultListModel dlm = new DefaultListModel();
//        if (index == 0) {
//
//            for (Translate t : tl) {
//                dlm.addElement(t.getPolish());
//            }
//        } else {
//            ArrayList<Category> cl = db.getCl();
//            String cat = "" + comboCategories.getSelectedItem();
//            for (Category c : cl) {
//                if (c.getName().equals(cat)) {
//                    ArrayList<Translate> tl = c.getTl();
//                    Collections.sort(tl, new Comparator<Translate>() {
//
//                        public int compare(Translate t1, Translate t2) {
//                            return t1.getPolish().compareTo(t2.getPolish());
//                        }
//                    });
//                    for (Translate t : tl) {
//                        dlm.addElement(t.getPolish());
//                    }
//                    break;
//                }
//            }
//        }
//        return dlm;
//    }
}
