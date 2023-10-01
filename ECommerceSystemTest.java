import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ECommerceSystemTest {

    @Test
    public void testCalculateDiscountRegularProduct() {
        Product regularProduct = new Product(101, "Regular Item", 100.0, "Regular");
        assertEquals(10.0, regularProduct.calculateDiscount(), 0.01); // 10% discount
    }

    @Test
    public void testCalculateDiscountPromotionalProduct() {
        Product promotionalProduct = new Product(102, "Promo Item", 100.0, "Promotional");
        assertEquals(20.0, promotionalProduct.calculateDiscount(), 0.01); // 20% discount
    }

    @Test
    public void testCalculateDiscountClearanceProduct() {
        Product clearanceProduct = new Product(103, "Clearance Item", 100.0, "Clearance");
        assertEquals(30.0, clearanceProduct.calculateDiscount(), 0.01); // 30% discount
    }

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