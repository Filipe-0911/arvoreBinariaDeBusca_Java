package br.com.estrutura_de_dados;

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

    public void setValor(int valor) {
        this.valor = valor;
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
