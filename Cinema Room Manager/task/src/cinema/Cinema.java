package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] seatingGrid = seatingGridBuilder();

        int input = runMenu();

        while (input != 0) {
            if (input == 1) {
                seatingGridPrinter(seatingGrid);
            } else if (input == 2) {
                seatingGrid = buyATicket(seatingGrid);
            } else if (input == 3) {
                showStatistics(seatingGrid);
            }

            input = runMenu();
        }
    }

    public static int calculateTicketPrice(String[][] seatingGrid, int rowNumber) {
        int rows = seatingGrid.length;
        int totalSeats = rows * seatingGrid[0].length;

        int ticketPrice = 0;

        if (totalSeats < 60) {
            ticketPrice = 10;
        } else {
            if (rowNumber <= (rows / 2)) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }

        return ticketPrice;
    }

    public static String[][] buyATicket(String[][] seatingGrid) {
        Scanner scanner = new Scanner(System.in);
        boolean ticketPurchased = false;

        int rows = seatingGrid.length;

        while (!ticketPurchased) {

            System.out.println("\nEnter a row number:");
            int rowNumber = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seatNumberInRow = scanner.nextInt();

            if (rowNumber > rows || seatNumberInRow > seatingGrid[0].length) {
                System.out.println("Wrong input!");
                continue;
            }

            int ticketPrice = calculateTicketPrice(seatingGrid, rowNumber);

            System.out.println("Ticket price: $" + ticketPrice);

            if (seatingGrid[rowNumber - 1][seatNumberInRow - 1].equals("B")) {
                System.out.println("That ticket has already been purchased!");
            } else {
                seatingGrid[rowNumber - 1][seatNumberInRow - 1] = "B";
                ticketPurchased = true;
            }
        }
        return seatingGrid;
    }

    public static int runMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                    1. Show the Seats
                    2. Buy a ticket
                    3. Statistics
                    0. Exit
                    """);

        return scanner.nextInt();
    }

    public static String[][] seatingGridBuilder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        String[][] seatingGrid = new String[rows][seatsPerRow];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(seatingGrid[i], "S");
        }

        return seatingGrid;
    }
    public static void seatingGridPrinter(String[][] seatingGrid) {

        int rows = seatingGrid.length;
        int seatsPerRow = seatingGrid[0].length;

        StringBuilder seating = new StringBuilder("""
                \nCinema:
                \s""");

        for (int i = 1; i <= seatsPerRow; i++) {
            seating.append(" ").append(i);
        }

        for (int row = 0; row < rows; row++) {
            seating.append("\n");
            for (int seat = 0; seat <= seatsPerRow; seat++) {
                if (seat == 0) {
                    seating.append(row + 1);
                } else {
                    seating.append(" ").append(seatingGrid[row][seat - 1]);
                }
            }
        }

        System.out.println(seating);
    }

    public static void showStatistics(String[][] seatingGrid) {
        int rows = seatingGrid.length;
        int seatsPerRow = seatingGrid[0].length;
        int totalSeats = rows * seatsPerRow;
        int purchasedTickets = 0;
        float percentageOfPurchasedTickets = 0;
        int currentTicketIncome = 0;
        int totalTicketIncome = 0;

        for (int row = 0; row < rows; row++) {
            for (int seat = 0; seat < seatsPerRow; seat++) {
                totalTicketIncome += calculateTicketPrice(seatingGrid, row + 1);
                if (seatingGrid[row][seat].equals("B")) {
                    purchasedTickets++;
                    currentTicketIncome += calculateTicketPrice(seatingGrid, row + 1);
                }
            }
        }


        percentageOfPurchasedTickets = (float)purchasedTickets / totalSeats * 100;

        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.println("Percentage: " + String.format("%.2f"  , percentageOfPurchasedTickets) + "%");
        System.out.println("Current income: $" + currentTicketIncome);
        System.out.println("Total income: $" + totalTicketIncome);


    }
}