package database;

import java.util.ArrayList;
import project.CorrectionRequest;
import project.FamilyMember;
import project.UserRequest;

public class OfficerDB {

    public static ArrayList<FamilyMember> getFamilyMembers() {
        return new ArrayList<FamilyMember>();
    }

    public static ArrayList<UserRequest> getUserRequests() {
        return new ArrayList<UserRequest>();
    }

    public static ArrayList<CorrectionRequest> getCorrectionRequests() {
        return new ArrayList<CorrectionRequest>();
    }

    public static boolean check(String username, String password) {
        return false;
    }
}
