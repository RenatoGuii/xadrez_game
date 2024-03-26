package xadrezPecas;

import tabuleiro.MesaTabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

    public Rei(MesaTabuleiro mesaTabuleiro, Color color) {
        super(mesaTabuleiro, color);
    }
    
    @Override
    public String toString() {
        return "R";
    }   

}
