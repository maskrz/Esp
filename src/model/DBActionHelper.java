/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Skrzypek
 */
public class DBActionHelper {

    void fillDB(Database db) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:dictionary.sqlite");
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from Categories");
            while (rs.next()) {
                int id = rs.getInt("idC");
                String name = rs.getString("name");
                Category c = new Category(id, name);                
                db.addCategory(c);         
            }
            rs = stat.executeQuery("select * from Translates ");
            while (rs.next()) {
                int idT = rs.getInt("idT");
                String polish = rs.getString("polish");
                String spanish = rs.getString("spanish");
                String type = rs.getString("type");
                String note = rs.getString("note");
                Translate t = new Translate(idT, polish, spanish, type, note);
                db.addTranslate(t);
            }
            rs = stat.executeQuery("select * from CatTra");
             while (rs.next()) {
                    int idT = rs.getInt("idT");
                    int idC = rs.getInt("idC");
                    Category c = db.getCategoryWithId(idC);
                    Translate t = db.getTranslateWithId(idT);
                    c.addTranslate(t);
                    t.addCategory(c);
                }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBActionHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addCategory(String newCat) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:dictionary.sqlite");
            PreparedStatement stat = conn.prepareStatement("insert into Categories values(null, ?)");
            stat.setString(1, newCat);
            stat.executeUpdate();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBActionHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getCategoryId(String cat) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        int res = 0;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:dictionary.sqlite");
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from categories where name = '"+cat+"'");
            res = rs.getInt("idC");

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBActionHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public int getTranslateId(String tra) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        int res = 0;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:dictionary.sqlite");
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from translates where polish = '"+tra+"'");
            res = rs.getInt("idT");

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBActionHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public void addTranslate(Translate t) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:dictionary.sqlite");
            PreparedStatement stat = conn.prepareStatement("insert into Translates values(null, ?, ?, ?, ?)");
            stat.setString(1, t.getPolish());
            stat.setString(2, t.getSpanish());
            String st = (t.getType().equals(""))? null : t.getType();
            stat.setString(3, st);
            String sn = (t.getNote().equals(""))? null : t.getNote();
            stat.setString(4, sn);
            stat.executeUpdate();
            int idT = getTranslateId(t.getPolish());
            for(Category c : t.getCl()){
                stat = conn.prepareStatement("insert into CatTra values(null, ?, ?)");
                stat.setInt(1, c.getId());
                stat.setInt(2, idT);
                stat.executeUpdate();
            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBActionHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
