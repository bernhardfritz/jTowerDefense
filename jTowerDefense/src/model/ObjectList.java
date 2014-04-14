package model;

public class ObjectList {
	private ObjectNode head;
	private ObjectNode current;
	
	public ObjectList() {
		head = null;
		current = null;
	}
	
	public void insert(Buildable b) {
		if (head == null) {
			head = new ObjectNode(b);
			head.next = head;
			head.prev = head;
			current = head;
		}
		else {
			ObjectNode temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			ObjectNode insert = new ObjectNode(b);
			temp.next = insert;
			insert.prev = temp;
			insert.next = head;
			head.prev = insert;
		}
	}
	
	public Buildable mouseWheelUp() {
		current = current.prev;
		
		return current.getObject();
	}
	
	public Buildable mouseWheelDown() {
		current = current.next;
		
		return current.getObject();
	}
}