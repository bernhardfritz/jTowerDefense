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
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import control.InputManager;
import control.SpriteManager;
import control.TextureManager;

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
		iman=new InputManager();
		gc.getInput().addListener(iman);
		new SpriteManager(); // loads all static images
		new TextureManager(); // loads all static textures
		new Mouse();
		map=new Map(gc.getHeight()/Tile.HEIGHT, gc.getWidth()/Tile.WIDTH, TextureManager.grass);
		gc.setMouseCursor(new Image(Tile.WIDTH, Tile.HEIGHT, Image.FILTER_NEAREST), 0, 0); // transparent mouse
		gc.setTargetFrameRate(60);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		Mouse.update(map);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		map.draw(g);
		g.drawImage(SpriteManager.frame, 0,0);
		Mouse.draw(g);
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