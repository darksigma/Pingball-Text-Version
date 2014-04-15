package boardPhysics;

import java.util.Arrays;
import java.util.List;

import physics.LineSegment;
import physics.Vect;

public class TriangularBumper implements Gadget, BoardObject {
	
	/**
     * List of gadgets whose triggers are connected to this gadget
     */
    protected List<Gadget> triggers;
    
    /**
     * X coordinate of the upper left corner of this gadget
     */
    protected final int xCoord;
    
    /**
     * Y coordinate of the upper left corner of this gadget
     */
    protected final int yCoord;
    
    /**
     * The width of this gadget in units of L
     */
    protected int width;
    
    /**
     * The height of this gadget in units of L
     */
    protected int height;
    
    /**
     * The unique identifier of this wall
     */
    protected final String id;
    
    /**
     * The reflection coefficient for this gadget
     */
    protected final double reflecCoeff;
    
    /**
     * List of line segments representing the triangular bumper
     */
    protected final List<LineSegment> triangleSides;
    
    public TriangularBumper(String id, int x, int y, int orientation){
		this.xCoord = x;
		this.yCoord = y;
		this.width = 1;
		this.height = 1;
		this.id = id;
		this.reflecCoeff = 0.95;
		
		int caseNo = (orientation % 360)/90;
		
		switch(caseNo){
			case 0:
				triangleSides = Arrays.asList(new LineSegment(x, y+1, x, y),
											new LineSegment(x, y, x+1, y),
											new LineSegment(x, y+1, x+1, y));
				break;
			case 1:
				triangleSides = Arrays.asList(new LineSegment(x, y, x+1, y),
											new LineSegment(x+1, y, x+1, y+1),
											new LineSegment(x, y, x+1, y+1));
				break;
			case 2:
				triangleSides = Arrays.asList(new LineSegment(x+1, y+1, x+1, y),
											new LineSegment(x, y+1, x+1, y+1),
											new LineSegment(x, y+1, x+1, y));
				break;
			default:
				triangleSides = Arrays.asList(new LineSegment(x, y, x, y+1),
											new LineSegment(x, y+1, x+1, y+1),
											new LineSegment(x, y, x+1, y+1));
				break;
		}
			
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

	@Override
	public double secondsUntilImpact(Ball ball) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void step(double timeStep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vect recalculateBallVelocity(Ball ball) {
		// TODO Auto-generated method stub
		return null;
	}

}
