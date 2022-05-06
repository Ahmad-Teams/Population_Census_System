/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Admin;

import Model.project.Officer;

/**
 *
 * @author ahmad
 */
public class OfficerTableColumn extends Officer{

    private String areaName;

    public OfficerTableColumn(Officer officer, String areaName) {
        super(officer.getPhone(), officer.getEmail(), officer.getOID(), officer.getName(), officer.getAreaID(), officer.getSex(), officer.getUsername(), officer.getPassword(), officer.getAID());
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
