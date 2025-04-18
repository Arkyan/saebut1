package latice.model.slate;

import java.util.ArrayList;
import java.util.List;

public class Pool {
    private final List<Tile> tiles;

    public Pool(List<Tile> tiles) {
        this.tiles = tiles;
        initializeTiles();
    }
    
	public Pool() {
		this.tiles = new ArrayList<>();
		initializeTiles();
	}

	public void initializeTiles() {
        for (Color color : Color.values()) {
            for (Shape shape : Shape.values()) {
                tiles.add(new Tile(color, shape));
                tiles.add(new Tile(color, shape));
            }
        }
    }

    public void showPool() {
        for (Tile tile : tiles) {
            tile.showTile();
        }
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }
}
