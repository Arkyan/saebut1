package latice.model.infoplayer;

import model.slate.Tile;

public class Player {
	private String name;
	private PlayerBag playerBag;
	private Rack rack;
	private Integer points;
	
	public Player(String name, PlayerBag playerBag, Rack rack) {
		this.name = name;
		this.playerBag = playerBag;
		this.rack = rack;
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
