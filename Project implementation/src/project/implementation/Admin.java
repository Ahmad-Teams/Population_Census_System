
package project.implementation;

import java.util.ArrayList;


public class Admin extends Person implements System_user {

    private int AID;

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

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
    
}
