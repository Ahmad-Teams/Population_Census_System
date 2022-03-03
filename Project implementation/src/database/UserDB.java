/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import project.CorrectionRequest;
import project.Member;
import project.UserRequest;

/**
 *
 * @author PC
 */
public class UserDB {

    public static void addUserRequest(UserRequest request) {

    }

    public static ArrayList<Member> getMembers() {
        return new ArrayList<Member>();
    }

    public static ArrayList<UserRequest> getUserRequests() {
        return new ArrayList<UserRequest>();

    }

    public static ArrayList<CorrectionRequest> getCorrectionRequests() {
        return new ArrayList<CorrectionRequest>();
    }

    public boolean check(String username, String password) {
         return OfficerDB.check(username, password);
    }

}
