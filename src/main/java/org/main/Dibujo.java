package org.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dibujo extends JFrame {
    private JPanel lienzo;
    private int xAnterior, yAnterior;

    public Dibujo() {
        setTitle("Aplicación de Dibujo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lienzo = new JPanel();
        lienzo.setBackground(Color.WHITE);

        lienzo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                xAnterior = e.getX();
                yAnterior = e.getY();
            }
        });

        lienzo.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Graphics g = lienzo.getGraphics();
                g.setColor(Color.BLACK);
                int x = e.getX();
                int y = e.getY();
                g.drawLine(xAnterior, yAnterior, x, y);
                xAnterior = x;
                yAnterior = y;
            }
        });

        getContentPane().add(lienzo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Dibujo().setVisible(true);
            }
        });
    }
}

