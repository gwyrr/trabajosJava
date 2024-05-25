package ProyectoFinalPOO;

import java.util.List;
import java.util.Scanner;

import static ProyectoFinalPOO.Main.*;
import static ProyectoFinalPOO.Usuario.*;

public class Menu {
    public static void mostrarMenu(Usuario usuario, List<Producto> productos, List<Pedido> pedidos, List<Informe> informes) {
        Scanner scanner = new Scanner(System.in);
        String rol = usuario.getRol();

        while (true) {
            System.out.println("\nOpciones:");
            switch (rol.toLowerCase()) {
                case "administrador":
                    System.out.println("1. Agregar producto");
                    System.out.println("2. Modificar producto");
                    System.out.println("3. Eliminar producto");
                    System.out.println("4. Gestionar pedidos");
                    System.out.println("5. Confirmar envios");
                    System.out.println("6. Generar informes");
                    System.out.println("7. Administrar usuarios");
                    System.out.println("8. Ver inventario");
                    System.out.println("9. Salir de la cuenta");
                    System.out.println("0. Salir");
                    break;
                case "almacenero":
                    System.out.println("1. Ver inventario");
                    System.out.println("2. Gestionar pedidos");
                    System.out.println("3. Confirmar envios");
                    System.out.println("9. Salir de la cuenta");
                    System.out.println("0. Salir");
                    break;
                case "contador":
                    System.out.println("1. Ver inventario");
                    System.out.println("2. Generar informes");
                    System.out.println("9. Salir de la cuenta");
                    System.out.println("0. Salir");
                    break;
                default:
                    System.out.println("Usuario no reconocido.");
                    return;
            }

            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0:
                    System.out.println("Finalizando");
                    return;
                case 9:
                    System.out.println("Saliendo de la cuenta");
                    main(new String[0]); // Volver al inicio del programa
                    return;
                default:
                    procesarOpcion(usuario, opcion);
            }
        }
    }

    public static void procesarOpcion(Usuario usuario, int opcion) {
        String rol = usuario.getRol();
        switch (rol.toLowerCase()) {
            case "administrador":
                procesarOpcionAdministrador(opcion);
                break;
            case "almacenero":
                procesarOpcionAlmacenero(opcion);
                break;
            case "contador":
                procesarOpcionContador(opcion);
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }
}
