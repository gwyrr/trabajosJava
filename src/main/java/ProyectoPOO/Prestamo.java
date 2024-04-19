package ProyectoPOO;

import java.time.LocalDate;
import java.util.Scanner;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Usuario usuario;
    private Libro libroPrestado;

    public static class Usuario {
        private String nombre;
        private String correoElectronico;
        private String direccion;

        public Usuario(String nombre, String correo, String direccion) {
            this.nombre = nombre;
            this.correoElectronico = correo;
            this.direccion = direccion;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCorreoElectronico() {
            return correoElectronico;
        }

        public void setCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        @Override
        public String toString() {
            return "Usuario: " +
                    "nombre: " + nombre + '\'' +
                    ", correo electronico: " + correoElectronico + '\'' +
                    ", direccion: " + direccion + '\'';
        }
    }

    public Prestamo(LocalDate fechaPrestamo, Usuario usuario, Libro libroPrestado) {
        this.fechaPrestamo = fechaPrestamo;
        this.usuario = usuario;
        this.libroPrestado = libroPrestado;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Libro libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    @Override
    public String toString() {
        return "Prestamo" +
                "Fecha de prestamo=" + fechaPrestamo +
                ", Fecha de devolucion=" + fechaDevolucion +
                ", Usuario=" + usuario +
                ", Libro prestado=" + libroPrestado;
    }
    public void realizarPrestamo(Libreria libreria, Scanner scanner) {
        System.out.println("Que libro desea prestar:");
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

            libreria.realizarPrestamo(prestamo);
            System.out.println("Prestamo realizado con exito.");
        } else {
            System.out.println("El libro no esta disponible en la libreria.");
        }
    }

    public static void devolverLibroPrestado(Libreria libreria, Scanner scanner) {
        System.out.println("Ingrese el titulo del libro a devolver:");
        String titulo = scanner.nextLine();
        Libro libro = libreria.buscarTitulo(titulo);
        if (libro != null) {
            // Buscar el prestamo del libro
            Prestamo prestamo = libreria.buscarPrestamo(libro);
            if (prestamo != null) {
                prestamo.setFechaDevolucion(LocalDate.now());
                // Eliminar el prestamo de la lista de prestamos
                libreria.devolverLibroPrestado(prestamo);
                System.out.println("Libro devuelto con exito.");
            } else {
                System.out.println("El libro no se encuentra prestado.");
            }
        } else {
            System.out.println("El libro no esta disponible en la libreria.");
        }
    }
}