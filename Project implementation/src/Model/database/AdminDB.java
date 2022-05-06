package Model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.project.Area;
import Model.project.FamilyMember;
import Model.project.Officer;
import Model.project.State;

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
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("insert into Officer(Phone,Email,Name,AreaID,Sex,Username,Password,AID) values(?,?,?,?,?,?,?,?)");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, officer.getPhone());
            p.setString(2, officer.getEmail());
            p.setString(3, officer.getName());
            p.setInt(4, officer.getAreaID());
            p.setString(5, officer.getSex());
            p.setString(6, officer.getUsername());
            p.setString(7, officer.getPassword());
            p.setInt(8, officer.getAID());
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
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("UPDATE Officer SET Phone = ?,Email = ?,Name = ?,AreaID = ?,Sex = ?,Username = ?,Password = ?,AID = ? WHERE OID = ?");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, officer.getPhone());
            p.setString(2, officer.getEmail());
            p.setString(3, officer.getName());
            p.setInt(4, officer.getAreaID());
            p.setString(5, officer.getSex());
            p.setString(6, officer.getUsername());
            p.setString(7, officer.getPassword());
            p.setInt(8, officer.getAID());
            p.setInt(9, officer.getOID());
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static ArrayList<Officer> getOfficers() {
        ArrayList<Officer> officers = new ArrayList<>();
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("select * from Officer");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of officer table 

                    officers.add(new Officer(r.getString("Phone"), r.getString("Email"), r.getInt("OID"), r.getString("Name"), r.getInt("AreaID"), r.getString("Sex"), r.getString("Username"), r.getString("Password"), r.getInt("AID")));

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
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("UPDATE Area SET AreaName = ?,StateID = ? WHERE AreaID= ?");  PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, area.getAreaName());
            p.setInt(2, area.getStateID());
            p.setInt(3, area.getAreaID());
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static ArrayList<Area> getAreas() {
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

    public static int getAreaID(String areaName) {
        int areaID =0;
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("select AreaID from Area where AreaName = ?");
                
                ) {
                p.setString(1, areaName);
                ResultSet r = p.executeQuery();
                while (r.next()) {      
                    areaID= r.getInt("AreaID");
                }
            
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return areaID;
    }
    
    public static String getAreaName(int areaID) {
        String areaName ="";
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("select AreaName from Area where AreaID = ?");
                
                ) {
                p.setInt(1, areaID);
                ResultSet r = p.executeQuery();
                while (r.next()) {      
                    areaName= r.getString("AreaName");
                }
            
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return areaName;
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

    public static ArrayList<State> getStates() {
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

    public static ArrayList<FamilyMember> getFamilyMembers() {

        ArrayList<FamilyMember> FamilyMembers = new ArrayList<>();
        try ( //(String city, String address, String education, String email, String sex, String occupation, String DocName, Date DOB, int areaID, String name, int phone, String imageName, String Email
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("SELECT User.City,User.Adderss,User.Education,User.Email,User.Sex,User.Occupation,User.DOB,User.AreaID,User.Name,User.Phone\n"
                        + "FROM User,Area,Admin\n"
                        + "WHERE User.AreaID=Area.AreaID AND Area.StateID=Admin.StateID"); PreparedStatement p1 = con.prepareStatement("SELECT Member.City,Member.Adderss,Member.Education,Member.Email,Member.Sex,Member.Occupation,Member.DOB,Member.AreaID,Member.Name,Member.Phone\n"
                        + "FROM Member,Area,Admin\n"
                        + "WHERE Member.AreaID=Area.AreaID AND Area.StateID=Admin.StateID");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {       

                    FamilyMembers.add(new FamilyMember(r.getString("City"), r.getString("Adderss"), r.getString("Education"), r.getString("Email"), r.getString("Sex"), r.getString("Occupation"), r.getString("DOB"), r.getInt("AreaID"), r.getString("Name"), r.getString("Phone")));

                }
                ResultSet r2 = p1.executeQuery();
                while (r2.next()) {     

                    FamilyMembers.add(new FamilyMember(r2.getString("City"), r2.getString("Adderss"), r2.getString("Education"), r2.getString("Email"), r2.getString("Sex"), r2.getString("Occupation"), r2.getString("DOB"), r2.getInt("AreaID"), r2.getString("Name"), r2.getString("Phone")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return FamilyMembers;

    }

    public static boolean check(String username, String password) {
        return OfficerDB.check(username, password);
    }

}
