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
public class FamilyMember extends Person{

    private String city;
    private String address;
    private String education;
    private String sex;
    private String occupation;
    private int stateID;
    private String DOB;
    private int areaID;
    

    public FamilyMember(String city, String address, String education, String email, String sex, String occupation, String DOB, int areaID, String name, String phone) {
        super(name, phone, email, sex);
        this.city = city;
        this.address = address;
        this.education = education;
        this.sex = sex;
        this.occupation = occupation;
        this.stateID = stateID;
        this.DOB = DOB;
        this.areaID = areaID;
    }



    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int AreaID) {
        this.areaID = AreaID;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

  
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
