package control;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteManager {
	public static Image sword;
	public static Image dirt;
	public static Image grass;
	public static Image frame;
	public static Image greenMinionLeft1;
	public static Image greenMinionLeft2;
	public static Image greenMinionLeft3;
	public static Image greenMinionRight1;
	public static Image greenMinionRight2;
	public static Image greenMinionRight3;
	public static Image greenMinionFront1;
	public static Image greenMinionFront2;
	public static Image greenMinionFront3;
	public static Image greenMinionBack1;
	public static Image greenMinionBack2;
	public static Image greenMinionBack3;
	public static Image projectile;
	public static Image arrowTower;
	public static Image frostTower;
	
	public SpriteManager() {
		try {
			initTextures();
			initMisc();
			initGreenMinion();
			initProjectiles();
			initTowers();
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
		greenMinionLeft1=new Image("res/minions/greenMinion/left1.png");
		greenMinionLeft2=new Image("res/minions/greenMinion/left2.png");
		greenMinionLeft3=new Image("res/minions/greenMinion/left3.png");
		greenMinionRight1=new Image("res/minions/greenMinion/right1.png");
		greenMinionRight2=new Image("res/minions/greenMinion/right2.png");
		greenMinionRight3=new Image("res/minions/greenMinion/right3.png");
		greenMinionFront1=new Image("res/minions/greenMinion/front1.png");
		greenMinionFront2=new Image("res/minions/greenMinion/front2.png");
		greenMinionFront3=new Image("res/minions/greenMinion/front3.png");
		greenMinionBack1=new Image("res/minions/greenMinion/back1.png");
		greenMinionBack2=new Image("res/minions/greenMinion/back2.png");
		greenMinionBack3=new Image("res/minions/greenMinion/back3.png");
	}
	
	public void initProjectiles() throws SlickException {
		projectile=new Image("res/projectiles/arrow2.png");
	}
	
	public void initTowers() throws SlickException {
		arrowTower=new Image("res/towers/arrowTower.png");
		frostTower=new Image("res/towers/frostTower.png");
	}
}
