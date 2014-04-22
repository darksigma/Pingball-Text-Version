package boardPhysics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import physics.*;

public class Flipper implements Gadget, BoardObject {
	
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
     * The line segment representing the flipper
     */
    protected final List<LineSegment> flipper;
    
    /**
     * True if the flipper is a right flipper, false if it is a left flipper.
     */
    protected final boolean isRight;
    
    /**
     * Orientation of the flipper --> 0 if it is vertical, 0.5 f it is intermediate, 1 if it is horizontal
     */
    protected final double orientation;
    
    public Flipper(String id, int x, int y, boolean isRight, int startingOrientation){
		this.xCoord = x;
		this.yCoord = y;
		this.width = 2;
		this.height = 2;
		this.id = id;
		this.reflecCoeff = 0.95;
		this.isRight = isRight;
		this.orientation = startingOrientation;
		this.triggers = new ArrayList<Gadget>();
		if(isRight){
			this.flipper = Arrays.asList(new LineSegment(new Vect(x, y), new Vect(x, y+2)),
										new LineSegment(new Vect(x, y), new Vect(x+2, y)));
		} else{
			this.flipper = Arrays.asList(new LineSegment(new Vect(x+2, y), new Vect(x+2, y+2)),
										new LineSegment(new Vect(x, y), new Vect(x+2, y)));
		}
	}
	
    @Override
	public boolean connect(Gadget g) {
		return triggers.add(g);
	}

	@Override
	public boolean disconnect(Gadget g) {
		return triggers.remove(g);
	}

	@Override
	public int getX() {
		return xCoord;
	}

	@Override
	public int getY() {
		return yCoord;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public int getWidth() {
		return 2;
	}

	@Override
	public int getHeight() {
		return 2;
	}

	@Override
	public double getReflec() {
		return reflecCoeff;
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
	public void progress(double timeStep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double[] impactCalc(Ball ball) {
		// TODO Auto-generated method stub
		return null;
	}

}
