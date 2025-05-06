package latice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import latice.controler.Referee;
import latice.model.slate.Color;
import latice.model.slate.Pool;
import latice.model.slate.Shape;
import latice.model.slate.Tile;

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
	
	@Test
	public void isPlayerRackFilled() {
		//arrange
		Integer numberOfPlayers = 2;
    	List<String> names = new ArrayList<>();
    	names.add("Michel");
    	names.add("Jean");
    	//act
    	referee.distributeTilesToPlayers(names);
    	referee.fillAllRacks();
    	//assert
    	for (int i = 0; i < numberOfPlayers; i++) {
    		assert (referee.getPlayers().get(i).getRack().getTiles().size() == 5);
    	}
	}
	
	@Test
	public void isTileRightColorAndShape() {
		
		Tile tile = new Tile(Color.Red, Shape.TURTLE);
		
		assert(tile.getColor() == Color.Red);
		assert(tile.getShape() == Shape.TURTLE);
	}
	
	@Test
	public void isPoolFilledWithTheRightTiles() {
		//arrange
		pool = new Pool();
		//act
		//clearing the pool before initializing
		pool.getTiles().clear();
		pool.initializeTiles();
		//assert
		int expectedTilesCount = 72;
		int actualTilesCount = pool.getTiles().size();
		assert(expectedTilesCount == actualTilesCount);
		int expectedTileCountPerColor = 12;
		int actualTileCountPerColor = 0;
		for (Color color : Color.values()) {
			for (Shape shape : Shape.values()) {
				actualTileCountPerColor += pool.getTiles().stream()
						.filter(tile -> tile.getColor() == color && tile.getShape() == shape).count();
			}
			assert (expectedTileCountPerColor == actualTileCountPerColor);
			actualTileCountPerColor = 0;
		}

	}
}
