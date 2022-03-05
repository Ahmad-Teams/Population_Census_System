package project;

import java.util.ArrayList;

public class Officer extends Person implements System_user, Observable {

    private int OID;
    private int AID;
    private Area area;
    private String username;
    private String password;
    private ArrayList<Observer> observers;
    private int areaID;

    public Officer(int OID, int AID, Area area, String username, String password, ArrayList<Observer> observers, int areaID, String name, int phone, String imageName, String Email, String Sex) {
        super(name, phone, imageName, Email, Sex);
        this.OID = OID;
        this.AID = AID;
        this.area = area;
        this.username = username;
        this.password = password;
        this.observers = observers;
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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

    @Override
    public void notifyUpdate() {
        User.Update();
    }

    @Override
    public void getObservers() {
        ArrayList<Observer> observers = new ArrayList<Observer>();
        //here we find the observers of the officer (users) by matching the common area and adding them to the arraylist (observers)
        this.setObservers(observers);
    }

}
