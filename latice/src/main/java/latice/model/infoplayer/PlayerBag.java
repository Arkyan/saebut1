package main.java.latice.model.infoplayer;

import latice.model.slate.Tile;

import java.util.List;

public class PlayerBag {
    private List<Tile> tiles;

    public PlayerBag(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }
}
