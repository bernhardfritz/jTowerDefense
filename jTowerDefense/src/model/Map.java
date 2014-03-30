package model;

import org.newdawn.slick.Image;

public class Map {
	private Tile tiles[][];
	private int rows;
	private int columns;
	
	
	public Map(int rows, int columns, Image texture) {
		this.rows=rows;
		this.columns=columns;
		tiles=new Tile[rows][columns];
		initTiles(texture);
	}
	
	private void initTiles(Image texture) {
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				tiles[row][column]=new Tile(Tile.WIDTH*column,Tile.HEIGHT*row,texture);
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
}
