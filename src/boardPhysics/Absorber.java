package boardPhysics;

import java.util.Arrays;
import java.util.List;

import physics.Geometry;
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
    protected final List<LineSegment> absorberEdges;
	
    public Absorber(String id, int x, int y, int width, int height){
		this.xCoord = x;
		this.yCoord = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.reflecCoeff = 0;
		this.absorberEdges = Arrays.asList(new LineSegment(x, y, x+width, y),
								new LineSegment(x+width, y, x+width, y+height),
								new LineSegment(x+width, y+height, x, y+height),
								new LineSegment(x, y+height, x, y));
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
		return width;
	}

	@Override
	public int getHeight() {
		return height;
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
	public void step(double timeStep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double[] impactCalc(Ball ball) {
		double minTimeToCollision = Double.POSITIVE_INFINITY;
		LineSegment closestEdge = absorberEdges.get(0);
		for (LineSegment edge : absorberEdges){
			double timeToCollision = Geometry.timeUntilWallCollision(edge, ball.toCircle(), ball.getVel());
			if (timeToCollision < minTimeToCollision){
				minTimeToCollision = timeToCollision;
				closestEdge = edge;
			}
		}
		
		Vect newVel = Geometry.reflectWall(closestEdge, ball.getVel(), reflecCoeff);
		
		return new double[] {minTimeToCollision, newVel.x(), newVel.y()};
	}

}
