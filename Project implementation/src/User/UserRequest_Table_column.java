/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import project.UserRequest;

/**
 *
 * @author PC
 */
public class UserRequest_Table_column extends UserRequest{
    private String areaName;

    public UserRequest_Table_column (UserRequest request, String areaName) {
        super(request.getRequestID(), request.getRequestState(), request.getAddress(), request.getCity(), request.getEducation(), request.getPhone(), request.getEmail(), request.getMID(), request.getDOB(), request.getAreaID(), request.getSex(), request.getOccupation(), request.getUID());
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
