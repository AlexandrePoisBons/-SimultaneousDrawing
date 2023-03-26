import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelBouton extends JPanel implements ActionListener{
    private JButton boutonCouleur;
    private JButton boutonEpaisseur;
    private JButton boutonRectangle;
    private JButton boutonCercle;
    private JButton boutonLigne;
    private JButton boutonEffacer;

    private Controleur c;
    
    
    public PanelBouton(JFrame frame, Controleur c){
        this.c = c;
        this.boutonCouleur = new JButton("Couleur");
        this.boutonEpaisseur = new JButton("Epaisseur");
        this.boutonRectangle = new JButton("Rectangle");
        this.boutonCercle = new JButton("Cercle");
        this.boutonLigne = new JButton("Ligne");
        this.boutonEffacer = new JButton("Effacer");
        
        this.add(boutonCouleur);
        this.add(boutonEpaisseur);
        this.add(boutonRectangle);
        this.add(boutonCercle);
        this.add(boutonLigne);
        this.add(boutonEffacer);
        
        this.boutonCouleur.addActionListener(this);
        this.boutonEpaisseur.addActionListener(this);
        this.boutonRectangle.addActionListener(this);
        this.boutonCercle.addActionListener(this);
        this.boutonLigne.addActionListener(this);
        this.boutonEffacer.addActionListener(this);
        this.setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource() == this.boutonCouleur){
            Color couleur = JColorChooser.showDialog(this, "Choisissez une couleur", Color.black);
            if (couleur != null)
                this.c.setCouleur(couleur);
        }
        else if(e.getSource() == this.boutonEpaisseur){
            /*open a dialog to choose the thickness*/
            String epaisseur = (String)JOptionPane.showInputDialog(this, "Choisissez une épaisseur", "Epaisseur", JOptionPane.PLAIN_MESSAGE, null, null, "1");
            if (epaisseur != null)
            try{
                this.c.setEpaisseur(Integer.parseInt(epaisseur));
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre entier", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == this.boutonRectangle){
            this.c.setTypeForme("Rectangle");
        }
        else if(e.getSource() == this.boutonCercle){
            this.c.setTypeForme("Cercle");
        }
        else if(e.getSource() == this.boutonLigne){
            this.c.setTypeForme("Ligne");
        }
        else if(e.getSource() == this.boutonEffacer){
            System.out.println("Effacer");
        }
        
    }
    
    

}
