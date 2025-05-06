package latice.model.infoplayer;

public class Player {
	private String name;
	private PlayerBag playerBag;
	private Rack rack;
	private Integer points;
	
	public Player(String name) {
		this.name = name;
		this.playerBag = new PlayerBag();
		this.rack = new Rack();
		this.points = 0;
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
}
