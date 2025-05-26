package latice.controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import latice.view.console.Console;
import latice.model.boardgame.Board;
import latice.model.boardgame.Cell;
import latice.model.infoplayer.Player;
import latice.model.infoplayer.PlayerBag;
import latice.model.infoplayer.Rack;
import latice.model.slate.Pool;
import latice.model.slate.Tile;

public class Referee {

	private static final int EXTREMITY_OF_GRID = 9;
	private static final int START_OF_GRID = 0;
	private static final Integer MAX_TILES_IN_RACK = 5;
	private final String name = "Michel";
    private List<Player> players;
    private Pool pool;
    private Board board;


    public Referee() {
        players = new ArrayList<>();
        pool = new Pool();
        board = new Board();
    }
    
    public void prepareGame() {
    	Integer numberOfPlayers = 2;
    	
    	for (Integer idActualPlayer = 1; idActualPlayer <= numberOfPlayers; idActualPlayer++) {
            String playerName = Console.input(name + ": Enter name for player " + idActualPlayer );
            Player player = new Player(playerName);
            players.add(player);
        }
    	shuffleCollection();
    	distributeTilesToPlayers(players);
    	fillAllRacks();
		for (Player player : players) {
			System.out.println(player.getName() + "'s tiles:");
			player.getRack().displayRack();
		}

    	board.display();
    }
    
    public void shuffleCollection() {
        Collections.shuffle(pool.getTiles());
    }
    
    
    public void distributeTilesToPlayers(List<Player> list) {
        Integer totalPlayers = list.size();
        Integer tilesPerPlayer = pool.getTiles().size() / totalPlayers;

        for (Player player : players) {
            List<Tile> playerTiles = new ArrayList<>();
            for (Integer j = 0; j < tilesPerPlayer; j++) {
                playerTiles.add(pool.getTiles().remove(0));
            }
            player.getPlayerBag().getTiles().addAll(playerTiles);
        }
    }
    
    public void fillRackFromPlayerBag(Player player) {
        Rack rack = player.getRack();
        PlayerBag bag = player.getPlayerBag();

        while (rack.getTiles().size() < MAX_TILES_IN_RACK && !bag.getTiles().isEmpty()) {
            Tile tile = bag.getTiles().remove(0);
            rack.getTiles().add(tile);
        }
    }
    
    public void fillAllRacks() {
        for (Player player : players) { 
            fillRackFromPlayerBag(player);
        }
    }

	public String getName() {
		return name;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public boolean placeTileOnBoard(Tile tile, Integer row, Integer col, Player player) {
		Board board = this.board;
		Cell[][] cells = board.getCells();

		if (isPlacementValid(tile, row, col, board)) {
			cells[row][col].setTile(tile);
			player.getRack().removeTile(tile);
			fillRackFromPlayerBag(player);
			return true;
		} else {
			return false;
		}
    }
	
    @SuppressWarnings("null")
	public boolean isPlacementValid(Tile tile, Integer row, Integer col, Board board) {
        Cell[][] cells = board.getCells();

        // Check bounds
        if (row < START_OF_GRID || row >= EXTREMITY_OF_GRID || col < START_OF_GRID || col >= EXTREMITY_OF_GRID) return false;

        // Check if cell is empty
        if (cells[row][col].getTile() != null) return false;

        // First move: must be center
        boolean boardIsEmpty = true;
        for (Cell[] cellRow : cells) {
            for (Cell cell : cellRow) {
                if (cell.getTile() != null) {
                    boardIsEmpty = false;
                    break;
                }
            }
        }
        if (boardIsEmpty) {
            return row == 4 && col == 4; // center
        }

        // Check at least one adjacent tile with matching color or shape
        Integer[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Integer nbOfCorrectPos = 0;
        for (Integer[] d : directions) {
        	Integer r = row + d[0];
        	Integer c = col + d[1];
            if (r >= START_OF_GRID && r < EXTREMITY_OF_GRID && c >= START_OF_GRID && c < EXTREMITY_OF_GRID) {
                Tile neighbor = cells[r][c].getTile();
                if (neighbor != null &&
                   (neighbor.getColor() == tile.getColor() || neighbor.getShape() == tile.getShape())) {
                    nbOfCorrectPos++;
                }
            }
        }

        if (nbOfCorrectPos != 0) {
            return true;
        }
        return false; // No valid adjacent match
    }
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public Board getBoard() {
		return board;
	}
}
