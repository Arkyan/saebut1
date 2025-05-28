package latice.model.infoplayer;

public class Player {
	private String name;
	private PlayerBag playerBag;
	private Rack rack;
	private Integer points;
	private Integer numberOfTilesPutOnBoard;
	
	public Player(String name) {
		this.name = name;
		this.playerBag = new PlayerBag();
		this.rack = new Rack();
		this.points = (Integer) 0;
		this.numberOfTilesPutOnBoard = (Integer) 0;
	}

	public String getName() {
		return name;
	}
	
	public PlayerBag getPlayerBag() {
		return playerBag;
	}
	
	public Rack getRack() {
		return rack;
	}
	
	public Integer getPoints() {
		return points;
	}

	public void addPoints(Integer points) {
		this.points += points;
	}
	
	public Integer getNumberOfTilesPutOnBoard() {
		return numberOfTilesPutOnBoard;
	}
	
	public void setNumberOfTilesPutOnBoard(Integer numberOfTilesPutOnBoard) {
		this.numberOfTilesPutOnBoard = numberOfTilesPutOnBoard;
	}
}
