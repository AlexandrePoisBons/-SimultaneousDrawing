package metier;
import java.awt.Color;
import java.util.UUID;

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

    private String id;

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
        this.id = UUID.randomUUID().toString();

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
        this.id = UUID.randomUUID().toString();
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

    public String serialize() {
        System.out.println(id +","+ typeForme + "," + xDebut + "," + yDebut + "," + xFin + "," + yFin + "," + couleur.getRGB() + "," + epaisseur + "," + rempli + "," + text);
        return typeForme + "," + xDebut + "," + yDebut + "," + xFin + "," + yFin + "," + couleur.getRGB() + "," + epaisseur + "," + rempli + "," + text;
    }

    public String getId() {
        return id;
    }

    public static Forme deserialize(String s) {
        String[] arr = s.split(",");
        Forme f = new Forme(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), new Color(Integer.parseInt(arr[5])), Integer.parseInt(arr[6]), Boolean.parseBoolean(arr[7]), arr[8]);
        return f;
    }


    
}
