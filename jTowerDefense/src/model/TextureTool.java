package model;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import control.TextureManager;

public class TextureTool extends Tool{

	private Texture primary=TextureManager.dirt;
	private Texture secondary=TextureManager.grass;
	private int size=1;
	
	public void textureTileOnMap(Tile t, Map map, Texture tex) {
		if(!tex.isWalkable()) {
			if(t==map.getPath().getStart()) map.getPath().setStart(null);
			else if(t==map.getPath().getEnd()) map.getPath().setEnd(null);
		}
		t.setTexture(tex);
	}
	
	@Override
	public void primaryAction(Map map) {
		Tile t=map.getTileAtExactly(x,y);
		if(t==null) return;
		if(size>=1) {
			textureTileOnMap(t, map, primary);
		}
		if(size>=2) {
			textureTileOnMap(t, map, primary);
			ArrayList<Tile> tiles=new ArrayList<Tile>();
			tiles.add(t.getRightNeighbour());
			tiles.add(t.getBottomNeighbour());
			tiles.add(t.getRightNeighbour().getBottomNeighbour());
			for(Tile tmp:tiles) {
				textureTileOnMap(tmp, map, primary);
			}
		}
		if(size>=3) {
			textureTileOnMap(t, map, primary);
			ArrayList<Tile> tiles=new ArrayList<Tile>();
			tiles.add(t.getRightNeighbour().getRightNeighbour());
			tiles.add(t.getRightNeighbour().getRightNeighbour().getBottomNeighbour());
			tiles.add(t.getRightNeighbour().getRightNeighbour().getBottomNeighbour().getBottomNeighbour());
			tiles.add(t.getBottomNeighbour().getBottomNeighbour());
			tiles.add(t.getBottomNeighbour().getBottomNeighbour().getRightNeighbour());
			for(Tile tmp:tiles) {
				textureTileOnMap(tmp, map, primary);
			}
		}
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
	
	public void incrementSize() {
		if(size<3) {
			size++;
		}
	}
	
	public void decrementSize() {
		if(size>1) {
			size--;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, Tile.WIDTH*size, Tile.HEIGHT*size);
	}
}
