package latice.model.slate;

import latice.model.slate.Color;
import latice.model.slate.Shape;

import static latice.view.console.Console.message;

public class Tile {
	private Color color;
	private Shape shape;

	public Tile(Color color, Shape shape) {
			super();
			this.color = color;
			this.shape = shape;
	}

    public Color getColor() {
		return color;
	}

	public Shape getShape() {
		return shape;
	}

	public void describe() {
		message("I am a " + color + " tile and my shape is " + shape.getSymbol());
	}

	public String showTile() {
		String colorCode;
		switch (color) {
        	case Red:
        		colorCode = "\u001B[31m";
        		break;
        	case Yellow:
        		colorCode = "\u001B[33m";
        		break;
        	case Navy:
        		colorCode = "\u001B[34m";
        		break;
        	case Magenta:
        		colorCode = "\u001B[35m";
        		break;
        	case Green:
        		colorCode = "\u001B[32m";
        		break;
        	case Teal:
        		colorCode = "\u001B[36m";
        		break;
        	default:
        		colorCode = "\u001B[0m";
		}

		String reset = "\u001B[0m";
		return colorCode + shape.getSymbol() + reset;
	}
}
