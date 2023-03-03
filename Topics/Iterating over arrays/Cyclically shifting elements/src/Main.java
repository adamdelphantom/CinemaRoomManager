import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLength = scanner.nextInt();
        int[] output = new int[inputLength];

        for (int i = 0; i < inputLength; i++) {
            int nextInt = scanner.nextInt();
            if (i + 1 == inputLength) {
                output[0] = nextInt;
            } else {
                output[i + 1] = nextInt;
            }
        }

        for (int number :
                output) {
            System.out.print(number + " ");
        }
    }
}