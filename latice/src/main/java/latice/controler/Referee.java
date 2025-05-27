package latice.controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import latice.view.console.Console;
import latice.model.boardgame.Board;
import latice.model.boardgame.Cell;
import latice.model.infoplayer.Player;
import latice.model.infoplayer.PlayerBag;
import latice.model.infoplayer.Rack;
import latice.model.slate.Pool;
import latice.model.slate.Tile;

import static latice.model.boardgame.Board.EXTREMITY_OF_GRID;
import static latice.model.boardgame.Board.START_OF_GRID;
import static latice.view.console.Console.message;

public class Referee {

	public static final Integer MAX_TILES_IN_RACK = 5;
	private final String name = "Michel";
    private List<Player> players;
    private Pool pool;
    private Board board;
    private Integer numberOfIteration = 0;


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
			message(player.getName() + "'s tiles:");
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
            for (Integer playerTile = 0; playerTile < tilesPerPlayer; playerTile++) {
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
	
	public void placeTileOnBoard(Tile tile, Integer row, Integer col, Player player) {
		Board board = this.board;
		Cell[][] cells = board.getCells();
        Integer[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Integer nbOfCorrectPos = 0;

		if (isPlacementValid(tile, row, col, board)) {
			cells[row][col].setTile(tile);
			player.getRack().removeTile(tile);
			fillRackFromPlayerBag(player);
            nbOfCorrectPos = calculateNumberOfMatchingSides(tile, row, col, cells, directions, nbOfCorrectPos);

            switch (nbOfCorrectPos) {
                case 2 :
                    player.addPoints(1);
                    break;
                case 3 :
                    player.addPoints(2);
                    break;
                case 4 :
                    player.addPoints(4);
                    break;
                default :
                    break;
            }
        }
    }
    @SuppressWarnings("null")
	public boolean isPlacementValid(Tile tile, Integer row, Integer col, Board board) {
        Cell[][] cells = board.getCells();

        if (row < START_OF_GRID || row >= EXTREMITY_OF_GRID || col < START_OF_GRID || col >= EXTREMITY_OF_GRID) return false;

        if (cells[row][col].getTile() != null) return false;

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

        return checkIfNbOfMatchingSidesEqualsNumberOfNeighbors(tile, row, col, cells);
    }

    private boolean checkIfNbOfMatchingSidesEqualsNumberOfNeighbors(Tile tile, Integer row, Integer col, Cell[][] cells) {
        Integer[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Integer nbOfCorrectPos = 0;
        Integer nbOfNeighbors;
        nbOfNeighbors = calculateNumberOfNeighbors(tile, row, col, directions, cells);
        nbOfCorrectPos = calculateNumberOfMatchingSides(tile, row, col, cells, directions, nbOfCorrectPos);

        return Objects.equals(nbOfCorrectPos, nbOfNeighbors);
    }

    private Integer calculateNumberOfNeighbors(Tile tile, Integer row, Integer col, Integer[][] directions, Cell[][] cells) {
        Integer nbOfNeighbors = 0;
        for (Integer[] d : directions) {
            Integer neighborRow = row + d[0];
            Integer neighborCol = col + d[1];
            if (neighborRow >= START_OF_GRID && neighborRow < EXTREMITY_OF_GRID && neighborCol >= START_OF_GRID && neighborCol < EXTREMITY_OF_GRID) {
                Tile neighbor = cells[neighborRow][neighborCol].getTile();
                if (neighbor != null) {
                    nbOfNeighbors++;
                }
            }
        }

        return nbOfNeighbors;
    }

    private Integer calculateNumberOfMatchingSides(Tile tile, Integer row, Integer col, Cell[][] cells, Integer[][] directions, Integer nbOfCorrectPos) {
        for (Integer[] d : directions) {
            Integer neighborRow = row + d[0];
            Integer neighborCol = col + d[1];
            if (neighborRow >= START_OF_GRID && neighborRow < EXTREMITY_OF_GRID && neighborCol >= START_OF_GRID && neighborCol < EXTREMITY_OF_GRID) {
                Tile neighbor = cells[neighborRow][neighborCol].getTile();
                if (neighbor != null &&
                        (neighbor.getColor() == tile.getColor() || neighbor.getShape() == tile.getShape())) {
                    nbOfCorrectPos++;
                }
            }
        }
        return nbOfCorrectPos;
    }
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public Board getBoard() {
		return board;
	}
	
    public Player getNextPlayer(Player currentPlayer) {
        Integer currentIndex = players.indexOf(currentPlayer);
        if (currentIndex == -1) {
            return null; // Player not found
        }
        Integer nextIndex = (currentIndex + 1) % players.size();
        return players.get(nextIndex);
        
    }

    public Boolean stateOfRound() {
        numberOfIteration++;
            if (numberOfIteration == players.size()) {
                numberOfIteration = 0;
                return true;
                }
        return false;
    }
}
