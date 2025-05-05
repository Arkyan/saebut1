package boardgame;

public class NormalCell extends Cell {
	public NormalCell(Integer row, Integer col) {
		super(row, col);
	}
	
	@Override
	public String display() {
		System.out.print("Normal Cell: ");
		return super.display();
	}

}
