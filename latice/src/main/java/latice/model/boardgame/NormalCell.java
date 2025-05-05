package latice.model.boardgame;

public class NormalCell extends Cell {
	public NormalCell(Integer row, Integer col) {
		super(row, col);
	}
	
	@Override
	public String display() {
		if (tile != null) {
			return(tile.showTile() + " ");
		} else {
			return("⏹️ ");
		}
	}

}
