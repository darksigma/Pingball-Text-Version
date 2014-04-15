package boardPhysics;

import java.util.Arrays;
import java.util.List;

import physics.LineSegment;
import physics.Vect;

public class Absorber implements Gadget, BoardObject {
	
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
     * List of line segments representing the absorber
     */
    protected final List<LineSegment> absorber;
	
    public Absorber(String id, int x, int y, int width, int height){
		this.xCoord = x;
		this.yCoord = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.reflecCoeff = 0;
		absorber = Arrays.asList(new LineSegment(x, y, x+width, y),
								new LineSegment(x+width, y, x+width, y+height),
								new LineSegment(x+width, y+height, x, y+height),
								new LineSegment(x, y+height, x, y));
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
