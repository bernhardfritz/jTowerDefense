package model;

import org.newdawn.slick.Color;

public class SpawnpointTool extends Tool{

	public SpawnpointTool() {
		color=Color.magenta;
	}
	
	@Override
	public void primaryAction(Map map) {
		Tile t=map.getTileAtExactly(x, y);
		if(t!=null) {
			if(t.isWalkable() && t!=map.getPath().getEnd()) {
				map.getPath().setStart(t);
			}
		} else map.getPath().setStart(null);
		map.getPath().init(map);
	}

	@Override
	public void secondaryAction(Map map) {
		Tile t=map.getTileAtExactly(x, y);
		if(t!=null) {
			if(t.isWalkable() && t!=map.getPath().getStart()) {
				map.getPath().setEnd(t);
			}
		} else map.getPath().setEnd(null);
		map.getPath().init(map);
	}

}
