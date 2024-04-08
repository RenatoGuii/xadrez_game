package xadrezPecas;

import tabuleiro.MesaTabuleiro;
import tabuleiro.Posicao;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

    public Rei(MesaTabuleiro mesaTabuleiro, Cor cor) {
        super(mesaTabuleiro, cor);
    }

    @Override
    public String toString() {
        return "R";
    }

    private boolean podeMover(Posicao posicao) {
        PecaXadrez p = (PecaXadrez) getMesaTabuleiro().peca(posicao);
        return p == null || p.getCor() != getCor();
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getMesaTabuleiro().getLinhas()][getMesaTabuleiro().getColunas()];

        Posicao p = new Posicao(0, 0);

        // Acima
        p.setValores(posicao.getLinha() - 1, posicao.getColuna());
        if (getMesaTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Abaixo
        p.setValores(posicao.getLinha() + 1, posicao.getColuna());
        if (getMesaTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Esquerda
        p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
        if (getMesaTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Direita
        p.setValores(posicao.getLinha(), posicao.getColuna() + 1);
        if (getMesaTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // NOROESTE
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
        if (getMesaTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // NORDESTE
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
        if (getMesaTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // SUDOESTE
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
        if (getMesaTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // SUDESTE
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
        if (getMesaTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        return mat;
    }
}
