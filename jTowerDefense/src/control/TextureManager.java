package control;

import org.newdawn.slick.SlickException;

import model.Texture;

public class TextureManager {
	public static Texture grass;
	public static Texture dirt;
	
	public TextureManager() {
		try {
			grass=new Texture(SpriteManager.grass, true, false);
			dirt=new Texture(SpriteManager.dirt, false, true);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
