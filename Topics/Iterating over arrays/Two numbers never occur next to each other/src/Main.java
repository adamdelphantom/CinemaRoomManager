import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String length = scanner.nextLine();
        int lengthInt = Integer.parseInt(length);

        String input = scanner.nextLine();
        String[] splitInputArray = input.split(" ");
        int[] intInputArray = new int[splitInputArray.length];
        for (int i = 0; i < splitInputArray.length; i++) {
            intInputArray[i] = Integer.parseInt(splitInputArray[i]);
        }

        String valuesToCheck = scanner.nextLine();
        String[] splitValuesArray = valuesToCheck.split(" ");
        int[] intValuesArray = new int[splitValuesArray.length];
        for (int i = 0; i < splitValuesArray.length; i++) {
            intValuesArray[i] = Integer.parseInt(splitValuesArray[i]);
        }

        for (int i = 0; i < lengthInt - 1; i++) {
            if (intValuesArray[0] == intInputArray[i]) {
                if (intValuesArray[1] == intInputArray[i + 1]) {
                    System.out.println("false");
                    return;
                }
            } else if (intValuesArray[1] == intInputArray[i]) {
                if (intValuesArray[0] == intInputArray[i + 1]) {
                    System.out.println("false");
                    return;
                }
            }
        }

        System.out.println("true");
    }
}