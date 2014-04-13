package model;

public class Mouse {
	private static int button=-1; // -1 = not pressed; 0 = left; 1 = right 
	private static int x=0;
	private static int y=0;
	private static int delta=0;
	private static boolean pressed=false;
	
	public static boolean press(int button) {
		boolean tmp=pressed;
		pressed=true;
		Mouse.button=button;
		return tmp!=pressed;
	}
	
	public static boolean release() {
		boolean tmp=pressed;
		pressed=false;
		Mouse.button=-1;
		return tmp!=pressed;
	}
	
	public static void move(int x, int y) {
		Mouse.x=x;
		Mouse.y=y;
	}

	public static int getButton() {
		return button;
	}
	
	public static void moveMouseWheel(int delta) {
		Mouse.delta=delta;
	}
	
	public static int getMouseWheelDelta() {
		int ret=delta;
		delta=0;
		return ret;
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public static boolean isPressed() {
		return pressed;
	}	
	
}
