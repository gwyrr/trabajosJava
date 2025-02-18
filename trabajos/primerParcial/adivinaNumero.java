package primerParcial;
import java.util.Random;
import java.util.Scanner;


public class adivinaNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        int intentos = 0;
        int intentoUsuario;

        System.out.println("Hola juguemos a adivinar el numero");
        do {
            System.out.println("intenta adivinar el numero del 1 al 100");
            intentoUsuario = scanner.nextInt();
            intentos++;

            if (intentoUsuario < numeroAleatorio) {
                System.out.println("El numero es mayor");
            } else if (intentoUsuario > numeroAleatorio) {
                System.out.println("El numero es menor");
            }
        } while (intentoUsuario != numeroAleatorio);

        System.out.println("felicidades adivinaste el numero " + numeroAleatorio + " en el intento " + intentos);
    }
}
