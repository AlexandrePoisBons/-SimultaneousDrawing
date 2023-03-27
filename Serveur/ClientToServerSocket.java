package Serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import metier.Controleur;
import metier.Forme;
@SuppressWarnings("unchecked") 
public class ClientToServerSocket extends Thread
{
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket socket;
    private Boolean running;
    private Controleur ctrl;
    
    public ClientToServerSocket(Controleur ctrl)
    {
        this.ctrl = ctrl;
    }

    public Boolean Connect(String ip, int port)
    {
        try
        {
            
            this.socket = new Socket(ip, port);

            if (this.socket.isConnected())
            {
                System.out.println("Connexion établie avec le serveur");
            }
            else
            {
                System.err.println("Impossible de se connecter au serveur");
                return false;
            }


            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.ois = new ObjectInputStream(socket.getInputStream());
            this.running = true;

            
        }
        catch (Exception e)
        {
            System.err.println("Echec de connection au serveur");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public void Disconnect()
    {
        this.running = false;
        try {
            this.socket.close();
        } catch (IOException e) {
        }

    }

    
    
    public void requestDrawing()
    {
        if (!this.running)
        {
            return;
        }

        try {
            this.oos.writeObject("requestDrawing");
        } catch (IOException e) {
            System.err.println("Echec a la récupération des dessins");
            e.printStackTrace();
        }

    }

    public void sendForme(Forme forme)
    {
        System.out.println("Client envoie forme");
        try {
            oos.reset();
            oos.writeObject("newDrawing");
            oos.writeObject(forme);
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void removeForme(Forme forme)
    {
        System.out.println("Client suprime forme ClientToServerSocket");
        try {
            oos.reset();
            oos.writeObject("removeDrawing");
            oos.writeObject(forme.getId());
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }



    @Override
    public void run()
    {
        while (this.running)
        {

            // Read the object sent by the server
            try
            {
                String command = (String)ois.readObject();
                if (command.equals("disconnect"))
                {
                    this.Disconnect();
                }
                
                if (command.equals("drawings"))
                {
                    this.ctrl.getArrForme().clear();
                    List<Forme> lstFormes = (List<Forme>)ois.readObject();
                    
                    for (Forme forme : lstFormes)
                    {
                        this.ctrl.getArrForme().add(forme);
                    }
                    this.ctrl.majIhm();
                }

                if (command.equals("newDrawing"))
                {
                    Forme forme = (Forme)ois.readObject();
                    this.ctrl.getArrForme().add(forme);
                    this.ctrl.majIhm();
                }

                if (command.equals("removeDrawing"))
                {
                    //this.ctrl.enleveFormeDuServeur((String)ois.readObject());
                    this.ctrl.copieServeur();
                    this.ctrl.majIhm();
                }

            }
            catch (Exception e)
            {
                System.err.println("Impossible de lire l'objet envoyé par le client");
                e.printStackTrace();
                break;
            }



        }
    }
    
}
