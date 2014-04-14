package boardPhysics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import physics.*;

public class Board {
	
	private final int xDim;
	private int yDim;
	private ArrayList<Gadget> gadgets;
	private ArrayList<Ball> balls;
	private ArrayList<BoardObject> inhabitants;
	
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
			board.addGadgetToBoard(new OuterWall(walls.get(i), wallsReflec[i]));
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
	}
	
	/**
	 * Adds a ball to the board.
	 * 
	 * @param ball
	 * 			a ball to be added to the board
	 */
	public void addBallToBoard(Ball ball){
	}
	
	/**
	 * Return the maximum x-coordinate on the board.
	 * 
	 * @return
	 * 			an integer representing the largest x-coordinate that exists on the board	
	 */
	public int getXMax(){
	}
	
	/**
	 * Return the maximum y-coordinate on the board.
	 * 
	 * @return
	 * 			an integer representing the largest y-coordinate that exists on the board	
	 */
	public int getYMax(){
	}
	
	/**
	 * Calculate the number seconds until a collision would occur assuming that all objects
	 * on the board maintained the same linear and angular velocities
	 * 
	 * @return
	 * 			returns the number of seconds until a collision will next occur
	 */
	public double secondsUntilNextCollision(){
		
	}
	
	/**
	 * Determine the objects involved in the next collision that would occur assuming that all objects
	 * on the board maintained the same linear and angular velocities
	 * 
	 * @return
	 * 			returns a list of BoardObjects involved in the next collision
	 */
	public List<BoardObject> objectsAtNextCollision(){
		
	}
	
	/**
	 * Advances the whole board one step forward by a time step
	 * 
	 * @param timeStep
	 * 			a double the represents the time by which we want to shift the state of the
	 * 			board
	 */
	public void step(double timeStep){
	}
	
	
	/**
	 * Returns a string representing the board to be printed on the screen and for debugging purposes
	 * 
	 * @return
	 * 			a string representing the board
	 */
	public String toString(){
	}
}
