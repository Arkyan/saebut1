package latice.model.boardgame;

public class Board {
	Cell[][] cells;
	
    public Board() {
        cells = new Cell[9][9]; 
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (i == 4 && j == 4) {
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

    public void setCells(Cell[][] cells) {
    	this.cells = cells;
    }

	public void display() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				System.out.print(cells[i][j].display());
			}
			System.out.println();
		}
	}

	public Cell getCell(int row, int col) {
		return cells[row][col];
	}
	
	public boolean CheckPosition(int row, int col) throws Exception {
		if (row < 0 || row >= cells.length ) {
			throw new Exception("Row out of bounds");
		}else if (col < 0 || col >= cells[0].length) {
			throw new Exception("Column out of bounds");
		}
		return true;
	}
	
}
