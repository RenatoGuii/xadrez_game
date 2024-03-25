package xadrez;

import tabuleiro.MesaTabuleiro;

public class PartidaXadrez {

    private MesaTabuleiro mesaTabuleiro;

    public PartidaXadrez() {
        this.mesaTabuleiro = new MesaTabuleiro(8, 8);
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

}
