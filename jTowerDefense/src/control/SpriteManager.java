package control;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteManager {
	public static Image sword;
	public static Image dirt;
	public static Image grass;
	public static Image frame;
	public static Image greenMinionFront1;
	public static Image greenMinionFront2;
	public static Image greenMinionFront3;
	public static Image projectile;
	
	public SpriteManager() {
		try {
			initTextures();
			initMisc();
			initGreenMinion();
			initProjectiles();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void initTextures() throws SlickException {
		grass=new Image("res/grass5_1.png");
		dirt=new Image("res/dirt.png");
	}
	
	public void initMisc() throws SlickException {
		sword=new Image("res/sword.png");
		frame=new Image("res/frame.png");
	}
	
	public void initGreenMinion() throws SlickException {
		greenMinionFront1=new Image("res/minions/greenMinionFront1.png");
		greenMinionFront2=new Image("res/minions/greenMinionFront2.png");
		greenMinionFront3=new Image("res/minions/greenMinionFront3.png");
	}
	
	public void initProjectiles() throws SlickException {
		projectile=new Image("res/projectiles/arrow2.png");
	}
}
