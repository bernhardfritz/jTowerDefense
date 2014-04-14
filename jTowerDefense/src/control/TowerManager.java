package control;

import java.util.ArrayList;

import model.Minion;
import model.Tower;

import org.newdawn.slick.Graphics;

public class TowerManager {
	private static ArrayList<Tower> towers=new ArrayList<Tower>();
	
	public static void addTower(Tower t) {
		towers.add(t);
	}
	
	public static void removeTower(Tower t) {
		towers.remove(t);
	}
	
	public static void removeAllTowers() {
		towers.clear();
	}
	
	public static void shootAllMinions() {
		for(Tower t:towers) {
			for(Minion m:MinionManager.getMinions()) {
				if(m.isAlive() && t.shoot(m)) break;
			}
		}
	}
	
	public static ArrayList<Tower> getTowers() {
		return towers;
	}
	
	public static Tower getTowerAtExactly(int x, int y) {
		for(Tower t: towers) {
			if(t.getX()==x && t.getY()==y) {
				return t;
			}
		}
		return null;
	}
	
	public static void draw(Graphics g) {
		for(Tower t:towers) {
			t.draw(g);
		}
	}
}
