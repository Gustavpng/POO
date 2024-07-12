package graficot1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class Janela extends JFrame implements ActionListener, MouseListener {
    
    private JPopupMenu puMenu;

    private JMenu menuForma;
    private JMenu menuCor;

    private JMenuItem itemForma1;
    private JMenuItem itemForma2;
    private JMenuItem itemForma3;

    private JMenuItem itemCor1;
    private JMenuItem itemCor2;
    private JMenuItem itemCor3;
    
    private int tipoForma;
    private int tipoCor;
    private Desenho desenho;
    
    Janela() {
        
        puMenu = new JPopupMenu();
        menuForma = new JMenu("Forma");
        menuCor = new JMenu("Cor");
        
        itemForma1 = new JMenuItem("Triangulo");
        itemForma2 = new JMenuItem("Retangulo");
        itemForma3 = new JMenuItem("Circulo");
        
        itemCor1 = new JMenuItem("Vermelho");
        itemCor2 = new JMenuItem("Azul");
        itemCor3 = new JMenuItem("Verde");

        menuForma.add(itemForma1);
        menuForma.add(itemForma2);
        menuForma.add(itemForma3);

        menuCor.add(itemCor1);
        menuCor.add(itemCor2);
        menuCor.add(itemCor3);

        puMenu.add(menuForma);
        puMenu.add(menuCor);
        
        this.addMouseListener(this);
        itemForma1.addActionListener(this);
        itemForma2.addActionListener(this);
        itemForma3.addActionListener(this);
        
        itemCor1.addActionListener(this);
        itemCor2.addActionListener(this);
        itemCor3.addActionListener(this);

        desenho = new Desenho(tipoForma, tipoCor);
        this.add(desenho);

        this.setTitle("Desenho");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == itemForma1){
            tipoForma = 1;
        }
        else if(e.getSource() == itemForma2){
            tipoForma = 2;
        }
        else if(e.getSource() == itemForma3){
            tipoForma = 3;
        }
        if(e.getSource() == itemCor1){
            tipoCor = 1;
        }        
        else if(e.getSource() == itemCor2){
            tipoCor = 2;
        }       
        else if(e.getSource() == itemCor3){
            tipoCor = 3;
        }
        
        desenho.setTipoForma(tipoForma);
        desenho.setTipoCor(tipoCor);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3){
            puMenu.show(this, e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
