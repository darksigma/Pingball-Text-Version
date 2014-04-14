package boardPhysics;

import physics.Vect;

public class Ball {
	
	/**
	 * A set of constants describing the effects of friction on movement
	 * 
	 */
	private static double MU_1 = 0.025;
	private static double MU_2 = 0.025;
	
	/**
	 * A constant describing the effective force of gravity on the ball
	 */
	private static double GRAVITY = 25.0;
	
	/**
	 * A vector to the center of the ball describing its position
	 */
	private Vect pos; 
	
	/**
	 * A double representing the length of a ball's radius
	 */
	private double radius;
	
	/**
	 * A vector representing the velocity of the ball
	 */
	private Vect vel;
	
	/**
	 * A double representing the mass of the ball, to be used as needed
	 */
	private double mass;
	
	/**
	 * The board that this ball currently inhabits
	 */
	private Board board;
	
	public Ball(Board board, double x, double y, double xVel, double yVel){
		this.pos = new Vect(x, y);
		this.vel = new Vect(xVel, yVel);
		this.board = board;
	}
	
	/**
	 * Determine the x-coordinate of the center of the ball
	 * 
	 * @return
	 * 		returns a double representing the x-coordinate of the ball
	 */
	public double getX(){
	}
	
	/**
	 * Determine the y-coordinate of the center of the ball
	 * 
	 * @return
	 * 		returns a double representing the y-coordinate of the ball
	 */
	public double getY(){
	}
	
	/**
     *Allows the ball to move about the board. If the item encounters other objects in the board,
     *the item is reflected appropriately. If the item does not move, step returns the item's current
     *position
     *
     *@param timeStep 
     *		a double representing the time increment by which the velocity changes; cannot be null
    **/
	public void step(double timeStep){
	}
}

