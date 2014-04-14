package model;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

import view.Editor;

import control.ProjectileManager;
import control.SpriteManager;

public class ProjectileTool extends Tool{
	
	public ProjectileTool() {
		grid=false;		
	}
	@Override
	public void primaryAction() {
		ProjectileManager.addProjectile(new Projectile(new Point(Editor.WIDTH/2, Editor.HEIGHT/2), new Point(x, y), 2, 100,SpriteManager.projectile));
	}

	@Override
	public void secondaryAction() {
		// does nothing
	}
	
	public void draw(Graphics g) {
		g.drawImage(SpriteManager.sword, x, y);
	}
}
