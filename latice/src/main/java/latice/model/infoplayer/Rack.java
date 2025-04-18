package latice.model.infoplayer;

import latice.model.slate.Tile;

import java.util.List;

public class Rack {
    private List<Tile> tiles;

    public Rack(List<Tile> tiles) {
     this.tiles = tiles;
    }

    public void displayRack() {
        System.out.print("|");
        for (int i = 0; i < 5; i++) {
            if (i < tiles.size()) {
                tiles.get(i).showTile();
            }
            else {
                System.out.print("   ");
            }
            System.out.print("|");
        }
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }
}
