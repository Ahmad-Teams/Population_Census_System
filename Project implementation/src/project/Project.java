package project;

import database.AdminDB;
import database.OfficerDB;
import java.util.ArrayList;
import database.UserDB;
public class Project {

    public static void main(String[] args) {
        // TODO code application logic here
                       //int phone,String Email,int OID,String name,int areaID,String Sex,String username, String password,int AID,String imageName
    //Officer o=new Officer(010237,"ahmednagi318s",25,"ahmed",25,"male","ahmednagi55","153sdf",522,"image");
      // AdminDB.addOfficer(o);
      /* ArrayList<FamilyMember> family_members= AdminDB.getFamilyMembers();
       for(int i=0;i<family_members.size();i++){
        System.out.println(family_members.get(i).getName());       
       }*/
      
      
      /* ArrayList<System_user> users=OfficerDB.getSystemUsers();
       for(int i=0;i<users.size();i++){
        System.out.println(users.get(i).getUsername()+"     "+users.get(i).getPassword()+"    "+users.get(i).getType()+"  "+users.get(i).getID());       
       }
        boolean x=UserDB.check("ahmednagi", "51515");
        System.out.println(x);
       
       */
       
       ArrayList<FamilyMember> FamilyMembers =OfficerDB.getFamilyMembers(1);
        for (int i = 0; i < FamilyMembers.size(); i++) {
            System.out.println(FamilyMembers.get(i).getName());
        }
        /*ArrayList<UserRequest> userRequests = OfficerDB.getUserRequests(1);
        System.out.println(userRequests.size());*/
    }
    
}

