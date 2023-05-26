package archivos;

import java.util.Scanner;

/**
 * Esta clase alberga funcionalidades para a búsqueda de archivos y la comparación de directorios en busca de archivos repetidos.
 */


public class RFF {

	/**
	 * Método principal que se encarga de ejecutar la búsqueda de archivos y de comparar directorios para encontrar archivos repetidos.
	 */

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String[] folder1;
		String[] folder2;
		// Directorio raíz donde se realizará la búsqueda
		String directory = "";

		// Nombre del archivo a buscar
		String NameOfFile;

		String repeat = "";
		RFFController controller = new RFFController();
		do {
			try {
				System.out.println("1. Search files.\n2. Compare directories.");
				Scanner read1 = new Scanner(System.in);
				int option = read1.nextInt();
				switch (option) {
					case 1:
						System.out.println("Introduce the name of the file you would like to search: ");
						NameOfFile = read.nextLine();
						System.out.println("Introduce the directory in which you would like to search: ");
						directory = read.nextLine();
						controller.searchFile(directory, NameOfFile);
						break;
					case 2:
						System.out.println("First directory: ");
						folder1 = controller.compare(read.nextLine());
						System.out.println("Second directory: ");
						folder2 = controller.compare(read.nextLine());
						int counterRepeat = controller.counter(folder1, folder2);
						System.out.println("There are " + counterRepeat + " repeated files.");
						break;
				}
			} catch (Exception e) {
			}
			System.out.println("Would you like to do another comparison? Write 'y' to execute the program again, or write 'n' to finish the program");
			repeat = read.nextLine();
		} while (repeat.equalsIgnoreCase("y"));
		System.out.println("Program finished. Bye.");
		read.close();
	}

}