import java.util.ArrayList;
import java.util.List;

class Product {
    private int id;
    private String name;
    private double price;
    private String type;

    public Product(int id, String name, double price, String type) {
        setId(id);
        setName(name);
        setPrice(price);
        setType(type);
        this.id = id;
        this.name = name;
        if (price < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
        if (type != "Regular" && type != "Promotional" && type != "Clearance") {
            throw new IllegalArgumentException("Invalid discount type");
        }
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double calculateDiscount() {
        double discount = 0;
        if ("Regular".equals(type)) {
            // Apply 10% discount for regular products.
            discount = price * 0.1;
        } else if ("Promotional".equals(type)) {
            // Apply 20% discount for promotional products.
            discount = price * 0.2;
        } else if ("Clearance".equals(type)) {
            // Apply 30% discount for clearance products.
            discount = price * 0.3;
        }
        return discount;
    }

}

class Customer {

    private int customerId;
    private String name;
    private String email;
    private List<Order> orders;

    public Customer(int customerId, String name, String email) {
        if (customerId < 0) {
            throw new IllegalArgumentException("Customer ID cannot be negative");
        }
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
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

class Employee {
    private int EmployeeId;
    private String name;
    private String email;
    private List<Order> orders;

    public Employee(int employeeId, String name, String email) {
        this.EmployeeId = employeeId;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private String employeeExtension;
    private String officeNumber;

    public String getEmployeeTelephoneNumber() {
        return ("(" + officeNumber + ") " + employeeExtension);
    }

    void setEmployeeExtension(String arg) {
        employeeExtension = arg;
    }

    String getOfficeNumber() {
        return officeNumber;
    }

    void setOfficeNumber(String arg) {
        officeNumber = arg;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}

class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;

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

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() - product.calculateDiscount();
        }
        return total;
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Alice", "alice@example.com");
        Customer customer2 = new Customer(2, "Bob", "bob@example.com");

        Product product1 = new Product(101, "Laptop", 799.99, "Regular");
        Product product2 = new Product(102, "Smartphone", 399.99, "Regular");

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