package boardPhysics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import physics.*;

public class Board {
	
	/**
	 * A set of constants describing the effects of friction on movement
	 */
	private static final double MU_1 = 0.025;
	private static final double MU_2 = 0.025;
	
	/**
	 * A constant describing the effective force of gravity on the ball
	 */
	private static final double GRAVITY = 25.0;
	
	/**
	 * This is the maximal coordinate in the x direction
	 */
	private final int xDim;
	
	/**
	 * This is the maximal coordinate in the y direction
	 */
	private final int yDim;
	
	/**
	 * This is a list of gadgets on the board
	 */
	private final ArrayList<Gadget> gadgets;
	
	/**
	 * This is a list of balls on the board
	 */
	private final ArrayList<Ball> balls;
	
	/**
	 * This is a list of board objects on the board
	 */
	private final ArrayList<BoardObject> inhabitants;
	
	private Board(int xDim, int yDim){
		this.xDim = xDim;
		this.yDim = yDim;
		this.gadgets = new ArrayList<Gadget>();
		this.balls = new ArrayList<Ball>();
		this.inhabitants = new ArrayList<BoardObject>();
	}
	
	/**
	 * 
	 * @param xDim
	 * 			The size of the board in the x-dimension
	 * @param yDim
	 * 			The size of the board in the y-dimension
	 * @param wallsReflec
	 * 			A list of booleans determining whether the walls are reflective or invisible:
	 * 			Order is: top, right, bottom, left walls (clockwise order)
	 * @return
	 */
	public static Board newBoard(int xDim, int yDim, boolean[] wallsReflec){
		Board board = new Board(xDim, yDim);
		
		List<LineSegment> walls = Arrays.asList(
				new LineSegment(0, 0, xDim, 0),
				new LineSegment(xDim, 0, xDim, yDim),
				new LineSegment(xDim, yDim, 0, yDim),
				new LineSegment(0, yDim, 0, 0)
				); 
		
		for(int i = 0; i < 4; i ++){
			board.addGadgetToBoard(new OuterWall("wall " + i, walls.get(i), wallsReflec[i]));
		}
		
		return board;
	}
	
	/**
	 * Adds a gadget to the board.
	 * 
	 * @param gadget
	 * 			a gadget to be added to the board
	 */
	public void addGadgetToBoard(Gadget gadget){
		gadgets.add(gadget);
		inhabitants.add((BoardObject) gadget);
	}
	
	/**
	 * Adds a ball to the board.
	 * 
	 * @param ball
	 * 			a ball to be added to the board
	 */
	public void addBallToBoard(Ball ball){
		balls.add(ball);
		inhabitants.add((BoardObject) ball);
	}
	
	/**
	 * Return the maximum x-coordinate on the board.
	 * 
	 * @return
	 * 			an integer representing the largest x-coordinate that exists on the board	
	 */
	public int getXMax(){
		return xDim;
	}
	
	/**
	 * Return the maximum y-coordinate on the board.
	 * 
	 * @return
	 * 			an integer representing the largest y-coordinate that exists on the board	
	 */
	public int getYMax(){
		return yDim;
	}
	
//	/**
//	 * Calculate the number seconds until a collision would occur assuming that all objects
//	 * on the board maintained the same linear and angular velocities and determines the new
//	 * velociti
//	 * 
//	 * @return
//	 * 			returns the number of seconds until a collision will next occur
//	 */
//	public double[] detailsOfNextCollision(){
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//	/**
//	 * Determine the objects involved in the next collision that would occur assuming that all objects
//	 * on the board maintained the same linear and angular velocities
//	 * 
//	 * @return
//	 * 			returns a list of BoardObjects involved in the next collision
//	 */
//	public List<BoardObject> objectsAtNextCollision(){
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	/**
	 * Advances the whole board one step forward by a time step
	 * 
	 * @param timeStep
	 * 			a double the represents the time by which we want to shift the state of the
	 * 			board
	 */
	public void step(double timeStep){
		
		for(Ball ball : balls){
			Vect vOld = ball.getVel();
			
			// Vnew = Vold × ( 1 - mu × delta_t - mu2 × |Vold| × delta_t )
			Vect vNew = vOld.times(1 - MU_1*timeStep - MU_2*vOld.length()*timeStep);
			
			ball.setVel(vNew);
		}
		
		double minTimeUntilBallBallCollision = Double.POSITIVE_INFINITY;
		Ball[] ballBallCollision = new Ball[2];
		for(int i = 0; i < balls.size() - 1; i++){
			for(int j = i + 1; j < balls.size(); j++){
				Ball ball1 = balls.get(i);
				Ball ball2 = balls.get(j);
				
			}
		}
		
		
	}
	
	
	/**
	 * Returns a string representing the board to be printed on the screen and for debugging purposes
	 * 
	 * @return
	 * 			a string representing the board
	 */
	public String toString(){
		// TODO Auto-generated method stub
		return null;
	}
}
