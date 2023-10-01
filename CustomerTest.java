import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class CustomerTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCustomerId() {
        // Attempt to create a customer with an invalid negative customer ID
        Customer customer = new Customer(-1, "Invalid", "invalid@example.com");
    }

    @Test
    public void testAddNullOrder() {
        Customer customer = new Customer(1, "Alice", "alice@example.com");
        // Attempt to add a null order should result in an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> customer.placeOrder(null));
    }

    @Test
    public void testGetOrdersEmpty() {
        Customer customer = new Customer(1, "Alice", "alice@example.com");
        List<Order> orders = customer.getOrders();
        // Ensure that the getOrders method returns an empty list when no orders are placed
        assertTrue(orders.isEmpty());
    }
}