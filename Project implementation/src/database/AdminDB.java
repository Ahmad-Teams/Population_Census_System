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
import project.State;

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
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("insert into Officer(StateName,Phone,Email,Name,AreaName,Sex,Username,Password,AID) values(?,?,?,?,?,?,?,?,?)");
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, officer.getState().getStateName());
            p.setInt(2, officer.getPhone());
            p.setString(3, officer.getEmail());
            p.setString(4, officer.getName());
            p.setString(5, officer.getArea().getAreaName());
            p.setString(6, officer.getSex());
            p.setString(7, officer.getUsername());
            p.setString(8, officer.getPassword());
            p.setInt(9, officer.getAID());
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }
    }
     
    

    public static void deleteOfficer(int OID) {
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("delete from Officer where OID = ? ");
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, OID);

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }
        }
    

    public static void updateOfficer(int OID, String name, String StateName, int Phone, String Username,
            String Password, String AreaName,String Email,String Sex,int AID) {
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("UPDATE Officer SET name = ?, StateName = ?, Phone = ?, Username = ?,password = ?, AreaName = ?, Email = ?, Sex = ?,AID = ? WHERE OID = ?");
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, name);
            p.setString(2, StateName);
            p.setInt(3, Phone);
            p.setString(4, Username);
            p.setString(5, Password);
            p.setString(6, AreaName);
            p.setString(7, Email);
            p.setString(8, Sex);
            p.setInt(9, AID);

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }
//(int OID, String name, String StateName, int Phone, String Username,
          //  String Password, String AreaName,String Email,String Sex,int AID)
    public ArrayList<Officer> getOfficers() {
        ArrayList<Officer> list = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from Officer");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {
                   
                        list.add(new Officer(r.getInt("OID"), r.getString("name"),new State(r.getString("StateName")),r.getInt("Phone") ,r.getString("Username"), r.getString("Password"),r.getString("AreaName"),r.getString("Email") ,r.getString("Sex"),r.getInt("AID")));
                   
                    
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
}
