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
    private int UID;
    public int getMID() {
        return MID;
    }
      //(Adderss,City,Education,Phone,Email,DOB,Name,AreaID,Sex,Occupation,UID,DocName,ImageName)
    public Member(String address,String city,String education,int phone,String email,int MID,Date DOB,String name,int areaID,String sex,String occupation,int UID,String DocName,String imageName) {
        super(city, address, education, email, sex, occupation, DocName, DOB, areaID, name, phone, imageName, email);
        this.MID = MID;
        this.UID=UID;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    


    
}
