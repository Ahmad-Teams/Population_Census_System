/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.database.OfficerDB;
import Model.project.User;

/**
 *
 * @author ahmad
 */
public class OfficerViewController {

    int officerID;

    public OfficerViewController(int officerID) {
        this.officerID = officerID;
    }

    public void addUser(String name, String address, String education, String phone, String email, String date, String sex, String Occupation, String username, String password, int OfficerID) {
        OfficerDB.addUser(new User(officerID,address,education,email,sex,Occupation,date,OfficerDB.getAreaIDFromOfficerID(officerID),name,phone,username,password));
    }

}
