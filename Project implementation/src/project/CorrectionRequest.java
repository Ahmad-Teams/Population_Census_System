package project;

public class CorrectionRequest {

    private int requestID;
    private int userRequestID;
    private int OID;
    private String requestTitle;
    private String requestContent;
    private int UID;

    public int getUserRequestID() {
        return userRequestID;
    }

    public void setUserRequestID(int userRequestID) {
        this.userRequestID = userRequestID;
    }

    public CorrectionRequest(int requestID, int OID, String requestTitle, String requestContent, int UID) {
        this.requestID = requestID;
        this.OID = OID;
        this.requestTitle = requestTitle;
        this.requestContent = requestContent;
        this.UID = UID;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
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

    public CorrectionRequest(int stringrequestID, String requestTitle, String requestContent) {
        this.requestID = stringrequestID;
        this.requestTitle = requestTitle;
        this.requestContent = requestContent;
    }

}
