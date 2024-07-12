package jogodavelha;

public class Computador extends Jogador{

    public Computador(int jogador) {
        super(jogador);
    }

    @Override
    public void jogar(int pos, Tabuleiro tabuleiro, int simbolo) {
        tabuleiro.marcaTabuleiro(pos, 2, simbolo);
    }
    
}
