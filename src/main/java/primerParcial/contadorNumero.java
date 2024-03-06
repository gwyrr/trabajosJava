package primerParcial;

import java.util.Scanner;
public class contadorNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero positivo: ");
        int numero = scanner.nextInt();

        System.out.print("Ingrese un digito: ");
        int digito = scanner.nextInt();

        int contador = contarApariciones(numero, digito);

        System.out.println("El digito " + digito + " aparece " + contador + " veces en el número ingresado.");
    }

    private static int contarApariciones(int numero, int digito) {
        int contador = 0;
        while (numero > 0) {
            if (numero % 10 == digito) {
                contador++;
            }
            numero /= 10;
        }
        return contador;
    }

}
