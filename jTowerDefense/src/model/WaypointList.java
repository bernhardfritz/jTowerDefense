package model;

public class WaypointList {
	private Waypoint head;
	private Waypoint tail;
	
	public WaypointList() {
		head=null;
		tail=null;
	}
	
	public void prepend(Waypoint w) {
		if(head==null) {
			append(w);
		} else {
			head.prev=w;
			w.next=head;
			head=w;
		}
	}
	
	public void append(Waypoint w) {
		if(head==null) {
			head=w;
			tail=w;
		} else {
			tail.next=w;
			w.prev=tail;
			tail=w;
		}
	}
	
	public Waypoint search(Waypoint old) {
		Waypoint tmp=tail;
		while(old!=null) {
			while(tmp!=null) {
				if(old.getTile()==tmp.getTile()) return tmp;
				tmp=tmp.prev;
			}
			old=old.prev;
		}
		return null;
	}
	
	public void delete(Waypoint w) {
		if(head!=null) {
			if(w==head) {
				head=head.next;
				if(head!=null) head.prev=null;
			} else if(w==tail) {
				tail=tail.prev;
				if(tail!=null) tail.next=null;
			} else {
				Waypoint tmp=head;
				while(tmp.next!=null && tmp.next!=w) {
					tmp=tmp.next;
				}
				if(tmp.next!=null) {
					tmp.next=tmp.next.next;
					tmp.next.prev=tmp;
				}
			}
		}
	}
	
	public Waypoint getHead() {
		return head;
	}
	
	public Waypoint getTail() {
		return tail;
	}
}
