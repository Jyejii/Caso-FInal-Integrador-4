package org.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Navegacion extends JFrame {
    private JComboBox<String> documentosComboBox;
    private JTextArea textArea;
    private JButton abrirButton;
    private List<String> nombresDocumentos;

    public Navegacion() {
        setTitle("Navegación de documentos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        documentosComboBox = new JComboBox<>();
        textArea = new JTextArea();
        abrirButton = new JButton("Abrir");

        nombresDocumentos = new ArrayList<>();
        cargarNombresDocumentos();

        for (String nombreDocumento : nombresDocumentos) {
            documentosComboBox.addItem(nombreDocumento);
        }

        abrirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirDocumentoSeleccionado();
            }
        });

        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Documentos disponibles: "));
        panelSuperior.add(documentosComboBox);

        JScrollPane scrollPane = new JScrollPane(textArea);

        getContentPane().add(panelSuperior, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(abrirButton, BorderLayout.SOUTH);
    }

    private void cargarNombresDocumentos() {

        nombresDocumentos.add("documento1.txt");
        nombresDocumentos.add("documento2.txt");
        nombresDocumentos.add("documento3.txt");
    }

    private void abrirDocumentoSeleccionado() {
        String nombreDocumentoSeleccionado = (String) documentosComboBox.getSelectedItem();
        if (nombreDocumentoSeleccionado != null) {
            try {
                File documento = new File(nombreDocumentoSeleccionado);
                BufferedReader reader = new BufferedReader(new FileReader(documento));
                StringBuilder contenidoDocumento = new StringBuilder();
                String linea;
                while ((linea = reader.readLine()) != null) {
                    contenidoDocumento.append(linea).append("\n");
                }
                reader.close();
                textArea.setText(contenidoDocumento.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al abrir el documento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Navegacion().setVisible(true);
            }
        });
    }
}
