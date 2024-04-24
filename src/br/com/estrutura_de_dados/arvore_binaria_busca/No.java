package br.com.estrutura_de_dados.arvore_binaria_busca;

public class No {
    private int valor;
    private No esq;
    private No dir;

    public int getValor() {
        return valor;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public No getEsq() {
        return esq;
    }

    public No getDir() {
        return dir;
    }

    public No(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "%d".formatted(this.valor);
    }
}
