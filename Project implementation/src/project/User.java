package project;

import java.util.ArrayList;
import java.util.Date;

public class User extends FamilyMember{

    public User(int UID, String city, String address, String education, String email, String sex, String occupation, String DOB, int areaID, String name, String phone) {
        super(city, address, education, email, sex, occupation, DOB, areaID, name, phone);
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
