package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.FamilyMember;
import project.Officer;

public class AdminDB {

    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection("jdbc:sqlite:Population Census System DB.db");
    }

    public static void addOfficer(Officer officer) {
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("insert into Officer(Phone,Email,Name,AreaID,Sex,Username,Password,AID,imageName) values(?,?,?,?,?,?,?,?,?)");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, officer.getPhone());
            p.setString(2, officer.getEmail());
            p.setString(3, officer.getName());
            p.setInt(4, officer.getAreaID());
            p.setString(5, officer.getSex());
            p.setString(6, officer.getUsername());
            p.setString(7, officer.getPassword());
            p.setInt(8, officer.getAID());
            p.setString(9, officer.getImageName());
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }
    }

    public static void deleteOfficer(int OID) {
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("delete from Officer where OID = ? ");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, OID);

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }
    }
           
    public static void updateOfficer(Officer officer) {
       try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("UPDATE Officer SET Phone = ?,Email = ?,Name = ?,AreaID = ?,Sex = ?,Username = ?,Password = ?,AID = ?,imageName = ? WHERE OID = ?"); 
                 PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, officer.getPhone());
            p.setString(2, officer.getEmail());
            p.setString(3, officer.getName());
            p.setInt(4, officer.getAreaID());
            p.setString(5, officer.getSex());
            p.setString(6, officer.getUsername());
            p.setString(7, officer.getPassword());
            p.setInt(8, officer.getAID());
            p.setString(9, officer.getImageName());
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public ArrayList<Officer> getOfficers() {
        ArrayList<Officer> list = new ArrayList<>();
        try (
                 Connection con = connect(); 
                PreparedStatement p = con.prepareStatement("select * from Officer");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of officer table 

                    list.add(new Officer(r.getInt("Phone"), r.getString("Email"), r.getInt("OID"), r.getString("Name"), r.getInt("AreaID"), r.getString("Sex"), r.getString("Username"), r.getString("Password"), r.getInt("AID"), r.getString("imageName")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return new ArrayList<Officer>();
    }

    public ArrayList<FamilyMember> getFamilyMembers() {
        
        return new ArrayList<FamilyMember>();
    }

    public static boolean check(String username, String password) {
        return OfficerDB.check(username, password);
    }

    public static void getObservers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
