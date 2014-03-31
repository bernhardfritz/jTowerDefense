package control;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteManager {
	public static Image sword;
	public static Image dirt;
	public static Image grass;
	public static Image frame;
	
	public SpriteManager() {
		try {
			sword=new Image("res/sword.png");
			grass=new Image("res/grass5_1.png");
			dirt=new Image("res/dirt.png");
			frame=new Image("res/frame.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
