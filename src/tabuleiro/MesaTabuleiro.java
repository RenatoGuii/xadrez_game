package tabuleiro;

public class MesaTabuleiro {

    private Integer linhas;
    private Integer colunas;
    private Peca[][] pecas;

    public MesaTabuleiro(Integer linhas, Integer colunas) {
        if (linhas < 1 || colunas < 1) {
            throw new TabuleiroException("Erro na criacao do tabuleiro: E necessário que haja pelo menos 1 linha e 1 coluna!");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        this.pecas = new Peca[linhas][colunas];
    }

    public Integer getLinhas() {
        return linhas;
    }

    public Integer getColunas() {
        return colunas;
    }

    public Peca peca(int linha, int coluna) {
        if (!posicaoExiste(linha, coluna)) {
            throw new TabuleiroException("Posicao nao existe no tabuleiro");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new TabuleiroException("Posicao nao existe no tabuleiro");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void posicionarPeca (Peca peca, Posicao posicao) {
        if (haUmaPeca(posicao)) {
            throw new TabuleiroException("Ja existe uma peca nesta posicao: " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    private Boolean posicaoExiste (int linha, int coluna) {
        return linha >= 0 && linha < this.linhas && coluna >= 0 && coluna < this.colunas;
    }

    public Boolean posicaoExiste (Posicao posicao) {
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }

    public Boolean haUmaPeca (Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new TabuleiroException("Posicao nao existe no tabuleiro");
        }
        return peca(posicao) != null;
    }

}
