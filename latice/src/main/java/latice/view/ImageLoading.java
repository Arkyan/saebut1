package latice.view;

import latice.model.slate.Color;
import latice.model.slate.Shape;
import latice.model.slate.Tile;

import java.io.File;

public class ImageLoading {
	
	public String getImagePath(Color color, Shape shape) {
		switch (color) {
			case Red:
                return switch (shape) {
                    case FLOWER -> "/flower_r.png";
                    case GECKO -> "/gecko_r.png";
                    case FEATHER -> "/feather_r.png";
                    case BIRD -> "/bird_r.png";
                    case DOLPHIN -> "/dolphin_r.png";
                    case TURTLE -> "/turtle_r.png";
                };
            case Yellow:
                return switch (shape) {
                    case FLOWER -> "/flower_y.png";
                    case GECKO -> "/gecko_y.png";
                    case FEATHER -> "/feather_y.png";
                    case BIRD -> "/bird_y.png";
                    case DOLPHIN -> "/dolphin_y.png";
                    case TURTLE -> "/turtle_y.png";
                };
			case Navy:
                return switch (shape) {
                    case FLOWER -> "/flower_n.png";
                    case GECKO -> "/gecko_n.png";
                    case FEATHER -> "/feather_n.png";
                    case BIRD -> "/bird_n.png";
                    case DOLPHIN -> "/dolphin_n.png";
                    case TURTLE -> "/turtle_n.png";
                };
			case Magenta:
                return switch (shape) {
                    case FLOWER -> "/flower_m.png";
                    case GECKO -> "/gecko_m.png";
                    case FEATHER -> "/feather_m.png";
                    case BIRD -> "/bird_m.png";
                    case DOLPHIN -> "/dolphin_m.png";
                    case TURTLE -> "/turtle_m.png";
                };
			case Green:
                return switch (shape) {
                    case FLOWER -> "/flower_g.png";
                    case GECKO -> "/gecko_g.png";
                    case FEATHER -> "/feather_g.png";
                    case BIRD -> "/bird_g.png";
                    case DOLPHIN -> "/dolphin_g.png";
                    case TURTLE -> "/turtle_g.png";
                };
			case Teal:
                return switch (shape) {
                    case FLOWER -> "/flower_t.png";
                    case GECKO -> "/gecko_t.png";
                    case FEATHER -> "/feather_t.png";
                    case BIRD -> "/bird_t.png";
                    case DOLPHIN -> "/dolphin_t.png";
                    case TURTLE -> "/turtle_t.png";
                };
			default:
				return null;
		}
	}

	public Tile getTileFromImage(String file) {
        String[] fileNameSplitedWithoutSlash = file.split("/");
        String[] fileNameSplitedWithoutExtension = fileNameSplitedWithoutSlash[1].split("\\.");
		String[] fileNameSplited = fileNameSplitedWithoutExtension[0].split("_");

		String shape = fileNameSplited[0];
		String color = fileNameSplited[1];


		switch (shape) {
			case "bird":
                switch (color) {
                    case "r" -> {
                        return new Tile(Color.Red, Shape.BIRD);
                    }
                    case "y" -> {
                        return new Tile(Color.Yellow, Shape.BIRD);
                    }
                    case "n" -> {
                        return new Tile(Color.Navy, Shape.BIRD);
                    }
                    case "m" -> {
                        return new Tile(Color.Magenta, Shape.BIRD);
                    }
                    case "g" -> {
                        return new Tile(Color.Green, Shape.BIRD);
                    }
                    case "t" -> {
                        return new Tile(Color.Teal, Shape.BIRD);
                    }
                }
                break;
			case "dolphin" :
                switch (color) {
                    case "r" -> {
                        return new Tile(Color.Red, Shape.DOLPHIN);
                    }
                    case "y" -> {
                        return new Tile(Color.Yellow, Shape.DOLPHIN);
                    }
                    case "n" -> {
                        return new Tile(Color.Navy, Shape.DOLPHIN);
                    }
                    case "m" -> {
                        return new Tile(Color.Magenta, Shape.DOLPHIN);
                    }
                    case "g" -> {
                        return new Tile(Color.Green, Shape.DOLPHIN);
                    }
                    case "t" -> {
                        return new Tile(Color.Teal, Shape.DOLPHIN);
                    }
                }
                break;
			case "feather" :
                switch (color) {
                    case "r" -> {
                        return new Tile(Color.Red, Shape.FEATHER);
                    }
                    case "y" -> {
                        return new Tile(Color.Yellow, Shape.FEATHER);
                    }
                    case "n" -> {
                        return new Tile(Color.Navy, Shape.FEATHER);
                    }
                    case "m" -> {
                        return new Tile(Color.Magenta, Shape.FEATHER);
                    }
                    case "g" -> {
                        return new Tile(Color.Green, Shape.FEATHER);
                    }
                    case "t" -> {
                        return new Tile(Color.Teal, Shape.FEATHER);
                    }
                }
                break;
			case "flower" :
                switch (color) {
                    case "r" -> {
                        return new Tile(Color.Red, Shape.FLOWER);
                    }
                    case "y" -> {
                        return new Tile(Color.Yellow, Shape.FLOWER);
                    }
                    case "n" -> {
                        return new Tile(Color.Navy, Shape.FLOWER);
                    }
                    case "m" -> {
                        return new Tile(Color.Magenta, Shape.FLOWER);
                    }
                    case "g" -> {
                        return new Tile(Color.Green, Shape.FLOWER);
                    }
                    case "t" -> {
                        return new Tile(Color.Teal, Shape.FLOWER);
                    }
                }
                break;
			case "gecko" :
                switch (color) {
                    case "r" -> {
                        return new Tile(Color.Red, Shape.GECKO);
                    }
                    case "y" -> {
                        return new Tile(Color.Yellow, Shape.GECKO);
                    }
                    case "n" -> {
                        return new Tile(Color.Navy, Shape.GECKO);
                    }
                    case "m" -> {
                        return new Tile(Color.Magenta, Shape.GECKO);
                    }
                    case "g" -> {
                        return new Tile(Color.Green, Shape.GECKO);
                    }
                    case "t" -> {
                        return new Tile(Color.Teal, Shape.GECKO);
                    }
                }
                break;
			case "turtle" :
                switch (color) {
                    case "r" -> {
                        return new Tile(Color.Red, Shape.TURTLE);
                    }
                    case "y" -> {
                        return new Tile(Color.Yellow, Shape.TURTLE);
                    }
                    case "n" -> {
                        return new Tile(Color.Navy, Shape.TURTLE);
                    }
                    case "m" -> {
                        return new Tile(Color.Magenta, Shape.TURTLE);
                    }
                    case "g" -> {
                        return new Tile(Color.Green, Shape.TURTLE);
                    }
                    case "t" -> {
                        return new Tile(Color.Teal, Shape.TURTLE);
                    }
                }
                break;
            default: return null;
		}
        return null;
    }
}
