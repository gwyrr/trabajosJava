package primerParcial;

import java.util.Scanner;

public class vectorMayor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamanho = 0;
        int mayor = 0;

        System.out.println("Digite el tamano del vector");
        tamanho = scanner.nextInt();
        int[] vectorMayor = new int[tamanho];

        
        for (int i = 0; i < vectorMayor.length; i++) {
            System.out.print("Digite el valor de la posicion " + i + ": ");
            vectorMayor[i] = scanner.nextInt();
        }
        for (int i = 0; i < vectorMayor.length; i++) {
            if (vectorMayor[i] > mayor) {
                mayor = vectorMayor[i];
            }
        }
        System.out.println("El numero mayor es el: " + mayor);
    }
}
