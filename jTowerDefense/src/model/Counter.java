package model;

public class Counter {

	private static long time=0;
	
	public static void increment() {
		time++;
	}
	
	public static long getCount() {
		return time;
	}
}
