/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.User;

/**
 *
 * @author ahmad
 */
public class UserTableColumn {

    private String areaName;
    private int UID;
    private String city;
    private String address;
    private String education;
    private String sex;
    private String occupation;
    private int stateID;
    private String DOB;
    private int areaID;
    private String name;
    private String phone;
    private String Email;

    public UserTableColumn(String areaName, int UID, String city, String address, String education, String sex, String occupation, int stateID, String DOB, int areaID, String name, String phone, String Email) {
        this.areaName = areaName;
        this.UID = UID;
        this.city = city;
        this.address = address;
        this.education = education;
        this.sex = sex;
        this.occupation = occupation;
        this.stateID = stateID;
        this.DOB = DOB;
        this.areaID = areaID;
        this.name = name;
        this.phone = phone;
        this.Email = Email;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
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

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }   
    
}
