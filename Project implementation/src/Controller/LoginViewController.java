/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.database.AdminDB;
import Model.database.OfficerDB;
import Model.Entities.System_user;
import View.Admin.Admin_AddOfficer;
import View.Officer.ViewNewRequests;
import View.User.View_Family_Members;
import java.util.ArrayList;
import javafx.stage.Stage;

/**
 *
 * @author ahmad
 */
public class LoginViewController {

    public boolean checkIfUserExsist(String userName, String password) {
        return OfficerDB.check(userName, password);
    }

    public void openSystemUserAccount(String username,String password) {
        String accountType = getAccountType(username, password);
        if (accountType.equals("Admin")) {
            int adminID = AdminDB.getAdminIDfromUsername(username);
            Admin_AddOfficer c1 = new Admin_AddOfficer(adminID);
            c1.start(new Stage());
        } else if (accountType.equals("Officer")) {
            int officerID = AdminDB.getOfficerIDfromUsername(username);
            ViewNewRequests c1 = new ViewNewRequests(officerID);
            c1.start(new Stage());
        } else if (accountType.equals("User")) {
            int userID = AdminDB.getUserIDfromUsername(username);
            View_Family_Members c1 = new View_Family_Members(userID);
            c1.start(new Stage());
        }
    }

    private String getAccountType(String userName, String password) {
        String Accounttype = "";
        ArrayList<System_user> allAccounts = OfficerDB.getSystemUsers();
        for (int i = 0; i < allAccounts.size(); i++) {
            if (allAccounts.get(i).getUsername().equals(userName) && allAccounts.get(i).getPassword().equals(password)) {
                Accounttype = allAccounts.get(i).getType();
                break;
            }
        }
        return Accounttype;
    }
}
