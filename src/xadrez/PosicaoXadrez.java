package xadrez;

import tabuleiro.Posicao;

public class PosicaoXadrez {

    private char coluna;
    private int linha;

    public PosicaoXadrez(char coluna, int linha) {

        if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
            throw new XadrezException("Erro na instancia da posicao. Valores validos estao entre a1 e h8");
        }

        this.coluna = coluna;
        this.linha = linha;

    }

    public char getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

    protected Posicao posicionarXadrezMatriz() {
        return new Posicao(8 - this.linha, this.coluna - 'a');
    }

    protected static PosicaoXadrez posicionarMatrizXadrez(Posicao posicao) {
        return new PosicaoXadrez((char) ('a' - posicao.getColuna()), 8 - posicao.getLinha());
    }

    @Override
    public String toString() {
        return "" + coluna + linha;
    }

}
