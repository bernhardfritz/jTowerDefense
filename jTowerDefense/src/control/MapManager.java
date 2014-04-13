package control;

import model.Map;

public class MapManager {
	private static Map map;
	
	public static void setMap(Map map) {
		MapManager.map=map;
	}
	public static Map getMap() {
		return map;
	}
}
