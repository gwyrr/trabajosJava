package ProyectoFinalPOO;

import java.time.LocalDate;
import java.util.List;

public class Informe {
    private final LocalDate fecha;
    private final Producto producto;
    private final int cantidadVendida;

    public Informe(String fecha, Producto producto, int cantidadVendida) {
        this.fecha = LocalDate.parse(fecha);
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
    }

    public static void addAll(List<Informe> informes) {

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

    public static void mostrarInformes(List<Informe> informes) {
        if (informes.isEmpty()) {
            System.out.println("No hay informes disponibles.");
        } else {
            System.out.println("Informes de Ventas del ultimo mes:");
            for (Informe informe : informes) {
                System.out.println("Fecha: " + informe.getFecha() +
                        ", Producto: " + informe.getProducto().getNombre() +
                        ", Cantidad vendida: " + informe.getCantidad());
            }
        }
    }

}
