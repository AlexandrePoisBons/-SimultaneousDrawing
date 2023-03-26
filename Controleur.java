
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Controleur {
    
    JFrame ihm;

    ArrayList<Forme> arrForme; 
    String typeForme;



    public Controleur() {
        arrForme = new ArrayList<Forme>();
        ihm = new Frame(this);
        typeForme = "Ligne";
        
    }

    public void creeForme(String typeForme, int xDebut, int yDebut, int xFin, int yFin, Color couleur, int epaisseur) {
        Forme f = new Forme(typeForme, xDebut, yDebut, xFin, yFin, couleur, epaisseur);
        arrForme.add(f);
    }

    public ArrayList<Forme> getArrForme() {
        return arrForme;
    }

    public void setTypeForme(String typeForme) {
        this.typeForme = typeForme;
    }

    public String getTypeForme() {
        return typeForme;
    }

    

    public static void main(String[] args) {
        Controleur c = new Controleur();
    }


    





}
