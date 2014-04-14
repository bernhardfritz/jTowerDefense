package model;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

import control.ProjectileManager;
import control.SpriteManager;

public class Tower extends GameObject implements Buildable{
	private int x;
	private int y;
	private int radius;
	private float speed;
	private Image image;
	private int shootFactor;
	
	public Tower(Image image) {
		this.image=image;
	}
	public Tower(int x, int y, int radius, float speed, int shootFactor, Image image) {
		this.x=x;
		this.y=y;
		this.radius=radius;
		this.speed=speed;
		this.shootFactor = shootFactor;
		this.image=image;
	}
	
	public boolean shoot(Minion minion) {
		if(Counter.getCount()%(101-speed)==0) {
			Minion m = calculateMinionMoves(minion);
			Circle c = new Circle(x, y, radius);
			Rectangle minionRectangle = new Rectangle(m.getX(), m.getY(), 16, 16);
			if(m.isAlive() && c.intersects(minionRectangle)) {
				ProjectileManager.addProjectile(new Projectile(new Point(x,y), new Point(m.getX(), m.getY()), 5, 100,SpriteManager.projectile));
				return true;
			}
		}
		return false;
	}
	
	protected Minion calculateMinionMoves(Minion minion) {
		Minion m = (Minion) minion.clone();
		int moves = (int) (Math.max(Math.abs(this.getX()-minion.getX())/Tile.WIDTH, Math.abs(this.getY()-minion.getY())/Tile.HEIGHT)+shootFactor*m.getSpeed()/10);
		for (int i = 0; i < moves; i++) {
			m.move();
		}
		
		return m;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public float getSpeed() {
		return speed;
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
