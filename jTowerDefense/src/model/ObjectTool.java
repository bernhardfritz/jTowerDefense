package model;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import control.MapManager;
import control.SpriteManager;
import control.TowerManager;

public class ObjectTool extends Tool{

	private Buildable current = new Tower(SpriteManager.arrowTower.copy());
	private Color c;
	private ObjectList objectList = new ObjectList();
	
	public ObjectTool() {
		initObjectList();
	}
	
	@Override
	public void primaryAction() {
		Tile t=MapManager.getMap().getTileAtExactly(x, y);
		if(t==null) return;
		if(t.getBottomNeighbour().getTexture().isBuildable()) {
			if(TowerManager.getTowerAtExactly(x, y)==null) {
				if (current instanceof SplashTower) {
					TowerManager.addTower(new SplashTower(x,y,100,1,8,SpriteManager.frostTower));
				}
				else if (current instanceof SlowTower) {
					TowerManager.addTower(new SlowTower(x,y,100,1,8,SpriteManager.frostTower));
				}
				else if (current instanceof Tower) {
					TowerManager.addTower(new Tower(x,y,100,1,8,SpriteManager.arrowTower));
				}
			}
		}
	}

	@Override
	public void secondaryAction() { 
		Tower t=TowerManager.getTowerAtExactly(x, y);
		if(t!=null) TowerManager.removeTower(t);
	}
	
	public void updatePosition() {
		super.updatePosition();
		if(MapManager.getMap().getTileAtExactly(x,y).getBottomNeighbour().getTexture().isBuildable()) c=Color.green;
		else c=Color.red;
	}
	
	private void initObjectList() {
		objectList.insert(new Tower(SpriteManager.arrowTower.copy()));
		objectList.insert(new SplashTower(SpriteManager.frostTower.copy()));
		objectList.insert(new SlowTower(SpriteManager.frostTower.copy()));
	}
	
	public void mouseWheelUp() {
		current = objectList.mouseWheelUp();
	}
	
	public void mouseWheelDown() {
		current = objectList.mouseWheelDown();
	}
	
	public void changeObject() {
		if (current instanceof SplashTower) {
			current = new SlowTower(SpriteManager.frostTower.copy());
		}
		else if (current instanceof SlowTower) {
			current = new Tower(SpriteManager.arrowTower.copy());
		}
		else if (current instanceof Tower) {
			current = new SplashTower(SpriteManager.frostTower.copy());
		}
	}
	
	public void draw(Graphics g) {
		current.getImage().setAlpha(0.5f);
		g.drawImage(current.getImage(), x, y, c);
	}
}
