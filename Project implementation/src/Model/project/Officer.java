package Model.project;

import java.util.ArrayList;
import Model.database.OfficerDB;
public class Officer extends Person{

    private int OID;
    private int AID;
    private String username;
    private String password;
    private ArrayList<Observer> observers;
    private int areaID;
    
    public Officer(String phone,String Email,int OID,String name,int areaID,String Sex,String username, String password,int AID) {
        super(name, phone, Email, Sex);
        this.OID = OID;
        this.AID = AID;
        this.username = username;
        this.password = password;
        this.areaID = areaID;
    }
  
    public Officer(String phone,String Email,String name,int areaID,String Sex,String username, String password,int AID) {
        super(name, phone, Email, Sex);
        this.AID = AID;
        this.username = username;
        this.password = password;
        this.areaID = areaID;
    }
    
        public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    private void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
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

    public void viewFamilyMember(ArrayList<FamilyMember> FamilyMembers) {

    }

    public void viewUserRequests(ArrayList<UserRequest> UserRequests) {

    }

    public ArrayList<Observer> viewUserRequests() {

        return new ArrayList<Observer>();
    }

    public void notifyUpdate() {
        User.Update();
    }

    

    
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
