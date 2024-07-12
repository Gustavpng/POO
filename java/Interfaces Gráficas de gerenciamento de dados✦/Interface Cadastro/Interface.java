
package clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface extends JFrame implements ActionListener{
    
    //atributos graficos da tela
    private JPanel pnDados, pnBotoes;
    private JLabel lbCodico, lbNome;
    private JTextField tfCodigo, tfNome;
    private JButton btCriar, btMostrar, btSair;
    private Container tela;
    
    Cadastro cadastro = new Cadastro();
    
    Interface(){        
        
        //Criação do que vai conter na tela
        tela = this.getContentPane();
        tela.setLayout(new BorderLayout());
        
        //Instanciar Paineis
        pnDados = new JPanel();
        pnBotoes = new JPanel();
        
        //Adicionar paineis na tela
        tela.add(pnDados, BorderLayout.CENTER);
        tela.add(pnBotoes, BorderLayout.SOUTH);
       
        //mudar o fundo do painel
        pnBotoes.setBackground(Color.GRAY);
        
        //Configurando componentes
        lbCodico = new JLabel("Código do Cliente:");
        lbNome = new JLabel("Nome do Cliente:");
        
        tfCodigo = new JTextField(10);
        tfNome = new JTextField(30);
        
        btCriar = new JButton("Criar");
        btMostrar = new JButton("Mostrar");
        btSair = new JButton("Sair");
        
        pnDados.setLayout(new GridLayout(2,2));
        
        pnDados.add(lbCodico);
        pnDados.add(tfCodigo);

        pnDados.add(lbNome);
        pnDados.add(tfNome);
        
        pnBotoes.setLayout(new GridLayout(1,3));
        
        pnBotoes.add(btCriar);
        pnBotoes.add(btMostrar);
        pnBotoes.add(btSair);
        
        //Evento dos botoes
        btSair.addActionListener(this);
        btMostrar.addActionListener(this);
        btCriar.addActionListener(this);
        
        //Criação da tela
        this.setTitle("Cadastro de Clientes");
        this.setSize(400,120);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //quem realiza a ação
        if(e.getSource() == btSair){
            System.exit(0);
        }
        if(e.getSource() == btMostrar){
            System.out.println(cadastro);
        }      
        if(e.getSource() == btCriar){
            //cadastro.setCodCliente(tfCodigo.getText);
            cadastro.setNomeCliente(tfNome.getText());
            System.out.println("entrou");
        }
    }
    
}

