package latice.view.console;

import java.util.Scanner;

public class Console {
	public final static String SEPARATOR_LINE = "----------------------------------------"; 
	private static Scanner scanner = new Scanner(System.in);

    public static String input(String question) {
        try {
            System.out.print(question + " : ");
            String result = scanner.nextLine();
            return result != null && !result.trim().isEmpty() ? result : null;
        } catch (Exception e) {
            message("Une erreur s'est produite lors de la lecture de l'entrée : " + e.getMessage());
            return null;
        }
    }
	
	public static void message(String message) {
		System.out.println(message);
	}
	
	public static void coloredMessage(String message, ColorConsole color) {
		message(color.getCode() + message + "\u001B[0m");
	}
	
	public static void sepLine(Integer number) {
		for (Integer index = 0; index < number; index++) {
			System.out.print(SEPARATOR_LINE);
		}
		message("");
	}
	
	public static void title(String title) {
		message(SEPARATOR_LINE);
		message(SEPARATOR_LINE);
		message(title);
		message(SEPARATOR_LINE);
		message(SEPARATOR_LINE);
	}
	
	public static Integer inputInt(String question, Integer min, Integer max) {
		while (true) {
			System.out.print(question);
			try {
				String input = scanner.next(); 
				try {
					Integer result = Integer.parseInt(input); 
					if (result < min || result > max) {
						message("Le nombre doit être compris entre " + min + " et " + max + ". Veuillez réessayer.");
					} else {
						return result;
					}
				} catch (NumberFormatException nfe) {
					message("Entrée invalide. Veuillez entrer un nombre entier.");
				}
			} catch (Exception e) {
				message("Une erreur s'est produite lors de la lecture de l'entrée : " + e.getMessage());
				return null;
			}
		}
	}

	
}
	
	
	

