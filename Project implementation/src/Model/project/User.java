package Model.project;

import java.util.ArrayList;
import java.util.Date;

public class User extends FamilyMember {

    private int OID;
    private int UID;
    private String username;
    private String password;

    public User(int OID, int UID, String address, String education, String email, String sex, String occupation, String DOB, int areaID, String name, String phone,String username,String password) {
        super(address, education, email, sex, occupation, DOB, areaID, name, phone);
        this.OID = OID;
        this.UID = UID;
        this.username = username;
        this.password = password;
    }

    public User(int OID, String address, String education, String email, String sex, String occupation, String DOB, int areaID, String name, String phone,String username,String password) {
        super(address, education, email, sex, occupation, DOB, areaID, name, phone);
        this.OID = OID;
        this.username = username;
        this.password = password;
    }

    public User(String address, String education, String email, String sex, String occupation, String DOB, int areaID, String name, String phone) {
        super(address, education, email, sex, occupation, DOB, areaID, name, phone);
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

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
