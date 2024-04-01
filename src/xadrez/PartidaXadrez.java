package xadrez;

import java.util.ArrayList;
import java.util.List;

import tabuleiro.MesaTabuleiro;
import tabuleiro.Peca;
import tabuleiro.Posicao;
import xadrezPecas.Rei;
import xadrezPecas.Torre;

public class PartidaXadrez {

    private int turno;
    private Color jogadorAtual;
    private MesaTabuleiro mesaTabuleiro;

    private List<Peca> pecasNoTabuleiro = new ArrayList<>();
    private List<Peca> pecasCapturadas = new ArrayList<>();

    public PartidaXadrez() {
        this.mesaTabuleiro = new MesaTabuleiro(8, 8);
        this.turno = 1;
        this.jogadorAtual = Color.WHITE;
        initialSetup();
    }

    public int getTurno() {
        return turno;
    }

    public Color getJogadorAtual() {
        return jogadorAtual;
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

    public boolean[][] possiveisMovimentos(PosicaoXadrez posicaoOrigem) {
        Posicao posicao = posicaoOrigem.posicionarXadrezMatriz();
        validarPosicaoOrigem(posicao);
        return mesaTabuleiro.peca(posicao).movimentosPossiveis();
    }

    public PecaXadrez MovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
        Posicao origem = posicaoOrigem.posicionarXadrezMatriz();
        Posicao destino = posicaoDestino.posicionarXadrezMatriz();
        validarPosicaoOrigem(origem);
        validarPosicaoDestino(origem, destino);
        Peca pecaCapturada = executarMovimento(origem, destino);
        proximoTurno();
        return (PecaXadrez) pecaCapturada;
    }

    private Peca executarMovimento(Posicao origem, Posicao destino) {
        Peca p = mesaTabuleiro.removerPeca(origem);
        Peca pecaCapturada = mesaTabuleiro.removerPeca(destino);
        mesaTabuleiro.posicionarPeca(p, destino);

        if (pecaCapturada != null) {
            pecasNoTabuleiro.remove(pecaCapturada);
            pecasCapturadas.add(pecaCapturada);
        }

        return pecaCapturada;
    }

    private void validarPosicaoOrigem(Posicao posicao) {
        if (!mesaTabuleiro.haUmaPeca(posicao)) {
            throw new XadrezException("Nao existe peca nessa posicao!");
        }
        if (this.jogadorAtual != ((PecaXadrez) mesaTabuleiro.peca(posicao)).getColor()) {
            throw new XadrezException("A peca escolhida nao e sua!");
        }
        if (!mesaTabuleiro.peca(posicao).existeUmMovimento()) {
            throw new XadrezException("Nao existe movimentos possiveis para a peca escolhida");
        }
    }

    private void validarPosicaoDestino(Posicao origem, Posicao destino) {
        if (!mesaTabuleiro.peca(origem).movimentoPossivel(destino)) {
            throw new XadrezException("Nao e possivel mover a peca para essa posicao!");
        }
    }

    private void proximoTurno() {
        turno++;
        this.jogadorAtual = (this.jogadorAtual == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void coloqueNovaPeca(char coluna, int linha, PecaXadrez pecaXadrez) {
        mesaTabuleiro.posicionarPeca(pecaXadrez, new PosicaoXadrez(coluna, linha).posicionarXadrezMatriz());
        pecasNoTabuleiro.add(pecaXadrez);
    }

    private void initialSetup() {
        coloqueNovaPeca('e', 1, new Torre(mesaTabuleiro, Color.WHITE));
        coloqueNovaPeca('c', 1, new Torre(mesaTabuleiro, Color.WHITE));
        coloqueNovaPeca('c', 2, new Torre(mesaTabuleiro, Color.WHITE));
        coloqueNovaPeca('d', 2, new Torre(mesaTabuleiro, Color.WHITE));
        coloqueNovaPeca('e', 2, new Torre(mesaTabuleiro, Color.WHITE));
        coloqueNovaPeca('d', 1, new Rei(mesaTabuleiro, Color.WHITE));

        coloqueNovaPeca('c', 7, new Torre(mesaTabuleiro, Color.BLACK));
        coloqueNovaPeca('c', 8, new Torre(mesaTabuleiro, Color.BLACK));
        coloqueNovaPeca('d', 7, new Torre(mesaTabuleiro, Color.BLACK));
        coloqueNovaPeca('e', 7, new Torre(mesaTabuleiro, Color.BLACK));
        coloqueNovaPeca('e', 8, new Torre(mesaTabuleiro, Color.BLACK));
        coloqueNovaPeca('d', 8, new Rei(mesaTabuleiro, Color.BLACK));
    }

}
