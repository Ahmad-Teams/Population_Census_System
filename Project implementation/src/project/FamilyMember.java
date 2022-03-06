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
public class FamilyMember extends Person implements Observer{

    private String city;
    private String address;
    private String education;
    private String email;
    private String sex;
    private String occupation;
    private String DocName;
    private int stateID;
    private Date DOB;
    private int areaID;

    public FamilyMember(String city, String address, String education, String email, String sex, String occupation, String DocName, int stateID, Date DOB, int areaID, String name, int phone, String imageName, String Email, String Sex) {
        super(name, phone, imageName, Email, Sex);
        this.city = city;
        this.address = address;
        this.education = education;
        this.email = email;
        this.sex = sex;
        this.occupation = occupation;
        this.DocName = DocName;
        this.stateID = stateID;
        this.DOB = DOB;
        this.areaID = areaID;
    }



    public int getareaID() {
        return areaID;
    }

    public void setareaID(int AreaID) {
        this.areaID = AreaID;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public String getDocName() {
        return DocName;
    }

    public void setDocName(String DocName) {
        this.DocName = DocName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
