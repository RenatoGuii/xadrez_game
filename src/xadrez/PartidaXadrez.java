package xadrez;

import tabuleiro.MesaTabuleiro;
import tabuleiro.Posicao;
import xadrezPecas.Rei;
import xadrezPecas.Torre;

public class PartidaXadrez {

    private MesaTabuleiro mesaTabuleiro;

    public PartidaXadrez() {
        this.mesaTabuleiro = new MesaTabuleiro(8, 8);
        initialSetup();
    }

    public PecaXadrez[][] getPecas() {

        PecaXadrez[][] mat = new PecaXadrez[mesaTabuleiro.getLinhas()][mesaTabuleiro.getColunas()];

        for (int i = 0; i < mesaTabuleiro.getLinhas(); i++) {
            for (int j = 0; j < mesaTabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaXadrez) mesaTabuleiro.peca(i, j);
            }
        }

        return mat;

    }

    private void initialSetup() {
        mesaTabuleiro.posicionarPeca(new Torre(mesaTabuleiro, Color.WHITE), new Posicao(2, 1));
        mesaTabuleiro.posicionarPeca(new Rei(mesaTabuleiro, Color.BLACK), new Posicao(2, 3));
        mesaTabuleiro.posicionarPeca(new Torre(mesaTabuleiro, Color.WHITE), new Posicao(2, 4));
    }

}
