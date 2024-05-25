package ProyectoFinalPOO;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Producto> productos = new ArrayList<>();
    static List<Pedido> pedidos = new ArrayList<>();
    static List<Usuario> usuarios = new ArrayList<>();
    static List<Informe> Informes = new ArrayList<>();

    public static void main(String[] args) {
        Datos.inicializarDatos(productos, pedidos, usuarios, Informes);
        Usuario usuarioAutenticado = Usuario.solicitarAutenticacion(usuarios);

        if (usuarioAutenticado != null) {
            System.out.println("Bienvenido, " + usuarioAutenticado.getNombreUsuario() + "!");
            Menu.mostrarMenu(usuarioAutenticado, productos, pedidos, Informes);
        } else {
            System.out.println("Maximo de intentos alcanzado, reinicia la aplicacion");
        }
    }
}