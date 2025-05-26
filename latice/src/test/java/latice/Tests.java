package latice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import latice.controler.Referee;
import latice.model.boardgame.Board;
import latice.model.boardgame.Cell;
import latice.model.infoplayer.Player;
import latice.model.slate.Color;
import latice.model.slate.Pool;
import latice.model.slate.Shape;
import latice.model.slate.Tile;

class Tests {
	private static Referee referee;
	private static Pool pool;
	
	@BeforeAll
	public static void set_up() {
		pool = new Pool();
		referee = new Referee();
	}
	
	
	@Test
	public void is_poll_full() {
		assert(pool.getTiles().size() == 72);
	}
	
	@Test
	public void is_player_bag_filled() {
		// arrange
		Player player1 = new Player("Michel");
		Player player2 = new Player("Jean");
		referee.addPlayer(player1);
		referee.addPlayer(player2);
		
		
		// act
		referee.distributeTilesToPlayers(referee.getPlayers());
		// assert
		for (Player player : referee.getPlayers()) {
			assert (player.getPlayerBag().getTiles().size() == 36);
		}
    	
	}
	
	@Test
	public void is_player_rack_filled() {
		// arrange
		Player player1 = new Player("Michel");
		Player player2 = new Player("Jean");
		referee.addPlayer(player1);
		referee.addPlayer(player2);
				
				
		// act
		referee.distributeTilesToPlayers(referee.getPlayers());
    	referee.fillAllRacks();
    	//assert
    	for (Player player : referee.getPlayers()) {
			assert (player.getRack().getTiles().size() == 5);
		}
	}
	
	@Test
	public void is_tile_right_color_and_shape() {
		
		Tile tile = new Tile(Color.Red, Shape.TURTLE);
		
		assert(tile.getColor() == Color.Red);
		assert(tile.getShape() == Shape.TURTLE);
	}
	
	@Test
	public void is_pool_filled_with_the_right_tiles() {
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
