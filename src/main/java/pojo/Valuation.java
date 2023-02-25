package pojo;


//估值信息表
public class Valuation {
    private String valuationNo;//   十位数字
    private String valuationDate;
    private double valuationPrice;
    private String assetNo;
    private String employeeNo;

    public String getValuationNo() {
        return valuationNo;
    }

    public void setValuationNo(String valuationNo) {
        this.valuationNo = valuationNo;
    }

    public String getValuationDate() {
        return valuationDate;
    }

    public void setValuationDate(String valuationDate) {
        this.valuationDate = valuationDate;
    }

    public double getValuationPrice() {
        return valuationPrice;
    }

    public void setValuationPrice(double valuationPrice) {
        this.valuationPrice = valuationPrice;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    @Override
    public String toString() {
        return "Valuation{" +
                "valuationNo='" + valuationNo + '\'' +
                ", valuationDate='" + valuationDate + '\'' +
                ", valuationPrice=" + valuationPrice +
                ", assetNo='" + assetNo + '\'' +
                ", employeeNo='" + employeeNo + '\'' +
                '}';
    }
}
