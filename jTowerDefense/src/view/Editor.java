package view;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Map;
import model.Mouse;
import model.Tile;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import control.InputManager;
import control.SpriteManager;

public class Editor extends BasicGame
{
	InputManager iman;
	SpriteManager sman;
	Map map;
	public Editor(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		iman=new InputManager(gc);
		gc.getInput().addListener(iman);
		new SpriteManager(); // loads all static images
		map=new Map(gc.getHeight()/Tile.HEIGHT, gc.getWidth()/Tile.WIDTH, SpriteManager.grass);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		if(Mouse.button==0) {
			map.getTileAt(Mouse.x,Mouse.y).setTexture(SpriteManager.dirt);
		} else if(Mouse.button==1) {
			map.getTileAt(Mouse.x,Mouse.y).setTexture(SpriteManager.grass);
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		for(int row=0; row<map.getRows(); row++) {
			for(int column=0; column<map.getColumns(); column++) {
				map.getTiles()[row][column].draw(g);
			}
		}
	}
	
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Editor("jTowerDefense Editor"));
			appgc.setDisplayMode(640, 480, false);
			appgc.setShowFPS(false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}