package model;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import control.SpriteManager;
import control.TextureManager;

public class Mouse {
	public static int button=-1; // -1 = not pressed; 0 = left; 1 = right 
	public static int x=0;
	public static int y=0;
	private static int cursorX;
	private static int cursorY;
	private static int width=Tile.WIDTH;
	private static int height=Tile.HEIGHT;
	private static Tool tool=Tool.SELECT;
	private static Image image=SpriteManager.sword;
	
	public static void nextTool() {
		int newTool=(tool.ordinal()+1)%Tool.values().length;
		tool=Tool.values()[newTool];
	}
	
	public static void previousTool() {
		int newTool=(tool.ordinal()-1)%Tool.values().length;
		if(newTool<0) newTool=Tool.values().length-1;
		tool=Tool.values()[newTool];
	}
	
	public static Tool getTool() {
		return tool;
	}
	
	public static void update(Map map) {
		Tile t=map.getTileAt(Mouse.x,Mouse.y);
		if(t!=null) {
			cursorX=t.getX();
			cursorY=t.getY();
			switch(tool) {
				case SELECT: {
					if(Mouse.button==0) {
						map.getPath().init(map);
						System.out.println(map.getPath().calculatePath());
						break;
					}
				}
				case EDIT: {
					if(Mouse.button==0) {
						t.setTexture(TextureManager.dirt);
					} else if(Mouse.button==1) {
						t.setTexture(TextureManager.grass);
					}
					break;
				}
				case START: {
					if(Mouse.button==0) {
						map.getPath().setStart(t);
					} else if(Mouse.button==1 && t==map.getPath().getStart()) {
						map.getPath().setStart(null);
					}
					break;
				}
				case END: {
					if(Mouse.button==0) {
						map.getPath().setEnd(t);
					} else if(Mouse.button==1 && t==map.getPath().getEnd()) {
						map.getPath().setEnd(null);
					}
					break;
				}
			}
		}
	}
	
	public static void draw(Graphics g) {
		g.setColor(Color.white);
		g.drawString("Tool: "+tool.name(), 10, 10);
		switch(tool) {
			case SELECT: g.drawImage(image, x, y); break;
			case EDIT: g.setColor(Color.white); g.drawRect(cursorX, cursorY, width, height); break;
			case START: g.setColor(Color.green); g.drawRect(cursorX, cursorY, width, height); break;
			case END: g.setColor(Color.red); g.drawRect(cursorX, cursorY, width, height); break;
		}
	}


}
