package latice.console;

import java.util.Scanner;

public class Console {
	private final static String SEPARATOR_LINE = "----------------------------------------"; 
	private static Scanner scanner = new Scanner(System.in);

    public static String input(String question) {
        try {
            System.out.print(question + " : ");
            String result = scanner.nextLine();
            return result != null && !result.trim().isEmpty() ? result : null;
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la lecture de l'entrée : " + e.getMessage());
            return null;
        }
    }
	
	public static void message(String message) {
		System.out.println(message);
	}
	
	public static void coloredmessage(String message, ColorConsole color) {
		System.out.println(color.getCode() + message + "\u001B[0m");
	}
	
	public static void sepLine() {
		message(SEPARATOR_LINE);
	}
	
	public static void title(String title) {
		message(SEPARATOR_LINE);
		message(SEPARATOR_LINE);
		message(title);
		message(SEPARATOR_LINE);
		message(SEPARATOR_LINE);
	}
	
	public static Integer inputint(String question, Integer min, Integer max) {
		while (true) {
			System.out.print(question);
			try {
				String input = scanner.next(); 
				try {
					Integer result = Integer.parseInt(input); 
					if (result < min || result > max) {
						System.out.println("Le nombre doit être compris entre " + min + " et " + max + ". Veuillez réessayer.");
					} else {
						return result;
					}
				} catch (NumberFormatException nfe) {
					System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
				}
			} catch (Exception e) {
				System.out.println("Une erreur s'est produite lors de la lecture de l'entrée : " + e.getMessage());
				return null;
			}
		}
	}

	
}
	
	
	

