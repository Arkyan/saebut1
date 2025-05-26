package latice.model.boardgame;

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
			for (Integer i = 0; i < sunCellPositions.length; i++) {
				if (sunCellPositions[i][0] == row && sunCellPositions[i][1] == col) {
					return true;
				}
			}
			return false;
	}


        
}
