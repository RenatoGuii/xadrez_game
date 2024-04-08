package xadrezPecas;

import tabuleiro.MesaTabuleiro;
import tabuleiro.Posicao;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Bispo extends PecaXadrez {

    public Bispo(MesaTabuleiro mesaTabuleiro, Color color) {
        super(mesaTabuleiro, color);
    }

    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getMesaTabuleiro().getLinhas()][getMesaTabuleiro().getColunas()];

        Posicao p = new Posicao(0, 0);

        // Noroeste
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);

        while (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() - 1, p.getColuna() - 1);
        }

        if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Nordeste
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);

        while (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() - 1, p.getColuna() + 1);
            ;
        }

        if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Sudeste
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);

        while (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() + 1, p.getColuna() + 1);
            ;
        }

        if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Sudoeste
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);

        while (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() + 1, p.getColuna() - 1);
        }

        if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        return mat;
    }

}
