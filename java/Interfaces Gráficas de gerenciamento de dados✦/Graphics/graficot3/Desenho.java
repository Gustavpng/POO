
package graficot3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

public class Desenho extends JComponent implements Runnable{
    
    private int forma;
    private Color cor;
    private int px = 5, py = 5;
    private int direcao = 1;

    public Desenho(int forma, Color cor) {
        this.forma = forma;
        this.cor = cor;
        new Thread(this).start();
       
    }

    public void setForma(int forma) {
        this.forma = forma;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public void setPy(int py) {
        this.py = py;
    }
    
    @Override
    public void paint (Graphics g){
       g.setColor(cor);
       
       if (forma == 1){
           g.fillRect(px, py, 20, 20);
       }else if(forma == 2){
           g.fillOval(px, py, 20, 20);
       }
    }
    
    private void movimenta(){
        if(px > this.getWidth() - 25){
            direcao = 2;
        }
        if(px < 6){
            direcao = 1;
        }
        
        
        if(direcao == 1){
            px += 1;
        }else if(direcao == 2){
            px -= 1;
        }  
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
                movimenta();
                repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(Desenho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
