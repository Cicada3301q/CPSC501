// Step 1: Create an abstract base class or interface for products.
abstract class AbstractProduct {
    private int id;
    private String name;
    private double price;

    public AbstractProduct(int id, String name, double price) {
        setId(id);
        setName(name);
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
    }

    // Step 3: Declare an abstract method for calculating discounts.
    public abstract double calculateDiscount();
}

// Step 2: Create concrete subclasses for each product type.
class RegularProduct extends AbstractProduct {
    public RegularProduct(int id, String name, double price) {
        super(id, name, price);
    }

    // Step 3: Implement the discount calculation logic for regular products.
    @Override
    public double calculateDiscount() {
        // Apply 10% discount for regular products.
        return getPrice() * 0.1;
    }
}

class PromotionalProduct extends AbstractProduct {
    public PromotionalProduct(int id, String name, double price) {
        super(id, name, price);
    }

    // Step 3: Implement the discount calculation logic for promotional products.
    @Override
    public double calculateDiscount() {
        // Apply 20% discount for promotional products.
        return getPrice() * 0.2;
    }
}

class ClearanceProduct extends AbstractProduct {
    public ClearanceProduct(int id, String name, double price) {
        super(id, name, price);
    }

    // Step 3: Implement the discount calculation logic for clearance products.
    @Override
    public double calculateDiscount() {
        // Apply 30% discount for clearance products.
        return getPrice() * 0.3;
    }
}