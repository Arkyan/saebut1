package latice.model.infoplayer;

import latice.model.slate.Tile;

import java.util.ArrayList;
import java.util.List;

public class PlayerBag {
    private List<Tile> tiles;

    public PlayerBag(List<Tile> tiles) {
        this.tiles = tiles;
    }
    
    public PlayerBag() {
		this.tiles = new ArrayList<>();
	}

    public List<Tile> getTiles() {
        return this.tiles;
    }
    
    public void printPlayerBag() {
    	        System.out.print("|");
        for (Tile tile : tiles) {
            System.out.print(tile.showTile());
            System.out.print("|");
        }
        System.out.println();
    
    }
}
