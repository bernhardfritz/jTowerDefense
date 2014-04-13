package model;

public class Keyboard {
	private static int key;
	private static boolean pressed;
	
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
	
	public static int getKey() {
		if(pressed) {
			int tmp=key;
			key=-1;
			return tmp;
		}
		return -1;
	}
}
