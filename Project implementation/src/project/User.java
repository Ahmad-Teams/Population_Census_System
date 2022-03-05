package project;

import java.util.ArrayList;
import java.util.Date;

public class User extends FamilyMember implements System_user, Observer {

    public User(int UID, String city, String address, String education, String email, String sex, String occupation, String DocName, int stateID, Date DOB, int areaID, String name, int phone, String imageName, String Email, String Sex) {
        super(city, address, education, email, sex, occupation, DocName, stateID, DOB, areaID, name, phone, imageName, Email, Sex);
        this.UID = UID;
    }

    static void Update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int UID;

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public void viewMember(ArrayList<Member> members) {

    }

    public void viewUserRequests(ArrayList<UserRequest> userRequests) {

    }

    public void viewCorrectionRequests(ArrayList<CorrectionRequest> CorrectionRequests) {

    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
