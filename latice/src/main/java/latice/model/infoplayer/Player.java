package latice.model.infoplayer;

public class Player {
	private String name;
	private PlayerBag playerBag;
	private Rack rack;
	private Integer points;
	private Integer numberOfTilesPutOnBoard;
	private Integer numberOfActions ;
	
	public Player(String name) {
		this.name = name;
		this.playerBag = new PlayerBag();
		this.rack = new Rack();
		this.points = (Integer) 0;
		this.numberOfTilesPutOnBoard = (Integer) 0;
		this.numberOfActions = 1;
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
	
	public Integer getNumberOfActions() {
		return numberOfActions;
	}
	
	public void initializeNumberOfActions() {
		this.numberOfActions = 1;
	}
	
	public Boolean playerCanPlay() {
		return this.numberOfActions > 0;
	}
	
	public void useAction() {
		if (this.numberOfActions > 0) {
			this.numberOfActions--;
		} else {
			throw new IllegalStateException("No actions left for this player.");
		}
	}
	
	public void buyAction() {
		if (this.points >= 2) {
			this.numberOfActions++;
			this.points -= 2;
		} else {
			throw new IllegalStateException("Not enough points to buy an action.");
		}
	}
	
}
