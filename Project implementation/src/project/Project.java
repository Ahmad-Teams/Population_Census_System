package project;

import database.AdminDB;
import java.util.ArrayList;

public class Project {

    public static void main(String[] args) {
        // TODO code application logic here
                       //int phone,String Email,int OID,String name,int areaID,String Sex,String username, String password,int AID,String imageName
    //Officer o=new Officer(010237,"ahmednagi318s",25,"ahmed",25,"male","ahmednagi55","153sdf",522,"image");
      // AdminDB.addOfficer(o);
       ArrayList<FamilyMember> family_members= AdminDB.getFamilyMembers();
       for(int i=0;i<family_members.size();i++){
        System.out.println(family_members.get(i).getName());       
       }
    }
    
}

