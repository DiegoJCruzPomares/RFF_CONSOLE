package archivos;

import java.io.File;

/**
 * Esta clase proporciona métodos para comparar archivos entre diferentes directorios y buscar archivos en un directorio.
 */

public class RFFController {

    private File tempfolder;

    /**
     * Compara los archivos en una carpeta determinada.
     *
     * @param fileName El nombre de la carpeta que se desea comparar.
     * @return Devuelve una lista con los nombres de los archivos presentes en la carpeta especificada.
     * @throws IllegalArgumentException si la carpeta no existe o está vacía.
     */

    public String [] compare(String fileName){

        tempfolder = new File(fileName);
        if (tempfolder.list().length == 0) {
            throw new IllegalArgumentException("This folder is empty, it doesn't exist, or couldn't find repeated files, please try another one: ");
        }

        return tempfolder.list();

    }

    /**
     * Se cuenta la cantidad de archivos repetidos entre dos directorios.
     *
     * @param folder1 Matriz que recoge los nombres de los archivos presentes en la primera carpeta.
     * @param folder2 Matriz que recoge los nombres de los archivos presentes en la segunda carpeta.
     * @return Devuelve el número de archivos repetidos entre las dos carpetas.
     */

    public int counter(String [] folder1, String [] folder2){

        int counter = 0;

        for(String file1 : folder1){
            for (String file2 : folder2){
                if(file1.equals(file2)){

                    counter++;
                    System.out.println("File: " + file1 + " is repeated.");

                }
            }
        }
        return counter;
    }

    /**
     * Busca un archivo específico en el directorio especificado y sus subdirectorios.
     *
     * @param directoryPath Almacena el directorio en el que se realiza la búsqueda.
     * @param NameOfFile Almacena el nombre del archivo que se desea buscar.
     */


    public boolean searchFile(String directoryPath, String NameOfFile) {

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (NameOfFile.equalsIgnoreCase(file.getName())) {
                        System.out.println("Found file: " + file.getAbsolutePath());
                        return true;
                    }
                }
            }
        }
        System.out.println("File not found");
        return false;
    }
}