package project.implementation;

import java.util.ArrayList;

public class AdminDB {

    public static void addOfficer(Officer officer) {

    }

    public static void deleteOfficer(int Oid) {

    }

    public static void updateOfficer(int Oid, String name, String state, int phone, String username, String password, String area) {

    }

    public ArrayList<Officer> getOfficers() {
        return new ArrayList<Officer>();
    }

    public ArrayList<FamilyMember> getFamilyMembers() {
        return new ArrayList<FamilyMember>();
    }

    public static String check(String username, String password) {
        OfficerDB.check(username, password);
        return "";
    }
}