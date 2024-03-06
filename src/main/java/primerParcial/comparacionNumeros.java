package primerParcial;
import java.util.Scanner;
public class comparacionNumeros {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int primerNumero = 0;
        int segundoNumero = 0;
        int tercerNumero = 0;

        System.out.println("ingrese su primer numero");
        primerNumero = scanner.nextInt();
        System.out.println("ingrese su segundo numero");
        segundoNumero = scanner.nextInt();
        System.out.println("ingrese su tercer numero");
        tercerNumero = scanner.nextInt();

        if (primerNumero > segundoNumero && primerNumero > tercerNumero && segundoNumero < tercerNumero) {
            System.out.println("El orden es " + segundoNumero + " " + tercerNumero + " " + primerNumero);
        } else if (primerNumero < segundoNumero && segundoNumero > tercerNumero && primerNumero < tercerNumero) {
            System.out.println("El orden es " + primerNumero + " " + tercerNumero + " " + segundoNumero);
        } else if (primerNumero > segundoNumero && segundoNumero < tercerNumero && primerNumero < tercerNumero) {
            System.out.println("El orden es " + segundoNumero + " " + primerNumero + " " + tercerNumero);
        } else if (primerNumero < segundoNumero && segundoNumero > tercerNumero && primerNumero > tercerNumero) {
            System.out.println("El orden es " + tercerNumero + " " + primerNumero + " " + segundoNumero);
        } else if (primerNumero > segundoNumero && segundoNumero > tercerNumero) {
            System.out.println("El orden es " + tercerNumero + " " + segundoNumero + " " + primerNumero);
        } else {
            System.out.println("El orden es " + primerNumero + " " + segundoNumero + " " + tercerNumero);
        }
    }
}
