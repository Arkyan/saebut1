package latice.view;

import latice.model.slate.Color;
import latice.model.slate.Shape;
import latice.model.slate.Tile;
import latice.controler.Referee;

import java.io.File;

public class ImageLoading {
	
    private static String path = "/latice_lazuli/images";
    
	public String getImagePath(Color color, Shape shape) {
		
		switch (color) {
			case Red:
                return switch (shape) {
                    case FLOWER -> path + "/flower_r.png";
                    case GECKO -> path + "/gecko_r.png";
                    case FEATHER -> path + "/feather_r.png";
                    case BIRD -> path + "/bird_r.png";
                    case DOLPHIN -> path + "/dolphin_r.png";
                    case TURTLE -> path + "/turtle_r.png";
                };
            case Yellow:
                return switch (shape) {
                    case FLOWER -> path + "/flower_y.png";
                    case GECKO -> path + "/gecko_y.png";
                    case FEATHER -> path + "/feather_y.png";
                    case BIRD -> path + "/bird_y.png";
                    case DOLPHIN -> path + "/dolphin_y.png";
                    case TURTLE -> path + "/turtle_y.png";
                };
			case Navy:
                return switch (shape) {
                    case FLOWER -> path + "/flower_n.png";
                    case GECKO -> path + "/gecko_n.png";
                    case FEATHER -> path + "/feather_n.png";
                    case BIRD -> path + "/bird_n.png";
                    case DOLPHIN -> path + "/dolphin_n.png";
                    case TURTLE -> path + "/turtle_n.png";
                };
			case Magenta:
                return switch (shape) {
                    case FLOWER -> path + "/flower_m.png";
                    case GECKO -> path + "/gecko_m.png";
                    case FEATHER -> path + "/feather_m.png";
                    case BIRD -> path + "/bird_m.png";
                    case DOLPHIN -> path + "/dolphin_m.png";
                    case TURTLE -> path + "/turtle_m.png";
                };
			case Green:
                return switch (shape) {
                    case FLOWER -> path + "/flower_g.png";
                    case GECKO -> path + "/gecko_g.png";
                    case FEATHER -> path + "/feather_g.png";
                    case BIRD -> path + "/bird_g.png";
                    case DOLPHIN -> path + "/dolphin_g.png";
                    case TURTLE -> path + "/turtle_g.png";
                };
			case Teal:
                return switch (shape) {
                    case FLOWER -> path + "/flower_t.png";
                    case GECKO -> path + "/gecko_t.png";
                    case FEATHER -> path + "/feather_t.png";
                    case BIRD -> path + "/bird_t.png";
                    case DOLPHIN -> path + "/dolphin_t.png";
                    case TURTLE -> path + "/turtle_t.png";
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
	
	public static void setPath(String newPath) {
	        path = newPath;
	}
	
	public static String getPath() {
        return path;
    }
}
