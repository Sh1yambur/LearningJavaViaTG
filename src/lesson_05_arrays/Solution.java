package lesson_05_arrays;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //printName();
        printSum();
        //printSimpleNumbers(20);
    }

    // task #1
    private static void printName() {
        char[] arr = {'V', 'a', 's', 'y', 'a'};

        for (char c : arr) System.out.print(c);

        String name = "\n";
        for (char c : arr) name += c;
        System.out.println(name);
    }

    // task #2
    private static void printSum() {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Input arr[%d]: ", i);
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            int sum;
            if (i == 0) sum = arr[i] + arr[arr.length - 1];
            else sum = arr[i] + arr[i - 1];
            System.out.println(sum);
        }
    }

    // task #3(*)
    private static void printSimpleNumbers(int amountSimpleNumbers) {
        int[] array = new int[amountSimpleNumbers];
        int number = 2;

        for (int i = 0; i < array.length; i++) {
            while (true) {
                boolean isSimple = true;

                for (int divider = 2; divider < number; divider++) {
                    if (number % divider == 0) isSimple = false;
                }

                if (isSimple) break;
                number++;
            }
            array[i] = number;
            number++;
        }

        int sum = 0;
        for (int n : array) {
            System.out.print(n + " ");
            sum += n;
        }
        System.out.println("\nsum = " + sum);
    }
}
