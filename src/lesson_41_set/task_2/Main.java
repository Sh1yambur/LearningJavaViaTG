package lesson_41_set.task_2;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // :)
        System.out.printf("Found %s unique word(s)", new HashSet<>(List.of(new Scanner(System.in).nextLine().trim().toLowerCase().split(" "))).size());
    }
}
