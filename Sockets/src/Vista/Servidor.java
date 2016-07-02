/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.*;
import static java.awt.PageAttributes.MediaType.D;
import java.io.DataInputStream;
import java.io.IOException;
import javax.swing.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Servidor extends JFrame implements Runnable {

    private JTextArea texto;

    public static void main(String[] args) {
        new Servidor();
    }

    public Servidor() {
        super("Algo");
        this.setBounds(400, 400, 400, 400);

        texto = new JTextArea();

        texto.setBackground(Color.LIGHT_GRAY);
        this.add(texto);

        Thread hilo = new Thread(this);
        hilo.start();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void run() {
        try {
            ServerSocket servidorSocket = new ServerSocket(9989);
            servidorSocket.bind(new InetSocketAddress("192.168.1.1",0));
            while (true) {
                Socket miSocket = servidorSocket.accept();
                DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                this.texto.append("\n" + flujoEntrada.readUTF());
                 //JOptionPane.showMessageDialog(null,cambiaPalabra,"Funciona",JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
