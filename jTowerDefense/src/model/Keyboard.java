package model;

import control.AnimationManager;

public class Keyboard {
	private static int key;
	private static boolean pressed;
	
	public static void update(Map map) {
		if(getKey()==org.lwjgl.input.Keyboard.KEY_SPACE) {
			if(map.getPath().isValid()) {
				Minion m=new Minion(100,100,AnimationManager.greenMinion);
				map.addMinion(m);
				m.spawn(map.getPath().getWaypoints().getHead());
			}
		}
	}
	
	public static void press(int k) {
		if(!pressed) {
			key=k;
			pressed=true;
		}
	}
		
	public static void release(int k) {
		if(pressed) {
			k=-1;
			pressed=false;
		}
	}
	
	private static int getKey() {
		if(pressed==true) {
			int tmp=key;
			key=-1;
			return tmp;
		}
		return -1;
	}
}
