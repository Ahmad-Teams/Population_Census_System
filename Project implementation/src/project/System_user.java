/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project;

/**
 *
 * @author ahmad
 */
public class System_user {
    private String username;
    private String password;
    private String Type;
    private int ID;
    public System_user(String username, String password,String Type,int ID) {
        this.username = username;
        this.password = password;
        this.Type=Type;
        this.ID=ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return Type;
    }

    public int getID() {
        return ID;
    }
    
}
