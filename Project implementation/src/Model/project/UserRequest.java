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
public class UserRequest {

    private int requestID;
    private String requestState;
    private String address;
    private String city;
    private String education;
    private String phone;
    private String email;
    private int MID;
    private String DOB;
    private int areaID;
    private String sex;
    private String occupation;
    private int UID;
    //RequestState,Adderss,City,Education,Phone,Email,MID,DOB,DocName,AreaID,Sex,Occupation,UID)

    public UserRequest(int requestID, String requestState, String address, String city, String education, String phone, String email, int MID, String DOB, int areaID, String sex, String occupation, int UID) {
        this.requestID = requestID;
        this.requestState = requestState;
        this.address = address;
        this.city = city;
        this.education = education;
        this.phone = phone;
        this.email = email;
        this.MID = MID;
        this.DOB = DOB;
        this.areaID = areaID;
        this.sex = sex;
        this.occupation = occupation;
        this.UID = UID;
    }
    // where is name of the user ????????
    public UserRequest(String requestState, String address, String city, String education, String phone, String email, String DOB, int areaID, String sex, String occupation, int UID) {
        this.requestState = requestState;
        this.address = address;
        this.city = city;
        this.education = education;
        this.phone = phone;
        this.email = email;
        this.DOB = DOB;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
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
