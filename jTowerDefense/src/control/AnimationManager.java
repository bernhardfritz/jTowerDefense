package control;

import org.newdawn.slick.Animation;

public class AnimationManager {
	public static Animation greenMinion;
	
	public AnimationManager() {
		initGreenMinion();
	}
	
	private void initGreenMinion() {
		greenMinion=new Animation();
		greenMinion.addFrame(SpriteManager.greenMinionFront1, 250);
		greenMinion.addFrame(SpriteManager.greenMinionFront2, 250);
		greenMinion.addFrame(SpriteManager.greenMinionFront1, 250);
		greenMinion.addFrame(SpriteManager.greenMinionFront3, 250);
	}
}
