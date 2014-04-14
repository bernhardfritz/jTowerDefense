package model;

public class ObjectNode {
	private Buildable object;
	public ObjectNode next;
	public ObjectNode prev;
	
	public ObjectNode(Buildable object) {
		this.object = object;
		this.next = null;
		this.prev = null;
	}
	
	public Buildable getObject() {
		return object;
	}
}