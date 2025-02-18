package ProyectoFinalPOO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static ProyectoFinalPOO.Main.pedidos;

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
    static Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == id) {
                return pedido;
            }
        }
        return null;
    }
    public static void mostrarPedidos(List<Pedido> pedidos) {
        System.out.println("Lista de Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println("ID Pedido: " + pedido.getIdPedido());
            System.out.println("Estado: " + pedido.getEstadoPedido());
            System.out.println("Fecha y Hora: " + pedido.getFechaHora());
            System.out.println("Productos Solicitados:");
            for (Producto producto : pedido.getProductosSolicitados()) {
                System.out.println("- ID: " + producto.getId() +
                        ", Nombre: "
                        + producto.getNombre() +
                        ", Cantidad: "
                        + producto.getCantidadEnTienda());
            }
            System.out.println("-------------------------");
        }
    }
}
