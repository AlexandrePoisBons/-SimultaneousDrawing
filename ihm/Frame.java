package ihm;
import javax.swing.JFrame;
import javax.swing.JPanel;

import metier.Controleur;

public class Frame extends JFrame

{
    Controleur c;
    public Frame(Controleur c){
        JPanel panelDessin;
        JPanel panelBouton;
        this.c = c;
        panelDessin = new PanelDessins(this,c);
        panelBouton = new PanelBouton(this,c);

        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.BorderLayout());
        panel.add(panelBouton, java.awt.BorderLayout.NORTH);
        panel.add(panelDessin, java.awt.BorderLayout.CENTER);
        this.add(panel);

        this.setSize(750, 750);
        this.setVisible(true);
    }



}