package boardPhysics;

import java.util.ArrayList;
import java.util.List;

import physics.Circle;
import physics.Geometry;
import physics.Vect;

public class CircularBumper implements Gadget, BoardObject {
		
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
     * The circle representation for the bumper
     */
    protected final Circle circleRep;
    
	public CircularBumper(String id, int x, int y){
		this.xCoord = x;
		this.yCoord = y;
		this.width = 1;
		this.height = 1;
		this.id = id;
		this.reflecCoeff = 1.0;
		this.circleRep = new Circle(x+ 0.5, y + 0.5, 0.5);
		this.triggers = new ArrayList<Gadget>();
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
	public void progress(double timeStep) {
		return;
	}

	@Override
	public double[] impactCalc(Ball ball) {
		double timeUntilCollision = Geometry.timeUntilCircleCollision(circleRep, ball.toCircle(), ball.getVel());
		Vect newVel = Geometry.reflectCircle(circleRep.getCenter(), ball.getPos(), ball.getVel(), reflecCoeff);
		return new double[]{timeUntilCollision, newVel.x(), newVel.y()};
	}

}
