package model;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Map extends GameObject{
	private Tile tiles[][];
	private int rows;
	private int columns;
	private Tile start;
	private Tile end;
	
	public Map(int rows, int columns, Texture texture) {
		this.rows=rows;
		this.columns=columns;
		tiles=new Tile[rows][columns];
		initTiles(texture);
	}
	
	private void initTiles(Texture texture) {
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				tiles[row][column]=new Tile(Tile.WIDTH*column,Tile.HEIGHT*row,texture);
			}
		}
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				if(column>0) tiles[row][column].setLeft(tiles[row][column-1]);
				if(column<columns-1) tiles[row][column].setRight(tiles[row][column+1]);
				if(row>0) tiles[row][column].setTop(tiles[row-1][column]);
				if(row<rows-1) tiles[row][column].setBottom(tiles[row+1][column]); 
			}
		}
	}
	
	public Tile[][] getTiles() {
		return tiles;	
	}
	
	public Tile getTileAt(int x, int y) {
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				if(x>=tiles[row][column].getX() && x<tiles[row][column].getX()+Tile.WIDTH && y>=tiles[row][column].getY() && y<tiles[row][column].getY()+Tile.HEIGHT) {
					return tiles[row][column];
				}
			}
		}
		return null;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}

	public Tile getStart() {
		return start;
	}

	public void setStart(Tile start) {
		if(start==null) {
			this.start=start;
			return;
		}
		if(start.getTexture().isWalkable()) this.start=start;
	}

	public Tile getEnd() {
		return end;
	}

	public void setEnd(Tile end) {
		if(end==null) {
			this.end=end;
			return;
		}
		if(end.getTexture().isWalkable()) this.end=end;
	}

	@Override
	public void drawStrategy(Graphics g) {
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				tiles[row][column].draw(g);
			}
		}
		if(start!=null) {
			g.setColor(Color.green);
			g.drawRect(start.getX(), start.getY(), Tile.WIDTH, Tile.HEIGHT);
		}
		if(end!=null) {
			g.setColor(Color.red);
			g.drawRect(end.getX(), end.getY(), Tile.WIDTH, Tile.HEIGHT);
		}
	}
}
