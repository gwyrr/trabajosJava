package ProyectoFinalPOO;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Main {
    static List<Producto> productos;
    private static List<Pedido> pedidos;
    private static List<Usuario> usuarios;

    public static void main(String[] args) {
        productos = Datos.inicializarProductos();
        pedidos = Datos.inicializarPedidos();
        usuarios = Datos.inicializarUsuarios();

        // Solicita nombre de usuario y contraseña
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese contrasena: ");
        String contrasena = scanner.nextLine();

        // Autentica el usuario
        Usuario autenticarUsuario = autenticarUsuario(nombreUsuario, contrasena, usuarios);

        if (autenticarUsuario != null) {
            System.out.println("Bienvenido, " + autenticarUsuario.getNombreUsuario() + "!");
            mostrarMenu(autenticarUsuario);
        } else {
            System.out.println("Nombre de usuario o contrasena incorrectos.");
        }
    }

    public static Usuario autenticarUsuario(String nombreUsuario, String contrasena, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.verificarContrasena(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    public static void mostrarMenu(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        String rol = usuario.getRol();

        while (true) {
            System.out.println("\nOpciones:");
            switch (rol.toLowerCase()) {
                case "administrador":
                    System.out.println("1. Agregar producto");
                    System.out.println("2. Modificar producto");
                    System.out.println("3. Eliminar producto");
                    System.out.println("4. Gestionar pedidos");
                    System.out.println("5. Confirmar envios");
                    System.out.println("6. Generar informes");
                    System.out.println("7. Administrar usuarios");
                    System.out.println("8. Ver inventario");
                    System.out.println("9. Salir de la cuenta");
                    System.out.println("0. Salir");
                    break;
                case "almacenero":
                    System.out.println("1. Ver inventario");
                    System.out.println("2. Gestionar pedidos");
                    System.out.println("3. Confirmar envios");
                    System.out.println("9. Salir de la cuenta");
                    System.out.println("0. Salir");
                    break;
                case "contador":
                    System.out.println("1. Ver inventario");
                    System.out.println("2. Generar informes");
                    System.out.println("9. Salir de la cuenta");
                    System.out.println("0. Salir");
                    break;
                default:
                    System.out.println("Usuario no reconocido.");
                    return;
            }

            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0:
                    System.out.println("Finalizando");
                    return;
                case 9:
                    System.out.println("Saliendo de la cuenta");
                    main(new String[0]); // Volver al inicio del programa
                    return;
                default:
                    procesarOpcion(usuario, opcion);
            }
        }
    }

    public static void procesarOpcion(Usuario usuario, int opcion) {
        String rol = usuario.getRol();
        switch (rol.toLowerCase()) {
            case "administrador":
                procesarOpcionAdministrador(opcion);
                break;
            case "almacenero":
                procesarOpcionAlmacenero(opcion);
                break;
            case "contador":
                procesarOpcionContador(opcion);
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }

    private static boolean eliminarProductoPorId(int id) {
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.getId() == id) {
                iterator.remove();
                return true; // Producto encontrado y eliminado
            }
        }
        return false; // No se encontró ningún producto
    }

    private static Producto buscarProductoPorId(int id) {
        // buscar el producto
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    private static Pedido buscarPedidoPorId(int id) {
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

    public static void mostrarInformes(List<Informe> informes) {
        if (informes.isEmpty()) {
            System.out.println("No hay informes disponibles.");
        } else {
            System.out.println("Informes de Ventas del Último Mes:");
            for (Informe informe : informes) {
                System.out.println("Fecha: " + informe.getFecha() +
                        ", Producto: " + informe.getProducto().getNombre() +
                        ", Cantidad vendida: " + informe.getCantidad());
            }
        }
    }
    private static Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        for (Usuario usuario : Main.usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
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

