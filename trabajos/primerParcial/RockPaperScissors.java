package primerParcial;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int jugador, pc;
        System.out.println("juguemos piedra papel o tijera");
        System.out.println("1. Piedra");
        System.out.println("2. Papel");
        System.out.println("3. tijera");
        jugador = scanner.nextInt();
        scanner.nextLine();
        if (jugador < 1 || jugador > 3){
            System.out.println("Opcion no valida");
        } while (jugador < 1 || jugador > 3);
        pc = random.nextInt(3)+1;

        if (jugador == 1){
            System.out.println("el jugador eligio piedra");
        }
        if (jugador == 2){
            System.out.println("el jugador eligio papel");
        }
        if (jugador == 3){
            System.out.println("el jugador eligio tijera");
        }
        if (pc == 1){
            System.out.println("la maquina eligio piedra");
        }
        if (pc == 2){
            System.out.println("la maquina eligio papel");
        }
        if (pc == 3){
            System.out.println("la maquina eligio tijera");
        }
        if (jugador == pc){
            System.out.println("empate");
        }
        if((jugador == 1 && pc == 3)||(jugador == 2 && pc == 1)||(jugador == 3 && pc == 2)){
            System.out.println("El jugador gana");
        }
        if((jugador == 3 && pc == 1)||(jugador == 1 && pc == 2)||(jugador == 2 && pc == 3)) {
            System.out.println("la maquina gana");
        }
    }
}
