package jogodavelha;

public abstract class Jogador {
    
    protected int jogador;

    public Jogador(int jogador) {
        this.jogador = jogador;
    }

    public abstract void jogar(int pos, Tabuleiro tabuleiro, int simbolo);
    
}
