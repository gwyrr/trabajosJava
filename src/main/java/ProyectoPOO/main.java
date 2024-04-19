package ProyectoPOO;

import java.time.LocalDate;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Que deseas realizar?:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro por titulo");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Realizar prestamo");
            System.out.println("6. Devolver libro");
            System.out.println("7. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarNuevoLibro(libreria, scanner);
                    break;
                case 2:
                    buscarLibroPorTitulo(libreria, scanner);
                    break;
                case 3:
                    buscarLibroPorAutor(libreria, scanner);
                    break;
                case 4:
                    libreria.mostrarInventario();
                    break;
                case 5:
                    realizarPrestamo(libreria, scanner);
                    break;
                case 6:
                    devolverLibroPrestado(libreria, scanner);
                    break;
                case 7:
                    System.out.println("Gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("Ingresa una opcion valida");
            }
        } while (opcion != 7);
    }
    public static void realizarPrestamo(Libreria libreria, Scanner scanner) {
        System.out.println("Ingrese el titulo del libro a prestar:");
        String titulo = scanner.nextLine();
        Libro libro = libreria.buscarTitulo(titulo);
        if (libro != null) {
            System.out.println("Ingrese el nombre del usuario:");
            String nombreUsuario = scanner.nextLine();
            System.out.println("Ingrese el correo electronico del usuario:");
            String correoUsuario = scanner.nextLine();
            System.out.println("Ingrese la direccion del usuario:");
            String direccionUsuario = scanner.nextLine();
            Prestamo.Usuario usuario = new Prestamo.Usuario(nombreUsuario, correoUsuario, direccionUsuario);
            Prestamo prestamo = new Prestamo(LocalDate.now(), usuario, libro);
            // Agregar el prestamo a la lista de prestamos
            libreria.realizarPrestamo(prestamo);
            System.out.println("Prestamo realizado con exito");
        } else {
            System.out.println("El libro no esta disponible en la libreria");
        }
    }

    public static void devolverLibroPrestado(Libreria libreria, Scanner scanner) {
        System.out.println("Ingrese el titulo del libro a devolver:");
        String titulo = scanner.nextLine();
        Libro libro = libreria.buscarTitulo(titulo);
        if (libro != null) {
            // Buscar el prestamo correspondiente al libro
            Prestamo prestamo = libreria.buscarPrestamo(libro);
            if (prestamo != null) {
                prestamo.setFechaDevolucion(LocalDate.now());
                // Eliminar el prestamo de la lista de prestamos de la libreria
                libreria.devolverLibroPrestado(prestamo);
                System.out.println("Libro devuelto con exito");
            } else {
                System.out.println("El libro no se encuentra prestado");
            }
        } else {
            System.out.println("El libro no esta disponible en la libreria");
        }
    }

    public static void agregarNuevoLibro(Libreria libreria, Scanner scanner) {
        System.out.println("Ingrese los siguientes datos");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Editorial: ");
        String editorial = scanner.nextLine();
        System.out.print("Anho de publicacion: ");
        int anioPublicacion = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        Libro libroNuevo = new Libro(titulo, autor, isbn, editorial, anioPublicacion, precio);
        libreria.agregarLibro(libroNuevo);
        System.out.println("El libro se agrego");
    }

    public static void buscarLibroPorTitulo(Libreria libreria, Scanner scanner) {
        System.out.print("Que libro desea buscar? ");
        String titulo = scanner.nextLine();
        Libro libroEncontrado = libreria.buscarTitulo(titulo);
        if (libroEncontrado != null) {
            System.out.println("El libro esta en inventario");
            System.out.println(libroEncontrado);
        } else {
            System.out.println("El libro no se encuentra en el inventario");
        }
    }

    public static void buscarLibroPorAutor(Libreria libreria, Scanner scanner) {
        System.out.print("Ingrese nombre del autor");
        String autor = scanner.nextLine();
        Libro libroEncontrado = libreria.buscarAutor(autor);
        if (libroEncontrado != null) {
            System.out.println("El libro esta en el inventario");
            System.out.println(libroEncontrado);
        } else {
            System.out.println("No se encontraron libros del autor");
        }
    }

}
