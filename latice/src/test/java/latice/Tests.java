package latice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import latice.controler.Referee;
import latice.model.slate.Pool;

class Tests {
	private static Referee referee;
	private static Pool pool;
	
	@BeforeAll
	public static void setUp() {
		pool = new Pool();
		referee = new Referee();
	}
	
	
	@Test
	public void isPollFull() {
		assert(pool.getTiles().size() == 72);
	}
	
	@Test
	public void IsPlayerBagFilled() {
		Integer numberOfPlayers = 2;
    	List<String> names = new ArrayList<>();
    	names.add("Michel");
    	names.add("Jean");
    	
    	referee.distributeTilesToPlayers(names);
    	
		for (int i = 0; i < numberOfPlayers; i++) {
			assert (referee.getPlayers().get(i).getPlayerBag().getTiles().size() == 36);
		}
    	
	}
	
	

}
