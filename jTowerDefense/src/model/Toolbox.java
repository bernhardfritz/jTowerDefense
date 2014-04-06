package model;

import java.util.LinkedList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Toolbox {
	private static LinkedList<Tool> tools=new LinkedList<Tool>();
	private static Tool current;
	private static Map map;
	
	public Toolbox(Map map) {
		tools.add(new TextureTool());
		tools.add(new SpawnpointTool());
		next();
		Toolbox.map=map;
	}
	
	public static void next() {
		current=tools.removeFirst();
		tools.addLast(current);
	}
	
	public static void prev() {
		current=tools.removeLast();
		tools.addFirst(current);
	}
	
	public static Tool getCurrent() {
		return current;
	}
	
	public static void performAction() {
		if(Mouse.getButton()==0) {
			current.primaryAction(map);
		} else if(Mouse.getButton()==1) {
			current.secondaryAction(map);
		}
	}
	
	public static void update() {
		current.updatePosition();
	}
	
	public static void draw(Graphics g) {
		current.draw(g);
		g.setColor(Color.white);
		g.drawString(current.getClass().getName().replace("model.", ""), 10, 10);
	}
}
