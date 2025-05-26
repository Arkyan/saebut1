package latice.model.boardgame;

public class Board {
	private static final int CENTER_OF_THE_GRID = 4;
	Cell[][] cells;
	
    public Board() {
        cells = new Cell[9][9]; 
        for (Integer i = 0; i < cells.length; i++) {
            for (Integer j = 0; j < cells[i].length; j++) {
                if (i == CENTER_OF_THE_GRID && j == CENTER_OF_THE_GRID) {
                    cells[i][j] = new MoonCell(i, j); 
                } else if (CellLayout.isSunCell(i, j)) {
                    cells[i][j] = new SunCell(i, j);  
                } else {
                    cells[i][j] = new NormalCell(i, j); 
                }
            }
        }
    }

    public Cell[][] getCells() {
    	return cells;
    }

	public void display() {
		for (Integer row = 0; row < cells.length; row++) {
			for (Integer col = 0; col < cells[row].length; col++) {
				System.out.print(cells[row][col].display());
			}
			System.out.println();
		}
	}

	public Cell getCell(Integer row, Integer col) {
		return cells[row][col];
	}
	
	public boolean CheckPosition(Integer row, Integer col) throws Exception {
		if (row < 0 || row >= cells.length ) {
			throw new Exception("Row out of bounds");
		}else if (col < 0 || col >= cells[0].length) {
			throw new Exception("Column out of bounds");
		}
		return true;
	}
}
