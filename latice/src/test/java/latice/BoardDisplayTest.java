package latice;

import boardgame.Board;
import boardgame.Cell;
import latice.model.slate.Pool;
import latice.model.slate.Tile;

public class BoardDisplayTest {
	
	public static void main(String[] args) {
		Pool pool = new Pool();
		Board board = new Board();
		
		System.out.println("Initial Pool:");
		pool.showPool();

		Cell aCell = board.getCell(4, 4);
		Tile atile = pool.getTiles().get(0);
		aCell.setTile(atile);
		
		System.out.println("Initial Board:");
		board.display();
	}

}
