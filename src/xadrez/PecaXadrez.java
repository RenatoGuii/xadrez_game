package xadrez;

import tabuleiro.MesaTabuleiro;
import tabuleiro.Peca;

public class PecaXadrez extends Peca {

    private Color color;

    public PecaXadrez(MesaTabuleiro mesaTabuleiro, Color color) {
        super(mesaTabuleiro);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
