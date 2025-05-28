package latice.model.slate;

import org.junit.jupiter.api.Test;

class TileTest {

	@Test
	public void is_tile_right_color_and_shape() {
		
		Tile tile = new Tile(Color.Red, Shape.TURTLE);
		
		assert(tile.getColor() == Color.Red);
		assert(tile.getShape() == Shape.TURTLE);
	}


}
