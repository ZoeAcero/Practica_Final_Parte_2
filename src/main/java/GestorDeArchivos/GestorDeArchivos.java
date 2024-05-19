package GestorDeArchivos;

import Experimento.Experimento;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class GestorDeArchivos {

    public static void guardarExperimento(Experimento experimento, String rutaArchivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(rutaArchivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(experimento);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Experimento cargarExperimento(String rutaArchivo) {
        Experimento experimento = null;
        try {
            FileInputStream fileIn = new FileInputStream(rutaArchivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            experimento = (Experimento) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Experimento class not found");
            c.printStackTrace();
            return null;
        }
        return experimento;
    }

    public static boolean archivoExiste(String rutaArchivo) {
        File file = new File(rutaArchivo);
        return file.exists();
    }

    public static boolean eliminarArchivo(String rutaArchivo) {
        File file = new File(rutaArchivo);
        return file.delete();
    }

    public static void guardarExperimentoComoNuevoArchivo(Experimento experimento, String rutaArchivo) {
        if (!archivoExiste(rutaArchivo)) {
            guardarExperimento(experimento, rutaArchivo);
        } else {
            System.out.println("El archivo ya existe. Por favor, elige otra ruta o nombre de archivo.");
        }
    }

    public static void listarArchivosExperimento(String directorio) {
        try (Stream<Path> paths = Files.walk(Paths.get(directorio))) {
            paths.filter(Files::isRegularFile)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
