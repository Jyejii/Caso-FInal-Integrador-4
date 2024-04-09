package org.main;
import java.io.*;
import java.util.*;

public class AnalisisTexto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la ruta del archivo a analizar: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("El archivo especificado no existe o no es válido.");
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            // Contar palabras
            int wordCount = countWords(content.toString());
            System.out.println("Número de palabras en el documento: " + wordCount);

            // Estadísticas de uso de palabras
            Map<String, Integer> wordFrequency = calculateWordFrequency(content.toString());
            System.out.println("Estadísticas de uso de palabras:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para contar palabras en el texto
    private static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    // Método para calcular la frecuencia de uso de cada palabra
    private static Map<String, Integer> calculateWordFrequency(String text) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        if (text == null || text.isEmpty()) {
            return wordFrequency;
        }
        String[] words = text.split("\\s+");
        for (String word : words) {
            word = word.toLowerCase(); // Convertir la palabra a minúsculas para evitar diferencias de mayúsculas y minúsculas
            if (wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            } else {
                wordFrequency.put(word, 1);
            }
        }
        return wordFrequency;
    }
}

