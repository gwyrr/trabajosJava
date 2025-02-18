package primerParcial;

import java.util.ArrayList;
import java.util.List;

public class listaImpares {
    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        lista.add(15);
        lista.add(22);
        lista.add(33);
        lista.add(28);
        lista.add(46);
        lista.add(11);
        List<Integer> listaFinal = new ArrayList<>();

        System.out.println("los numeros de la lista son: " + lista);

        for (int par : lista) {
            if (par % 2 == 0) {
                listaFinal.add(par);
            }
        }

        System.out.println("Lista sin impares: " + listaFinal);
    }
}
