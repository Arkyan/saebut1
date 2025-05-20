package latice.model.infoplayer;

import latice.model.slate.Tile;

import java.util.ArrayList;
import java.util.List;

public class Rack {
    private static final int LENGTH_OF_RACK = 5;
	private List<Tile> tiles;

    public Rack(List<Tile> tiles) {
     this.tiles = tiles;
    }

	public Rack() {
		this.tiles = new ArrayList<>();
	}

    public void displayRack() {
        System.out.print("|");
        for (Integer actualPositionInRack = 0; actualPositionInRack < LENGTH_OF_RACK; actualPositionInRack++) {
            if (actualPositionInRack < tiles.size()) {
            	System.out.print(tiles.get(actualPositionInRack).showTile());
            }
            else {
                System.out.print("   ");
            }
            System.out.print("|");
        }
        System.out.println();
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }

	public void removeTile(Tile tile) {
		tiles.remove(tile);
		
	}
}
