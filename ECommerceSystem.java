import java.util.ArrayList;
import java.util.List;

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

abstract class Person {
    private int id;
    private String name;
    private String email;
    private List<Order> orders;

    public Person(int id, String name, String email) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void placeOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}

class Customer extends Person {
    public Customer(int id, String name, String email) {
        super(id, name, email);
    }
}

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

class EmployeePhoneNumber {
    private String employeeExtension;
    private String officeNumber;

    void setEmployeeExtension(String arg) {
        employeeExtension = arg;
    }

    String getOfficeNumber() {
        return officeNumber;
    }

    void setOfficeNumber(String arg) {
        officeNumber = arg;
    }

    public String getEmployeeTelephoneNumber() {
        return ("(" + officeNumber + ") " + employeeExtension);
    }
}

class Order {
    private int orderId;
    private Customer customer;
    private List<AbstractProduct> products;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addProduct(AbstractProduct product) {
        products.add(product);
    }

    public List<AbstractProduct> getProducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;
        for (AbstractProduct product : products) {
            total += product.getPrice() - product.calculateDiscount();
        }
        return total;
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Alice", "alice@example.com");
        Customer customer2 = new Customer(2, "Bob", "bob@example.com");

        AbstractProduct product1 = new RegularProduct(101, "Laptop", 799.99);
        AbstractProduct product2 = new RegularProduct(102, "Smartphone", 399.99);

        Order order1 = new Order(201, customer1);
        Order order2 = new Order(202, customer2);

        order1.addProduct(product1);
        order1.addProduct(product2);

        order2.addProduct(product1);

        customer1.placeOrder(order1);
        customer2.placeOrder(order2);

        // Calculate and print the total order amount for customer1
        double totalAmount = 0;
        for (Order order : customer1.getOrders()) {
            totalAmount += order.calculateTotal();
        }
        System.out.println(customer1.getName() + "'s total order amount: $" + totalAmount);
    }
}