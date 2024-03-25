package tabuleiro;

public class Peca {

    protected Posicao posicao;
    private MesaTabuleiro mesaTabuleiro;

    public Peca(MesaTabuleiro mesaTabuleiro) {
        this.mesaTabuleiro = mesaTabuleiro;
        this.posicao = null;
    }

    protected MesaTabuleiro getMesaTabuleiro() {
        return mesaTabuleiro;
    }

}
