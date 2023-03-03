import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        long num1 = Long.parseLong(input[0]);
        String operator = input[1];
        long num2 = Long.parseLong(input[2]);

        if (Objects.equals(operator, "/") && num2 == 0) {
            System.out.println("Division by 0!");
            return;
        }

        switch (operator) {
            case "+":
                System.out.println(num1 + num2);
                break;
            case "-":
                System.out.println(num1 - num2);
                break;
            case "/":
                System.out.println(num1 / num2);
                break;
            case "*":
                System.out.println(num1 * num2);
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}