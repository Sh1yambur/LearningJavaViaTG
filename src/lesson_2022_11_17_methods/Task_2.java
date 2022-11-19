package lesson_2022_11_17_methods;

/*
 * Реализовать методы «вычисления суммы» для всех примитивных типов, кроме void. Возвращать:
 * Для числовых типов — тот же тип. Даже если это ведет к потере точности.
 * При угрозе потери данных — выводить сообщение в консоль и возвращать текущий результат (для byte, short, int);
 * Для boolean — определение истинности всех переданных параметров, принимая то, что их стоит объединять через логическое И;
 * Для char — строку, полученную в результате конкатенации всех переданных параметров.
 * Количество параметров может быть любым. Используйте перегрузку — у всех методов должны быть одинаковые названия.
 * Примечание: это задача без вариантов, методы для всех типов должны быть реализованы в одной программе.
 */
public class Task_2 {
    public static void execute() {
        boolean a1 = true, a2 = true;
        System.out.println(getSum(a1, a2));

        byte b1 = 120, b2 = 8;
        System.out.println(getSum(b1, b2));

        short c1 = 32000, c2 = 1000;
        System.out.println(getSum(c1, c2));

        char d1 = 'f', d2 = 'o';
        System.out.println(getSum(d1, d2));

        int e1 = 2_000_000_000, e2 = 1_000_000_000;
        System.out.println(getSum(e1, e2));

        long f1 = 3812382182382138183L, f2 = 2348234237743424433L;
        System.out.println(getSum(f1, f2));

        float g1 = 42.567f, g2 = 234.389f;
        System.out.println(getSum(g1, g2));

        double h1 = 2342.32, h2 = 324.4232;
        System.out.println(getSum(h1, h2));
    }

    private static boolean getSum(boolean a, boolean b) {
        return a && b;
    }

    private static byte getSum(byte a, byte b) {
        int sum = a + b;
        if (sum > Byte.MAX_VALUE || sum < Byte.MIN_VALUE) {
            System.out.print("Value out of Byte! ");
        }
        return (byte) sum;
    }

    private static short getSum(short a, short b) {
        int sum = a + b;
        if (sum > Short.MAX_VALUE || sum < Short.MIN_VALUE) {
            System.out.print("Value out of Short! ");
        }
        return (short) sum;
    }

    private static String getSum(char a, char b) {
        return a + "" + b;
    }

    private static int getSum(int a, int b) {
        return a + b;
    }

    private static long getSum(long a, long b) {
        return a + b;
    }

    private static float getSum(float a, float b) {
        double sum = a + b;
        if (sum > Float.MAX_VALUE || sum < Float.MIN_VALUE) {
            System.out.print("Value out of Float! ");
        }
        return (float) sum;
    }

    private static double getSum(double a, double b) {
        return a + b;
    }
}
