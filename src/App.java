import java.util.ArrayList;
import java.util.List;

import br.com.estrutura_de_dados.AVL.AVL;
import br.com.estrutura_de_dados.arvore_binaria_busca.Arvore;

public class App {
    public static void main(String[] args) throws Exception {

        List<Integer> listaNumeros = new ArrayList<>(List.of(89, 66, 43, 51, 16, 55, 11, 79, 77, 82, 32, 100, 90));
        Arvore ar = new Arvore(61);

        for (int numero : listaNumeros) {
            ar.inserir(numero, ar.getRaiz());
        }
        
        // List<Integer> listaNumeros = new ArrayList<>(List.of(25, 20, 28, 29, 40, 37, 50));
        // Arvore ar = new Arvore(30);
        int numeroApagar = 61;

        System.out.println("Percurso em pre-ordem ANTES de deletar %d".formatted(numeroApagar));
        ar.preOrdem(ar.getRaiz());
        System.out.println();
        System.out.println("---------------");

        System.out.println("Percurso em pre-ordem DEPOIS de deletar %d".formatted(numeroApagar));
        ar.deletarValor(numeroApagar, ar.getRaiz());
        ar.preOrdem(ar.getRaiz());
        System.out.println();
        System.out.println("---------------");

        System.out.println("Nós folha");
        ar.imprimeFolhas(ar.getRaiz());

        System.out.println("*****************************************************");
        System.out.println("Arvore AVL");
        System.out.println();

        List<Integer> listaNumerosAvl = new ArrayList<>(List.of(61, 89, 66, 43, 51, 16, 55, 11, 79, 77, 82, 32, 100, 90));

        AVL<Integer> avl = new AVL<Integer>();

        for (int numero : listaNumerosAvl) {
            avl.setNoRaiz(avl.inserir(avl.getNoRaiz(), numero));
        }

        avl.imprimeNos(avl.getNoRaiz());
        System.out.println();



    }
}
