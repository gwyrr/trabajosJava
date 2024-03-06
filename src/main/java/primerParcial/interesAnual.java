package primerParcial;

import java.util.Scanner;
//Desarrolla un programa en Java que permita calcular el monto final de una inversión
//después de un cierto número de años, utilizando la fórmula de interés compuesto. El
//programa debe pedir al usuario ingresar la cantidad inicial invertida, la tasa de interés anual
//y el número de años. Luego, muestra el monto final.*/
public class interesAnual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inversion, interes, interesFinal, inversionFinal;
        int anhos;

        System.out.println("Ingrese la inversion");
        inversion = scanner.nextDouble();
        System.out.println("Ingrese el interes");
        interes = scanner.nextDouble();
        System.out.println("Ingrese los anhos");
        anhos = scanner.nextInt();

        interesFinal = inversion * Math.pow(1 + interes, anhos);
        inversionFinal = interesFinal + inversion;
        System.out.println("La inversion final sera: $" + inversionFinal);
        System.out.println("El interes generado es: $" + interesFinal);
    }
}
