package model;

import org.newdawn.slick.Graphics;

public abstract class GameObject {
	private boolean visible=true;
	
	public void draw(Graphics g) {
		if(visible) {
			drawStrategy(g);
		}
	}
	
	public abstract void drawStrategy(Graphics g);
	
	public void show() {
		visible=true;
	}
	
	public void hide() {
		visible=false;
	}
}
