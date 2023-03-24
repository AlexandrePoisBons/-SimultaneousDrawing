import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.Color;

public class PanelDessins extends JPanel implements MouseListener , ActionListener
{

    int baseX, baseY , newX , newY;
    JFrame frame;
    public PanelDessins(JFrame frame)
    {
        this.frame = frame;
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
        g.drawOval(this.baseX, this.baseY, this.newX, this.newY);
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

        this.repaint();
    }



    

}
