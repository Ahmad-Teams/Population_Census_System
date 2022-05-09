/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.database;

import static Model.database.AdminDB.connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.project.CorrectionRequest;
import Model.project.Member;
import Model.project.Observer;
import Model.project.UserRequest;

/**
 *
 * @author PC
 */
public class UserDB implements Observer {

    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection("jdbc:sqlite:Population Census System DB.db");
    }

    public static void addMember(Member member) {
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("insert into Member(Address,Education,Phone,Email,DOB,Name,AreaID,Sex,Occupation,UID) values(?,?,?,?,?,?,?,?,?,?)");
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, member.getAddress());
            p.setString(2, member.getEducation());
            p.setString(3, member.getPhone());
            p.setString(4, member.getEmail());
            p.setString(5, member.getDOB());
            p.setString(6, member.getName());
            p.setInt(7, member.getAreaID());
            p.setString(8, member.getSex());
            p.setString(9, member.getOccupation());
            p.setInt(10, member.getUID());
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static void deleteMember(int MID) {
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("delete from Member where MID = ? ");
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, MID);

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }
//(Address,City,Education,Phone,Email,DOB,Name,AreaID,Sex,Occupation,UID,DocName,ImageName)

    public static void updateMember(Member member) {
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("UPDATE Member SET Address = ?,Education = ?,Phone = ? ,Email = ?,DOB = ?,Name = ?,AreaID = ?,Sex = ?,Occupation = ?,UID = ? WHERE MID= ?");
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, member.getAddress());
            p.setString(2, member.getEducation());
            p.setString(3, member.getPhone());
            p.setString(4, member.getEmail());
            p.setString(5, member.getDOB());
            p.setString(6, member.getName());
            p.setInt(7, member.getAreaID());
            p.setString(8, member.getSex());
            p.setString(9, member.getOccupation());
            p.setInt(10, member.getUID());
            p.setInt(11, member.getMID());
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static ArrayList<Member> getMembers(int userID) {
        ArrayList<Member> members = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from Member where UID = " + userID);) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of Area table 
                    members.add(new Member(r.getInt("MID"), r.getInt("UID"), r.getString("Address"), r.getString("Education"), r.getString("Email"), r.getString("Sex"), r.getString("Occupation"), r.getString("DOB"), r.getInt("AreaID"), r.getString("Name"), r.getString("Phone")));
                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return members;
    }

    public static int getNewIDForMember(){
        int memberID=0;
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("select seq from sqlite_sequence where name = \"Member\"");) {
            ResultSet r = p.executeQuery();
            while (r.next()) {
                memberID = r.getInt("seq");
            }

        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return memberID + 1;
    }
    
    // where is delete and update UserRequest ???????
    public static void addUserRequest(UserRequest userRequest) {
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("insert into UserRequest(RequestState,Name,Address,Education,Phone,Email,MID,DOB,AreaID,Sex,Occupation,UID) values(?,?,?,?,?,?,?,?,?,?,?,?)");
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, userRequest.getRequestState());
            p.setString(2, userRequest.getName());
            p.setString(3, userRequest.getAddress());
            p.setString(4, userRequest.getEducation());
            p.setString(5, userRequest.getPhone());
            p.setString(6, userRequest.getEmail());
            p.setInt(7, getNewIDForMember());
            p.setString(8, userRequest.getDOB());
            p.setInt(9, userRequest.getAreaID());
            p.setString(10, userRequest.getSex());
            p.setString(11, userRequest.getOccupation());
            p.setInt(12, userRequest.getUID());
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static void updateUserRequest(UserRequest userRequest) {
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("UPDATE UserRequest SET RequestState = ?,Address = ?,Education = ?,Phone = ?,Email = ?,MID = ?,DOB = ?,AreaID = ?,Sex = ?,Occupation = ?,UID = ?");
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, userRequest.getRequestState());
            p.setString(2, userRequest.getAddress());
            p.setString(3, userRequest.getEducation());
            p.setString(4, userRequest.getPhone());
            p.setString(5, userRequest.getEmail());
            p.setString(6, userRequest.getDOB());
            p.setInt(7, userRequest.getMID());
            p.setInt(8, userRequest.getAreaID());
            p.setString(9, userRequest.getSex());
            p.setString(10, userRequest.getOccupation());
            p.setInt(11, userRequest.getUID());

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static void deleteUserRequest(int requestID) {
        try (
                Connection con = connect();
                PreparedStatement p1 = con.prepareStatement("delete from UserRequest where requestID = ? ");) {
            p1.setInt(1, requestID);
            p1.execute();

        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static ArrayList<UserRequest> getUserRequests() {
        ArrayList<UserRequest> userRequests = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from UserRequest");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of Area table 
                    userRequests.add(new UserRequest(r.getInt("RequestID"), r.getString("RequestState"), r.getString("Name"),r.getString("Address"), r.getString("Education"), r.getString("Phone"), r.getString("Email"), r.getInt("MID"), r.getString("DOB"), r.getInt("AreaID"), r.getString("Sex"), r.getString("Occupation"), r.getInt("UID")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return userRequests;

    }

    public static ArrayList<CorrectionRequest> getCorrectionRequests() {
        ArrayList<CorrectionRequest> correctionRequests = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from CorrectionRequest");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    correctionRequests.add(new CorrectionRequest(r.getInt("RequestID"), r.getInt("UserRequestID"), r.getString("RequestTitle"), r.getString("RequestContent"), r.getInt("UID"), r.getInt("OID")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return correctionRequests;

    }

    public static int getAreaIDFromUserID(int userID) {
        int areaID=0;
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("select AreaID from User where UID = ?");) {
            p.setInt(1, userID);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                areaID = r.getInt("AreaID");
            }

        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return areaID;
    }
    
    public static boolean check(String username, String password) {

        return OfficerDB.check(username, password);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
