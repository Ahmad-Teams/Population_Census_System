/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.database.*;
import Model.project.*;
import View.Admin.OfficerTableColumn;
import View.User.UserTableColumn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author ahmad
 */
public class AdminViewController {

    int adminID;

    public AdminViewController(int adminID) {
        this.adminID = adminID;
    }

    public ArrayList<String> getAreasForComboBox() {
        ArrayList<Area> areas = AdminDB.getAreasFromStateID(AdminDB.getAdminFromAdminID(adminID).getStateID());
        ArrayList<String> areasNames = new ArrayList<String>();
        for (int i = 0; i < areas.size(); i++) {
            areasNames.add(areas.get(i).getAreaName());
        }
        return areasNames;
    }

    public void addOfficer(String phone, String email, String name, String area, String sex, String username, String password) {
        AdminDB.addOfficer(new Officer(phone, email, name, AdminDB.getAreaID(area), sex, username, password, adminID));
    }

    public ObservableList<OfficerTableColumn> getOfficers() {
        ObservableList<OfficerTableColumn> officerList = FXCollections.observableArrayList();
        ArrayList<Officer> officers = AdminDB.getOfficers(adminID);
        for (int i = 0; i < officers.size(); i++) {
            Officer officer = officers.get(i);
            officerList.add(new OfficerTableColumn(AdminDB.getAreaName(officer.getAreaID()), officer.getOID(), officer.getAID(), officer.getUsername(), officer.getPassword(), officer.getAreaID(), officer.getName(), officer.getPhone(), officer.getEmail(), officer.getSex()));
        }
        return officerList;
    }

    public void deleteOfficer(int OID) {
        AdminDB.deleteOfficer(OID);
    }

    public void updateOfficer(String phone, String Email, int OID, String name, String areaName, String Sex, String username, String password, int adminID) {
        AdminDB.updateOfficer(new Officer(phone, Email, OID, name, AdminDB.getAreaID(areaName), Sex, username, password, adminID));
    }

    public String getAreaName(int areaID) {
        return AdminDB.getAreaName(areaID);
    }

    public ObservableList getReport(String SearchOn, String SearchOptions, String SortByOption, String OrderOption) {
        ObservableList reportList = FXCollections.observableArrayList();

        boolean isHasdescendantsOrHasUsers = SearchOptions.equals("Has descendants") || SearchOptions.equals("Has Users") ? true : false;
        boolean isAscendingOrder = OrderOption.equals("Ascending") ? true : false;

        if (SearchOn.equals("User")) {
            ArrayList<User> users = OfficerDB.getUsersByParameters(isHasdescendantsOrHasUsers, SortByOption, isAscendingOrder,adminID);
            reportList = makeUserTableRowsList(users);
        } else if (SearchOn.equals("Officer")) {
            ArrayList<Officer> officers = AdminDB.getOfficersByParameters(isHasdescendantsOrHasUsers, SortByOption, isAscendingOrder,adminID);
            reportList = makeOfficerTableRowsList(officers);
        }

        return reportList;
    }

    private ObservableList makeUserTableRowsList(ArrayList<User> users) {
        ObservableList<UserTableColumn> UserTableRowsList = FXCollections.observableArrayList();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            UserTableRowsList.add(new UserTableColumn(AdminDB.getAreaName(user.getAreaID()), user.getUID(), user.getAddress(), user.getEducation(), user.getSex(), user.getOccupation(), user.getDOB(), user.getAreaID(), user.getName(), user.getPhone(), user.getEmail()));
        }
        return UserTableRowsList;
    }

    private ObservableList makeOfficerTableRowsList(ArrayList<Officer> officers) {
        ObservableList<OfficerTableColumn> OfficerTableRowsList = FXCollections.observableArrayList();

        for (int i = 0; i < officers.size(); i++) {
            Officer officer = officers.get(i);
            OfficerTableRowsList.add(new OfficerTableColumn(AdminDB.getAreaName(officer.getAreaID()), officer.getOID(), officer.getAID(), officer.getUsername(), officer.getPassword(), officer.getAreaID(), officer.getName(), officer.getPhone(), officer.getEmail(), officer.getSex()));
        }
        return OfficerTableRowsList;
    }

}
