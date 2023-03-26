import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Color;

public class PanelDessins extends JPanel implements MouseListener , ActionListener
{

    int baseX, baseY , newX , newY;
    JFrame frame;
    Controleur c;
    public PanelDessins(JFrame frame, Controleur c)
    {
        this.frame = frame;
        this.c = c;
        this.setSize(500, 500);
        this.setVisible(true);
        this.setBackground(Color.red);
        this.addMouseListener(this);

        this.baseX = this.baseY = this.newX = this.newY = 0;

    


    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.blue);

        ArrayList<Forme> arrForme = this.c.getArrForme();

        for (Forme f : arrForme){
            if (f.getTypeForme().equals("Cercle")){
                g.drawOval(f.getXDebut(), f.getYDebut(), f.getXFin(), f.getYFin());
            }
            else if (f.getTypeForme().equals("Rectangle")){
                g.drawRect(f.getXDebut(), f.getYDebut(), f.getXFin(), f.getYFin());
            }
            else if (f.getTypeForme().equals("Ligne")){
                g.drawLine(f.getXDebut(), f.getYDebut(), f.getXFin(), f.getYFin());
            }
        }


        
        //g.drawOval(this.baseX, this.baseY, this.newX, this.newY);
    }



    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        System.out.println("Action performed");
    }

    public void mouseClicked(java.awt.event.MouseEvent e)
    {
        System.out.println("Mouse clicked");
    }

    public void mouseEntered(java.awt.event.MouseEvent e)
    {
        System.out.println("Mouse entered");
    }

    public void mouseExited(java.awt.event.MouseEvent e)
    {
        System.out.println("Mouse exited");
    }


    public void mousePressed(java.awt.event.MouseEvent e)
    {
        System.out.println("Mouse pressed");
        this.baseX = e.getX();
        this.baseY = e.getY();


    }

    public void mouseReleased(java.awt.event.MouseEvent e)
    {
        System.out.println("Mouse released");
        this.newX = e.getX();
        this.newY = e.getY();


        this.c.creeForme("Ligne", this.baseX, this.baseY, this.newX, this.newY, Color.BLUE, 1);

        this.repaint();
    }



    

}
