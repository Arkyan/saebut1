package latice.controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import latice.console.Console;
import latice.model.boardgame.Board;
import latice.model.infoplayer.Player;
import latice.model.infoplayer.PlayerBag;
import latice.model.infoplayer.Rack;
import latice.model.slate.Pool;
import latice.model.slate.Tile;

public class Referee {

	private static final Integer MAX_TILES_IN_RACK = 5;
	private final String name = "Michel";
    private List<Player> players;
    private Pool pool;
    private Board board;


    public Referee() {
        players = new ArrayList<>();
        pool = new Pool();
    }
    
    public void prepareGame() {
    	Integer numberOfPlayers = 2;
        board = new Board();
    	
    	List<String> names = new ArrayList<>();
    	for (Integer i = 1; i <= numberOfPlayers; i++) {
            String playerName = Console.input(name + ": Enter name for player " + i );
            names.add(playerName);
            Player player = new Player(playerName);
            players.add(player);
        }
    	shuffleCollection();
    	distributeTilesToPlayers(names);
    	fillAllRacks();
		for (Player player : players) {
			System.out.println(player.getName() + "'s tiles:");
			player.getRack().displayRack();
		}

    	board.display();
    }
    
    private void shuffleCollection() {
        Collections.shuffle(pool.getTiles());
    }
    
    public void distributeTilesToPlayers(List<String> playerNames) {
        Integer totalPlayers = playerNames.size();
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
}
