package org.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Barra extends JFrame {
    private JTextArea textArea;
    private JScrollBar scrollBar;

    public Barra() {
        setTitle("Barra de Progreso");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        scrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, 101);

        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int value = e.getValue();
                int max = scrollBar.getMaximum();
                int height = textArea.getHeight();
                int scrollHeight = (int) (textArea.getDocument().getLength() * ((double) value / max));
                textArea.scrollRectToVisible(new Rectangle(0, scrollHeight - height, 0, height));
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setModel(scrollBar.getModel());

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Barra().setVisible(true);
            }
        });
    }
}

