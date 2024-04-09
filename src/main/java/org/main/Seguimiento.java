package org.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Seguimiento extends JFrame {
    private JLabel etiquetaPosicion;

    public Seguimiento() {
        setTitle("Seguimiento del Ratón");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        etiquetaPosicion = new JLabel("Posición del ratón: ");
        etiquetaPosicion.setHorizontalAlignment(SwingConstants.CENTER);

        getContentPane().add(etiquetaPosicion, BorderLayout.SOUTH);

        // Agregar el MouseMotionListener para seguir el movimiento del ratón
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                actualizarPosicionRaton(e.getX(), e.getY());
            }
        });
    }

    // Método para actualizar la etiqueta con la posición actual del ratón
    private void actualizarPosicionRaton(int x, int y) {
        etiquetaPosicion.setText("Posición del ratón: (" + x + ", " + y + ")");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Seguimiento().setVisible(true);
            }
        });
    }
}

