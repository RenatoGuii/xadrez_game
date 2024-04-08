package xadrezPecas;

import tabuleiro.MesaTabuleiro;
import tabuleiro.Posicao;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Rainha extends PecaXadrez {

    public Rainha(MesaTabuleiro mesaTabuleiro, Color color) {
        super(mesaTabuleiro, color);
    }

    public String toString() {
        return "D";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getMesaTabuleiro().getLinhas()][getMesaTabuleiro().getColunas()];

        Posicao p = new Posicao(0, 0);

        // Acima
        p.setValores(posicao.getLinha() - 1, posicao.getColuna());

        while (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() - 1);
        }

        if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Esquerda
        p.setValores(posicao.getLinha(), posicao.getColuna() - 1);

        while (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
            ;
        }

        if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Direita
        p.setValores(posicao.getLinha(), posicao.getColuna() + 1);

        while (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() + 1);
            ;
        }

        if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Abaixo
        p.setValores(posicao.getLinha() + 1, posicao.getColuna());

        while (getMesaTabuleiro().posicaoExiste(p) && !getMesaTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() + 1);
        }

        if (getMesaTabuleiro().posicaoExiste(p) && existePecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

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
