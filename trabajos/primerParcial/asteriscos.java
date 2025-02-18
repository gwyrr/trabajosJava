package primerParcial;

import java.util.Scanner;

public class asteriscos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamano = 1;
        int cantidad = 0;

        System.out.println("ingresa la cantidad de asteriscos");
        cantidad = scanner.nextInt();

        while (tamano <= cantidad) {
            int asteriscos = 1;
            while (asteriscos <= tamano){
                System.out.print("*");
                asteriscos++;
            }
            System.out.println();
            tamano++;
        }
        scanner.close();
    }
}
