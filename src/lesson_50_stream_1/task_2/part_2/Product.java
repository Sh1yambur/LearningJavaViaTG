package lesson_50_stream_1.task_2.part_2;

import java.util.Set;

public class Product {
    private static Set<Product> products;

    private Long id;
    private String name;
    private String category;
    private Double price;
    private Set<Order> orders;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public static Set<Product> getAll() {
        return products;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }
}
