package latice.model.slate;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PoolTest {
	private static Pool pool;
	
	@BeforeAll
	public static void set_up() {
		pool = new Pool();
	}

	@Test
	public void is_poll_full() {
		assert(pool.getTiles().size() == 72);
	}
	
	@Test
	public void is_pool_filled_with_the_right_tiles() {
		//arrange
		pool = new Pool();
		//act
		//clearing the pool before initializing
		pool.getTiles().clear();
		pool.initializeTiles();
		//assert
		int expectedTilesCount = 72;
		int actualTilesCount = pool.getTiles().size();
		assert(expectedTilesCount == actualTilesCount);
		int expectedTileCountPerColor = 12;
		int actualTileCountPerColor = 0;
		for (Color color : Color.values()) {
			for (Shape shape : Shape.values()) {
				actualTileCountPerColor += pool.getTiles().stream()
						.filter(tile -> tile.getColor() == color && tile.getShape() == shape).count();
			}
			assert (expectedTileCountPerColor == actualTileCountPerColor);
			actualTileCountPerColor = 0;
		}

	}

}
