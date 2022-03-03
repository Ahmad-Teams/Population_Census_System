package project.implementation;

public class CorrectionRequest {

    private int stringrequestID;

    public int getStringrequestID() {
        return stringrequestID;
    }

    public void setStringrequestID(int stringrequestID) {
        this.stringrequestID = stringrequestID;
    }

    private String requestTitle;

    public String getRequestTitle() {
        return requestTitle;
    }

    public void setRequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }

    private String requestContent;

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    private String requestState;

    public String getRequestState() {
        return requestState;
    }

    public void setRequestState(String requestState) {
        this.requestState = requestState;
    }

    public CorrectionRequest(int stringrequestID, String requestTitle, String requestContent, String requestState) {
        this.stringrequestID = stringrequestID;
        this.requestTitle = requestTitle;
        this.requestContent = requestContent;
        this.requestState = requestState;
    }

}
