import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
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

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPrice() {
        // Attempt to create a product with an invalid negative price
        Product product = new Product(101, "Invalid Product", -10.0, "Regular");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDiscountType() {
        // Attempt to create a product with an invalid discount type
        Product product = new Product(102, "Invalid Product", 100.0, "InvalidType");
    }

}