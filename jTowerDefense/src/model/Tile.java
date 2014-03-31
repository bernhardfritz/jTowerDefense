package model;

import org.newdawn.slick.Graphics;

public class Tile extends GameObject{
	private int x;
	private int y;
	public static final int WIDTH=16;
	public static final int HEIGHT=16;
	private Texture texture;
	private Tile left;
	private Tile right;
	private Tile top;
	private Tile bottom;
	
	public Tile(int x, int y, Texture texture) {
		this.x=x;
		this.y=y;
		this.texture=texture;
		this.left=null;
		this.right=null;
		this.top=null;
		this.bottom=null;
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

	public Tile getLeft() {
		return left;
	}

	public void setLeft(Tile left) {
		this.left = left;
	}

	public Tile getRight() {
		return right;
	}

	public void setRight(Tile right) {
		this.right = right;
	}

	public Tile getTop() {
		return top;
	}

	public void setTop(Tile top) {
		this.top = top;
	}

	public Tile getBottom() {
		return bottom;
	}

	public void setBottom(Tile bottom) {
		this.bottom = bottom;
	}

	@Override
	public void drawStrategy(Graphics g) {
		g.drawImage(texture.getImage(), x, y);
	}
	
}
