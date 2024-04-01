package xadrez;

import tabuleiro.MesaTabuleiro;
import tabuleiro.Peca;
import tabuleiro.Posicao;

public abstract class PecaXadrez extends Peca {

    private Color color;

    public PecaXadrez(MesaTabuleiro mesaTabuleiro, Color color) {
        super(mesaTabuleiro);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public PosicaoXadrez getPosicaoXadrez() {
        return PosicaoXadrez.posicionarMatrizXadrez(posicao);
    }

    protected boolean existePecaOponente(Posicao posicao) {
        PecaXadrez p = (PecaXadrez) getMesaTabuleiro().peca(posicao);
        return p != null && p.getColor() != color;
    }

}
