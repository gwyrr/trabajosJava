package ProyectoFinalPOO;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int cantidadEnTienda;

    public Producto(int id, String nombre, double precio, int cantidadEnTienda) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnTienda = cantidadEnTienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadEnTienda() {
        return cantidadEnTienda;
    }

    public void setCantidadEnTienda(int cantidadEnTienda) {
        this.cantidadEnTienda = cantidadEnTienda;
    }
}
