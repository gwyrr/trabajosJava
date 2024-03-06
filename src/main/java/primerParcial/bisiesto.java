package primerParcial;

import java.util.Scanner;

public class bisiesto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = 0;

        System.out.println("enter the year to verify");
        year = scanner.nextInt();

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("the year " +year+ " is leap year");
        } else {
            System.out.println("the year " +year+ " is not a leap year");
        }
    }
}
