package model;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

public class Tile extends GameObject{
	private int x;
	private int y;
	public static final int WIDTH=16;
	public static final int HEIGHT=16;
	private Texture texture;
	private ArrayList<Tile> neighbours=new ArrayList<Tile>();
	private ArrayList<Tile> walkableNeighbours=new ArrayList<Tile>();
	
	public Tile(int x, int y, Texture texture) {
		this.x=x;
		this.y=y;
		this.texture=texture;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setTexture(Texture texture) {
		this.texture=texture;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public int getDistanceToTile(Tile t) {
		return Math.abs(t.getX()-this.getX())+Math.abs(t.getY()-this.getY());
	}
	
	public Point getCenterPoint() {
		return new Point(x+(float)Tile.WIDTH/2, y+(float)Tile.HEIGHT/2);
	}
	
	public void addNeighbour(Tile t) {
		if(!neighbours.contains(t)) neighbours.add(t);
	}
	
	public ArrayList<Tile> getNeighbours() {
		return neighbours;
	}
	
	public void initWalkableNeighbours() {
		walkableNeighbours.clear();
		if(!neighbours.isEmpty()) {
			for(Tile t:neighbours) {
				if(t.isWalkable()) walkableNeighbours.add(t);
			}
		}
	}
	
	public ArrayList<Tile> getWalkableNeighbours() {
		return walkableNeighbours;
	}
	
	public void removeWalkableNeighbour(Tile t) {
		walkableNeighbours.remove(t);
	}
	
	public boolean isWalkable() {
		return texture.isWalkable();
	}
	
	public boolean isBuildable() {
		return texture.isBuildable();
	}
	
	public Tile getLeftNeighbour() {
		for(Tile t:neighbours)
			if(t.getX()<getX()) return t;
		return this;
	}
	
	public Tile getRightNeighbour() {
		for(Tile t:neighbours)
			if(t.getX()>getX()) return t;
		return this;
	}
	
	public Tile getTopNeighbour() {
		for(Tile t:neighbours)
			if(t.getY()<getY()) return t;
		return this;
	}
	
	public Tile getBottomNeighbour() {
		for(Tile t:neighbours)
			if(t.getY()>getY()) return t;
		return this;
	}

	@Override
	public void drawStrategy(Graphics g) {
		g.drawImage(texture.getImage(), x, y);
	}

	public void removeWalkableNeighbours(Object[] array) {
		for(Object o:array) {
			removeWalkableNeighbour((Tile)o);
		}
		
	}
	
}
