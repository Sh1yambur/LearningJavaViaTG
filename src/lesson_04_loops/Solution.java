package lesson_04_loops;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Input number: ");
//        int in = sc.nextInt();

        printSumOrDiv(5);
    }

    // task #1
    private static long factorial(int num) {
        if (num <= 1) return 1;
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    // task #2
    private static int getSumNum(int num) {
        int result = 0;

        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        result += num;
        return result;
    }

    // task #3
    private static void printRectangle(int width, int height) {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                boolean isTopOrBottom = (h == 0 || h == height - 1);
                boolean isSide = (w == 0 || w == width - 1);
                boolean isCorner = isTopOrBottom && isSide;

                if (isCorner) System.out.print(" ");
                else if (isTopOrBottom) System.out.print("-");
                else if (isSide) System.out.print("|");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    // task #4
    private static void printSumOrDiv(int numTwo) {
        for (int numOne = 1; numOne <= 10; numOne++) {
            if (numOne % 2 == 0) System.out.printf("%d + %d = %d\n", numOne, numTwo, numOne + numTwo);
            else System.out.printf("%d - %d = %d\n", numOne, numTwo, numOne - numTwo);

            if (numOne == numTwo) System.out.println("Numbers is equal!");
        }
    }

    // task #5
    private static void printNotGuessed(Scanner sc) {
        while (true) {
            System.out.print("Input number: ");
            int num = sc.nextInt();
            if (num == 1) {
                System.out.println("Good bye");
                break;
            } else System.out.println("Don't guessed!");
        }
    }
}
