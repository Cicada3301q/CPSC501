public class EmployeePhoneNumber {
    private String employeeExtension;
    private String officeNumber;

    void setEmployeeExtension(String arg) {
        employeeExtension = arg;
    }

    String getOfficeNumber() {
        return officeNumber;
    }

    void setOfficeNumber(String arg) {
        officeNumber = arg;
    }

    public String getEmployeeTelephoneNumber() {
        return ("(" + officeNumber + ") " + employeeExtension);
    }
}