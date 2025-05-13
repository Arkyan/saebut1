package latice.view;

import latice.model.slate.Color;
import latice.model.slate.Shape;

public class ImageLoading {
	
	public String getImagePath(Color color, Shape shape) {
		switch (color) {
			case Red:
				if (shape == Shape.FLOWER) {
					return "/flower_r.png";
				} else if (shape == Shape.GECKO) {
					return "/gecko_r.png";
				} else if (shape == Shape.FEATHER) {
					return "/feather_r.png";
				} else if (shape == Shape.BIRD) {
					return "/bird_r.png";
				} else if (shape == Shape.DOLPHIN) {
					return "/dolphin_r.png";
				} else if (shape == Shape.TURTLE) {
					return "/turtle_r.png";
				}
				break;
			case Yellow:
				if (shape == Shape.FLOWER) {
					return "/flower_y.png";
				} else if (shape == Shape.GECKO) {
					return "/gecko_y.png";
				} else if (shape == Shape.FEATHER) {
					return "/feather_y.png";
				} else if (shape == Shape.BIRD) {
					return "/bird_y.png";
				} else if (shape == Shape.DOLPHIN) {
					return "/dolphin_y.png";
				} else if (shape == Shape.TURTLE) {
					return "/turtle_y.png";
				}
				break;
			case Navy:
				if (shape == Shape.FLOWER) {
					return "/flower_n.png";
				} else if (shape == Shape.GECKO) {
					return "/gecko_n.png";
				} else if (shape == Shape.FEATHER) {
					return "/feather_n.png";
				} else if (shape == Shape.BIRD) {
					return "/bird_n.png";
				} else if (shape == Shape.DOLPHIN) {
					return "/dolphin_n.png";
				} else if (shape == Shape.TURTLE) {
					return "/turtle_n.png";
				}
				break;
			case Magenta:
				if (shape == Shape.FLOWER) {
					return "/flower_m.png";
				} else if (shape == Shape.GECKO) {
					return "/gecko_m.png";
				} else if (shape == Shape.FEATHER) {
					return "/feather_m.png";
				} else if (shape == Shape.BIRD) {
					return "/bird_m.png";
				} else if (shape == Shape.DOLPHIN) {
					return "/dolphin_m.png";
				} else if (shape == Shape.TURTLE) {
					return "/turtle_m.png";
				}
				break;
			case Green:
				if (shape == Shape.FLOWER) {
					return "/flower_g.png";
				} else if (shape == Shape.GECKO) {
					return "/gecko_g.png";
				} else if (shape == Shape.FEATHER) {
					return "/feather_g.png";
				} else if (shape == Shape.BIRD) {
					return "/bird_g.png";
				} else if (shape == Shape.DOLPHIN) {
					return "/dolphin_g.png";
				} else if (shape == Shape.TURTLE) {
					return "/turtle_g.png";
				}
				break;
			case Teal:
				if (shape == Shape.FLOWER) {
					return "/flower_t.png";
				} else if (shape == Shape.GECKO) {
					return "/gecko_t.png";
				} else if (shape == Shape.FEATHER) {
					return "/feather_t.png";
				} else if (shape == Shape.BIRD) {
					return "/bird_t.png";
				} else if (shape == Shape.DOLPHIN) {
					return "/dolphin_t.png";
				} else if (shape == Shape.TURTLE) {
					return "/turtle_t.png";
				}
				break;
			default:
				return null;
		}
		return null;
	}

}
