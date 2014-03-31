package model;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Texture {
	private Image image;
	private boolean buildable;
	private boolean walkable;
	
	public Texture(Image image, boolean buildable, boolean walkable) throws SlickException {
		this.image=image;
		this.buildable=buildable;
		this.walkable=walkable;
	}
	
	public Image getImage() {
		return image;
	}

	public boolean isBuildable() {
		return buildable;
	}

	public boolean isWalkable() {
		return walkable;
	}
}
