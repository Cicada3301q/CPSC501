import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ECommerceSystemTest {

    @Test
    public void testCalculateTotal() {
        Customer customer = new Customer(1, "Alice", "alice@example.com");
        AbstractProduct product1 = new RegularProduct(101, "Laptop", 799.99);
        AbstractProduct product2 = new PromotionalProduct(102, "Smartphone", 399.99);
        Order order = new Order(201, customer);
        order.addProduct(product1);
        order.addProduct(product2);
        assertEquals(1039.98, order.calculateTotal(), 0.01); // Total amount with discounts
    }
}