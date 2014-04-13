package model;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;

import control.ProjectileManager;

import view.Editor;

public class Projectile extends GameObject{
	private Point start;
	private Point end;
	private float x;
	private float y;
	private float vx;
	private float vy;
	private float rotation;
	private Image image;
	private float speed;
	private boolean alive;
	private int damage;
	
	public Projectile(Point start, Point end, float speed, int damage, Image image) {
		this.start=start;
		x=start.getX();
		y=start.getY();
		this.end=end;
		this.speed=speed;
		this.damage=damage;
		this.image=image.copy();
		rotateProjectile();
		spawn();
	}
	
	private void rotateProjectile() {
		float dx=Math.abs(end.getX()-start.getX());
		float dy=Math.abs(end.getY()-start.getY());
		rotation=(float)Math.atan(dy/dx);
		vx=(float)Math.cos(rotation);
		vy=(float)Math.sin(rotation);
		rotation*=57.2957795;
		if(end.getX()<start.getX())	vx=-vx;
		if(end.getY()<start.getY())	vy=-vy;
		if(vx<0&&vy<0) rotation=180-rotation;
		else if(vx<0&&vy>0) rotation=180+rotation;
		else if(vx>0&&vy>0) rotation=360-rotation;
		image.setRotation(360-rotation+45);
	}
	
	public void spawn() {
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
	
	public int getDamage() {
		return damage;
	}
	
	public void move() {
		if(alive) {
			x+=vx*speed;
			y+=vy*speed;
			if(x<0 || x>Editor.WIDTH || y<0 || y>Editor.HEIGHT) {
				despawn();
			}
		}
	}

	@Override
	public void drawStrategy(Graphics g) {
		if(alive) {
			g.drawImage(image, x,y);
		}
	}
}
