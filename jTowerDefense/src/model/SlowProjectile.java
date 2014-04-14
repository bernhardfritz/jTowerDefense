package model;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

import control.MinionManager;

public class SlowProjectile extends Projectile {
	private float slowFactor;
	private int slowDuration;

	public SlowProjectile(Point start, Point end, float speed, int damage, float slowFactor, int slowDuration, Image image) {
		super(start, end, speed, damage, image);
		this.slowFactor = slowFactor;
		this.slowDuration = slowDuration;
	}
	
	public void checkCollision() {
		for (Minion m : MinionManager.getMinions()) {
			if (m.isAlive() && this.isAlive()) {
				Rectangle minionRectangle = new Rectangle(m.getX(), m.getY(), 16, 16);
				if (minionRectangle.intersects(this.getProjectileShape())) {
					this.despawn();
					m.slow(slowFactor, slowDuration);
				}
			}
		}
	}
}
