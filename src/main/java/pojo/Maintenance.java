package pojo;

public class Maintenance {
    private String maintenanceNo;
    private String maintenanceDate;
    private String maintenanceDescription;
    private double maintenanceCost;
    private String assetNo;
    private String employeeNo;
    private String agentNo;

    public String getMaintenanceNo() {
        return maintenanceNo;
    }

    public void setMaintenanceNo(String maintenanceNo) {
        this.maintenanceNo = maintenanceNo;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getMaintenanceDescription() {
        return maintenanceDescription;
    }

    public void setMaintenanceDescription(String maintenanceDescription) {
        this.maintenanceDescription = maintenanceDescription;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
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

    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceNo='" + maintenanceNo + '\'' +
                ", maintenanceDate='" + maintenanceDate + '\'' +
                ", maintenanceDescription='" + maintenanceDescription + '\'' +
                ", maintenanceCost=" + maintenanceCost +
                ", assetNo='" + assetNo + '\'' +
                ", employeeNo='" + employeeNo + '\'' +
                ", agentNo='" + agentNo + '\'' +
                '}';
    }
}
