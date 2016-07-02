/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.net.*;
import java.util.*;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Cliente extends JFrame {

    private JButton boton;
    private JTextField texto;
    private JLabel etiqueta;
    private String cambiaPalabra;
    public Cliente() {
        super("racing");
        boton = new JButton("Aceptar");
        boton.setSize(20, 20);
        texto = new JTextField(20);
        etiqueta = new JLabel("Escribe");
        etiqueta.setForeground(Color.green);
        
        setBounds(600, 300, 280, 350);
        
        JPanel panel = new JPanel();
        panel.add(etiqueta);
        panel.setBackground(Color.BLUE);
        panel.add(texto);
        panel.add(boton);
        this.add(panel);
        cambiaPalabra="fefe";
        //Agregar Eventos
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                QueHacer();
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void QueHacer(){
        try {
            Socket miSocket= new Socket("192.168.1.1",9989);
            DataOutputStream flujoDeSalida= new DataOutputStream(miSocket.getOutputStream());
            flujoDeSalida.writeUTF(texto.getText());
            flujoDeSalida.close();
            
           // JOptionPane.showMessageDialog(null,cambiaPalabra,"Funciona",JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
