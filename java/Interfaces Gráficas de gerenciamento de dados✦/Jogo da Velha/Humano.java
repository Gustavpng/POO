package jogodavelha;

public class Humano extends Jogador{

    public Humano(int jogador) {
        super(jogador);
    }

    @Override
    public void jogar(int pos, Tabuleiro tabuleiro, int simbolo) {
        tabuleiro.marcaTabuleiro(pos, 1, simbolo);
    }
}
