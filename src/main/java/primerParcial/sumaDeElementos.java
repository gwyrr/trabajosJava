package primerParcial;
import java.util.Scanner;

//Escribir un programa que calcule la suma de todos los elementos en un vector de enteros.
public class sumaDeElementos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamanho, total = 0;
        String conc = "";

        System.out.println("Digite el tamano del vector");
        tamanho = scanner.nextInt();
        int []vectorSuma = new int [tamanho];

        for (int i = 1; i < vectorSuma.length; i++) {
            System.out.print("Digite el valor de la posicion " + i + ": ");
            vectorSuma[i] = scanner.nextInt();
        }
        for (int i = 0; i < vectorSuma.length; i++) {
           // System.out.println(conc + " | " + vectorSuma[i]);
            conc = conc + " | " + vectorSuma[i];
            total = total + vectorSuma[i];
        }
        System.out.println("Los datos del vector son  " + conc);
        System.out.println("La suma del vector son  "+ total);
    }
}
