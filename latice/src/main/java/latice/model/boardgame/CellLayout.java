package latice.model.boardgame;

import java.util.Objects;

import static latice.model.boardgame.Board.START_OF_GRID;

public class CellLayout {

static Integer[][] sunCellPositions = {
            {0, 0}, 
            {0, 4},
            {0, 8}, 
            {1, 1},
            {1, 7}, 
            {2, 2}, 
            {2, 6}, 
            {4, 0},
            {4, 8}, 
            {6, 2},
            {6, 6}, 
            {7, 1},
            {7, 7}, 
            {8, 0}, 
            {8, 4}, 
            {8, 8}  
        };

	public static boolean isSunCell(Integer row, Integer col) {
			for (Integer rowOfSunCell = START_OF_GRID; rowOfSunCell < sunCellPositions.length; rowOfSunCell++) {
				if (Objects.equals(sunCellPositions[rowOfSunCell][START_OF_GRID], row) && Objects.equals(sunCellPositions[rowOfSunCell][1], col)) {
					return true;
				}
			}
			return false;
	}


        
}