package control;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteManager {
	public static Image dirt;
	public static Image grass;
	
	public SpriteManager() throws SlickException{
		dirt=new Image("res/dirt.png");
		grass=new Image("res/grass.png");
	}
}
