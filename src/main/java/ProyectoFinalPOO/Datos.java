package ProyectoFinalPOO;

import java.util.ArrayList;
import java.util.List;

import static ProyectoFinalPOO.Main.productos;

public class Datos {

    public static List<Producto> inicializarProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Casco de moto", 260000, 250));
        productos.add(new Producto(2, "Guantes de moto", 70000, 98));
        productos.add(new Producto(3, "Chaqueta de moto", 120000, 75));
        productos.add(new Producto(4, "Rodilleras", 98500, 80));
        productos.add(new Producto(5, "Kit de herramientas", 160000, 130));
        productos.add(new Producto(6, "Cubierta para moto", 90000, 60));
        productos.add(new Producto(7, "Soporte para telefono", 35500,34));
        return productos;
    }

    public static List<Pedido> inicializarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();

        Pedido pedido1 = new Pedido(1, "2024-05-19", "Pendiente");
        pedido1.agregarProducto(new Producto(1, "Casco de moto", 260000, 1));
        pedido1.agregarProducto(new Producto(2, "Guantes de moto", 140000, 2));
        pedido1.agregarProducto(new Producto(3, "Rodilleras", 98500, 1));

        Pedido pedido2 = new Pedido(2, "2024-05-20", "Entregado");
        pedido2.agregarProducto(new Producto(3, "Chaqueta de moto", 120000, 1));
        pedido2.agregarProducto(new Producto(4, "Rodilleras", 98500, 1));
        pedido2.agregarProducto(new Producto(7, "Soporte para teléfono", 35500, 1));

        Pedido pedido3 = new Pedido(3, "2024-05-21", "Pendiente");
        pedido3.agregarProducto(new Producto(5, "Kit de herramientas", 160000, 1));
        pedido3.agregarProducto(new Producto(6, "Cubierta para moto", 90000, 1));

        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        return pedidos;
    }

    public static List<Usuario> inicializarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin", "admin123", "administrador"));
        usuarios.add(new Usuario("almacenero", "almacenero123", "almacenero"));
        usuarios.add(new Usuario("contador", "contador123", "contador"));

        return usuarios;
    }
    public static List<Informe> inicializarInformes() {
        List<Informe> informes = new ArrayList<>();

        informes.add(new Informe("2024-04-01", productos.get(0), 20)); // Casco de moto
        informes.add(new Informe("2024-04-01", productos.get(1), 15)); // Guantes de moto
        informes.add(new Informe("2024-04-02", productos.get(2), 10)); // Chaqueta de moto
        informes.add(new Informe("2024-04-02", productos.get(3), 5)); // Rodilleras
        informes.add(new Informe("2024-04-03", productos.get(4), 30)); // Kit de herramientas
        informes.add(new Informe("2024-04-03", productos.get(5), 8)); // Cubierta para moto
        informes.add(new Informe("2024-04-04", productos.get(6), 12)); // Soporte para teléfono

        return informes;
    }

    public static void inicializarDatos(List<Producto> productos, List<Pedido> pedidos, List<Usuario> usuarios, List<Informe> informes){
        productos.addAll(inicializarProductos());
        pedidos.addAll(inicializarPedidos());
        usuarios.addAll(inicializarUsuarios());
        Informe.addAll(inicializarInformes());
    }
}
