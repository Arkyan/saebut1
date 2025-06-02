package latice;

import latice.controler.Referee;

import static latice.view.console.Console.SEPARATOR_LINE;
import static latice.view.console.Console.message;

public class LaticeApplicationConsole {
	
	
	public static void main(String[] args) {
		Referee referee = new Referee();        
		message(SEPARATOR_LINE);
		message("-- Welcome in our wonderful Latice game --");
		message("-- Developped by : Jules                --");
		message("-- Developped by : Max                  --");
		message("-- Developped by : Martin               --");
		message("-- Developped by : Alexandre            --");
		message(SEPARATOR_LINE);
		message("Let's end the v7 with FX!");
		
        message(referee.getName() + " is now managing the game!");
        referee.prepareGame();
		
	}
}
