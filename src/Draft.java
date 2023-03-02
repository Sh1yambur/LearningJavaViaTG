import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Draft {
    public static void main(String[] args) {
        Integer a = 4;
        Integer b = 10;
        Integer d = 9;
        //System.out.println(a.compareTo(d) * d.compareTo(b) >= 0);

        // 10. Sieve of Eratosthenes / prime numbers
        LinkedList<Integer> nums = IntStream.rangeClosed(2, 100)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        IntStream.rangeClosed(2, Double.valueOf(Math.sqrt(nums.getLast())).intValue())
                .forEach(n -> nums.removeIf(i -> i % n == 0 && n != i));

        nums.stream()
                .map(n -> n + " ")
                .forEach(System.out::print);

    }
}