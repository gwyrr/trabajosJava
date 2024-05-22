package ProyectoFinalPOO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int idPedido;
    private List<Producto> productosSolicitados;
    private String estadoPedido;
    private LocalDateTime fechaHora;

    public Pedido(int idPedido, String date, String estadoPedido) {
        this.idPedido = idPedido;
        this.productosSolicitados = new ArrayList<>();
        this.estadoPedido = estadoPedido;
        this.fechaHora = LocalDateTime.parse(date + "T00:00:00");
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public List<Producto> getProductosSolicitados() {
        return productosSolicitados;
    }

    public void setProductosSolicitados(List<Producto> productosSolicitados) {
        this.productosSolicitados = productosSolicitados;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void agregarProducto(Producto producto) {
        this.productosSolicitados.add(producto);
    }

    public void cambiarEstadoPedido(String nuevoEstado) {
        if (nuevoEstado.equals("Pendiente") || nuevoEstado.equals("Enviado") || nuevoEstado.equals("Entregado")) {
            this.estadoPedido = nuevoEstado;
        } else {
            System.out.println("Estado no válido. El estado debe ser Pendiente, Enviado o Entregado.");
        }
    }
}
