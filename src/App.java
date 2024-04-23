import java.util.ArrayList;
import java.util.List;

import br.com.estrutura_de_dados.Arvore;
// import br.com.estrutura_de_dados.No;

public class App {
    public static void main(String[] args) throws Exception {

        List<Integer> listaNumeros = new ArrayList<>(List.of(89, 66, 43, 51, 16, 55, 11, 79, 77, 82, 32, 100, 90));

        Arvore ar = new Arvore(61);

        for (int numero : listaNumeros) {
            ar.inserir(numero, ar.raiz);
        }
        int numeroApagar = 90;

        System.out.println("Percurso em pre-ordem ANTES de deletar %d".formatted(numeroApagar));
        ar.preOrdem(ar.raiz);
        System.out.println();
        System.out.println("---------------");

        System.out.println("Percurso em pre-ordem DEPOIS de deletar %d".formatted(numeroApagar));
        ar.deletarValor(numeroApagar, ar.raiz);
        ar.preOrdem(ar.raiz);
        System.out.println();
        System.out.println("---------------");

        System.out.println(ar.noMinimo(ar.raiz));
        System.out.println(ar.noMaximo(ar.raiz));

    }
}
