package model;

import control.TextureManager;

public class TextureTool extends Tool{

	private Texture primary=TextureManager.dirt;
	private Texture secondary=TextureManager.grass;
	
	@Override
	public void primaryAction(Map map) {
		Tile t=map.getTileAtExactly(x,y);
		if(!primary.isWalkable()) {
			if(t==map.getPath().getStart()) map.getPath().setStart(null);
			else if(t==map.getPath().getEnd()) map.getPath().setEnd(null);
		}
		t.setTexture(primary);
		map.getPath().init(map);
	}
	
	@Override
	public void secondaryAction(Map map) {
		Tile t=map.getTileAtExactly(x,y);
		if(!secondary.isWalkable()) {
			if(t==map.getPath().getStart()) map.getPath().setStart(null);
			else if(t==map.getPath().getEnd()) map.getPath().setEnd(null);
		}
		t.setTexture(secondary);
		map.getPath().init(map);
	}
	
	public void setPrimaryTexture(Texture t) {
		primary=t;
	}
	
	public void setSecondaryTexture(Texture t) {
		secondary=t;
	}
}
