package xadrez;

import tabuleiro.MesaTabuleiro;
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

    private void coloqueNovaPeca(char coluna, int linha, PecaXadrez pecaXadrez) {
        mesaTabuleiro.posicionarPeca(pecaXadrez, new PosicaoXadrez(coluna, linha).posicionarXadrezMatriz());
    }

    private void initialSetup() {
        coloqueNovaPeca('b', 6, new Torre(mesaTabuleiro, Color.WHITE));
        coloqueNovaPeca('e', 8, new Rei(mesaTabuleiro, Color.BLACK));
        coloqueNovaPeca('e', 1, new Rei(mesaTabuleiro, Color.WHITE));
    }

}
