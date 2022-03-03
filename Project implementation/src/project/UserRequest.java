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
    private String requestTitle;
    private String requestType;
    private String requestState;
    private int MID;
    private int DocName;
    private String address;
    private String city;
    private String education;
    private int phone;
    private String email;
    private Date DOB;
    private String area;
    private String sex;
    private String occupation;

    public UserRequest(int requestID, String requestTitle, String requestType, String requestState, int MID, int DocName, String address, String city, String education, int phone, String email, String area, String sex, String occupation, Date DOB) {
        this.requestID = requestID;
        this.requestTitle = requestTitle;
        this.requestType = requestType;
        this.requestState = requestState;
        this.MID = MID;
        this.DocName = DocName;
        this.address = address;
        this.city = city;
        this.education = education;
        this.phone = phone;
        this.email = email;
        this.DOB = DOB;
        this.area = area;
        this.sex = sex;
        this.occupation = occupation;
    }
    
    public void updateMember(Member member){
        
    }
    
    public void addMember(Member member){
        
    }
    
    
    public int getRequestID() {
        return requestID;
    }

    public String getRequestTitle() {
        return requestTitle;
    }

    public void setRequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
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

    public int getDocName() {
        return DocName;
    }

    public void setDocName(int DocName) {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
