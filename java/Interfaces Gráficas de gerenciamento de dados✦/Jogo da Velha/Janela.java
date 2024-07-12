
package jogodavelha;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Janela extends JFrame implements ActionListener, Runnable{
    
    private Jogador jogador1, jogador2;
    private LogicaDoJogo logica;
    
    private ImageIcon icon;
    
    private final String caminho1 = "./src/img/o.png";
    private final String caminho2 = "./src/img/x.png";
    
    private JRadioButton rbHumano1, rbHumano2, rbComputador1, rbComputador2;
    
    private JPanel painelJogador1, painelJogador2, painelDesenho, painelBotoes, painelDados;
    
    private JLabel lbBarraT, lbBarraS;
    
    private JButton btIniciar;
    
    private JButton[] bts;
    
    private ButtonGroup gbJogador1, gbJogador2;
    
    Janela(){
        
        this.setSize(200,200);
        this.setLayout(new BorderLayout());
        
        painelDados = new JPanel(new GridLayout(3,1));
        painelBotoes = new JPanel(new GridLayout(3,3));
        painelDesenho = new JPanel(new BorderLayout());
        
        bts = new JButton[9];
        for(int i = 0; i< 9; i++){
            bts[i] = new JButton();
            painelBotoes.add(bts[i]);
        }
        
        lbBarraT = new JLabel("Jogador ===>");
        lbBarraS = new JLabel("Bom jogo");
        
        painelDesenho.add(lbBarraT,BorderLayout.NORTH);
        painelDesenho.add(painelBotoes,BorderLayout.CENTER);
        painelDesenho.add(lbBarraS,BorderLayout.SOUTH);
        
        painelJogador1 = new JPanel();
        painelJogador1.setBorder(BorderFactory.createTitledBorder("Jogador 1"));
        
        painelJogador2 = new JPanel();
        painelJogador2.setBorder(BorderFactory.createTitledBorder("Jogador 2"));
        
        gbJogador1 = new ButtonGroup();
        gbJogador2 = new ButtonGroup();
        
        rbHumano1 = new JRadioButton("Humano", true);
        rbHumano2 = new JRadioButton("Humano");
        
        rbComputador1 = new JRadioButton("Computador");
        rbComputador2 = new JRadioButton("Computador", true);
        
        gbJogador1.add(rbHumano1);
        gbJogador1.add(rbComputador1);
        
        gbJogador2.add(rbHumano2);
        gbJogador2.add(rbComputador2);
        
        btIniciar = new JButton("Iniciar");
        
        painelJogador1.add(rbHumano1);
        painelJogador1.add(rbComputador1);
        
        painelJogador2.add(rbHumano2);
        painelJogador2.add(rbComputador2);
        
        painelDados.add(painelJogador1);
        painelDados.add(painelJogador2);
        painelDados.add(btIniciar);
        
        this.add(painelDados, BorderLayout.WEST);
        this.add(painelDesenho);
        
        btIniciar.addActionListener(this);
        
        for(int i=0; i<9;i++){
            bts[i].addActionListener(this);
        }
        
        
        this.setTitle("Jogo da Velha");
        this.setSize(500,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == btIniciar){
             iniciarJogares();
             logica = new LogicaDoJogo(jogador1, jogador2);
             btIniciar.setText("Reiniciar");
             new Thread(this).start();
        }
         
        for(int i=0; i<9;i++){
            if(e.getSource() == bts[i]){
                if(logica == null){
                    JOptionPane.showMessageDialog(null, "Clique em inicar para começar o jogo");
                }else if(!logica.isIniciado()){
                    JOptionPane.showMessageDialog(null, "Clique em reinicar para começar o jogo");
                }else{
                    if(bts[i].getIcon() == null){
                        logica.geraRodada(i);
                    }
                }
            }
        }
    }

    private void iniciarJogares() {
        if (rbHumano1.isSelected()) {
            this.jogador1 = new Humano(1);
            lbBarraT.setText("Jogadores: Humano x ");
        }else{
            this.jogador1 = new Computador(1);
            lbBarraT.setText("Jogadores: Computador x ");
        }
        
        if (rbHumano2.isSelected()) {
            this.jogador2 = new Humano(2);
            lbBarraT.setText(lbBarraT.getText() + "Humano");
        }else{
            this.jogador2 = new Computador(2);
            lbBarraT.setText(lbBarraT.getText() + "Computador");
        }
        
    }
    
    public void reiniciaBotoes(){
        for(int i=0; i<9;i++){
            bts[i].setIcon(null);
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
                for(int i=0; i<9;i++){
                    if(logica.getTabuleiro().tabSimbolo[i] == 0){
                        icon = new ImageIcon(caminho1);
                        bts[i].setIcon(icon);
                    }else if(logica.getTabuleiro().tabSimbolo[i] == 1){
                        icon = new ImageIcon(caminho2);
                        bts[i].setIcon(icon);
                    }else{
                        bts[i].setIcon(null);
                    }        
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
