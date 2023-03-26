
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Controleur {
    
    JFrame ihm;

    ArrayList<Forme> arrForme; 
    String typeForme;
    int epaisseur;
    Color couleur;
    boolean rempli;
    String texte;



    public Controleur() {
        arrForme = new ArrayList<Forme>();
        ihm = new Frame(this);
        typeForme = "Ligne";
        couleur = Color.black;
        epaisseur = 1;
        rempli = false;
        texte = "texte";

        
    }

    public void creeForme(String typeForme, int xDebut, int yDebut, int xFin, int yFin, Color couleur, int epaisseur, boolean rempli) {
        Forme f = new Forme(typeForme, xDebut, yDebut, xFin, yFin, couleur, epaisseur, rempli);
        arrForme.add(f);
    }

    public void creeForme(String typeForme, int xDebut, int yDebut, int xFin, int yFin, Color couleur, int epaisseur, boolean rempli, String text) {
        Forme f = new Forme(typeForme, xDebut, yDebut, xFin, yFin, couleur, epaisseur, rempli, text);
        arrForme.add(f);
    }


    public ArrayList<Forme> getArrForme() {
        return arrForme;
    }
    public void undo() {
        if (arrForme.size() > 0) {
            arrForme.remove(arrForme.size() - 1);
        }

        this.ihm.repaint();
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
