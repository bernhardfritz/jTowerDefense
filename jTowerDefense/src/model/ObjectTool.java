package model;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import control.MapManager;
import control.SpriteManager;
import control.TowerManager;

public class ObjectTool extends Tool{

	private Buildable current=new Tower(SpriteManager.arrowTower.copy());
	private Color c;
	
	@Override
	public void primaryAction() {
		Tile t=MapManager.getMap().getTileAtExactly(x, y);
		if(t==null) return;
		if(t.getBottomNeighbour().getTexture().isBuildable()) {
			if(TowerManager.getTowerAtExactly(x, y)==null) {
				TowerManager.addTower(new Tower(x,y,100,1,SpriteManager.arrowTower));
			}
		}
	}

	@Override
	public void secondaryAction() { 
	}
	
	public void updatePosition() {
		super.updatePosition();
		if(MapManager.getMap().getTileAtExactly(x,y).getBottomNeighbour().getTexture().isBuildable()) c=Color.green;
		else c=Color.red;
	}
	
	public void draw(Graphics g) {
		current.getImage().setAlpha(0.5f);
		g.drawImage(current.getImage(), x, y, c);
	}
}
