/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.User;

/**
 *
 * @author ahmad
 */
public class CorrectionRequestTableColumn {

    private int requestID;
    private int userRequestID;
    private int officerID;
    private String requestTitle;
    private String requestContent;
    private int userID;

    public CorrectionRequestTableColumn(int requestID, int userRequestID, int officerID, String requestTitle, String requestContent, int userID) {
        this.requestID = requestID;
        this.userRequestID = userRequestID;
        this.officerID = officerID;
        this.requestTitle = requestTitle;
        this.requestContent = requestContent;
        this.userID = userID;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getUserRequestID() {
        return userRequestID;
    }

    public void setUserRequestID(int userRequestID) {
        this.userRequestID = userRequestID;
    }

    public int getOfficerID() {
        return officerID;
    }

    public void setOfficerID(int officerID) {
        this.officerID = officerID;
    }

    public String getRequestTitle() {
        return requestTitle;
    }

    public void setRequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


}
