/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Admin;

import Model.project.User;

/**
 *
 * @author ahmad
 */
public class UserTableColumn extends User {

    private String areaName;

    public UserTableColumn(User user, String areaName) {
        super(user.getUID(), user.getCity(), user.getAddress(), user.getEducation(), user.getEmail(), user.getSex(), user.getOccupation(), user.getDOB(), user.getAreaID(), user.getName(),user.getPhone());
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
