/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.project;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Member extends FamilyMember {

    private int MID;
    private int UID;
    public int getMID() {
        return MID;
    }

    public Member(int MID, int UID, String address, String education, String email, String sex, String occupation, String DOB, int areaID, String name, String phone) {
        super(address, education, email, sex, occupation, DOB, areaID, name, phone);
        this.MID = MID;
        this.UID = UID;
    }

    public Member(int UID, String address, String education, String email, String sex, String occupation, String DOB, int areaID, String name, String phone) {
        super(address, education, email, sex, occupation, DOB, areaID, name, phone);
        this.UID = UID;
    } 

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    


    
}
