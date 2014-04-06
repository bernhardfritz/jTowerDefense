package model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

public class Minion extends GameObject{

	private int x;
	private int y;
	private int vx;
	private int vy;
	private int frameThreshold;
	private int frameCounter;
	private int health;
	private int reward;
	private boolean alive;
	private Animation anim;
	private Waypoint waypoint;
	
	public Minion(int health, int reward, Animation anim) {
		this.health=health;
		this.reward=reward;
		this.anim=anim;
		hide();
	}
	
	public void spawn(Waypoint waypoint) {
		this.waypoint=waypoint;
		this.x=waypoint.getX();
		this.y=waypoint.getY();
		this.frameThreshold=2;
		this.frameCounter=0;
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
	
	public float getX() {
		return x;
	}
	
	public float getY() {
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
			if(frameCounter==frameThreshold) {
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
				frameCounter=0;
			}
			frameCounter++;
		}
	}
	
	public void setWaypoint(Waypoint w) {
		waypoint=w;
	}
	
	public Waypoint getWaypoint() {
		return waypoint;
	}
	
	@Override
	public void drawStrategy(Graphics g) {
		if(alive) {
			g.drawAnimation(anim, x,y);
		}
	}
}
