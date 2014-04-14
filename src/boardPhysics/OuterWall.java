package boardPhysics;

import physics.*;


public class OuterWall implements Gadget {
	private LineSegment wall;
	private boolean isReflec;
	
	public OuterWall(int x1, int y1, int x2, int y2, boolean isReflec){
		this.wall = new LineSegment(x1, y1, x2, y2);
		this.isReflec = isReflec;
	}
	
	public OuterWall(LineSegment wall, boolean isReflec){
		this.wall = wall;
		this.isReflec = isReflec;
	}
	
	public void setReflec(boolean isReflec){
		this.isReflec = isReflec;
	}
}
