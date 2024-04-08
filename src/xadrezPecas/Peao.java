package xadrezPecas;

import tabuleiro.MesaTabuleiro;
import tabuleiro.Posicao;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {

    public Peao(MesaTabuleiro mesaTabuleiro, Color color) {
        super(mesaTabuleiro, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getMesaTabuleiro().getLinhas()][getMesaTabuleiro().getColunas()];

        Posicao p = new Posicao(0, 0);

        if (getColor() == Color.WHITE) {

            p.setValores(posicao.getLinha() - 1, posicao.getColuna());
            if (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

            p.setValores(posicao.getLinha() - 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
            if (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)
                    && getMesaTabuleiro().posicaoExiste(p2) && !getMesaTabuleiro().haUmaPeca(p2)
                    && getNumeroMovimentos() == 0) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

            p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
            if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

            p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
            if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

        } else {

            p.setValores(posicao.getLinha() + 1, posicao.getColuna());
            if (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

            p.setValores(posicao.getLinha() + 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
            if (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)
                    && getMesaTabuleiro().posicaoExiste(p2) && !getMesaTabuleiro().haUmaPeca(p2)
                    && getNumeroMovimentos() == 0) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

            p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
            if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

            p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
            if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

        }

        return mat;
    }

}
