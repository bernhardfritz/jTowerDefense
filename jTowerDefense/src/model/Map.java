package model;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Map extends GameObject{
	private Tile tiles[][];
	private int rows;
	private int columns;
	private Path path;
	
	public Map(int rows, int columns, Texture texture) {
		this.rows=rows;
		this.columns=columns;
		this.path=new Path();
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
				tiles[row][column].getNeighbours().clear();
				if(column>0) tiles[row][column].addNeighbour(tiles[row][column-1]);
				if(column<columns-1) tiles[row][column].addNeighbour(tiles[row][column+1]);
				if(row>0) tiles[row][column].addNeighbour(tiles[row-1][column]);
				if(row<rows-1) tiles[row][column].addNeighbour(tiles[row+1][column]);
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
	
	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}

	@Override
	public void drawStrategy(Graphics g) {
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				tiles[row][column].draw(g);
			}
		}
		path.draw(g);
		if(path.getStart()!=null) {
			g.setColor(Color.green);
			g.drawRect(path.getStart().getX(), path.getStart().getY(), Tile.WIDTH, Tile.HEIGHT);
		}
		if(path.getEnd()!=null) {
			g.setColor(Color.red);
			g.drawRect(path.getEnd().getX(), path.getEnd().getY(), Tile.WIDTH, Tile.HEIGHT);
		}
	}
}
