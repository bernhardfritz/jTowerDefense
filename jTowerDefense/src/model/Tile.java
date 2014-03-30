package model;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Tile extends GameObject{
	private int x;
	private int y;
	public static final int WIDTH=16;
	public static final int HEIGHT=16;
	private Image texture;
	
	public Tile(int x, int y, Image texture) {
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
	
	public void setTexture(Image texture) {
		this.texture=texture;
	}
	
	public Image getTexture() {
		return texture;
	}

	@Override
	public void drawStrategy(Graphics g) {
		g.drawImage(texture, x, y);
	}
	
}
