import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ECommerceSystemTest {

    @Test
    public void testCalculateTotal() {
        Customer customer = new Customer(1, "Alice", "alice@example.com");
        Product product1 = new Product(101, "Laptop", 799.99, "Regular");
        Product product2 = new Product(102, "Smartphone", 399.99, "Promotional");
        Order order = new Order(201, customer);
        order.addProduct(product1);
        order.addProduct(product2);
        assertEquals(1039.98, order.calculateTotal(), 0.01); // Total amount with discounts
    }
}