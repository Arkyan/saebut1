package latice.model.slate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static latice.view.console.Console.message;

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
            message(tile.showTile() + " ");
        }
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }

	@Override
	public int hashCode() {
		return Objects.hash(tiles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pool other = (Pool) obj;
		return Objects.equals(tiles, other.tiles);
	}
    
  
}
