import java.util.ArrayList;
import java.util.List;

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