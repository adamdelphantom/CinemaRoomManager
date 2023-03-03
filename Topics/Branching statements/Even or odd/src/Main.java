import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextLine();

        while (!input.equals("0")) {
            if (Integer.parseInt(input) % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
            input = scanner.nextLine();
        }
    }
}