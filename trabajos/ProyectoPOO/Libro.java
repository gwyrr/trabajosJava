package ProyectoPOO;

public class Libro {
        private String titulo, autor, ISBN, editorial;
private int anioPublicacion;
private double precio;

public Libro(String titulo, String autor, String ISBN, String editorial, int anioPublicacion, double precio) {
    this.titulo = titulo;
    this.autor = autor;
    this.ISBN = ISBN;
    this.editorial = editorial;
    this.anioPublicacion = anioPublicacion;
    this.precio = precio;
}

public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public String getAutor() {
    return autor;
}

public void setAutor(String autor) {
    this.autor = autor;
}

public String getISBN() {
    return ISBN;
}

public void setISBN(String ISBN) {
    this.ISBN = ISBN;
}

public String getEditorial() {
    return editorial;
}

public void setEditorial(String editorial) {
    this.editorial = editorial;
}

public int getAnioPublicacion() {
    return anioPublicacion;
}

public void setAnioPublicacion(int anioPublicacion) {
    this.anioPublicacion = anioPublicacion;
}

public double getPrecio() {
    return precio;
}

public void setPrecio(double precio) {
    this.precio = precio;
}
public String toString(){
    return "Titulo: " + titulo + " Autor: "+ autor;
}
}
