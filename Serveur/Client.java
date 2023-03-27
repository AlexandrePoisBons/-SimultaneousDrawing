package Serveur;

import metier.Controleur;
import metier.Forme;

public class Client
{
    
    private ClientToServerSocket clientToServerSocket;
    private Controleur ctrl;

    public Client(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.ctrl.creeIhm();
        this.clientToServerSocket = new ClientToServerSocket(this.ctrl);
    }

    public void sendForme(Forme form)
    {
        this.clientToServerSocket.sendForme(form);
    }


    public void removeFrome(Forme form)
    {
        this.clientToServerSocket.removeForme(form);
        this.ctrl.getArrForme().clear();
        this.clientToServerSocket.requestDrawing();
    }

    public void copieClient(){
        this.ctrl.getArrForme().clear();
        this.clientToServerSocket.requestDrawing();
    }



    public Boolean Connect(String ip, int port)
    {

        if (this.clientToServerSocket.isAlive())
        {
            this.clientToServerSocket.Disconnect();
        }

        Boolean success = this.clientToServerSocket.Connect(ip, port);


        if (success)
        {
            
            this.clientToServerSocket.start();
            this.clientToServerSocket.requestDrawing();

        }

        return success;

    }




}