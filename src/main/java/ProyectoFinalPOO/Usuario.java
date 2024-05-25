package ProyectoFinalPOO;

import java.util.List;
import java.util.Scanner;

import static ProyectoFinalPOO.Informe.mostrarInformes;
import static ProyectoFinalPOO.Main.*;
import static ProyectoFinalPOO.Pedido.buscarPedidoPorId;
import static ProyectoFinalPOO.Pedido.mostrarPedidos;
import static ProyectoFinalPOO.Producto.buscarProductoPorId;
import static ProyectoFinalPOO.Producto.eliminarProductoPorId;


public class Usuario {

    private String nombreUsuario;
    private String contrasena;
    private String rol;

    public Usuario(String nombreUsuario, String contrasena, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean verificarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    static Usuario solicitarAutenticacion(List<Usuario> usuarios) {
        int intentos = 0;
        while (intentos < 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();
            System.out.print("Ingrese contrasena: ");
            String contrasena = scanner.nextLine();

            Usuario usuarioAutenticado = autenticarUsuario(nombreUsuario, contrasena, usuarios);
            if (usuarioAutenticado != null) {
                return usuarioAutenticado;
            } else {
                intentos++;
                System.out.println("Nombre de usuario o contrasena incorrectos.");
            }
        }
        return null;
    }

    static Usuario autenticarUsuario(String nombreUsuario, String contrasena, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.verificarContrasena(contrasena)) {
                return usuario;
            }
        }
        return null;
    }
    private  static Usuario buscarUsuarioPorNombre(String nombreUsuario){
        for(Usuario usuario : Main.usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                return usuario;
            }
        }
        return null;
    }
    public static void procesarOpcionAdministrador(int opcion) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                if (productos == null) {
                    System.out.println("La lista de productos no esta inicializada.");
                    return;
                }
                System.out.println("Agrega el producto.");
                System.out.print("Ingrese ID del producto: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Ingrese nombre del producto: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese precio del producto: ");
                double precio = scanner.nextDouble();
                System.out.print("Ingrese cantidad en tienda: ");
                int cantidad = scanner.nextInt();
                productos.add(new Producto(id, nombre, precio, cantidad));
                System.out.println("Producto agregado.");
                break;
            case 2:
                System.out.println("Modificar producto seleccionado.");
                System.out.print("Ingrese el ID del producto que desea modificar: ");
                int idProducto = scanner.nextInt();
                scanner.nextLine();
                Producto productoAModificar = buscarProductoPorId(idProducto);
                if (productoAModificar != null) {
                    System.out.println("Producto encontrado: " + productoAModificar.getNombre());
                    System.out.println("Ingrese los nuevos datos del producto:");
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = scanner.nextInt();
                    //realiza los cambios
                    productoAModificar.setNombre(nuevoNombre);
                    productoAModificar.setPrecio(nuevoPrecio);
                    productoAModificar.setCantidadEnTienda(nuevaCantidad);
                    System.out.println("Producto modificado exitosamente.");
                } else {
                    System.out.println("No se encontro ningun producto.");
                }
                break;
            case 3:
                System.out.println("Eliminar producto seleccionado.");
                System.out.print("Ingrese el ID del producto que desea eliminar: ");
                int idProductoEliminar = scanner.nextInt();
                scanner.nextLine();
                boolean productoEliminado = eliminarProductoPorId(idProductoEliminar);
                if (productoEliminado) {
                    System.out.println("Producto eliminado exitosamente.");
                } else {
                    System.out.println("No se encontro ningun producto");
                }
                break;
            case 4:
                System.out.println("Gestionar pedidos seleccionado.");
                if (pedidos == null) {
                    System.out.println("La lista de pedidos no esta inicializada.");
                    return;
                }
                mostrarPedidos(pedidos);
                break;
            case 5:
                System.out.println("Confirmar envios seleccionado.");
                System.out.print("Ingrese el ID del pedido que desea confirmar: ");
                int idPedido = scanner.nextInt();
                Pedido pedidoAConfirmar = buscarPedidoPorId(idPedido);
                if (pedidoAConfirmar != null) {
                    pedidoAConfirmar.cambiarEstadoPedido("Entregado");
                    System.out.println("Pedido " + idPedido + " ha sido entregado.");
                } else {
                    System.out.println("Pedido con ID " + idPedido + " no encontrado.");
                }
                break;
            case 6:
                System.out.println("Generar informes seleccionado.");
                mostrarInformes(Datos.inicializarInformes());
                break;
            case 7:
                System.out.println("Administrar usuarios seleccionado.");
                System.out.print("Ingrese el nombre de usuario al que desea cambiar el rol: ");
                String nombreUsuario = scanner.nextLine();
                Usuario usuarioACambiar = buscarUsuarioPorNombre(nombreUsuario);
                if (usuarioACambiar != null) {
                    System.out.println("Rol actual del usuario: " + usuarioACambiar.getRol());
                    System.out.print("Ingrese el nuevo rol del usuario: ");
                    String nuevoRol = scanner.nextLine();
                    usuarioACambiar.setRol(nuevoRol);
                    System.out.println("Rol cambiado exitosamente.");
                } else {
                    System.out.println("Usuario no encontrado.");
                }
                break;
            case 8:
                System.out.println("Ver inventario seleccionado.");
                for (Producto producto : productos) {
                    System.out.println(producto.getNombre() + ": "
                            + producto.getCantidadEnTienda() +
                            " unidades disponibles, Precio: $"
                            + producto.getPrecio());
                }
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }


    public static void procesarOpcionAlmacenero(int opcion) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("Ver inventario seleccionado.");
                for (Producto producto : productos) {
                    System.out.println(producto.getNombre() + ": "
                            + producto.getCantidadEnTienda() +
                            " unidades disponibles, Precio: $"
                            + producto.getPrecio());
                }
                break;
            case 2:
                System.out.println("Gestionar pedidos seleccionado.");
                if (pedidos == null) {
                    System.out.println("La lista de pedidos no esta  inicializada.");
                    return;
                }
                mostrarPedidos(pedidos);
                break;
            case 3:
                System.out.println("Confirmar envios seleccionado.");
                System.out.print("Ingrese el ID del pedido que desea confirmar: ");
                int idPedido = scanner.nextInt();
                Pedido pedidoAConfirmar = buscarPedidoPorId(idPedido);
                if (pedidoAConfirmar != null) {
                    pedidoAConfirmar.cambiarEstadoPedido("Entregado");
                    System.out.println("Pedido " + idPedido + " ha sido entregado.");
                } else {
                    System.out.println("Pedido con ID " + idPedido + " no encontrado.");
                }
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }
    public static void procesarOpcionContador(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Ver inventario seleccionado.");
                for (Producto producto : productos) {
                    System.out.println(producto.getNombre() + ": "
                            + producto.getCantidadEnTienda() +
                            " unidades disponibles, Precio: $"
                            + producto.getPrecio());
                }
                break;
            case 2:
                System.out.println("Generar informes seleccionado.");
                mostrarInformes(Datos.inicializarInformes());
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }
}