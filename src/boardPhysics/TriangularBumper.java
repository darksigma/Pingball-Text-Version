package boardPhysics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import physics.Circle;
import physics.Geometry;
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
    
    /**
     * List of circles representing the triangle bumper vertices
     */
    protected final List<Circle> triangleVertices;
    
    /**
     * Represents orientation of the triangular bumper:
     * 		0. 0 degrees
     * 		1. 90 degrees
     * 		2. 180 degrees
     * 		3. 270 degrees
     */
    protected final int orientation;
    
    public TriangularBumper(String id, int x, int y, int orientation){
		this.xCoord = x;
		this.yCoord = y;
		this.width = 1;
		this.height = 1;
		this.id = id;
		this.reflecCoeff = 0.95;
		this.triggers = new ArrayList<Gadget>();
		
		this.orientation = (orientation % 360)/90;
		
		switch(this.orientation){
			case 0:
				triangleSides = Arrays.asList(new LineSegment(x, y+1, x, y),
											new LineSegment(x, y, x+1, y),
											new LineSegment(x, y+1, x+1, y));
				triangleVertices = Arrays.asList(new Circle(x, y, 0),
												new Circle(x+1, y, 0),
												new Circle(x, y+1, 0));
				break;
			case 1:
				triangleSides = Arrays.asList(new LineSegment(x, y, x+1, y),
											new LineSegment(x+1, y, x+1, y+1),
											new LineSegment(x, y, x+1, y+1));
				triangleVertices = Arrays.asList(new Circle(x, y, 0),
											new Circle(x+1, y, 0),
											new Circle(x+1, y+1, 0));
				break;
			case 2:
				triangleSides = Arrays.asList(new LineSegment(x+1, y+1, x+1, y),
											new LineSegment(x, y+1, x+1, y+1),
											new LineSegment(x, y+1, x+1, y));
				triangleVertices = Arrays.asList(new Circle(x, y+1, 0),
											new Circle(x+1, y, 0),
											new Circle(x+1, y+1, 0));
				break;
			default:
				triangleSides = Arrays.asList(new LineSegment(x, y, x, y+1),
											new LineSegment(x, y+1, x+1, y+1),
											new LineSegment(x, y, x+1, y+1));
				triangleVertices = Arrays.asList(new Circle(x, y, 0),
											new Circle(x+1, y+1, 0),
											new Circle(x, y+1, 0));
				break;
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
	
	/**
	 * Returns an integer representing the orientation of the bumper
	 * 
	 * @return
	 * 			integer as follows:
	 * 				0. 0 degrees
     * 				1. 90 degrees
     * 				2. 180 degrees
     * 				3. 270 degrees
	 */
	public int getOrientation(){
		return orientation;
	}

	@Override
	public String getID() {
		return id;
	}
	
	@Override
	public int getWidth() {
		return 1;
	}

	@Override
	public int getHeight() {
		return 1;
	}

	@Override
	public double getReflec() {
		return reflecCoeff;
	}

	@Override
	public void action() {
		return;
	}

	@Override
	public void trigger() {
		action();
		for (Gadget t : triggers){
			t.trigger();
		}
	}

	@Override
	public double[] impactCalc(Ball ball) {
		double minTimeToEdgeCollision = Double.POSITIVE_INFINITY;
		LineSegment closestEdge = triangleSides.get(0);
		
		for (LineSegment edge : triangleSides){
			double timeToCollision = Geometry.timeUntilWallCollision(edge, ball.toCircle(), ball.getVel());
			if (timeToCollision < minTimeToEdgeCollision){
				minTimeToEdgeCollision = timeToCollision;
				closestEdge = edge;
			}
		}
		
		double minTimeToVertexCollision = Double.POSITIVE_INFINITY;
		Circle closestVertex = triangleVertices.get(0);
		
		for (Circle vertex : triangleVertices){
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

	@Override
	public void progress(double timeStep) {
		return;
	}

}
