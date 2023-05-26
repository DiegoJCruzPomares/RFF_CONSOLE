package archivos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Counter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RFFControllerTest {

    RFFController RFFController = new RFFController();

    @Test
    public void testCompareWithNonEmptyFolder() {
        // Preparación
        String folderPath = "C:\\Users\\JESUS\\Documents";
        RFFController yourClass = new RFFController();

        // Acción
        String[] result = yourClass.compare(folderPath);

        // Verificación
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.length > 0);
    }

    @Test
    public void testCompareWithEmptyFolder() {
        // Preparación
        String emptyFolderPath = "C:\\Users\\JESUS\\Documents\\Lightshot";
        RFFController yourClass = new RFFController();

        // Acción y verificación
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            yourClass.compare(emptyFolderPath);
        });
    }

    @Test
    public void testCompareWithInvalidFolderPath() {
        // Preparación
        String invalidFolderPath = "path/to/invalid/folder";
        RFFController yourClass = new RFFController();

        // Acción y verificación
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            yourClass.compare(invalidFolderPath);
        });
    }

    @Test
    public void testCounter() {
        // Preparación
        String[] folder1 = {"file1.txt", "file2.txt", "file3.txt"};
        String[] folder2 = {"file2.txt", "file3.txt", "file4.txt"};
        RFFController yourClass = new RFFController();

        // Acción
        int result = yourClass.counter(folder1, folder2);

        // Verificación
        Assertions.assertEquals(2, result);
    }

    @Test
    public void testSearchFile() {
        // Preparación
        String directoryPath = "C:\\Users\\JESUS\\Documents";
        String fileName = "entornos_final.pptx";
        RFFController yourClass = new RFFController();

        // Acción
        boolean result = yourClass.searchFile(directoryPath, fileName);

        // Verificación
        Assertions.assertTrue(result);
    }

}

