
package clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface extends JFrame implements ActionListener {

    //atributos graficos da tela
    private JPanel pnDados, pnBotoes;
    private JLabel lbCodico, lbNome;
    private JTextField tfCodigo, tfNome;
    private JButton btNovo, btMostrar, btSair, btInserir, btAnterior, btProximo;
    private Container tela;

    private List<Cadastro> clientes = new ArrayList<>();

    private Cadastro cadastro = new Cadastro();

    private ListIterator<Cadastro> moveRegistro;
    
    private JStatusBar statusBar = new JStatusBar();

    Interface() {

        //Criação do que vai conter na tela
        tela = this.getContentPane();
        tela.setLayout(new BorderLayout());

        //Instanciar Paineis
        pnDados = new JPanel();
        pnBotoes = new JPanel();

        //Adicionar paineis na tela
        tela.add(pnDados, BorderLayout.CENTER);
        tela.add(pnBotoes, BorderLayout.NORTH);
        tela.add(statusBar, BorderLayout.SOUTH);

        //mudar o fundo do painel
        pnBotoes.setBackground(Color.GRAY);

        //Configurando componentes
        lbCodico = new JLabel("Código do Cliente:");
        lbNome = new JLabel("Nome do Cliente:");

        tfCodigo = new JTextField(10);
        tfNome = new JTextField(30);

        btNovo = new JButton("Novo");
        btInserir = new JButton("Inserir");
        btMostrar = new JButton("Mostrar");
        btSair = new JButton("Sair");
        btAnterior = new JButton("<");
        btProximo = new JButton(">");

        //Layout dos Paineis
        pnDados.setLayout(new GridLayout(2, 2));

        pnDados.add(lbCodico);
        pnDados.add(tfCodigo);

        pnDados.add(lbNome);
        pnDados.add(tfNome);

        pnBotoes.setLayout(new GridLayout(1, 6));

        pnBotoes.add(btNovo);
        pnBotoes.add(btInserir);
        pnBotoes.add(btAnterior);
        pnBotoes.add(btProximo);
        pnBotoes.add(btMostrar);
        pnBotoes.add(btSair);

        //Evento dos botoes
        btSair.addActionListener(this);
        btMostrar.addActionListener(this);
        btNovo.addActionListener(this);
        btInserir.addActionListener(this);
        btAnterior.addActionListener(this);
        btProximo.addActionListener(this);

        //tratamentos de erros
        tfCodigo.setEditable(false);
        pnDados.setVisible(false);

        btAnterior.setEnabled(false);
        btProximo.setEnabled(false);
        btMostrar.setEnabled(false);
        btInserir.setEnabled(false);

        //Criação da tela
        this.setTitle("Cadastro de Clientes");
        this.setSize(500, 120);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private void inserirClientes() {
        clientes.add(cadastro);
        moveRegistro = clientes.listIterator();
        ultimoCliente();
    }

    private void ultimoCliente() {
        for (; moveRegistro.hasNext(); moveRegistro.next());
    } 

    private void mostrarCliente(Cadastro cadastro) {
        clientes.forEach(item -> JOptionPane.showMessageDialog(null, item));
    }

    private void ordemClientes() {
        tfCodigo.setText(Integer.toString(clientes.get(moveRegistro.nextIndex() - 1).getCodCliente()));
        tfNome.setText(clientes.get(moveRegistro.nextIndex() - 1).getNomeCliente());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //quem realiza a ação
        if (e.getSource() == btSair) {
            System.exit(0);
        }
        if (e.getSource() == btNovo) {
            pnDados.setVisible(true);
            btInserir.setEnabled(true);

            tfCodigo.setText("");
            tfNome.setText("");
        }
        if (e.getSource() == btMostrar) {
            mostrarCliente(cadastro);
        }
        if (e.getSource() == btInserir) {
            cadastro = new Cadastro(tfNome.getText());
            tfCodigo.setText(Integer.toString(cadastro.getCodCliente()));
            statusBar.setText("Cadastro feito com sucesso!");
            
            inserirClientes();

            btMostrar.setEnabled(true);
            btAnterior.setEnabled(true);
            btProximo.setEnabled(true);
        }

        if (e.getSource() == btAnterior) {
            if (moveRegistro.hasPrevious()) {
            moveRegistro.previous();
        }
        ordemClientes();
        }

        if (e.getSource() == btProximo) {
           if (moveRegistro.hasNext()) {
            moveRegistro.next();
        }
        ordemClientes();
        }

    }
}
