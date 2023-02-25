package pojo;

public class ServiceAgent {
    private String agentNo;
    private String agentName;
    private String agentStreet;
    private String agentCity;
    private String agentState;
    private String agentZipCode;
    private String agentTelNo;
    private String agentFaxNo;
    private String agentEmailAddress;
    private String agentWebAddress;
    private String contactName;
    private String contactTelNo;
    private float contactFaxNo;
    private String contactEmailAddress;

    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentStreet() {
        return agentStreet;
    }

    public void setAgentStreet(String agentStreet) {
        this.agentStreet = agentStreet;
    }

    public String getAgentCity() {
        return agentCity;
    }

    public void setAgentCity(String agentCity) {
        this.agentCity = agentCity;
    }

    public String getAgentState() {
        return agentState;
    }

    public void setAgentState(String agentState) {
        this.agentState = agentState;
    }

    public String getAgentZipCode() {
        return agentZipCode;
    }

    public void setAgentZipCode(String agentZipCode) {
        this.agentZipCode = agentZipCode;
    }

    public String getAgentTelNo() {
        return agentTelNo;
    }

    public void setAgentTelNo(String agentTelNo) {
        this.agentTelNo = agentTelNo;
    }

    public String getAgentFaxNo() {
        return agentFaxNo;
    }

    public void setAgentFaxNo(String agentFaxNo) {
        this.agentFaxNo = agentFaxNo;
    }

    public String getAgentEmailAddress() {
        return agentEmailAddress;
    }

    public void setAgentEmailAddress(String agentEmailAddress) {
        this.agentEmailAddress = agentEmailAddress;
    }

    public String getAgentWebAddress() {
        return agentWebAddress;
    }

    public void setAgentWebAddress(String agentWebAddress) {
        this.agentWebAddress = agentWebAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTelNo() {
        return contactTelNo;
    }

    public void setContactTelNo(String contactTelNo) {
        this.contactTelNo = contactTelNo;
    }

    public float getContactFaxNo() {
        return contactFaxNo;
    }

    public void setContactFaxNo(float contactFaxNo) {
        this.contactFaxNo = contactFaxNo;
    }

    public String getContactEmailAddress() {
        return contactEmailAddress;
    }

    public void setContactEmailAddress(String contactEmailAddress) {
        this.contactEmailAddress = contactEmailAddress;
    }

    @Override
    public String toString() {
        return "ServiceAgent{" +
                "agentNo='" + agentNo + '\'' +
                ", agentName='" + agentName + '\'' +
                ", agentStreet='" + agentStreet + '\'' +
                ", agentCity='" + agentCity + '\'' +
                ", agentState='" + agentState + '\'' +
                ", agentZipCode='" + agentZipCode + '\'' +
                ", agentTelNo=" + agentTelNo +
                ", agentFaxNo=" + agentFaxNo +
                ", agentEmailAddress='" + agentEmailAddress + '\'' +
                ", agentWebAddress='" + agentWebAddress + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactTelNo='" + contactTelNo + '\'' +
                ", contactFaxNo=" + contactFaxNo +
                ", contactEmailAddress='" + contactEmailAddress + '\'' +
                '}';
    }
}
