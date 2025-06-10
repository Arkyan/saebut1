package latice.view;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import latice.model.slate.Color;
import latice.model.slate.Shape;
import latice.model.slate.Tile;

public class ImageLoadingTest {
	
	@Test
	public void shouldReturnCorrectImagePathForRedFlower() {
		ImageLoading imageLoading = new ImageLoading();
	    String expectedPath = "/latice_lazuli/images/flower_r.png";
	    String actualPath = imageLoading.getImagePath(Color.Red, Shape.FLOWER);
	    assertEquals(expectedPath, actualPath, "Image path for Red Flower should match expected path.");
	}
	
	@Test
	public void shouldReturnCorrectImagePathForYellowGecko() {
		ImageLoading imageLoading = new ImageLoading();
	    String expectedPath = "/latice_lazuli/images/gecko_y.png";
	    String actualPath = imageLoading.getImagePath(Color.Yellow, Shape.GECKO);
	    assertEquals(expectedPath, actualPath, "Image path for Yellow Gecko should match expected path.");
	}
	
	@Test
	public void shouldReturnCorrectImagePathForNavyFeather() {
		ImageLoading imageLoading = new ImageLoading();
	    String expectedPath = "/latice_lazuli/images/feather_n.png";
	    String actualPath = imageLoading.getImagePath(Color.Navy, Shape.FEATHER);
	    assertEquals(expectedPath, actualPath, "Image path for Navy Feather should match expected path.");
	}
	
	@Test
	public void shouldReturnCorrectImagePathForMagentaBird() {
		ImageLoading imageLoading = new ImageLoading();
	    String expectedPath = "/latice_lazuli/images/bird_m.png";
	    String actualPath = imageLoading.getImagePath(Color.Magenta, Shape.BIRD);
	    assertEquals(expectedPath, actualPath, "Image path for Magenta Bird should match expected path.");
	}
	
	@Test
	public void shouldReturnCorrectImagePathForGreenDolphin() {
		ImageLoading imageLoading = new ImageLoading();
	    String expectedPath = "/latice_lazuli/images/dolphin_g.png";
	    String actualPath = imageLoading.getImagePath(Color.Green, Shape.DOLPHIN);
	    assertEquals(expectedPath, actualPath, "Image path for Green Dolphin should match expected path.");
	}
	
	@Test
	public void shouldReturnCorrectImagePathForTealTurtle() {
		ImageLoading imageLoading = new ImageLoading();
	    String expectedPath = "/latice_lazuli/images/turtle_t.png";
	    String actualPath = imageLoading.getImagePath(Color.Teal, Shape.TURTLE);
	    assertEquals(expectedPath, actualPath, "Image path for Red Turtle should match expected path.");
	}
	
	@Test
    public void shouldReturnRedBirdTile_whenFileNameIsBird_r() {
		String path = "/bird_r.png";
		ImageLoading imageLoading = new ImageLoading();
		Tile tile = imageLoading.getTileFromImage(path);
        assertEquals(Color.Red, tile.getColor());
        assertEquals(Shape.BIRD, tile.getShape());
    }
	
	@Test
		public void shouldReturnYellowFlowerTile_whenFileNameIsFlower_y() {
		String path = "/flower_y.png";
		ImageLoading imageLoading = new ImageLoading();
		Tile tile = imageLoading.getTileFromImage(path);
		assertEquals(Color.Yellow, tile.getColor());
		assertEquals(Shape.FLOWER, tile.getShape());
	}
	
	@Test
	public void shouldReturnNavyGeckoTile_whenFileNameIsGecko_n() {
		String path = "/gecko_n.png";
		ImageLoading imageLoading = new ImageLoading();
		Tile tile = imageLoading.getTileFromImage(path);
		assertEquals(Color.Navy, tile.getColor());
		assertEquals(Shape.GECKO, tile.getShape());
	}
	
	@Test
	public void shouldReturnMagentaFeatherTile_whenFileNameIsFeather_m() {
		String path = "/feather_m.png";
		ImageLoading imageLoading = new ImageLoading();
		Tile tile = imageLoading.getTileFromImage(path);
		assertEquals(Color.Magenta, tile.getColor());
		assertEquals(Shape.FEATHER, tile.getShape());
	}
	
	@Test
	public void shouldReturnGreenDolphinTile_whenFileNameIsDolphin_g() {
		String path = "/dolphin_g.png";
		ImageLoading imageLoading = new ImageLoading();
		Tile tile = imageLoading.getTileFromImage(path);
		assertEquals(Color.Green, tile.getColor());
		assertEquals(Shape.DOLPHIN, tile.getShape());
	}
	
	@Test
	public void shouldReturnTealTurtleTile_whenFileNameIsTurtle_t() {
		String path = "/turtle_t.png";
		ImageLoading imageLoading = new ImageLoading();
		Tile tile = imageLoading.getTileFromImage(path);
		assertEquals(Color.Teal, tile.getColor());
		assertEquals(Shape.TURTLE, tile.getShape());
	}
}
