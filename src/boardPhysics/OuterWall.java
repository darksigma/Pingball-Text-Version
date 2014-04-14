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

	@Override
	public boolean connect(Gadget g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disconnect(Gadget g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getReflec() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trigger(Ball ball) {
		// TODO Auto-generated method stub
		
	}
}
