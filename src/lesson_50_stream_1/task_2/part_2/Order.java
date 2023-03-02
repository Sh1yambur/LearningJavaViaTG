package lesson_50_stream_1.task_2.part_2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Order {
    private static Set<Order> orders;

    private Long id;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;
    private Customer customer;
    private final Set<Product> products = new HashSet<>();

    public Long getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public static Set<Order> getAll() {
        return orders;
    }

    public void addProduct(Product... prods) {
        this.products.addAll(Arrays.asList(prods));
    }
}
