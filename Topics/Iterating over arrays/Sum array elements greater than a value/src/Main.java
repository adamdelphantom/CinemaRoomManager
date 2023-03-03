import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int output = 0;

        Scanner scanner = new Scanner(System.in);

        int inputLength = Integer.parseInt(scanner.nextLine());

        int[] input = new int[inputLength];
        for (int i = 0; i < inputLength; i++) {
            input[i] = scanner.nextInt();
        }

        var _dummy = scanner.nextLine();
        int minValueToSum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputLength; i++) {
            if (input[i] > minValueToSum) {
                output += input[i];
            }
        }

        System.out.println(output);
    }
}