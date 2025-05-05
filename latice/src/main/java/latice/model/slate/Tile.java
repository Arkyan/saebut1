package latice.model.slate;

import latice.model.slate.Color;
import latice.model.slate.Shape;

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
		System.out.println("I am a " + color + " tile and my shape is " + shape.getSymbol());
	}

	public String showTile() {
		String colorCode;
		switch (color) {
        	case Red:
        		colorCode = "\u001B[31m";  // Red
        		break;
        	case Yellow:
        		colorCode = "\u001B[33m";  // Yellow
        		break;
        	case Navy:
        		colorCode = "\u001B[34m";  // Navy
        		break;
        	case Magenta:
        		colorCode = "\u001B[35m";  // Magenta
        		break;
        	case Green:
        		colorCode = "\u001B[32m";  // Green
        		break;
        	case Teal:
        		colorCode = "\u001B[36m";  // Teal
        		break;
        	default:
        		colorCode = "\u001B[0m";   // Reset color
		}

		String reset = "\u001B[0m";  // Reset console color
		return colorCode + shape.getSymbol() + reset;
	}

	public String getComboTile() {
		String colorCode;
		switch (color) {
        	case Red:
        		colorCode = "\u001B[31m";  // Red
        		break;
        	case Yellow:
        		colorCode = "\u001B[33m";  // Yellow
        		break;
        	case Navy:
        		colorCode = "\u001B[34m";  // Navy
        		break;
        	case Magenta:
        		colorCode = "\u001B[35m";  // Magenta
        		break;
        	case Green:
        		colorCode = "\u001B[32m";  // Green
        		break;
        	case Teal:
        		colorCode = "\u001B[36m";  // Teal
        		break;
        	default:
        		colorCode = "\u001B[0m";   // Reset color
		}

		String reset = "\u001B[0m";  // Reset console color
    	return colorCode + shape.getSymbol() + reset;
	}


}
