package latice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import latice.controller.Referee;
import latice.model.boardgame.Board;
import latice.model.infoplayer.Player;
import latice.model.slate.Color;
import latice.model.slate.Pool;
import latice.model.slate.Shape;
import latice.model.slate.Tile;

class RefereeTest {
	private static Referee referee;
	Player player1 = new Player("Michel");
	Player player2 = new Player("Jean");
	
	@BeforeAll
	public static void set_up() {
		referee = new Referee();
	}
	
	
	@Test
	public void is_player_bag_filled() {
	    // arrange
	    referee.addPlayer(player1);
	    referee.addPlayer(player2);

	    // act
	    referee.distributeTilesToPlayers(referee.getPlayers());

	    // assert
	    for (Player player : referee.getPlayers()) {
	        System.out.println("Player: " + player.getName() + ", Tile count: " + player.getPlayerBag().getTiles().size());
	        assertEquals(31, player.getPlayerBag().getTiles().size());
	    }
	}

	
	@Test
	public void is_player_rack_filled() {
		// arrange
		referee.addPlayer(player1);
		referee.addPlayer(player2);
				
		// act
		referee.distributeTilesToPlayers(referee.getPlayers());
    	referee.fillAllRacks();
    	//assert
    	for (Player player : referee.getPlayers()) {
            assertEquals(5, player.getRack().getTiles().size());
		}
	}
	
	@Test
	public void shoud_place_a_tile_at_the_right_index() {
		Board board = new Board();
		Tile blueTurtle = new Tile(Color.Navy, Shape.TURTLE);
		Player michel = new Player("Michel");
		referee.placeTileOnBoard(blueTurtle, 4, 4, michel);
		
		assertNotSame(board, referee.getBoard());
	}
	
	@Test 
	public void should_not_place_a_tile_when_neighbor_does_not_match() {
		Tile blueTurtle = new Tile(Color.Navy, Shape.TURTLE);
		Player michel = new Player("Michel");
		referee.placeTileOnBoard(blueTurtle, 4, 4, michel);
		
		Tile redTurtle = new Tile(Color.Red, Shape.FLOWER);
		referee.placeTileOnBoard(redTurtle, 4, 5, michel);
		
		Boolean isPlaced = referee.getBoard().getCells()[4][5].getTile() != null;
		
		assertEquals(false, isPlaced);
	}
	
	@Test
	public void should_place_a_tile_when_neighbor_match() {
		Tile blueTurtle = new Tile(Color.Navy, Shape.TURTLE);
		Player michel = new Player("Michel");
		referee.placeTileOnBoard(blueTurtle, 4, 4, michel);
		
		Tile redTurtle = new Tile(Color.Red, Shape.TURTLE);
		referee.placeTileOnBoard(redTurtle, 4, 5, michel);
		
		Boolean isPlaced = referee.getBoard().getCells()[4][5].getTile() != null;
		
		assertEquals(true, isPlaced);
	}
	
	
	@Test
	public void should_have_the_right_number_of_neighbor() {
		Tile blueTurtle = new Tile(Color.Navy, Shape.TURTLE);
		Tile redTurtle = new Tile(Color.Red, Shape.TURTLE);
		Tile greenTurtle = new Tile(Color.Green, Shape.TURTLE);
		Tile yellowTurtle = new Tile(Color.Yellow, Shape.TURTLE);
		Player michel = new Player("Michel");
		Integer[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
		
		referee.placeTileOnBoard(blueTurtle, 4, 4, michel);
		referee.placeTileOnBoard(redTurtle, 4, 5, michel);
		referee.placeTileOnBoard(greenTurtle, 5, 4, michel);
		
		Integer nbOfNeighbors = referee.calculateNumberOfNeighbors(blueTurtle, 4, 4, directions, referee.getBoard().getCells());
		
		assertEquals(2, nbOfNeighbors);
	}
	
	@Test
	public void should_get_the_next_player() {
		referee.addPlayer(player1);
		referee.addPlayer(player2);
		
		Player nextPlayer = referee.getNextPlayer(player1);
		assertEquals(player2, nextPlayer);
	}

	@Test
	public void should_add_1_point() {
		Integer nbCorrectPosition = 2;
		Integer expectedPoints = 1;
		Boolean isOnASunCell = false;
		referee.calculatePoints(player1, nbCorrectPosition, isOnASunCell);
		
		assertEquals(expectedPoints, player1.getPoints());
	}
	
	@Test
	public void should_add_2_point() {
		Integer nbCorrectPosition = 3;
		Integer expectedPoints = 2;
		Boolean isOnASunCell = false;
		referee.calculatePoints(player1, nbCorrectPosition, isOnASunCell);
		
		assertEquals(expectedPoints, player1.getPoints());
	}
	
	@Test
	public void should_add_4_point() {
		Integer nbCorrectPosition = 4;
		Integer expectedPoints = 4;
		Boolean isOnASunCell = false;
		referee.calculatePoints(player1, nbCorrectPosition, isOnASunCell);
		
		assertEquals(expectedPoints, player1.getPoints());
	}
	
	@Test
	public void shouldn_t_add_point() {
		Integer nbCorrectPosition = 0;
		Integer expectedPoints = 0;
		Boolean isOnASunCell = false;
		referee.calculatePoints(player1, nbCorrectPosition, isOnASunCell);
		
		assertEquals(expectedPoints, player1.getPoints());
	}
	
	@Test
	public void should_add_2_points_on_sun_cell() {
		Integer nbCorrectPosition = 2;
		Integer expectedPoints = 3;
		Boolean isOnASunCell = true;
		referee.calculatePoints(player1, nbCorrectPosition, isOnASunCell);

		assertEquals(expectedPoints, player1.getPoints());
	}
	
	
}
