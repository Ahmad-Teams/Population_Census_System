/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Member extends FamilyMember {

    private int MID;

    public int getMID() {
        return MID;
    }

    public Member(int MID, String city, String address, String education, String email, String sex, String occupation, String DocName, int stateID, Date DOB, int areaID, String name, int phone, String imageName, String Email, String Sex) {
        super(city, address, education, email, sex, occupation, DocName, stateID, DOB, areaID, name, phone, imageName, Email, Sex);
        this.MID = MID;
    }

    


    
}
