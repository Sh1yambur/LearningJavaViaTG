package lesson_2022_11_18_classes_and_objects;

/*
 * Реализовать класс-счетчик. Полями класса должны выступать название счетчика и, непосредственно, целочисленный счетчик.
 * Реализовать для созданного класса конструктор с двумя параметрами,
 * с одним (значение счетчика в таком случае инициализировать как 0),
 * методы увеличения и уменьшения счетчиков на 1 и на заданное пользователем целом значение.
 * Методы должны возвращать актуальное значение счетчика.
 * Используя созданный класс, посчитать количество четных и количество нечетных чисел в ряду от 1 до 100.
 * Конечные показатели счетчиков вывести в консоль.
 */

public class Counter {
    private final String name;
    private int count;

    public Counter(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public Counter(String name) {
        this(name, 0);
    }

    public int countPlus(int value) {
        this.count += value;
        return this.count;
    }

    public int countPlusOne() {
        return countPlus(1);
    }

    public int countMinus(int value) {
        this.count--;
        return this.count;
    }

    public int countMinusOne() {
        return countMinus(1);
    }

    public int getCount() {
        return this.count;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Counter %s: %d", this.name, this.count);
    }
}
