package lesson_50_stream_1.task_2.part_2;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

// https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82

public class Main {
    public static void main(String[] args) {

    }

    // Упражнение 1.
    // Получите список товаров, относящихся к категории “Книги”, с ценой > 100
    public static List<Product> getListEx1() {
        return Product.getAll().stream()
                .filter(p -> p.getName().equals("Book"))
                .filter(b -> b.getPrice() > 100)
                .collect(Collectors.toList());
    }

    // Упражнение 2.
    // Получить список заказов с товарами, относящимися к категории “Baby”
    public static List<Order> getListEx2() {
        return Order.getAll().stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
                ).collect(Collectors.toList());
    }

    // Упражнение 3.
    // Получите список товаров с категорией = “Игрушки”, а затем примените скидку 10%.
    public static List<Product> getListEx3() {
        return Product.getAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Toy"))
                .map(x -> x.setPrice(x.getPrice() * 0.9))
                .collect(Collectors.toList());
    }

    // Упражнение 4.
    // Получите список продуктов, заказанных клиентом уровня 2 в период с 01 февраля 2021 года по 01 апреля 2021 года
    public static List<Product> getListEx4() {
        LocalDate start = LocalDate.of(2021, 2, 1);
        LocalDate end = LocalDate.of(2021, 4, 1);

        return Order.getAll().stream()
                .filter(o -> o.getCustomer().getTier() == 2)
                .filter(o -> start.compareTo(o.getOrderDate()) * o.getOrderDate().compareTo(end) >= 0)
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    // Упражнение 5.
    // Получите самые дешевые товары категории «Книги»
    // (решение на сайте получает только один первый товар)
    public static Optional<Product> getProductEx5() {
        return Product.getAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Book"))
                .min(Comparator.comparing(Product::getPrice));
    }

    // Упражнение 5.2
    // Получите самые дешевые товары категории «Книги»
    public static List<Product> getListEx52() {
        return Product.getAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Book"))
                .collect(Collectors.groupingBy(Product::getPrice))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList());
    }

    // Упражнение 6.
    // Получите 3 последних размещенных ордера
    public static List<Order> getListEx6() {
        return Order.getAll().stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    // Упражнение 7.
    // Получите список заказов, сделанных 15 марта 2021 г., зарегистрируйте записи заказов в консоли,
    // а затем верните список продуктов.
    public static List<Product> getListEx7() {
        return Order.getAll().stream()
                .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
                .peek(o -> System.out.println(o.getId()))
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    // Упражнение 8.
    // Рассчитайте общую единовременную сумму всех заказов, размещенных в феврале 2021 г.
    public static double getSumEx8() {
        return Order.getAll().stream()
                .filter(o -> !o.getOrderDate().isBefore(LocalDate.of(2021, 2, 1)))
                .filter(o -> o.getOrderDate().isBefore(LocalDate.of(2021, 3, 1)))
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    // Упражнение 9.
    // Расчет среднего платежа по заказу, размещенному 14 марта 2021 г.
    // (это имеено средний платеж по заказу, а не средняя цена товаров во всех заказах, как в решении на сайте)
    public static double getPriceEx9() {
        return Order.getAll().stream()
                .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 14)))
                .flatMapToDouble(o -> DoubleStream.of(
                        o.getProducts().stream()
                                .mapToDouble(Product::getPrice)
                                .sum()
                ))
                .average()
                .orElse(0.0);
    }

    // Упражнение 10.
    // Получите набор статистических данных (т. е. сумма, среднее, максимальное, минимальное, количество)
    // для всех продуктов категории «Книги».
    public static DoubleSummaryStatistics getStatisticsEx10() {
        return Product.getAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Book"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
    }

    // Упражнение 11.
    // Получите карту данных с идентификатором заказа и количеством продуктов в заказе.
    public static Map<Long, Integer> getMapEx11() {
        return Order.getAll()
                .stream()
                .collect(Collectors.toMap(
                                Order::getId,
                                o -> o.getProducts().size()
                        )
                );
    }

    // Упражнение 12.
    // Создайте карту данных с записями заказов, сгруппированными по клиентам.
    public static Map<Customer, List<Order>> getMapEx12() {
        return Order.getAll()
                .stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
    }

    // Упражнение 13.
    // Создайте карту данных с записью заказа и общей суммой продукта.
    public static Map<Order, Double> getMapEx13() {
        return Order.getAll()
                .stream()
                .collect(Collectors.toMap(
                                Function.identity(),
                                o -> o.getProducts()
                                        .stream()
                                        .mapToDouble(Product::getPrice)
                                        .sum()
                        )
                );
    }

    // Упражнение 14.
    // Получите карту данных со списком названий продуктов по категориям
    public static Map<String, List<String>> getMapEx14() {
        return Product.getAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.mapping(Product::getName, Collectors.toList())
                        )
                );
    }

    // Упражнение 15.
    // Найдите самый дорогой продукт по категории
    public static Map<String, Optional<Product>> getMapEx15() {
        return Product.getAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.maxBy(Comparator.comparing(Product::getPrice))
                        )
                );
    }
}
