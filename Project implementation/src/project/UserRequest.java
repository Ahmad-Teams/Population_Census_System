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
public class UserRequest {

    private int requestID;
    private String requestState;
    private String address;
    private String city;
    private String education;
    private int phone;
    private String email;
    private int MID;
    private Date DOB;
    private String DocName;
    private int areaID;
    private String sex;
    private String occupation;
    private int UID;
    //RequestState,Adderss,City,Education,Phone,Email,MID,DOB,DocName,AreaID,Sex,Occupation,UID)

    public UserRequest(int requestID, String requestState, String address, String city, String education, int phone, String email, int MID, Date DOB, String DocName, int areaID, String sex, String occupation, int UID) {
        this.requestID = requestID;
        this.requestState = requestState;
        this.address = address;
        this.city = city;
        this.education = education;
        this.phone = phone;
        this.email = email;
        this.MID = MID;
        this.DOB = DOB;
        this.DocName = DocName;
        this.areaID = areaID;
        this.sex = sex;
        this.occupation = occupation;
        this.UID = UID;
    }

    public void updateMember(Member member) {

    }

    public int getUID() {
        return UID;
    }

    public void addMember(Member member) {

    }

    public int getRequestID() {
        return requestID;
    }

    public String getRequestState() {
        return requestState;
    }

    public void setRequestState(String requestState) {
        this.requestState = requestState;
    }

    public int getMID() {
        return MID;
    }

    public void setMID(int MID) {
        this.MID = MID;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

    public int getAreaID() {
        return areaID;
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

}
