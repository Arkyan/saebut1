package latice.model.boardgame;

public class MoonCell extends Cell {
	public MoonCell(Integer row, Integer col) {
		super(row, col);
	}

	@Override
	public String display() {
		if (tile != null) {
			return(tile.showTile() + " ");
		} else {
			return("🌙 ");
		}
	}

}
