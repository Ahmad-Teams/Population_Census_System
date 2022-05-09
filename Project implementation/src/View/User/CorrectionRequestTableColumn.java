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
    private int OID;
    private String requestTitle;
    private String requestContent;
    private int UID;

    public CorrectionRequestTableColumn(int requestID, int userRequestID, int OID, String requestTitle, String requestContent, int UID) {
        this.requestID = requestID;
        this.userRequestID = userRequestID;
        this.OID = OID;
        this.requestTitle = requestTitle;
        this.requestContent = requestContent;
        this.UID = UID;
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

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
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

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }


}
