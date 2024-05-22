package ProyectoFinalPOO;

import java.time.LocalDate;

public class Informe {
    private LocalDate fecha;
    private Producto producto;
    private int cantidadVendida;

    public Informe(String fecha, Producto producto, int cantidadVendida) {
        this.fecha = LocalDate.parse(fecha);
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public int getCantidad() {
        return cantidadVendida;
    }
}
