package model;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import control.AnimationManager;
import control.MapManager;
import control.MinionManager;

public class Toolbox {
	private static ArrayList<Tool> tools=new ArrayList<Tool>();
	private static Tool current;
	
	public Toolbox() {
		tools.add(new TextureTool());
		tools.add(new SpawnpointTool());
		tools.add(new ObjectTool());
		tools.add(new ProjectileTool());
		current=tools.get(0);
	}
	
	public static void setTool(int i) {
		current=tools.get(i);
	}
	
	public static Tool getCurrent() {
		return current;
	}
	
	public static void performAction() {
		int button=Mouse.getButton();
		int delta=Mouse.getMouseWheelDelta();
		int key=Keyboard.getKey();
		if(button==0) {
			current.primaryAction();
		} else if(button==1) {
			current.secondaryAction();
		} else if(delta==1) {
			if(current instanceof TextureTool) {
				((TextureTool) current).incrementSize();
			}
		} else if(delta==-1) {
			if(current instanceof TextureTool) {
				((TextureTool) current).decrementSize();
			}
		} else if(key==org.lwjgl.input.Keyboard.KEY_SPACE) {
			if(MapManager.getMap().getPath().isValid()) {
				Minion m=new Minion(100,100,10,AnimationManager.greenMinion);
				MinionManager.addMinion(m);
				m.spawn(MapManager.getMap().getPath().getWaypoints().getHead());
			}
		} else if(key==org.lwjgl.input.Keyboard.KEY_1) {
			Toolbox.setTool(0);
		} else if(key==org.lwjgl.input.Keyboard.KEY_2) {
			Toolbox.setTool(1);
		} else if(key==org.lwjgl.input.Keyboard.KEY_3) {
			Toolbox.setTool(2);
		} else if(key==org.lwjgl.input.Keyboard.KEY_4) {
			Toolbox.setTool(3);
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
