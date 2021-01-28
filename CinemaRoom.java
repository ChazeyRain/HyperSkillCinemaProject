package cinema;

import java.util.Scanner;

public class CinemaRoom {
    final int rows;
    final int columns;

    boolean[][] isSeatsTaken;

    private int income = 0;
    private int count = 0;
    /*
    *
    Default constructor
    *
     */
    CinemaRoom() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        columns = scanner.nextInt();

        isSeatsTaken = new boolean[rows][columns];
    }

    /*
    *
    DRAWING CINEMA ROOM
    *
    */
    public void cinemaDraw() {
        System.out.println("Cinema:");
        for (int i = -1; i < rows; i++) {
            // row counter
            System.out.print((i != -1) ? i + 1 : " ");
            for (int j = 0; j < columns; j++) {
                // whitespace before place indicator
                System.out.print(" ");
                // I think that this is a good way to create first row with numbers
                if (i != -1) {
                    // check of an availability of the place
                    if (!isSeatsTaken[i][j]) {
                        System.out.print("S");
                    } else {
                        System.out.print("B");
                    }
                } else {
                    System.out.print(j+1);
                }
            }
            // moving to the next row
            System.out.println();
        }
    }

    /*
    *
    RESERVATIONS
    *
     */
    public void reserve() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a row number:");
        int row = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int column = scanner.nextInt();

        if (row > rows || column > columns) {
            System.out.println("Wrong input!");
            reserve();
        } else if (isSeatsTaken[row - 1][column - 1]) {
            System.out.println("That ticket has already been purchased!");
            reserve();
        } else {
            isSeatsTaken[row - 1][column - 1] = true;
            System.out.printf("Ticket price: $%d\n", seatPrice(row));
            income += seatPrice(row);
            count++;
        }
    }

    /*
    *
    Max income counter
    *
     */
    public int maxIncome () {
        int income;
        int ticketPrice = 10;
        int cheapTicketPrice = 8;

        if (rows * columns <= 60) {
            income = rows * columns * ticketPrice;
        } else {
            income = (rows / 2 * ticketPrice + (rows + 1) / 2 * cheapTicketPrice) * columns;
        }
        return income;
    }

    /*
    *
    SEAT PRICE
    *
     */
    private int seatPrice(int row) {
        int price;

        if (rows * columns <= 60 || row <= rows/2) {
            price = 10;
        } else {
            price = 8;
        }
        return price;
    }
    /*
    *
    * STATISTICS
    *
     */
    public void cinemaStats() {
        float percentage = (float)count * 100 / (float)(rows * columns);
        System.out.printf("Number of purchased tickets: %d\n", count);
        System.out.printf("Percentage: %.2f%% \n", percentage);
        System.out.printf("Current income: $%d\n", income);
        System.out.printf("Total income: $%d\n", maxIncome());
        System.out.println();
    }
}
