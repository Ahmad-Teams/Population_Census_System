package project;

import java.util.ArrayList;

public class Admin extends Person implements System_user ,Observable{

    private int AID;
    private String Name;
    private int stateID;
    private String username;
    private String password;

    public Admin(int AID, String Name, int stateID, String username, String password, String name, int phone, String imageName, String Email, String Sex) {
        super(name, phone, imageName, Email, Sex);
        this.AID = AID;
        this.Name = Name;
        this.stateID = stateID;
        this.username = username;
        this.password = password;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addOfficer(Officer officer) {

    }

    public void deleteOfficer(int Oid) {

    }

    public void updateOfficer(int Oid, String name,
            String state, int phone, String username,
            String password, String area) {

    }

    public void viewOfficers(ArrayList<Officer> officers) {

    }

    public void viewFamilyMember(ArrayList<FamilyMember> FamilyMembers) {

    }

    @Override
    public void getObservers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
