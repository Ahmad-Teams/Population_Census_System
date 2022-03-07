/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.Member;

/**
 *
 * @author ahmed
 */
public class MemberDB {
    

    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MemberDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection("jdbc:sqlite:Population Census System DB.db");
    }

    public static void addMember(Member member) {
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("insert into Member(Adderss,City,Education,Phone,Email,DOB,Name,AreaID,Sex,Occupation,UID,DocName,ImageName) values(?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, member.getAddress());
            p.setString(2, member.getCity());
            p.setString(3, member.getEducation());
            p.setInt(4, member.getPhone());
            p.setString(5, member.getEmail());
            p.setDate(6, (Date) member.getDOB());
            p.setString(7, member.getName());
            p.setInt(8, member.getareaID());
            p.setString(9, member.getSex());
            p.setString(10, member.getOccupation());
            p.setInt(11, member.getUID());
            p.setString(12, member.getDocName());
            p.setString(13, member.getImageName());

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }

    public static void deleteMember(int MID) {
        try (
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("delete from Member where MID = ? ");  
                PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setInt(1, MID);

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }
//(Adderss,City,Education,Phone,Email,DOB,Name,AreaID,Sex,Occupation,UID,DocName,ImageName)
    public static void updateMember(Member member) {
         try (                                                             
                 Connection con = connect();  PreparedStatement p = con.prepareStatement("UPDATE Member SET Adderss = ?,City = ?,Education = ?,Phone = ? ,Email = ?,DOB = ?,Name = ?,AreaID = ?,Sex = ?,Occupation = ?,UID = ?,DocName = ?,ImageName = ? WHERE MID= ?");  
                 PreparedStatement p1 = con.prepareStatement("PRAGMA foreign_keys = ON;");) {
            p1.execute();
            p.setString(1, member.getAddress());
            p.setString(2, member.getCity());
            p.setString(3, member.getEducation());
            p.setInt(4, member.getPhone());
            p.setString(5, member.getEmail());
            p.setDate(6, (Date) member.getDOB());
            p.setString(7, member.getName());
            p.setInt(8, member.getareaID());
            p.setString(9, member.getSex());
            p.setString(10, member.getOccupation());
            p.setInt(11, member.getUID());
            p.setString(12, member.getDocName());
            p.setString(13, member.getImageName());

            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

    }
    public ArrayList<Member> getMembers() {
        ArrayList<Member> list = new ArrayList<>();
        try (
                 Connection con = connect(); 
                PreparedStatement p = con.prepareStatement("select * from CorrectionRequest");) {
            {
                ResultSet r = p.executeQuery();
                while (r.next()) {      //return  one row of Area table 
                                                
                    list.add(new Member(r.getString("Adderss"), r.getString("City"), r.getString("Education"),r.getInt("Phone"),r.getString("Email"),r.getInt("MID"),r.getDate("DOB"),r.getString("Name"), r.getInt("AreaID"), r.getString("Sex"),r.getString("Occupation"),r.getInt("UID"),r.getString("DocName"),r.getString("ImageName")));

                }
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());// we will put out custimize exption massages here
        }

        return list;
    }
    
}
