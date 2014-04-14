package model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

import control.AnimationManager;
import control.SpriteManager;

public class Minion extends GameObject implements Cloneable{

	private int x;
	private int y;
	private int vx;
	private int vy;
	private int health;
	private int reward;
	private float speed;
	private boolean alive;
	private Waypoint waypoint;
	private float originSpeed;
	private int slowDuration;
	
	public Minion(int health, int reward, float speed) {
		this.health=health;
		this.reward=reward;
		this.speed=speed;
		this.slowDuration = 0;
		this.originSpeed = speed;
		hide();
	}
	
	public void spawn(Waypoint waypoint) {
		this.waypoint=waypoint;
		this.x=waypoint.getX();
		this.y=waypoint.getY();
		this.alive=true;
		show();
	}
	
	public void despawn() {
		this.alive=false;
		hide();
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public boolean isDead() {
		return !alive;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getReward() {
		return reward;
	}
	
	public void move() {
		if(alive) {
			if (slowDuration > 0) {
				slowDuration--;
			}
			else {
				this.speed = this.originSpeed;
			}
			
			if(speed!=0 && Counter.getCount()%(11-speed)==0) {
				if(waypoint==null) {
					this.despawn();
					return;
				}
				if(x==waypoint.getX() && y==waypoint.getY()) {
					waypoint=waypoint.next;
					if(waypoint!=null) {
						vx=(waypoint.getX()-x)/Tile.WIDTH;
						vy=(waypoint.getY()-y)/Tile.HEIGHT;
					}
				} else {
					x+=vx;
					y+=vy;
				}
			}
		}
	}
	
	public void slow(float slowFactor, int slowDuration) {
		if (this.slowDuration <= 0) {
			this.speed -= slowFactor;
		}
		this.slowDuration = slowDuration;
	}
	
	public void setWaypoint(Waypoint w) {
		waypoint=w;
	}
	
	public Waypoint getWaypoint() {
		return waypoint;
	}
	
	public void reduceHealth(int difference) {
		this.health -= difference;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	private boolean isWalkingLeft() {
		return vx<0;
	}
	
	private boolean isWalkingRight() {
		return vx>0;
	}
	
	private boolean isWalkingUp() {
		return vy<0;
	}
	
	private boolean isWalkingDown() {
		return vy>0;
	}
	
	@Override
	public void drawStrategy(Graphics g) {
		if (health <= 0) {
			despawn();
		}
		if(alive) {
			if(isWalkingLeft()) {
				g.drawAnimation(AnimationManager.greenMinionLeft, x,y);
			} else if(isWalkingRight()) {
				g.drawAnimation(AnimationManager.greenMinionRight, x,y);
			} else if(isWalkingUp()) {
				g.drawAnimation(AnimationManager.greenMinionBack, x,y);
			} else if(isWalkingDown()) {
				g.drawAnimation(AnimationManager.greenMinionFront, x,y);
			}
		}
	}
	
	@Override
	protected Object clone() {
		try {
			return super.clone();
		}
		catch (Exception e) {
			
		}
		return null;
	}
}
