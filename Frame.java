import javax.swing.JFrame;
import javax.swing.JPanel;

class Frame extends JFrame

{
    Controleur c;
    public Frame(Controleur c){
        JPanel panelDessin;
        this.c = c;
        panelDessin = new PanelDessins(this);
        this.add(panelDessin);
        this.setSize(500, 500);
        this.setVisible(true);
    }
}