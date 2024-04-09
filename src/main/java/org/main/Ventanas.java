package org.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventanas extends JFrame {
    private JTabbedPane tabbedPane;
    private int contadorDocumentos;

    public Ventanas() {
        setTitle("Sistema de Ventanas Múltiples");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        contadorDocumentos = 0;

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Archivo");
        JMenuItem menuItemNuevo = new JMenuItem("Nuevo");
        JMenuItem menuItemCerrar = new JMenuItem("Cerrar");

        menuItemNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNuevaVentana();
            }
        });

        menuItemCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrarVentanaActual();
            }
        });

        menu.add(menuItemNuevo);
        menu.add(menuItemCerrar);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        agregarNuevaVentana();
    }

    private void agregarNuevaVentana() {
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        tabbedPane.addTab("Documento " + (++contadorDocumentos), scrollPane);
    }

    private void cerrarVentanaActual() {
        int index = tabbedPane.getSelectedIndex();
        if (index != -1) {
            tabbedPane.remove(index);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Ventanas().setVisible(true);
            }
        });
    }
}
