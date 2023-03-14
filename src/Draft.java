import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Draft {
    public static void main(String[] args) {
        Stream.iterate(1, i -> ++i)
                .limit(10)
                .forEach(System.out::print);
    }

    private static void printPrimeNumbers(int end) {
        LinkedList<Integer> nums = IntStream.rangeClosed(2, end)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        IntStream.rangeClosed(2, Double.valueOf(Math.sqrt(nums.getLast())).intValue())
                .forEach(n -> nums.removeIf(i -> i % n == 0 && n != i));

        nums.stream()
                .map(n -> n + " ")
                .forEach(System.out::print);
    }

    private static boolean printIsBetween(Integer target, Integer begin, Integer end) {
        return begin.compareTo(target) * target.compareTo(end) >= 0;
    }
}