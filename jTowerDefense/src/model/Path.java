package model;

import java.util.ArrayList;
import java.util.Stack;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import control.MapManager;
import control.MinionManager;

public class Path extends GameObject{
	private Stack<Tile> path=new Stack<Tile>();
	private Tile start;
	private Tile end;
	private int rows;
	private int columns;
	private boolean valid=false;
	private WaypointList waypoints;
	
	public void init() {
		rows=MapManager.getMap().getRows();
		columns=MapManager.getMap().getColumns();
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				MapManager.getMap().getTiles()[row][column].initWalkableNeighbours();
			}
		}
		path.clear();
		path.push(start);
		valid=calculatePath();
		if(valid) {
			calculateWaypoints();
			notifyMinions(MinionManager.getMinions());
		}
		else MinionManager.removeAllMinions();
	}

	private boolean calculatePath() {
		if(start!=null && end!=null) {
			while(!path.isEmpty() && path.peek()!=end) {
				if(path.peek().getWalkableNeighbours().isEmpty()) {
					Tile tmp=path.pop();
					if(!path.isEmpty()) path.peek().removeWalkableNeighbour(tmp);
				} else {
					Tile tmp=path.peek();
					path.push(getClosestToEnd(tmp.getWalkableNeighbours()));
					path.peek().removeWalkableNeighbours(path.toArray());
				}
			}
			if(path.isEmpty()) return false;
			if(path.peek()==end) return true;
		}
		return false;
	}
	
	private void calculateWaypoints() {
		waypoints=new WaypointList();
		for(int i=0; i<path.size(); i++) {
			waypoints.append(new Waypoint(path.get(i)));	
		}
	}
	
	public WaypointList getWaypoints() {
		return waypoints;
	}
	
	private void notifyMinions(ArrayList<Minion> minions) {
		for(Minion m:minions) {
			m.setWaypoint(waypoints.search(m.getWaypoint()));
		}
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
		start=t;
	}

	public Tile getEnd() {
		return end;
	}

	public void setEnd(Tile t) {
		end=t;
	}

	public boolean isValid() {
		return valid;
	}

	@Override
	public void drawStrategy(Graphics g) {
		if(this.isValid()) {
			g.setColor(Color.blue);
			for(Object o:path.toArray()) {
				Tile tmp=(Tile)o;
				g.drawRect(tmp.getX(), tmp.getY(), Tile.WIDTH, Tile.HEIGHT);
			}
		}
	}
}
