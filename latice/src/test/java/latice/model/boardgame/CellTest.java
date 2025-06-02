package latice.model.boardgame;

import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;

import latice.model.slate.Color;
import latice.model.slate.Shape;
import latice.model.slate.Tile;

class CellTest {
	Tile tile = new Tile(Color.Red, Shape.TURTLE);

	@Test
	public void is_sun_cell() {
		SunCell cell = new SunCell(0,0);
		String expectedSunCellDisplay = "☀️ ";
		
		assert(cell.display().equals(expectedSunCellDisplay));
	}
	
	@Test
	public void sun_cell_with_tile_is_correctly_displayed() {
		SunCell cell = new SunCell(0, 0);
		cell.setTile(tile);
		String expectedSunCellDisplay = "☀️ ";

		assertNotSame(expectedSunCellDisplay, cell.display());
	}
	
	@Test
	public void is_moon_cell() {
		MoonCell cell = new MoonCell(0, 0);
		String expectedMoonCellDisplay = "🌙 ";

		assert (cell.display().equals(expectedMoonCellDisplay));
	}
	
	@Test
	public void moon_cell_with_tile_is_correctly_displayed() {
		MoonCell cell = new MoonCell(0, 0);
		cell.setTile(tile);
		String expectedMoonCellDisplay = "🌙 ";

		assertNotSame(expectedMoonCellDisplay, cell.display());
	}
	
	@Test
	public void is_normal_cell() {
		NormalCell cell = new NormalCell(0, 0);
		String expectedNormalCellDisplay = "⏹️ ";

		assert (cell.display().equals(expectedNormalCellDisplay));
	}
	
	@Test
	public void normal_cell_with_tile_is_correctly_displayed() {
		NormalCell cell = new NormalCell(0, 0);
		cell.setTile(tile);
		String expectedNormalCellDisplay = "⏹️ ";

		assertNotSame(expectedNormalCellDisplay, cell.display());
	}

}
