package latice.model.slate;

import latice.model.slate.Color;
import latice.model.slate.Shape;

import static latice.view.console.Console.message;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(color, shape);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		return color == other.color && shape == other.shape;
	}
	
	
}
