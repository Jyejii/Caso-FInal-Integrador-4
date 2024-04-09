package org.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Comparador extends JFrame {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton compararButton;

    public Comparador() {
        setTitle("Comparación de archivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        compararButton = new JButton("Comparar");

        compararButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                compararArchivos();
            }
        });

        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        JScrollPane scrollPane2 = new JScrollPane(textArea2);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(1, 2));
        panelSuperior.add(scrollPane1);
        panelSuperior.add(scrollPane2);

        getContentPane().add(panelSuperior, BorderLayout.CENTER);
        getContentPane().add(compararButton, BorderLayout.SOUTH);
    }

    private void compararArchivos() {
        String textoArchivo1 = textArea1.getText();
        String textoArchivo2 = textArea2.getText();

        if (textoArchivo1.equals(textoArchivo2)) {
            JOptionPane.showMessageDialog(this, "Los archivos son iguales.", "Resultado de la comparación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Los archivos son diferentes.", "Resultado de la comparación", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Comparador().setVisible(true);
            }
        });
    }
}

