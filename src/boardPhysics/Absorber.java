package boardPhysics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import physics.Circle;
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
    
    /**
     * List of circles representing the absorber vertices
     */
    protected final List<Circle> absorberVertices;
    
    /**
     * Whether the absorber is currently firing
     */
    protected boolean isFiring;
    
    /**
     * A list of balls that's being held by the absorber at any given time
     */
    protected final ArrayDeque<Ball> heldBalls;
    
    /**
     * Ball that is currently being fired, null if no ball is being fired
     */
    protected Ball firedBall;
    
    /**
     * The velocity at which to release a ball from the absorber
     */
    private final Vect releaseVel;
    
	
    public Absorber(String id, int x, int y, int width, int height, Vect releaseVel){
		this.xCoord = x;
		this.yCoord = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.reflecCoeff = 0;
		this.triggers = new ArrayList<Gadget>();
		this.absorberEdges = Arrays.asList(new LineSegment(x, y, x+width, y),
								new LineSegment(x+width, y, x+width, y+height),
								new LineSegment(x+width, y+height, x, y+height),
								new LineSegment(x, y+height, x, y));
		this.absorberVertices = Arrays.asList(new Circle(x, y, 0),
											new Circle(x+width, y, 0),
											new Circle(x+width, y+height, 0),
											new Circle(x, y+height, 0));
		this.isFiring = false;
		this.heldBalls = new ArrayDeque<Ball>();
		this.firedBall = null;
		this.releaseVel = releaseVel;
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
	
	public void addBallToAbsorber(Ball b){
		heldBalls.add(b);
	}

	@Override
	public void action() {
		if(isFiring == false && heldBalls.size() > 0){
			isFiring = true;
			firedBall = heldBalls.poll();
			firedBall.setVel(releaseVel);
		}
	}

	@Override
	public void trigger() {
		action();
		for (Gadget t : triggers){
			t.action();
		}
	}

	@Override
	public void progress(double timeStep) {
		if(isFiring){
			if(firedBall.getX() <= xCoord
				|| firedBall.getX() >= xCoord + width
				|| firedBall.getY() <= yCoord
				|| firedBall.getY() >= yCoord + height){
				
				isFiring = false;
				firedBall.setInAbsorber(false);
				firedBall = null;
			}
		}
	}

	@Override
	public double[] impactCalc(Ball ball) {
		double minTimeToEdgeCollision = Double.POSITIVE_INFINITY;
		LineSegment closestEdge = absorberEdges.get(0);
		
		for (LineSegment edge : absorberEdges){
			double timeToCollision = Geometry.timeUntilWallCollision(edge, ball.toCircle(), ball.getVel());
			if (timeToCollision < minTimeToEdgeCollision){
				minTimeToEdgeCollision = timeToCollision;
				closestEdge = edge;
			}
		}
		
		double minTimeToVertexCollision = Double.POSITIVE_INFINITY;
		Circle closestVertex = absorberVertices.get(0);
		
		for (Circle vertex : absorberVertices){
			double timeToCollision = Geometry.timeUntilCircleCollision(vertex, ball.toCircle(), ball.getVel());
			if (timeToCollision < minTimeToVertexCollision){
				minTimeToVertexCollision = timeToCollision;
				closestVertex = vertex;
			}
		}
		
		Vect newVel;
		double minTimeToCollision;
		
		if (minTimeToEdgeCollision < minTimeToVertexCollision){
			newVel = Geometry.reflectWall(closestEdge, ball.getVel(), reflecCoeff);
			minTimeToCollision = minTimeToEdgeCollision;
		} else{
			newVel = Geometry.reflectCircle(closestVertex.getCenter(), ball.getPos(), ball.getVel(), reflecCoeff);
			minTimeToCollision = minTimeToVertexCollision;
		}
		
		return new double[] {minTimeToCollision, newVel.x(), newVel.y()};
	}

}
