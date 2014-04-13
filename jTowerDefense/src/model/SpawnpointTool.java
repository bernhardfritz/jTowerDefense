package model;

import org.newdawn.slick.Color;

import control.MapManager;

public class SpawnpointTool extends Tool{

	public SpawnpointTool() {
		color=Color.magenta;
	}
	
	@Override
	public void primaryAction() {
		Tile t=MapManager.getMap().getTileAtExactly(x, y);
		if(t!=null) {
			if(t.isWalkable() && t!=MapManager.getMap().getPath().getEnd()) {
				MapManager.getMap().getPath().setStart(t);
			}
		} else MapManager.getMap().getPath().setStart(null);
		MapManager.getMap().getPath().init();
	}

	@Override
	public void secondaryAction() {
		Tile t=MapManager.getMap().getTileAtExactly(x, y);
		if(t!=null) {
			if(t.isWalkable() && t!=MapManager.getMap().getPath().getStart()) {
				MapManager.getMap().getPath().setEnd(t);
			}
		} else MapManager.getMap().getPath().setEnd(null);
		MapManager.getMap().getPath().init();
	}

}
