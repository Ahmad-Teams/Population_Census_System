/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.database.AdminDB;
import Model.database.OfficerDB;
import Model.project.User;
import Model.project.UserRequest;
import View.User.UserRequestTableColumn;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        OfficerDB.addUser(new User(officerID, address, education, email, sex, Occupation, date, OfficerDB.getAreaIDFromOfficerID(officerID), name, phone, username, password));
    }

    public ObservableList<UserRequestTableColumn> getUserRequests() {
        ObservableList<UserRequestTableColumn> UserRequestColumnsList = FXCollections.observableArrayList();
        ArrayList<UserRequest> userRequests = OfficerDB.getUserRequests(officerID);
        for (int i = 0; i < userRequests.size(); i++) {
            UserRequest userRequest = userRequests.get(i);
            UserRequestColumnsList.add(new UserRequestTableColumn(userRequest.getName(),AdminDB.getAreaName(userRequest.getAreaID()), userRequest.getRequestID(),userRequest.getRequestState(),userRequest.getAddress(),userRequest.getEducation(),userRequest.getPhone(),userRequest.getEmail(),userRequest.getMID(),userRequest.getDOB(),userRequest.getAreaID(),userRequest.getSex(),userRequest.getOccupation(),userRequest.getUID()));
        }
        return UserRequestColumnsList;
    }
}
