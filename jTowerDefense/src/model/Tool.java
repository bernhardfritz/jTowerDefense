package model;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class Tool {
	protected static int x;
	protected static int y;
	protected Color color=Color.white;
	
	public void updatePosition() {
		x=(Mouse.getX()/Tile.WIDTH)*Tile.WIDTH;
		y=(Mouse.getY()/Tile.HEIGHT)*Tile.HEIGHT;
	}
	
	public abstract void primaryAction(Map map);
	
	public abstract void secondaryAction(Map map);
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, Tile.WIDTH, Tile.HEIGHT);
	}
}
