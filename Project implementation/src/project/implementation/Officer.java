package project.implementation;

import java.util.ArrayList;

public class Officer extends Person implements System_user, Observable {

    private int OID;
    
    private ArrayList<Observer> observers;


    private void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }
    
    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    private Area area;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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

    public Officer(int OID, Area area, String username, String password) {
        this.OID = OID;
        this.area = area;
        this.username = username;
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
