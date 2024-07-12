
package jogodavelha;

import java.util.Random;
import javax.swing.JOptionPane;

public class LogicaDoJogo {
    
    private Tabuleiro tabuleiro;
    private int rodadaJogo;
    private Jogador jogadorEscolhido, jogador1, jogador2;
    private boolean iniciado;
    private int simbolo;

    public LogicaDoJogo(Jogador jogador1, Jogador jogador2) {
        tabuleiro = new Tabuleiro();
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        
        this.rodadaJogo = 1;
        this.iniciado = true;
        
        this.simbolo = new Random().nextInt(2);
        
        jogadorEscolhido = jogador1;
        if(jogadorEscolhido instanceof Computador){
            acionaComputador();
        }
    
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public int getRodadaJogo() {
        return rodadaJogo;
    }

    public Jogador getJogadorEscolhido() {
        return jogadorEscolhido;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogado2() {
        return jogador2;
    }
    
    public boolean isIniciado(){
        return iniciado;
    }
    
    public void geraRodada(int i){
        marcaPosicao(i);
        if(this.iniciado){
            this.rodadaJogo++;
            jogadorEscolhido = ((jogadorEscolhido == jogador2)? jogador1:jogador2);
            verficaVez();
        }
    }
    
    public void verficaVez(){
        if(jogadorEscolhido instanceof Computador){
            acionaComputador();
        }
    }
        
    private void acionaComputador() {
        if(this.iniciado){
            int pos = new Random().nextInt(9);
            while(!tabuleiro.posicaoLivre(pos)){
                pos = new Random().nextInt(9);
            }
            marcaPosicao(pos);
            this.rodadaJogo++;
            jogadorEscolhido = ((jogadorEscolhido == jogador2)? jogador1:jogador2);
            verficaVez();
        }
    }    

    private void marcaPosicao(int pos) {
          if(jogadorEscolhido instanceof Humano){
              jogadorEscolhido.jogar(pos, tabuleiro, simbolo);
          }else if(jogadorEscolhido instanceof Computador){
              jogadorEscolhido.jogar(pos, tabuleiro, simbolo);
          }
          
          simbolo = Math.abs(simbolo - 1);
          
          if(verificaVencedor() || verificaEmpate()){
              this.iniciado = false;
          }
    }

    private boolean verificaVencedor() {
        if(tabuleiro.verificaVencedor()){
            if(jogadorEscolhido  == jogador1){
                JOptionPane.showMessageDialog(null, "Jogador 1 ganhou.");
                return true;
            }else if(jogadorEscolhido  == jogador2){
                JOptionPane.showMessageDialog(null, "Jogador 2 ganhou.");
                return true;
            }
        }
        return false;
        
    }

    private boolean verificaEmpate() {
        if(tabuleiro.tabuleiroCompleto()){
            JOptionPane.showMessageDialog(null, "Jogo empatado.");
            return true;
        }
        return false;
        
    }
    
}
