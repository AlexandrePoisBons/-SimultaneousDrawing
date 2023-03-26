import java.awt.Color;

public class Forme {
    private String typeForme;
    private int xDebut;
    private int yDebut;
    private int xFin;
    private int yFin;
    private Color couleur;
    private int epaisseur;
    private boolean rempli;
    private String text;

    /*
     * Constructeur de la classe Forme
     * @param typeForme : type de la forme
     * @param xDebut : coordonnée x du début de la forme aka : RECT/CIRC/ELLI/ROUND etc ...
     * @param yDebut : coordonnée y du début de la forme
     * @param xFin : coordonnée x de la fin de la forme
     * @param yFin : coordonnée y de la fin de la forme
     * @param couleur : couleur de la forme
     * @param epaisseur : épaisseur de la forme
     */
    public Forme(String typeForme, int xDebut, int yDebut, int xFin, int yFin, Color couleur, int epaisseur, boolean rempli) {
        this.typeForme = typeForme;
        this.xDebut = xDebut;
        this.yDebut = yDebut;
        this.xFin = xFin;
        this.yFin = yFin;
        this.couleur = couleur;
        this.epaisseur = epaisseur;
        this.rempli = rempli;
        this.text = "";
    }
    public Forme(String typeForme, int xDebut, int yDebut, int xFin, int yFin, Color couleur, int epaisseur, boolean rempli, String text) {
        this.typeForme = typeForme;
        this.xDebut = xDebut;
        this.yDebut = yDebut;
        this.xFin = xFin;
        this.yFin = yFin;
        this.couleur = couleur;
        this.epaisseur = epaisseur;
        this.rempli = rempli;
        this.text = text;
    }

    public String getTypeForme() {
        return typeForme;
    }

    //getter
    public int getXDebut() {
        return xDebut;
    }
    

    public int getYDebut() {
        return yDebut;
    }

    public int getXFin() {
        return xFin;
    }

    public int getYFin() {
        return yFin;
    }

    public Color getCouleur() {
        return couleur;
    }

    public int getEpaisseur() {
        return epaisseur;
    }

    public boolean getRempli() {
        return rempli;
    }

    public String getText() {
        return text;
    }


    
}
