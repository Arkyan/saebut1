package boardgame;

public class SunCell extends Cell {
	public SunCell(Integer row, Integer col) {
		super(row, col);
	}

	@Override
	public String display() {
		if (tile != null) {
			return(tile.showTile() + " ");
		} else {
			return("☀️ ");
		}
	}

}
