import java.util.ArrayList;
import java.util.List;

public class Order {
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