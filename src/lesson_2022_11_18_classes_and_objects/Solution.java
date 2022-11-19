package lesson_2022_11_18_classes_and_objects;

public class Solution {
    public static void main(String[] args) {
        Counter counterEven = new Counter("Even");
        Counter counterOdd = new Counter("Odd");

        for (int i = 0; i < 111; i++) {
            if (i % 2 == 0) counterEven.countPlusOne();
            else counterOdd.countPlusOne();
        }

        System.out.println(counterEven);
        System.out.println(counterOdd);
    }
}
