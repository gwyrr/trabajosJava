package ProyectoPOO;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private HashMap<String, Libro> inventario;
    private List<Prestamo> listaDePrestamos;

    public Libreria() {
        inventario = new HashMap<>();
        listaDePrestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        inventario.put(libro.getTitulo(), libro);
    }

    public Libro buscarTitulo(String titulo) {
        return inventario.get(titulo);
    }

    public Libro buscarAutor(String autor) {
        for (Libro libro : inventario.values()) {
            if (libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null; //si no se encuentra el libro
    }

    public void mostrarInventario() {
        System.out.println("Inventario: ");
        for (Libro libro : inventario.values()) {
            System.out.println(libro);
        }
    }

    public void realizarPrestamo(Prestamo prestamo) {
        listaDePrestamos.add(prestamo);
    }

    public void devolverLibroPrestado(Prestamo prestamo) {
        listaDePrestamos.remove(prestamo);
    }

    public Prestamo buscarPrestamo(Libro libro) {
        for (Prestamo prestamo : listaDePrestamos) {
            if (prestamo.getLibroPrestado().equals(libro)) {
                return prestamo;
            }
        }
        return null;
    }
}
