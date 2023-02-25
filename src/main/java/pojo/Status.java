package pojo;

//状态信息表
public class Status {
    private String statusNo;
    private String statusDescription;

    @Override
    public String toString() {
        return "Status{" +
                "statusNo='" + statusNo + '\'' +
                ", statusDescription='" + statusDescription + '\'' +
                '}';
    }

    public String getStatusNo() {
        return statusNo;
    }

    public void setStatusNo(String statusNo) {
        this.statusNo = statusNo;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
