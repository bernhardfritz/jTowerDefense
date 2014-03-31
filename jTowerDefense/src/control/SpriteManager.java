package control;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteManager {
	public static Image sword;
	public static Image dirt;
	public static Image grass;
	
	public SpriteManager() {
		try {
			sword=new Image("res/sword.png");
			grass=new Image("res/grass2.png");
			dirt=new Image("res/dirt.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
