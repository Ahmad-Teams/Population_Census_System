/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.Area;

/**
 *
 * @author ahmed
 */
public class AreaDB {

    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AreaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection("jdbc:sqlite:Population Census System DB.db");
    }

    public static void addArea(Area area) {
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("insert into Area(AreaName,AreaID,StateID) values(?,?,?)");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, area.getAreaName());
            p.setInt(2, area.getAreaID());
            p.setInt(3, area.getStateID());

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static void deleteArea(int areaID) {
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("delete from Area where AreaID = ? ");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, areaID);

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static void updateArea(Area area) {
         try (                                                             
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("UPDATE Area SET AreaName = ?,AreaID = ?,StateID = ? WHERE AreaID= ?");  
                 PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, area.getAreaName());
            p.setInt(2, area.getAreaID());
            p.setInt(3, area.getStateID());

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }
    public ArrayList<Area> getAreas() {
        ArrayList<Area> list = new ArrayList<>();
        try (
                 Connection con = connect(); 
                PreparedStatement p = con.prepareStatement("select * from Area");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of Area table 

                    list.add(new Area(r.getString("AreaName"), r.getInt("AreaID"), r.getInt("StateID")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return list;
    }

}
