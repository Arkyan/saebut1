package latice.model.slate;

import latice.model.slate.Tile;
import latice.model.slate.Color;
import latice.model.slate.Shape;

import java.util.List;

public class Pool {
    private final List<Tile> tiles;

    public Pool(List<Tile> tiles) {
        this.tiles = tiles;
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
