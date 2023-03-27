package ihm;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import metier.Controleur;

public class FrameDepart extends JFrame implements ActionListener  {
    
    private Controleur c;
    private TextField ip;
    private TextField port;
    private TextField pseudo;
    private JButton connexion;
    private JButton creeServeur;

    public FrameDepart(Controleur c) {

        this.c = c;
        this.setSize(750, 750);
        this.setVisible(true);

        this.pseudo = new TextField("Pseudo");
        this.ip = new TextField("localhost");
        this.port = new TextField("1234");

        this.connexion = new JButton("Connexion");
        this.creeServeur = new JButton("Créer un serveur");

        connexion.addActionListener(this);
        creeServeur.addActionListener(this);

        


        Panel panel = new Panel();
        panel.setLayout(new GridLayout(4,2));
        
        panel.add(new JLabel("Pseudo : "));
        panel.add(pseudo);
        panel.add(new JLabel("IP : "));
        panel.add(ip);
        panel.add(new JLabel("Port : "));
        panel.add(port);
        panel.add(connexion);
        panel.add(creeServeur);

        
        
        
        this.add(panel);

        this.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.connexion){
            System.out.println("Connexion");
            c.joinServer(this.ip.getText(), this.port.getText());
            dispose();
            
        }
        if(e.getSource() == this.creeServeur){

            System.out.println("Création d'un serveur");
            if (c.startServer())
            {
                dispose();
                c.creeIhm();
            }
        }
    }
}
