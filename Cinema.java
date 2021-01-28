package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final CinemaRoom myCinema = new CinemaRoom();
        System.out.println();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            switch (scanner.nextInt()) {
                case 1:
                    myCinema.cinemaDraw();
                    break;
                case 2:
                    myCinema.reserve();
                    break;
                case 3:
                    myCinema.cinemaStats();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }
}