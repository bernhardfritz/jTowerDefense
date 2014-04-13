package model;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class Tool {
	protected static int x;
	protected static int y;
	protected boolean grid=true;
	protected Color color=Color.white;
	
	public void updatePosition() {
		if(grid) {
			x=(Mouse.getX()/Tile.WIDTH)*Tile.WIDTH;
			y=(Mouse.getY()/Tile.HEIGHT)*Tile.HEIGHT;
		} else {
			x=Mouse.getX();
			y=Mouse.getY();
		}
	}
	
	public abstract void primaryAction();
	
	public abstract void secondaryAction();
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, Tile.WIDTH, Tile.HEIGHT);
	}
}
