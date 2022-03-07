package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.Area;
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
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("insert into Officer(Phone,Email,Name,AreaID,Sex,Username,Password,AID,ImageName) values(?,?,?,?,?,?,?,?,?)");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
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
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("UPDATE Officer SET Phone = ?,Email = ?,Name = ?,AreaID = ?,Sex = ?,Username = ?,Password = ?,AID = ?,ImageName = ? WHERE OID = ?");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
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
        ArrayList<Officer> officers = new ArrayList<>();
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("select * from Officer");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of officer table 

                    officers.add(new Officer(r.getInt("Phone"), r.getString("Email"), r.getInt("OID"), r.getString("Name"), r.getInt("AreaID"), r.getString("Sex"), r.getString("Username"), r.getString("Password"), r.getInt("AID"), r.getString("imageName")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return officers;
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
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("UPDATE Area SET AreaName = ?,AreaID = ?,StateID = ? WHERE AreaID= ?");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
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
        ArrayList<Area> areas = new ArrayList<>();
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("select * from Area");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of Area table 

                    areas.add(new Area(r.getString("AreaName"), r.getInt("AreaID"), r.getInt("StateID")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return areas;
    }

    public static void addState(State state) {
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("insert into State(StateName) values(?)");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, state.getStateName());

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static void deleteState(int StateID) {
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("delete from State where StateID = ? ");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, StateID);

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static void updateState(State state) {
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("UPDATE State SET StateName = ? WHERE StateID = ?");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, state.getStateName());
            p.setInt(2, state.getStateID());

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public ArrayList<State> getStates(State state) {
        ArrayList<State> states = new ArrayList<>();
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("select * from State");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of State table 

                    states.add(new State(r.getInt("StateID"), r.getString("StateName")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return states;

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
