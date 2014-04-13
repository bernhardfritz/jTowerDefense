package control;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import model.Minion;

public class MinionManager {
	private static ArrayList<Minion> minions=new ArrayList<Minion>();
	
	public static void addMinion(Minion m) {
		minions.add(m);
	}
	
	public static void removeMinion(Minion m) {
		minions.remove(m);
	}
	
	public static void removeAllMinions() {
		minions.clear();
	}
	
	public static void moveAllMinions() {
		for(Minion m:minions) {
			m.move();
		}
	}
	
	public static ArrayList<Minion> getMinions() {
		return minions;
	}
	
	public static void draw(Graphics g) {
		for(Minion m:minions) {
			m.draw(g);
		}
	}
}
