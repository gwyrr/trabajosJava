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
                    System.out.println("1. Agregar producto\n" +
                            "2. Modificar producto\n" +
                            "3. Eliminar producto\n" +
                            "4. Gestionar pedidos\n" +
                            "5. Confirmar envios\n" +
                            "6. Generar informes\n" +
                            "7. Administrar usuarios\n" +
                            "8. Ver inventario\n" +
                            "9. Salir de la cuenta\n" +
                            "0. Salir\n");
                    break;
                case "almacenero":
                    System.out.println("1. Ver inventario\n" +
                            "2. Gestionar pedidos\n" +
                            "3. Confirmar envios\n" +
                            "9. Salir de la cuenta\n" +
                            "0. Salir\n");
                    break;
                case "contador":
                    System.out.println("1. Ver inventario\n" +
                            "2. Generar informes\n" +
                            "9. Salir de la cuenta\n" +
                            "0. Salir\n");
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
