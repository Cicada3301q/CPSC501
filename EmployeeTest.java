import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee(1, "John Doe", "john@example.com");
    }

    @Test
    public void testGetEmployeeId() {
        assertEquals(1, employee.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", employee.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john@example.com", employee.getEmail());
    }

    @Test
    public void testPlaceOrder() {
        Order order = new Order(101, new Customer(1, "Alice", "alice@example.com"));
        employee.placeOrder(order);
        assertEquals(1, employee.getOrders().size());
    }

}