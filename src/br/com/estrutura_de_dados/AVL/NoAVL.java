package br.com.estrutura_de_dados.AVL;

import java.util.Objects;

public class NoAVL<T extends Comparable<T>> implements Comparable<NoAVL<T>> {
    private T valor;
    private int contador;
    private NoAVL<T> noEsq;
    private NoAVL<T> noDir;

    public NoAVL (T valor) {
        this.valor = valor;
        this.contador = 1;
        this.noEsq = null;
        this.noDir = null;
    }

    public T getValor() {
        return valor;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void setNoEsq(NoAVL<T> noEsq) {
        this.noEsq = noEsq;
    }

    public void setNoDir(NoAVL<T> noDir) {
        this.noDir = noDir;
    }

    public NoAVL<T> getNoEsq() {
        return noEsq;
    }

    public NoAVL<T> getNoDir() {
        return noDir;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(NoAVL<T> outroNo) {
        return this.getValor().compareTo(outroNo.getValor());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NoAVL<?> other = (NoAVL<?>) obj;
        return Objects.equals(getValor(), other.getValor());
    }

}
