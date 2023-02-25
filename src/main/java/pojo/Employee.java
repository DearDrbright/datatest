package pojo;

//员工信息表
public class Employee {
    private String employeeNo;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private double workTelExt;
    private double homeTelNo;
    private String empEmallAddress;
    private double soclalSecurityNumber;
    private String dOB;
    private String position;
    private String sex;
    private double salary;
    private String dateStarted;

    public String getDOB() {
        return dOB;
    }

    public void setDOB(String dOB) {
        this.dOB = dOB;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNo='" + employeeNo + '\'' +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", workTelExt=" + workTelExt +
                ", homeTelNo=" + homeTelNo +
                ", empEmallAddress='" + empEmallAddress + '\'' +
                ", soclalSecurityNumber=" + soclalSecurityNumber +
                ", dob='" + dOB + '\'' +
                ", position='" + position + '\'' +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", dateStarted='" + dateStarted + '\'' +
                '}';
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getWorkTelExt() {
        return workTelExt;
    }

    public void setWorkTelExt(double workTelExt) {
        this.workTelExt = workTelExt;
    }

    public double getHomeTelNo() {
        return homeTelNo;
    }

    public void setHomeTelNo(double homeTelNo) {
        this.homeTelNo = homeTelNo;
    }

    public String getEmpEmallAddress() {
        return empEmallAddress;
    }

    public void setEmpEmallAddress(String empEmallAddress) {
        this.empEmallAddress = empEmallAddress;
    }

    public double getSoclalSecurityNumber() {
        return soclalSecurityNumber;
    }

    public void setSoclalSecurityNumber(double soclalSecurityNumber) {
        this.soclalSecurityNumber = soclalSecurityNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }
}
