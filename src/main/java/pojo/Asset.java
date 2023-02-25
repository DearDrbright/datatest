package pojo;

//资产信息表
public class Asset {
    private String assetNo;
    private String assetDescription;
    private String serialNo;
    private String dateAcquired;
    private double purchasePrice;
    private double currentValue;
    private String nextMaintenanceData;
    private String employeeNo;
    private String assetCategoryNo;
    private String statusNo;

    @Override
    public String toString() {
        return "Asset{" +
                "assetNo='" + assetNo + '\'' +
                ", assetDescription='" + assetDescription + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", dateAcquired='" + dateAcquired + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", currentValue=" + currentValue +
                ", nextMaintenanceData='" + nextMaintenanceData + '\'' +
                ", employeeNo='" + employeeNo + '\'' +
                ", assetCategoryNo='" + assetCategoryNo + '\'' +
                ", statusNo='" + statusNo + '\'' +
                '}';
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getAssetDescription() {
        return assetDescription;
    }

    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public String getNextMaintenanceData() {
        return nextMaintenanceData;
    }

    public void setNextMaintenanceData(String nextMaintenanceData) {
        this.nextMaintenanceData = nextMaintenanceData;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getAssetCategoryNo() {
        return assetCategoryNo;
    }

    public void setAssetCategoryNo(String assetCategoryNo) {
        this.assetCategoryNo = assetCategoryNo;
    }

    public String getStatusNo() {
        return statusNo;
    }

    public void setStatusNo(String statusNo) {
        this.statusNo = statusNo;
    }
}
