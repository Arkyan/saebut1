package latice.model.boardgame;

public class SunCell extends Cell {
	public SunCell(Integer row, Integer col) {
		super(row, col);
	}

	@Override
	public String display() {
		System.out.print("Sun Cell: ");
		 return super.display();
	}

}
