package br.com.estrutura_de_dados.arvore_binaria_busca;

public class Arvore {
    private No raiz;
    private No noPai;

    public Arvore(int valor) {
        this.raiz = new No(valor);

    }

    public No getRaiz() {
        return raiz;
    }

    public void inserir(int valor, No r) {
        if (r.getValor() > valor) {
            if (r.getEsq() != null) {
                inserir(valor, r.getEsq());
            } else {
                No novo = new No(valor);
                r.setEsq(novo);
            }

        } else {
            if (r.getDir() != null) {
                inserir(valor, r.getDir());
            } else {
                No novo = new No(valor);
                r.setDir(novo);
            }
        }

    }

    public void preOrdem(No r) {
        if (r != null) {
            System.out.print(r.getValor() + ", ");
            preOrdem(r.getEsq());
            preOrdem(r.getDir());
        }
    }

    public void emOrdem(No r) {
        if (r != null) {
            emOrdem(r.getEsq());
            System.out.print(r.getValor() + ", ");
            emOrdem(r.getDir());
        }
    }

    public void posOrdem(No r) {
        if (r != null) {
            posOrdem(r.getEsq());
            posOrdem(r.getDir());
            System.out.print(r.getValor() + ", ");
        }
    }

    public int buscaValor(int valor, No r) {
        if (r.getValor() == valor) {
            return valor;
        }
        if (r.getValor() > valor) {
            if (r.getEsq() != null) {
                return buscaValor(valor, r.getEsq());
            }
            return -1;
        }
        if (r.getDir() != null) {
            return buscaValor(valor, r.getDir());
        }

        return -1;

    }

    public void deletarValor(int valor, No r) {
        No noEncontrado = __buscaNo(valor, r);

        if (noEncontrado == null) {
            System.out.println("O número informado não está na Árvore de Busca Binária.");
            return;
        }

        if (noEncontrado.getValor() == valor) {

            if (noEncontrado.getDir() == null && noEncontrado.getEsq() == null) {

                if (noPai.getValor() > noEncontrado.getValor()) {
                    noPai.setEsq(null);
                } else {
                    noPai.setDir(null);
                }

            }

            if (noEncontrado.getDir() == null) {
                if (noPai.getValor() > noEncontrado.getValor()) {
                    noPai.setEsq(noEncontrado.getEsq());
                } else {
                    noPai.setDir(noEncontrado.getEsq());
                }
            }

            if (noEncontrado.getEsq() == null) {
                if (noPai.getValor() > noEncontrado.getValor()) {
                    noPai.setEsq(noEncontrado.getDir());
                } else {
                    noPai.setDir(noEncontrado.getDir());
                }
            }

            if (noEncontrado.getDir() != null && noEncontrado.getEsq() != null) {

                if (noPai != null) {
                    if (noPai.getValor() > noEncontrado.getValor()) {
                        // No pai 43 == 61
                        // System.out.println(noPai.getValor());

                        // No encontrado == 43 é o que será removido
                        // System.out.println(noEncontrado.getValor());

                        // No substituto do excluido == 32
                        No noSubstituto = noMaximo(noEncontrado.getEsq());

                        // muda valor noPai
                        __buscaNo(noSubstituto.getValor(), raiz);
                        noPai.setDir(null);

                        __buscaNo(noEncontrado.getValor(), raiz);

                        No adicionarAoSubstitudoDir = noEncontrado.getDir();
                        No adicionarAoSubstitutoEsq = noEncontrado.getEsq();

                        noSubstituto.setEsq(adicionarAoSubstitutoEsq);
                        noSubstituto.setDir(adicionarAoSubstitudoDir);

                        // noPai deve voltar a ser o 61
                        noPai.setEsq(noSubstituto);

                    } else {
                        No noMaximoEsquerdo = noMaximo(noEncontrado.getEsq());
                        __buscaNo(noMaximoEsquerdo.getValor(), raiz);

                        if (noMaximoEsquerdo.getValor() > noPai.getValor()) {
                            noPai.setDir(null);
                        } else {
                            noPai.setEsq(null);
                        }

                        noMaximoEsquerdo.setEsq(noEncontrado.getEsq());
                        noMaximoEsquerdo.setDir(noEncontrado.getDir());

                        __buscaNo(noEncontrado.getValor(), raiz);
                        noPai.setDir(noMaximoEsquerdo);

                    }

                } else {

                    No substituto = noMinimo(noEncontrado.getDir());
                    // achar nó pai do substituto
                    __buscaNo(substituto.getValor(), raiz);

                    // seta no esquerdo do pai do substituto o que está a esquerda do substituto
                    noPai.setEsq(substituto.getDir());

                    // seta na direita e na esquerda o que estava na direita e na esquerda do
                    // substituído
                    substituto.setDir(noEncontrado.getDir());
                    substituto.setEsq(noEncontrado.getEsq());

                    // muda a referência do início da árvore
                    raiz = substituto;

                }

            }

        } else {
            System.out.println("O número informado não está na Árvore de Busca Binária.");
        }
    }

    private No __buscaNo(int valor, No r) {
        if (r.getValor() == valor) {
            return r;
        }
        if (r.getValor() > valor) {
            if (r.getEsq() != null) {
                noPai = r;
                return __buscaNo(valor, r.getEsq());
            }
            return null;
        }
        if (r.getDir() != null) {
            noPai = r;
            return __buscaNo(valor, r.getDir());
        }

        return null;

    }

    public No noMinimo(No r) {
        No noMinimo = null;
        if (r.getEsq() != null) {
            return noMinimo(r.getEsq());
        } else {
            noMinimo = r;
        }
        return noMinimo;
    }

    public No noMaximo(No r) {
        No noMaximo = null;
        if (r.getDir() != null) {
            return noMaximo(r.getDir());
        } else {
            noMaximo = r;
        }
        return noMaximo;
    }

    public void imprimeFolhas(No r) {
        if (r != null) {
            if (r.getEsq() == null && r.getDir() == null) {
                System.out.println(r.getValor());
            } else {
                imprimeFolhas(r.getEsq());
                imprimeFolhas(r.getDir());
            }
        }
    }

}