package primerParcial;

import java.util.Scanner;

//Escribir un programa que encuentre el producto de todos los números pares en un vector de
//enteros.
public class vectorPares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamanho = 0;

        System.out.println("Digite el tamano del vector");
        tamanho = scanner.nextInt();
        int[] vectorPares = new int[tamanho];

        for (int i = 0; i < vectorPares.length; i++) {
            System.out.print("Digite el valor de la posicion " + i + ": ");
            vectorPares[i] = scanner.nextInt();
        }
        System.out.println("Los numeros pares son: ");
        for (int i = 0; i < vectorPares.length; i++) {
            if (vectorPares[i] % 2 == 0) {
                System.out.println(vectorPares[i]);
            }
        }
    }
}