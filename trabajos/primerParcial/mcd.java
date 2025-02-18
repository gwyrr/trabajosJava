package primerParcial;

import java.util.Scanner;

public class mcd {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero positivo: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingrese otro número entero positivo: ");
        int num2 = scanner.nextInt();

        int mcd = calcularMCD(num1, num2);

        System.out.println("El MCD de los dos numeros es: " + mcd);
    }

    private static int calcularMCD(int num1, int num2) {
        while (num2 != 0) {
            int resto = num1 % num2;
            num1 = num2;
            num2 = resto;
        }
        return num1;
    }
}