/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.database.AdminDB;
import Model.database.UserDB;
import Model.project.Member;
import Model.project.UserRequest;
import View.User.MemberTableColumn;
import View.User.UserRequestTableColumn;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ahmad
 */
public class UserViewController {

    int userID;

    public UserViewController(int userID) {
        this.userID = userID;
    }

    public ObservableList<UserRequestTableColumn> getuserRequests() {
        ObservableList<UserRequestTableColumn> UserRequestsList = FXCollections.observableArrayList();
        ArrayList<UserRequest> userRequests = UserDB.getUserRequests();
        for (int i = 0; i < userRequests.size(); i++) {
            if (userRequests.get(i).getUID() == userID) {
                UserRequest userRequest = userRequests.get(i);
                UserRequestsList.add(new UserRequestTableColumn(userRequest.getName(),AdminDB.getAreaName(userRequest.getAreaID()), userRequest.getRequestID(), userRequest.getRequestState(), userRequest.getAddress(), userRequest.getEducation(), userRequest.getPhone(), userRequest.getEmail(), userRequest.getMID(), userRequest.getDOB(), userRequest.getAreaID(), userRequest.getSex(), userRequest.getOccupation(), userRequest.getUID()));
            }
        }
        return UserRequestsList;
    }

    public ObservableList<MemberTableColumn> getMembers() {
        ObservableList<MemberTableColumn> membersList = FXCollections.observableArrayList();
        ArrayList<Member> members = UserDB.getMembers(userID);
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            membersList.add(new MemberTableColumn(AdminDB.getAreaName(member.getAreaID()), member.getMID(), member.getUID(), member.getAddress(), member.getEducation(), member.getSex(), member.getOccupation(), member.getDOB(), member.getAreaID(), member.getName(), member.getPhone(), member.getEmail()));
        }
        return membersList;
    }

    public void addUserRequest(String name ,String address, String education, String phone, String email, String date, String sex, String Occupation, int userID) {
        UserDB.addUserRequest(new UserRequest("Pending",name, address, education, phone, email, date, UserDB.getAreaIDFromUserID(userID), sex, Occupation, userID));
    }
}
