package project;

import java.util.ArrayList;

public class User extends FamilyMember implements System_user, Observer {

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
