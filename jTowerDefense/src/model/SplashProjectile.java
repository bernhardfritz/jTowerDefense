package model;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

import control.MinionManager;

public class SplashProjectile extends Projectile {
	int splashRadius;
	
	public SplashProjectile(Point start, Point end, float speed, int damage, int splashRadius, Image image) {
		super(start, end, speed, damage, image);
		this.splashRadius = splashRadius;
	}
	
	@Override
	public void checkCollision() {
		for (Minion m : MinionManager.getMinions()) {
			if (m.isAlive() && this.isAlive()) {
				Rectangle minionRectangle = new Rectangle(m.getX(), m.getY(), 16, 16);
				if (minionRectangle.intersects(this.getProjectileShape())) {
					Circle splashArea = new Circle(this.getProjectileShape().getCenterX(), this.getProjectileShape().getCenterY(), splashRadius);
					for (Minion mi : MinionManager.getMinions()) {
						Rectangle minionSplashRectangle = new Rectangle(mi.getX(), mi.getY(), 16, 16);
						if (mi.isAlive() && this.isAlive()) {
							if (splashArea.intersects(minionSplashRectangle)) {
								mi.reduceHealth(this.getDamage());
							}
						}
					}
					this.despawn();
				}
			}
		}
	}
}
