class Employee extends Person {
    private EmployeePhoneNumber phoneNumber;

    public Employee(int id, String name, String email) {
        super(id, name, email);
        this.phoneNumber = new EmployeePhoneNumber();
    }

    public void setEmployeeExtension(String arg) {
        phoneNumber.setEmployeeExtension(arg);
    }

    public void setOfficeNumber(String arg) {
        phoneNumber.setOfficeNumber(arg);
    }

    public String getOfficeNumber() {
        return phoneNumber.getOfficeNumber();
    }

    public String getEmployeeTelephoneNumber() {
        return phoneNumber.getEmployeeTelephoneNumber();
    }
}