package org.main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Buscador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la ruta del archivo a analizar: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("El archivo especificado no existe o no es válido.");
            return;
        }

        System.out.print("Ingrese la palabra a buscar: ");
        String wordToSearch = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int occurrences = searchWord(reader, wordToSearch);
            System.out.println("La palabra \"" + wordToSearch + "\" aparece " + occurrences + " veces en el documento.");
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static int searchWord(BufferedReader reader, String word) throws IOException {
        int count = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String w : words) {
                if (w.equalsIgnoreCase(word)) { // Ignora diferencias de mayúsculas y minúsculas
                    count++;
                }
            }
        }
        return count;
    }
}

