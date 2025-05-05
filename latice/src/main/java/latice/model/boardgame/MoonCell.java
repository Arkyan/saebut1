package latice.model.boardgame;

public class MoonCell extends Cell {
	public MoonCell(Integer row, Integer col) {
		super(row, col);
	}

	@Override
	public String display() {
		System.out.print("Moon Cell: ");
		return super.display();
	}

}
