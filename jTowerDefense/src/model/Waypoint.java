package model;

public class Waypoint {
	private Tile tile;
	public Waypoint prev;
	public Waypoint next;
	
	public Waypoint(Tile tile) {
		this.tile=tile;
	}
	
	public int getX() {
		return tile.getX();
	}
	
	public int getY() {
		return tile.getY();
	}
	
	public Tile getTile() {
		return tile;
	}
}
