package model;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Point;

import control.ProjectileManager;
import control.SpriteManager;

public class Tower extends GameObject implements Buildable{
	private int x;
	private int y;
	private int radius;
	private float speed;
	private Image image;
	
	public Tower(Image image) {
		this.image=image;
	}
	public Tower(int x, int y, int radius, float speed, Image image) {
		this.x=x;
		this.y=y;
		this.radius=radius;
		this.speed=speed;
		this.image=image;
	}
	
	public boolean shoot(Point target) {
		if(Counter.getCount()%(101-speed)==0) {
			if(new Circle(x, y, radius).contains(target.getX(), target.getY())) {
				ProjectileManager.addProjectile(new Projectile(new Point(x,y), target, 1, 100,SpriteManager.projectile));
				return true;
			}
		}
		return false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public void drawStrategy(Graphics g) {
		g.drawImage(image, x, y);		
	}

	@Override
	public Image getImage() {
		return image;
	}
}
