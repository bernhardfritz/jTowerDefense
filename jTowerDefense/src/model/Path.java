package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

public class Path {
	private Stack<Tile> path=new Stack<Tile>();
	private Tile start;
	private Tile end;
	private int rows;
	private int columns;
	
	public void init(Map map) {
		rows=map.getRows();
		columns=map.getColumns();
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				map.getTiles()[row][column].initWalkableNeighbours();
			}
		}
		path.clear();
		path.push(start);
	}
	
	public boolean calculatePath() {
		if(start!=null && end!=null) {
			int counter=0;
			while(counter<rows*columns*4 && !path.isEmpty() && path.peek()!=end) {
				if(path.peek().getWalkableNeighbours().isEmpty()) {
					Tile tmp=path.pop();
					if(!path.isEmpty()) path.peek().removeWalkableNeighbour(tmp);
				} else {
					Tile tmp=path.peek();
					path.push(getClosestToEnd(tmp.getWalkableNeighbours()));
					path.peek().removeWalkableNeighbour(tmp);
					
				}
				counter++;
			}
			if(path.isEmpty()) return false;
			if(path.peek()==end) return true;
		}
		return false;
	}
	
	public Tile getClosestToEnd(ArrayList<Tile> walkableNeighbours) {
		Tile min=walkableNeighbours.get(0);
		for(Tile t:walkableNeighbours) {
			if(t.getDistanceToTile(end)<min.getDistanceToTile(end)) min=t;
		}
		return min;
	}
	
	public Tile getStart() {
		return start;
	}

	public void setStart(Tile t) {
		if(t==null) {
			start=t;
		} else if(t.getTexture().isWalkable()) {
			start=t;
		}
	}

	public Tile getEnd() {
		return end;
	}

	public void setEnd(Tile t) {
		if(t==null) {
			end=t;
		} else if(t.getTexture().isWalkable()) {
			end=t;
		}
	}
}
