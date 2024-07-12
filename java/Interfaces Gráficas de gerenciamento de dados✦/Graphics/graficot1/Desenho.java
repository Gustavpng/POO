
package graficot1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JComponent;

public class Desenho extends  JComponent{
    
    private int tipoForma;
    private int tipoCor;

    public Desenho(int tipoForma, int tipoCor) {
        this.tipoForma = tipoForma;
        this.tipoCor = tipoCor;
    }

    public int getTipoForma() {
        return tipoForma;
    }

    public int getTipoCor() {
        return tipoCor;
    }

    public void setTipoForma(int tipoForma) {
        this.tipoForma = tipoForma;
        repaint();
    }

    public void setTipoCor(int tipoCor) {
        this.tipoCor = tipoCor;
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        
        switch (this.tipoCor) {
            case 1:
                g.setColor(Color.red);
                break;
            case 2:
                g.setColor(Color.blue);
                break;
            case 3:
                g.setColor(Color.green);
                break;
            default:
                break;
        }
        
        switch (this.tipoForma) {
            case 1:
                Polygon p = new Polygon();
                p.addPoint(25, 10);
                p.addPoint(10, 40);
                p.addPoint(40, 40);
                g.fillPolygon(p);
                break;
            case 2:
                g.fillRect(10, 10, 30, 30);
                break;
            case 3:
                g.fillOval(10, 10, 30, 30);
                break;
            default:
                break;
        }
        
    }
    
}
