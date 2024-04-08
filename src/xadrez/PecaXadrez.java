package xadrez;

import tabuleiro.MesaTabuleiro;
import tabuleiro.Peca;
import tabuleiro.Posicao;

public abstract class PecaXadrez extends Peca {

    private Cor cor;
    private int numeroMovimentos;

    public PecaXadrez(MesaTabuleiro mesaTabuleiro, Cor cor) {
        super(mesaTabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    public int getNumeroMovimentos() {
        return numeroMovimentos;
    }

    public void aumentarContagemMovimentos() {
        this.numeroMovimentos++;
    }

    public void diminuirContagemMovimentos() {
        this.numeroMovimentos--;
    }

    public PosicaoXadrez getPosicaoXadrez() {
        return PosicaoXadrez.posicionarMatrizXadrez(posicao);
    }

    protected boolean existePecaOponente(Posicao posicao) {
        PecaXadrez p = (PecaXadrez) getMesaTabuleiro().peca(posicao);
        return p != null && p.getCor() != cor;
    }

}
