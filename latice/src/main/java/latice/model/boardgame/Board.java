package latice.model.boardgame;

import static latice.view.console.Console.message;

public class Board {
	public static final Integer EXTREMITY_OF_GRID = 9;
	public static final Integer START_OF_GRID = 0;
	public static final int CENTER_OF_THE_GRID = 4;
	Cell[][] cells;
	
    public Board() {
		createBoard();
	}

	private void createBoard() {
		cells = new Cell[EXTREMITY_OF_GRID][EXTREMITY_OF_GRID];
		for (Integer row = START_OF_GRID; row < cells.length; row++) {
			for (Integer col = START_OF_GRID; col < cells[row].length; col++) {
				if (row == CENTER_OF_THE_GRID && col == CENTER_OF_THE_GRID) {
					cells[row][col] = new MoonCell(row, col);
				} else if (CellLayout.isSunCell(row, col)) {
					cells[row][col] = new SunCell(row, col);
				} else {
					cells[row][col] = new NormalCell(row, col);
				}
			}
		}
	}

	public Cell[][] getCells() {
    	return cells;
    }

	public void display() {
		for (Integer row = START_OF_GRID; row < cells.length; row++) {
			for (Integer col = START_OF_GRID; col < cells[row].length; col++) {
				System.out.print(cells[row][col].display());
			}
			message("");
		}
	}

	public Cell getCell(Integer row, Integer col) {
		return cells[row][col];
	}
	
	public boolean CheckPosition(Integer row, Integer col) throws Exception {
		if (row < START_OF_GRID || row >= cells.length ) {
			throw new Exception("Row out of bounds");
		}else if (col < START_OF_GRID || col >= cells[START_OF_GRID].length) {
			throw new Exception("Column out of bounds");
		}
		return true;
	}
}
