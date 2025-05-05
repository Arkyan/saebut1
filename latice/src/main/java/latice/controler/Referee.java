package latice.controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import latice.console.Console;
import latice.model.infoplayer.Player;
import latice.model.infoplayer.PlayerBag;
import latice.model.infoplayer.Rack;
import latice.model.slate.Pool;
import latice.model.slate.Tile;

public class Referee {
	private final String name = "Michel";
    private List<Player> players;
    private Pool pool;
    private int currentPlayerIndex;


    public Referee() {
        players = new ArrayList<>();
        pool = new Pool();
        currentPlayerIndex = 0;
    }
    
    public void prepareGame() {
    	Integer numberOfPlayers = 2;
    	
    	List<String> names = new ArrayList<>();
    	for (int i = 1; i <= numberOfPlayers; i++) {
            String playerName = Console.input(name + ": Enter name for player " + i );
            names.add(playerName);
        }
    	shufflePool();
    	distributeTilesToPlayers(names);
    	fillAllRacks();
		for (Player player : players) {
			System.out.println(player.getName() + "'s tiles:");
			player.getRack().displayRack();
		}
    	
    }
    
    private void shufflePool() {
        Collections.shuffle(pool.getTiles());
    }
    private void shufflePlayerBag(PlayerBag bag) {
		Collections.shuffle(bag.getTiles());
	}
    
    public void distributeTilesToPlayers(List<String> playerNames) {
        int totalPlayers = playerNames.size();
        int tilesPerPlayer = pool.getTiles().size() / totalPlayers;

        for (int i = 0; i < totalPlayers; i++) {
            List<Tile> playerTiles = new ArrayList<>();
            for (int j = 0; j < tilesPerPlayer; j++) {
                playerTiles.add(pool.getTiles().remove(0));
            }

            PlayerBag bag = new PlayerBag(playerTiles);
            Rack rack = new Rack();
            Player player = new Player(playerNames.get(i), bag, rack);
            players.add(player);
        }
    }
    
    public void fillRackFromPlayerBag(Player player) {
        Rack rack = player.getRack();
        PlayerBag bag = player.getPlayerBag();
        shufflePlayerBag(bag);

        while (rack.getTiles().size() < 5 && !bag.getTiles().isEmpty()) {
            Tile tile = bag.getTiles().remove(0);
            rack.getTiles().add(tile);
        }
    }
    
    private void fillAllRacks() {
        for (Player player : players) {
            shufflePlayerBag(player.getPlayerBag()); 
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
