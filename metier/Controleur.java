package metier;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import ihm.Frame;
import ihm.FrameDepart;

import Serveur.*;
public class Controleur {
    
    JFrame ihm;

    JFrame ihmDepart;

    ArrayList<Forme> arrForme; 
    String typeForme;
    int epaisseur;
    Color couleur;
    boolean rempli;
    String texte;
    Client client;
    ServerThread serveur;



    public Controleur() {
        arrForme = new ArrayList<Forme>();
        typeForme = "Ligne";
        couleur = Color.black;
        epaisseur = 1;
        rempli = false;
        texte = "texte";
        ihm = null;

        new FrameDepart(this);
        
    }

    public void creeIhm(){
        ihm = new Frame(this);
    }

    public void majIhm(){
        this.ihm.repaint();
    }

    public void creeForme(String typeForme, int xDebut, int yDebut, int xFin, int yFin, Color couleur, int epaisseur, boolean rempli) {
        Forme f = new Forme(typeForme, xDebut, yDebut, xFin, yFin, couleur, epaisseur, rempli);
        if (this.client != null)
        {
            this.client.sendForme(f);
        }
        else if (this.serveur != null)
        {
            this.serveur.broadcastForme(f);
        }
        arrForme.add(f);
    }

    public void creeForme(String typeForme, int xDebut, int yDebut, int xFin, int yFin, Color couleur, int epaisseur, boolean rempli, String text) {
        Forme f = new Forme(typeForme, xDebut, yDebut, xFin, yFin, couleur, epaisseur, rempli, text);

        if (this.client != null)
        {
            this.client.sendForme(f);
        }
        else if (this.serveur != null)
        {
            this.serveur.broadcastForme(f);
        }
        arrForme.add(f);
    }

    public Boolean startServer()
    {
        if (this.serveur == null)
        {
            this.serveur = new ServerThread(this);
            this.serveur.start();
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean joinServer(String ip, String port)
    {
        this.client = new Client(this);

        
        
        return this.client.Connect(ip, Integer.parseInt(port));

    }


    public synchronized ArrayList<Forme>  getArrForme() {
        return arrForme;
    }
    public void undo() {
        if (arrForme.size() > 0) {
            Forme tmp = arrForme.get(arrForme.size() - 1);
            
            if (this.client != null)
            {
                //this.arrForme.remove(tmp);
                this.arrForme.clear();
                this.client.removeFrome(tmp);

                

            }
            else if (this.serveur != null)
            {
                this.arrForme.remove(tmp);
                this.serveur.broadcastRemoveForme(tmp);
            }
        
        }

        this.ihm.repaint();
    }

    public void enleveFormeDuServeur(String id)
    {
        for (int i = 0; i < arrForme.size(); i++)
        {
            if (arrForme.get(i).getId().equals(id))
            {
    
                arrForme.remove(i);
                break;
            }
        }
        this.majIhm();
    }



    public void setTypeForme(String typeForme) {
        this.typeForme = typeForme;
    }

    public String getTypeForme() {
        return typeForme;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setEpaisseur(int epaisseur) {
        this.epaisseur = epaisseur;
    }

    public int getEpaisseur() {
        return epaisseur;
    }

    public void setRempli(boolean selected) {
        this.rempli = selected;
    }

    public boolean getRempli() {
        return rempli;
    }

    public void setTexte(String text) {
        this.texte = text;
    }

    public String getTexte() {
        return texte;
    }

    

    public static void main(String[] args) {
        Controleur c = new Controleur();
    }


   


    





}
