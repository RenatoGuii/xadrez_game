package xadrezPecas;

import tabuleiro.MesaTabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

    public Torre(MesaTabuleiro mesaTabuleiro, Color color) {
        super(mesaTabuleiro, color);
    }
    
    @Override
    public String toString() {
        return "T";
    }

}
