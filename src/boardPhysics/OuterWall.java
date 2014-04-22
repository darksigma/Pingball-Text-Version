package boardPhysics;

import java.util.ArrayList;
import java.util.List;

import physics.*;


public class OuterWall implements Gadget, BoardObject {
	
	private LineSegment wall;
	
	private boolean isReflec;
	
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
     * The unique identifier of this wall
     */
    protected final String id;
    
    /**
     * The reflection coefficient for this gadget
     */
    protected final double reflecCoeff;
	
	public OuterWall(String id, LineSegment wall, boolean isReflec){
		this.wall = wall;
		this.isReflec = isReflec;
		this.id = id; 
		this.triggers = new ArrayList<Gadget>();
		this.reflecCoeff = 1.0;
		
		if(wall.p1().x() < wall.p2().x()){
			this.xCoord = (int) wall.p1().x();
			this.yCoord = (int) wall.p1().y();
		} else if(wall.p2().x() < wall.p1().x()){
			this.xCoord = (int) wall.p2().x();
			this.yCoord = (int) wall.p2().y();
		} else if(wall.p1().y() < wall.p2().y()){
			this.xCoord = (int) wall.p1().x();
			this.yCoord = (int) wall.p1().y();
		} else{
			this.xCoord = (int) wall.p2().x();
			this.yCoord = (int) wall.p2().y();
		}
	}
	
	/**
	 * Sets the reflectivity property of the wall
	 * 
	 * @param isReflec
	 * 			True if the wall is reflective, false if it is invisible
	 */
	public void setReflec(boolean isReflec){
		this.isReflec = isReflec;
	}
	
	/**
	 * Determines the reflectivity property of the wall
	 * 
	 * @return
	 * 			True if the wall is reflective, false if it is invisible
	 */
	public boolean isReflec(){
		return isReflec;
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
		return (int) Math.abs(wall.p1().x() - wall.p2().x());
	}

	@Override
	public int getHeight() {
		return (int) Math.abs(wall.p1().y() - wall.p2().y());
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
	public double[] impactCalc(Ball ball) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void progress(double timeStep) {
		// TODO Auto-generated method stub
		
	}

}
