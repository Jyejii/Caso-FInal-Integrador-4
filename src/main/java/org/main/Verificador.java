package org.main;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.regex.*;

public class Verificador extends JFrame {
    private JTextField textField;
    private JLabel labelIndicador;

    public Verificador() {
        setTitle("Verificador de Email");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(20);
        labelIndicador = new JLabel();

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificarEmail();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarEmail();
            }
        });

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(textField);
        getContentPane().add(labelIndicador);

        verificarEmail();
    }

    private void verificarEmail() {
        String email = textField.getText();
        if (isValidEmail(email)) {
            labelIndicador.setText("Válido");
            labelIndicador.setForeground(Color.GREEN);
        } else {
            labelIndicador.setText("Inválido");
            labelIndicador.setForeground(Color.RED);
        }
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Verificador().setVisible(true);
            }
        });
    }
}


