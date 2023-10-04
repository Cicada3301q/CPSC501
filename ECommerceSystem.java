
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