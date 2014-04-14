package model;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

import control.ProjectileManager;
import control.SpriteManager;

public class SlowTower extends Tower {

	public SlowTower(Image image) {
		super(image);
	}

	public SlowTower(int x, int y, int radius, float speed, int shootFactor, Image image) {
		super(x, y, radius, speed, shootFactor, image);
	}
	
	@Override
	public boolean shoot(Minion minion) {
		if(Counter.getCount()%(101-this.getSpeed())==0) {
			Minion m = this.calculateMinionMoves(minion);
			
			Circle c = new Circle(this.getX(), this.getY(), this.getRadius());
			Rectangle minionRectangle = new Rectangle(m.getX(), m.getY(), 16, 16);
			if(m.isAlive() && c.intersects(minionRectangle)) {
				ProjectileManager.addProjectile(new SlowProjectile(new Point(this.getX(), this.getY()), new Point(m.getX(), m.getY()), 5, 100, 2, 150, SpriteManager.projectile));
				return true;
			}
		}
		return false;
	}
}
