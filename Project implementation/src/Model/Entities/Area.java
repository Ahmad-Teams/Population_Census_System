/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entities;

/**
 *
 * @author PC
 */
public class Area {

    private String areaName;
    private int areaID;
    
    private int stateID;

    public Area(String areaName, int areaID, int stateID) {
        this.areaName = areaName;
        this.areaID = areaID;
        this.stateID = stateID;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }


    public int getAreaID() {
        return areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

}
