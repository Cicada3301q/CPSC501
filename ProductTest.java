import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void testCalculateDiscountRegularProduct() {
        RegularProduct regularProduct = new RegularProduct(101, "Regular Item", 100.0);
        assertEquals(10.0, regularProduct.calculateDiscount(), 0.01); // 10% discount
    }

    @Test
    public void testCalculateDiscountPromotionalProduct() {
        PromotionalProduct promotionalProduct = new PromotionalProduct(102, "Promo Item", 100.0);
        assertEquals(20.0, promotionalProduct.calculateDiscount(), 0.01); // 20% discount
    }

    @Test
    public void testCalculateDiscountClearanceProduct() {
        ClearanceProduct clearanceProduct = new ClearanceProduct(103, "Clearance Item", 100.0);
        assertEquals(30.0, clearanceProduct.calculateDiscount(), 0.01); // 30% discount
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPrice() {
        // Attempt to create a product with an invalid negative price
        RegularProduct product = new RegularProduct(101, "Invalid Product", -10.0);
    }

}