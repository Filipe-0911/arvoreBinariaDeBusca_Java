package br.com.estrutura_de_dados.AVL;

public class AVL<T extends Comparable<T>> {
    private NoAVL<T> noRaiz;

    public int getFatorBalanceamento(NoAVL<T> no) {
        if (no == null) {
            return 0;
        }
        
        int esqContador = (no.getNoEsq() != null) ? no.getNoEsq().getContador() : 0;
        int dirContador = (no.getNoDir() != null) ? no.getNoDir().getContador() : 0;
    
        return esqContador - dirContador;
    }
    
    public void atualizarAuxCont(NoAVL<T> no) {
        int esqAuxCont = 0;
        int dirAuxCont = 0;
    
        if (no.getNoEsq() != null) {
            esqAuxCont = no.getNoEsq().getContador();
        }
        if (no.getNoDir() != null) {
            dirAuxCont = no.getNoDir().getContador();
        }
    
        no.setContador(Math.max(esqAuxCont, dirAuxCont) + 1);
    }

    public NoAVL<T> rotacaoDir(NoAVL<T> no) {
        NoAVL<T> raizNova = no.getNoEsq();
        NoAVL<T> subArvore = raizNova.getNoDir();
        raizNova.setNoDir(no);
        
        no.setNoEsq(subArvore);

        atualizarAuxCont(no);
        atualizarAuxCont(raizNova);

        return raizNova;
    }

    public NoAVL<T> rotacaoEsq(NoAVL<T> no) {
        NoAVL<T> raizNova = no.getNoDir();
        NoAVL<T> subArvore = raizNova.getNoEsq();

        raizNova.setNoEsq(no);
        no.setNoDir(subArvore);

        atualizarAuxCont(no);
        atualizarAuxCont(raizNova);

        return raizNova;

    }

    public NoAVL<T> inserir(NoAVL<T> no, T valor) {
        if(no == null) {
            return new NoAVL<T>(valor);
        }

        if(valor.compareTo(no.getValor()) == -1) {
            no.setNoEsq(inserir(no.getNoEsq(), valor));
        } else if (valor.compareTo(no.getValor()) == 1){
            no.setNoDir(inserir(no.getNoDir(), valor));;
        } else
            return no;
        atualizarAuxCont(no);
        int fatorBal = getFatorBalanceamento(no);

        if (fatorBal > 1 && valor.compareTo(no.getNoEsq().getValor()) == -1) {
            return rotacaoDir(no);
        }

        if(fatorBal < -1 && valor.compareTo(no.getNoDir().getValor()) == 1) {
            return rotacaoEsq(no);
        } 
        if(fatorBal > 1 && valor.compareTo(no.getNoEsq().getValor()) == 1) {
            no.setNoEsq(rotacaoEsq(no.getNoEsq()));
            return rotacaoDir(no);
        } 
        if(fatorBal < -1 && valor.compareTo(no.getNoDir().getValor()) == -1) {
            no.setNoDir(rotacaoDir(no.getNoDir()));
            return rotacaoEsq(no);
        } 
        return no;
    }

    public void imprimeNos(NoAVL<T> no) {
        if(no != null) {
            imprimeNos(no.getNoEsq());
            System.out.print(no.getValor() + ", ");
            imprimeNos(no.getNoDir());
        }
    }

    public NoAVL<T> getNoRaiz() {
        return noRaiz;
    }
    public void setNoRaiz(NoAVL<T> no) {
        this.noRaiz = no;
    }
}
