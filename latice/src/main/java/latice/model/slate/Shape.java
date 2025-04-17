package latice.model.slate;

public enum Shape {
    FLOWER("🌸"),
    GECKO("🦎"),
    FEATHER("🪶"),
    BIRD("🦜"),
    DOLPHIN("🐬"),
    TURTLE("🐢");

    private final String symbol;

    Shape(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
