package tabuleiro;

public abstract class Peca {

    protected Posicao posicao;
    private MesaTabuleiro mesaTabuleiro;

    public Peca(MesaTabuleiro mesaTabuleiro) {
        this.mesaTabuleiro = mesaTabuleiro;
        this.posicao = null;
    }

    protected MesaTabuleiro getMesaTabuleiro() {
        return mesaTabuleiro;
    }

    public abstract boolean[][] movimentosPossiveis();

    public boolean movimentoPossivel(Posicao posicao) {
        return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
    }

    public boolean existeUmMovimento() {
        boolean[][] mat = movimentosPossiveis();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
