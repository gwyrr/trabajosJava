package primerParcial;
import java.util.Random;
import java.util.Scanner;


public class sumaAleatoria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int primerNumero = random.nextInt(10) + 1;
        int segundoNumero = random.nextInt(10) + 1;
        int Solucion = 0;
        int Respuesta = 0;

        System.out.println("Hola bienvenido a las practicas de sumas basicas");
        System.out.println(primerNumero + " + " +segundoNumero);
        System.out.println("¿Cual es la respuesta?");

        boolean Stop = false;
        while (!Stop){
        Respuesta = scanner.nextInt();
        Solucion = primerNumero+segundoNumero;
            if (Respuesta == Solucion) {
                System.out.println("muy bien");
                Stop = true;
            } else {
                System.out.println("sigue intentando");
            }
            }
    }
}
