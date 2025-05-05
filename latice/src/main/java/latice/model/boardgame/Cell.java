package latice.model.boardgame;

import latice.model.slate.Tile;

public abstract class Cell {
	protected Integer row;
	protected Integer col;
	protected Tile tile;
	
	Cell(Integer row, Integer col) {
		this.row = row;
		this.col = col;
	}
	
	public Integer getRow() {
		return row;
	}
	
	public Integer getCol() {
		return col;
	}
	
	public Tile setTile() {
		return tile;
	}
	
	public String display() {
		if (tile != null) {
			return("Tile: " + tile.getShape() + tile.getColor());
		} else {
			return("No Tile");
		}
	}
}
