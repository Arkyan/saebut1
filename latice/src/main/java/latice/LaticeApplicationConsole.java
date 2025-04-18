package latice;

import latice.controler.Referee;

public class LaticeApplicationConsole {
	
	
	public static void main(String[] args) {
		Referee referee = new Referee();        
		System.out.println("------------------------------------------");
		System.out.println("-- Welcome in our wonderful Latice game --");
		System.out.println("-- Developped by : Jules                --");
		System.out.println("-- Developped by : Max                  --");
		System.out.println("-- Developped by : Martin               --");
		System.out.println("-- Developped by Alexandre              --");
		System.out.println("------------------------------------------");
		
        System.out.println(referee.getName() + " is now managing the game!");
        referee.prepareGame();
		
	}
}
