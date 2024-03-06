package primerParcial;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class listaDuplicado {
    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(2);
        lista.add(4);
        lista.add(1);

        System.out.println("los numeros de la lista son: " + lista);

        Set<Integer> clean = new HashSet<>(lista);
        List<Integer> listaSinDuplicados = new ArrayList<>(clean);

        System.out.println("Lista sin duplicados: " + listaSinDuplicados);
    }
}
