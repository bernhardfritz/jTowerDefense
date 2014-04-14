package control;

import org.newdawn.slick.Animation;

public class AnimationManager {
	public static Animation greenMinionLeft;
	public static Animation greenMinionRight;
	public static Animation greenMinionFront;
	public static Animation greenMinionBack;
	
	public AnimationManager() {
		initGreenMinion();
	}
	
	private void initGreenMinion() {
		greenMinionLeft=new Animation();
		greenMinionLeft.addFrame(SpriteManager.greenMinionLeft1, 250);
		greenMinionLeft.addFrame(SpriteManager.greenMinionLeft2, 250);
		greenMinionLeft.addFrame(SpriteManager.greenMinionLeft1, 250);
		greenMinionLeft.addFrame(SpriteManager.greenMinionLeft3, 250);
		greenMinionRight=new Animation();
		greenMinionRight.addFrame(SpriteManager.greenMinionRight1, 250);
		greenMinionRight.addFrame(SpriteManager.greenMinionRight2, 250);
		greenMinionRight.addFrame(SpriteManager.greenMinionRight1, 250);
		greenMinionRight.addFrame(SpriteManager.greenMinionRight3, 250);
		greenMinionFront=new Animation();
		greenMinionFront.addFrame(SpriteManager.greenMinionFront1, 250);
		greenMinionFront.addFrame(SpriteManager.greenMinionFront2, 250);
		greenMinionFront.addFrame(SpriteManager.greenMinionFront1, 250);
		greenMinionFront.addFrame(SpriteManager.greenMinionFront3, 250);
		greenMinionBack=new Animation();
		greenMinionBack.addFrame(SpriteManager.greenMinionBack1, 250);
		greenMinionBack.addFrame(SpriteManager.greenMinionBack2, 250);
		greenMinionBack.addFrame(SpriteManager.greenMinionBack1, 250);
		greenMinionBack.addFrame(SpriteManager.greenMinionBack3, 250);
	}
}
