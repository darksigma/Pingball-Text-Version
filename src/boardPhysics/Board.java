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
	 * A constant providing a buffer zone to prevent abnormalities in the
	 * action of various items on the board due to rounding errors in calculating
	 * the time it takes to collide with another object
	 */
	private static final double TIME_EPSILON = 0.0001;
	
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
		
		//Base case of the recursive implementation --> end if we've basically reached negligible
		//amounts of time
		if(timeStep < TIME_EPSILON){
			return;
		}
		
		//Modify the velocities of all of the balls according to gravitya and friction
		for(Ball ball : balls){
			Vect vOld = ball.getVel();
			
			// Vnew = Vold × ( 1 - mu × delta_t - mu2 × |Vold| × delta_t )
			Vect vNew = vOld.times(1 - MU_1*timeStep - MU_2*vOld.length()*timeStep);
			
			ball.setVel(vNew);
		}
		
		//With the current velocities and positions determine the time for the next ball-ball
		//collision as well as the balls that actually collide
		double minTimeUntilBallBallCollision = Double.POSITIVE_INFINITY;
		Ball collisionBall1 = balls.get(0);
		Ball collisionBall2 = balls.get(1);
		for(int i = 0; i < balls.size() - 1; i++){
			for(int j = i + 1; j < balls.size(); j++){
				Ball ball1 = balls.get(i);
				Ball ball2 = balls.get(j);
				if(!ball1.getInAbsorber() && !ball2.getInAbsorber()){	
					double timeUntilCollision = ball1.impactCalc(ball2)[0];
					if (timeUntilCollision < minTimeUntilBallBallCollision){
						collisionBall1 = ball1;
						collisionBall2 = ball2;
					}
				}
			}
		}
		
		//With the current velocities and positions determine the time for the next ball-gadget
		//collision and determine the objects involved in that collision
		double minTimeUntilBallGadgetCollision = Double.POSITIVE_INFINITY;
		Ball collisionBall3 = balls.get(0);
		Gadget collisionGadget = gadgets.get(0);
		for(Ball b : balls){
			if(!b.getInAbsorber()){
				for(Gadget g : gadgets){
					double timeUntilCollision = ((BoardObject) g).impactCalc(b)[0];
					if (timeUntilCollision < minTimeUntilBallGadgetCollision){
						collisionBall3 = b;
						collisionGadget = g;
					}
				}
			}
		}
		
		//Trivially progress the board if the next determined collision of any kind doesn't happen
		//within the time step
		if(Math.min(minTimeUntilBallBallCollision, minTimeUntilBallGadgetCollision) > timeStep){
			progress(timeStep - TIME_EPSILON);
			return;
		}
		
		//If a ball-ball collision happens within the time step, progress the board trivially until
		//just before the collision, modify the ball velocities accordingly and recursively call the
		//step function passing the remaining time as the argument for step()
		if(minTimeUntilBallBallCollision < minTimeUntilBallGadgetCollision){
			progress(minTimeUntilBallBallCollision - TIME_EPSILON);
			
			Vect ball1Vel = new Vect(collisionBall2.impactCalc(collisionBall1)[1], collisionBall2.impactCalc(collisionBall1)[2]);
			Vect ball2Vel = new Vect(collisionBall1.impactCalc(collisionBall2)[1], collisionBall1.impactCalc(collisionBall2)[2]);
			
			collisionBall1.setVel(ball1Vel);
			collisionBall2.setVel(ball2Vel);
			
			step(timeStep - minTimeUntilBallBallCollision);
			return;
		}
		
		//In the final case, a ball-gadget collision occurs within the time step. In this case we
		//progress the board trivially until just before the collision, modify the ball velocity
		//and trigger the gadget. Then recursively call the step function passing the remaining time 
		//as the argument for step()
		progress(minTimeUntilBallGadgetCollision - TIME_EPSILON);
		
		Vect ball3Vel = new Vect(((BoardObject)collisionGadget).impactCalc(collisionBall3)[1], ((BoardObject)collisionGadget).impactCalc(collisionBall3)[2]);
		
		collisionBall3.setVel(ball3Vel);
		collisionGadget.trigger(collisionBall3);
		
		step(timeStep - minTimeUntilBallBallCollision);
		return;	
	}
	
	/**
	 * Advances the whole board one step forward by a time step, assuming *NO* collisions
	 * occur
	 * 
	 * @param timeStep
	 * 			a double the represents the time by which we want to shift the state of the
	 * 			board, assuming *NO* collisions occur
	 */
	public void progress(double timeStep){
		for (BoardObject b : inhabitants){
			b.progress(timeStep);
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
