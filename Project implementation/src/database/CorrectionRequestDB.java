/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import project.CorrectionRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import project.CorrectionRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ahmed
 */
public class CorrectionRequestDB {
    
    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CorrectionRequestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection("jdbc:sqlite:Population Census System DB.db");
    }

    public static void addCorrectionRequest(CorrectionRequest cRequest) {
        try (
                 Connection con = connect();
                PreparedStatement p = con.prepareStatement("insert into CorrectionRequest(UserRequestID,RequestTitle,RequestContent,UID,OID) values(?,?,?,?,?)");
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, cRequest.getUserRequestID());
            p.setString(2, cRequest.getRequestTitle());
            p.setString(3, cRequest.getRequestContent());
            p.setInt(4, cRequest.getUID());
            p.setInt(5, cRequest.getOID());

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static void deleteCorrectionRequest(int requestID) {
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("delete from CorrectionRequest where requestID = ? "); 
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, requestID);

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static void updateCorrectionRequest(CorrectionRequest cRequest) {
         try (
                 Connection con = connect();
                PreparedStatement p = con.prepareStatement("UPDATE CorrectionRequest SET UserRequestID = ?,RequestTitle = ?,RequestContent = ?,UID = ?,OID = ? WHERE RequestID = ?");
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, cRequest.getUserRequestID());
            p.setString(2, cRequest.getRequestTitle());
            p.setString(3, cRequest.getRequestContent());
            p.setInt(4, cRequest.getUID());
            p.setInt(5, cRequest.getOID());

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }
     public ArrayList<CorrectionRequest> getCorrectionRequests() {
        ArrayList<CorrectionRequest> list = new ArrayList<>();
        try (
                 Connection con = connect(); 
                PreparedStatement p = con.prepareStatement("select * from CorrectionRequest");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of Area table 

                    list.add(new CorrectionRequest(r.getInt("RequestID"), r.getInt("UserRequestID"), r.getString("RequestTitle"),r.getString("RequestContent"),r.getInt("UID"),r.getInt("OID")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return list;
    }
    
}
