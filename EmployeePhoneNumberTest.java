import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EmployeePhoneNumberTest {
    private EmployeePhoneNumber phoneNumber;

    @Before
    public void setUp() {
        phoneNumber = new EmployeePhoneNumber();
    }

    @Test
    public void testSetAndGetOfficeNumber() {
        phoneNumber.setOfficeNumber("456");
        assertEquals("456", phoneNumber.getOfficeNumber());
    }

    @Test
    public void testGetEmployeeTelephoneNumber() {
        phoneNumber.setEmployeeExtension("123");
        phoneNumber.setOfficeNumber("456");
        assertEquals("(456) 123", phoneNumber.getEmployeeTelephoneNumber());
    }


}

