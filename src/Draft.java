import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Draft {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            String input = getInput();

            if (input.equals("q")) {
                System.out.println("quit");
                return;
            }

            System.out.printf("result ==> %d%n", calculate(parseNumbers(input)));
        }
    }

    private static String getInput() {
        System.out.print("input  <== ");
        return SCANNER.nextLine().trim();
        // need check correct input
    }

    private static String[] parseNumbers(String input) {
        String pattern = "[+\\-/*]";
        String[] characters = new String[3];
        System.arraycopy(input.split(pattern), 0, characters, 0, 2);
        characters[2] = input.replace(characters[0], "").replace(characters[1], "");

        return characters;
    }

    private static BinaryOperator<Integer> getOperator(String operation) {
        return switch (operation) {
            case "+" -> (a, b) -> a + b;
            case "-" -> (a, b) -> a - b;
            case "*" -> (a, b) -> a * b;
            case "/" -> (a, b) -> a / b;
            default -> (a, b) -> 0;
        };
    }

    private static int calculate(String[] operands) {
        return getOperator(operands[2]).apply(Integer.parseInt(operands[0]), Integer.parseInt(operands[1]));
    }
}