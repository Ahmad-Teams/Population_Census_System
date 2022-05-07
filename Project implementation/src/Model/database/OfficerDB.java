package Model.database;

import static Model.database.AdminDB.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.project.CorrectionRequest;
import Model.project.FamilyMember;
import Model.project.Member;
import Model.project.Officer;
import Model.project.System_user;
import Model.project.User;
import Model.project.UserRequest;

public class OfficerDB {

    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OfficerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection("jdbc:sqlite:Population Census System DB.db");
    }

    public static void addCorrectionRequest(CorrectionRequest cRequest) {
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("insert into CorrectionRequest(UserRequestID,RequestTitle,RequestContent,UID,OID) values(?,?,?,?,?)"); PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
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
                Connection con = connect(); PreparedStatement p = con.prepareStatement("delete from CorrectionRequest where requestID = ? "); PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, requestID);

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static void updateCorrectionRequest(CorrectionRequest cRequest) {
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("UPDATE CorrectionRequest SET RequestTitle = ?,RequestContent = ?,UID = ?,OID = ? WHERE RequestID = ?"); PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, cRequest.getRequestTitle());
            p.setString(2, cRequest.getRequestContent());
            p.setInt(3, cRequest.getUID());
            p.setInt(4, cRequest.getOID());
            p.setInt(5, cRequest.getUserRequestID());

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static ArrayList<User> getUsersByParameters(boolean hasDependenciesOrHasUsers, String SortByOption, boolean ascendingOrder) {
        ArrayList<User> Users = new ArrayList<>();
        String inOrNotIn = hasDependenciesOrHasUsers ? "IN" : "NOT IN";
        String ASCOrDESC = ascendingOrder ? "ASC" : "DESC";

        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("SELECT * FROM User WHERE UID " + inOrNotIn + "(SELECT UID FROM Member) ORDER BY " + SortByOption +"  "+ ASCOrDESC);) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of officer table 

                    Users.add(new User(r.getInt("UID"), r.getString("City"), r.getString("Address"), r.getString("Education"), r.getString("Email"), r.getString("Sex"), r.getString("Occupation"), r.getString("DOB"), r.getInt("AreaID"), r.getString("Name"), r.getString("Phone")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return Users;
    }

    public ArrayList<CorrectionRequest> getCorrectionRequests() {
        ArrayList<CorrectionRequest> CorrectionRequests = new ArrayList<>();
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("select * from CorrectionRequest");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of Area table 

                    CorrectionRequests.add(new CorrectionRequest(r.getInt("RequestID"), r.getInt("UserRequestID"), r.getString("RequestTitle"), r.getString("RequestContent"), r.getInt("UID"), r.getInt("OID")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return CorrectionRequests;
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> Users = new ArrayList<>();
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("select * from User");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of Area table 

                    Users.add(new User(r.getInt("UID"), r.getString("City"), r.getString("Address"), r.getString("Education"), r.getString("Email"), r.getString("Sex"), r.getString("Occupation"), r.getString("DOB"), r.getInt("AreaID"), r.getString("Name"), r.getString("Phone")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return Users;
    }

    public static ArrayList<System_user> getSystemUsers() {
        ArrayList<System_user> systemUsers = new ArrayList<>();
        try (
                Connection con = connect(); PreparedStatement p = con.prepareStatement("SELECT Username,Password,AID\n"
                        + "FROM Admin\n");
                PreparedStatement p1 = con.prepareStatement("SELECT Username,Password,UID\n"
                        + "FROM User\n");
                PreparedStatement p2 = con.prepareStatement("SELECT Username,Password,OID\n"
                        + "FROM Officer\n");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {

                    systemUsers.add(new System_user(r.getString("Username"), r.getString("Password"), "Admin", r.getInt("AID")));

                }
                r.close();
                ResultSet r1 = p1.executeQuery();
                while (r1.next()) {

                    systemUsers.add(new System_user(r1.getString("Username"), r1.getString("Password"), "User", r1.getInt("UID")));

                }
                r1.close();
                ResultSet r2 = p2.executeQuery();
                while (r2.next()) {

                    systemUsers.add(new System_user(r2.getString("Username"), r2.getString("Password"), "Officer", r2.getInt("OID")));

                }
                r2.close();
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return systemUsers;

    }

    public static ArrayList<FamilyMember> getFamilyMembers(int OID) {
        ArrayList<FamilyMember> FamilyMembers = new ArrayList<>();
        try ( //(String city, String address, String education, String email, String sex, String occupation, String DocName, Date DOB, int areaID, String name, int phone, String imageName, String Email
                Connection con = connect(); PreparedStatement p = con.prepareStatement("SELECT *\n"
                        + "FROM User\n"
                        + "WHERE User.OID=" + OID);
                PreparedStatement p1 = con.prepareStatement("SELECT *\n"
                        + "FROM Member,User\n"
                        + "WHERE Member.UID=User.UID AND User.OID=" + OID);) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    FamilyMembers.add(new User(r.getInt("UID"), r.getString("City"), r.getString("Address"), r.getString("Education"), r.getString("Email"), r.getString("Sex"), r.getString("Occupation"), r.getString("DOB"), r.getInt("AreaID"), r.getString("Name"), r.getString("Phone")));

                }
                ResultSet r2 = p1.executeQuery();
                while (r2.next()) {

                    FamilyMembers.add(new Member(r2.getString("Address"), r2.getString("City"), r2.getString("Education"), r2.getString("Phone"), r2.getString("Email"), r2.getInt("MID"), r2.getString("DOB"), r2.getString("Name"), r2.getInt("AreaID"), r2.getString("Sex"), r2.getString("Occupation"), r2.getInt("UID")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return FamilyMembers;

    }

    public static boolean check(String username, String password) {
        ArrayList<System_user> users = OfficerDB.getSystemUsers();
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<UserRequest> getUserRequests(int OID) {
        ArrayList<UserRequest> userRequests = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from UserRequest,User,Officer\n"
                        + "WHERE UserRequest.UID=User.UID AND User.OID=" + OID);) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    userRequests.add(new UserRequest(r.getInt("RequestID"), r.getString("RequestState"), r.getString("Address"), r.getString("City"), r.getString("Education"), r.getString("Phone"), r.getString("Email"), r.getInt("MID"), r.getString("DOB"), r.getInt("AreaID"), r.getString("Sex"), r.getString("Occupation"), r.getInt("UID")));

                }
                r.close();
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }

        return userRequests;

    }

}
