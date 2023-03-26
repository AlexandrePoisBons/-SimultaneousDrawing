package ihm;
import javax.swing.JFrame;
import javax.swing.JPanel;

import metier.Controleur;
import metier.Forme;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

public class PanelDessins extends JPanel implements MouseListener , ActionListener , MouseMotionListener
{

    private int baseX, baseY , newX , newY;
    private Controleur c;
    private Boolean isPressed;
    public PanelDessins(JFrame frame, Controleur c)
    {
        this.c = c;
        this.isPressed = false;
        
        this.setSize(500, 500);
        this.setVisible(true);
        this.setBackground(Color.white);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.baseX = this.baseY = this.newX = this.newY = 0;

    


    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); 

        Graphics2D g2 = (Graphics2D) g;
        
        //g.setStroke(new java.awt.BasicStroke(2));

        ArrayList<Forme> arrForme = this.c.getArrForme();

        for (Forme f : arrForme){
            g2.setStroke(new java.awt.BasicStroke(f.getEpaisseur()));
            g2.setColor(f.getCouleur());
            if (f.getTypeForme().equals("Cercle")){
                int x2 = f.getXFin() - f.getXDebut();
                int y2 = f.getYFin() - f.getYDebut();

                if(f.getRempli()){
                    if (x2 >0 && y2 > 0){
                        g2.fillOval(f.getXDebut(), f.getYDebut(), x2,y2);
                    }
                    else if (x2 < 0 && y2 < 0){
                        g2.fillOval(f.getXFin(), f.getYFin(), -x2,-y2);
                    }
                    else if (x2 < 0 && y2 > 0){
                        g2.fillOval(f.getXFin(), f.getYDebut(), -x2,y2);
                    }
                    else if (x2 > 0 && y2 < 0){
                        g2.fillOval(f.getXDebut(), f.getYFin(), x2,-y2);
                    }
                }
                else{
                    if (x2 >0 && y2 > 0){
                        g2.drawOval(f.getXDebut(), f.getYDebut(), x2,y2);
                    }
                    else if (x2 < 0 && y2 < 0){
                        g2.drawOval(f.getXFin(), f.getYFin(), -x2,-y2);
                    }
                    else if (x2 < 0 && y2 > 0){
                        g2.drawOval(f.getXFin(), f.getYDebut(), -x2,y2);
                    }
                    else if (x2 > 0 && y2 < 0){
                        g2.drawOval(f.getXDebut(), f.getYFin(), x2,-y2);
                    }
                }
                
            }
            else if (f.getTypeForme().equals("Rectangle")){


                int x2 = f.getXFin() - f.getXDebut();
                int y2 = f.getYFin() - f.getYDebut();

                if(f.getRempli()){
                    if (x2 >0 && y2 > 0){
                        g2.fillRect(f.getXDebut(), f.getYDebut(), x2,y2);
                    }
                    else if (x2 < 0 && y2 < 0){
                        g2.fillRect(f.getXFin(), f.getYFin(), -x2,-y2);
                    }
                    else if (x2 < 0 && y2 > 0){
                        g2.fillRect(f.getXFin(), f.getYDebut(), -x2,y2);
                    }
                    else if (x2 > 0 && y2 < 0){
                        g2.fillRect(f.getXDebut(), f.getYFin(), x2,-y2);
                    }
                }
                else{
                    if (x2 >0 && y2 > 0){
                        g2.drawRect(f.getXDebut(), f.getYDebut(), x2,y2);
                    }
                    else if (x2 < 0 && y2 < 0){
                        g2.drawRect(f.getXFin(), f.getYFin(), -x2,-y2);
                    }
                    else if (x2 < 0 && y2 > 0){
                        g2.drawRect(f.getXFin(), f.getYDebut(), -x2,y2);
                    }
                    else if (x2 > 0 && y2 < 0){
                        g2.drawRect(f.getXDebut(), f.getYFin(), x2,-y2);
                    }
                }

            }
            else if (f.getTypeForme().equals("Ligne")){
                g2.drawLine(f.getXDebut(), f.getYDebut(), f.getXFin(), f.getYFin());
            }
            else if (f.getTypeForme().equals("Texte")){
                g2.setFont(new Font("Arial", Font.PLAIN, f.getYFin()-f.getYDebut() > 0 ? f.getYFin()-f.getYDebut() : f.getYDebut()-f.getYFin()));
                System.out.println(f.getText());
                g2.drawString(f.getText(), f.getXDebut(), f.getYDebut());
            }
            
        }

        if (this.isPressed){
            g2.setStroke(new java.awt.BasicStroke(this.c.getEpaisseur()));
            g.setColor(this.c.getCouleur());
            if (this.c.getTypeForme().equals("Cercle")){
                int x2 = this.newX - this.baseX;
                int y2 = this.newY - this.baseY;


                if(this.c.getRempli()){
                    if (x2 >0 && y2 > 0){
                        g2.fillOval(this.baseX, this.baseY, x2,y2);
                    }
                    else if (x2 < 0 && y2 < 0){
                        g2.fillOval(this.newX, this.newY, -x2,-y2);
                    }
                    else if (x2 < 0 && y2 > 0){
                        g2.fillOval(this.newX, this.baseY, -x2,y2);
                    }
                    else if (x2 > 0 && y2 < 0){
                        g2.fillOval(this.baseX, this.newY, x2,-y2);
                    }
                }
                else{
                    if (x2 >0 && y2 > 0){
                        g2.drawOval(this.baseX, this.baseY, x2,y2);
                    }
                    else if (x2 < 0 && y2 < 0){
                        g2.drawOval(this.newX, this.newY, -x2,-y2);
                    }
                    else if (x2 < 0 && y2 > 0){
                        g2.drawOval(this.newX, this.baseY, -x2,y2);
                    }
                    else if (x2 > 0 && y2 < 0){
                        g2.drawOval(this.baseX, this.newY, x2,-y2);
                    }

                }

            }
            else if (this.c.getTypeForme().equals("Rectangle")){
                int x2 = this.newX - this.baseX;
                int y2 = this.newY - this.baseY;
                
                if(this.c.getRempli()){
                    if (x2 >0 && y2 > 0){
                        g2.fillRect(this.baseX, this.baseY, x2,y2);
                    }
                    else if (x2 < 0 && y2 < 0){
                        g2.fillRect(this.newX, this.newY, -x2,-y2);
                    }
                    else if (x2 < 0 && y2 > 0){
                        g2.fillRect(this.newX, this.baseY, -x2,y2);
                    }
                    else if (x2 > 0 && y2 < 0){
                        g2.fillRect(this.baseX, this.newY, x2,-y2);
                    }
                }
                else{
                if (x2 >0 && y2 > 0){
                    g2.drawRect(this.baseX, this.baseY, x2,y2);
                }
                else if (x2 < 0 && y2 < 0){
                    g2.drawRect(this.newX, this.newY, -x2,-y2);
                }
                else if (x2 < 0 && y2 > 0){
                    g2.drawRect(this.newX, this.baseY, -x2,y2);
                }
                else if (x2 > 0 && y2 < 0){
                    g2.drawRect(this.baseX, this.newY, x2,-y2);
                }
                }
            }
            else if (this.c.getTypeForme().equals("Ligne")){
                g2.drawLine(this.baseX, this.baseY, this.newX, this.newY);
            }
            else if (this.c.getTypeForme().equals("Texte")){
                g2.setFont(new Font("Arial", Font.PLAIN, this.newY-this.baseY > 0 ? this.newY-this.baseY : this.baseY-this.newY));
                g2.drawString(this.c.getTexte(), this.baseX, this.baseY);
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
        this.baseX = e.getX();
        this.baseY = e.getY();

        this.isPressed = true;




    }

    public void mouseDragged(java.awt.event.MouseEvent e)
    {
        this.newX = e.getX();
        this.newY = e.getY();

        this.repaint();

        
    }

    public void mouseReleased(java.awt.event.MouseEvent e)
    {
        this.newX = e.getX();
        this.newY = e.getY();

        this.isPressed = false;

        if(this.c.getTypeForme().equals("Texte")){
            this.c.creeForme(this.c.getTypeForme(), this.baseX, this.baseY, this.newX, this.newY, this.c.getCouleur(), this.c.getEpaisseur(),this.c.getRempli(),this.c.getTexte());
        }
        else{
            this.c.creeForme(this.c.getTypeForme(), this.baseX, this.baseY, this.newX, this.newY, this.c.getCouleur(), this.c.getEpaisseur(),this.c.getRempli());
        }
        

        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        return;
    }



    

}
