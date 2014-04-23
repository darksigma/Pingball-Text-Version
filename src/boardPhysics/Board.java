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
	 * @return
	 */
	public static Board newBoard(int xDim, int yDim){
		Board board = new Board(xDim, yDim);
		
		List<LineSegment> walls = Arrays.asList(
				new LineSegment(0, 0, xDim, 0),
				new LineSegment(xDim, 0, xDim, yDim),
				new LineSegment(xDim, yDim, 0, yDim),
				new LineSegment(0, yDim, 0, 0)
				); 
		
		for(int i = 0; i < 4; i ++){
			OuterWall wall = new OuterWall("wall " + i, walls.get(i), board, "wall " + i);
			board.gadgets.add(wall);
			board.inhabitants.add((BoardObject) wall);
		}
				
		return board;
	}
	
	/**
	 * Connects a wall in the board to another wall in the board specified
	 * 
	 * @param wall
	 * 			Specifies which wall in this board we want to connect to another
	 * @param boardToBeConnected
	 * 			Specifies which other board we want to connect our wall to
	 * @param wallToBeConnected
	 * 			Specifies which other wall in the other board we want to connect
	 * 			our wall to
	 * @return
	 * 			true if the connection process was successful and false otherwise
	 */
	public boolean connectWall(String wall, Board boardToBeConnected, String wallToBeConnected){
		for (Gadget g : gadgets){
			if(g instanceof OuterWall && g.getID().equals(wall)){
				OuterWall ourWall = (OuterWall) g;
				ourWall.setConnectivity(boardToBeConnected, wallToBeConnected);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Adds a gadget to the board.
	 * 
	 * @param gadget
	 * 			a gadget to be added to the board
	 */
	public void addGadgetToBoard(Gadget gadget){
		if (gadget instanceof OuterWall){
			throw new RuntimeException("CANNOT ADD A NEW OUTER WALL TO BOARD");
		}
		
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
		
//		//Modify the velocities of all of the balls according to gravity and friction
//		for(Ball ball : balls){
//			double vY = ball.getVel().y();
//			double vX = ball.getVel().x();
//		    double newVY = vY + GRAVITY * timeStep;
//		    double newVX = vX * (1 - MU_1 * timeStep - MU_2 * Math.abs(vX) * timeStep);
//		    newVY = newVY * (1 - MU_1 * timeStep - MU_2 * Math.abs(newVY) * timeStep);
//		    
//		    ball.setVel(new Vect(newVX, newVY));
//		}
		
		Ball collisionBall1 = null;
		Ball collisionBall2 = null;
		Ball collisionBall3 = null;
		Gadget collisionGadget = null;
		
		//With the current velocities and positions determine the time for the next ball-ball
		//collision as well as the balls that actually collide
		double minTimeUntilBallBallCollision = Double.POSITIVE_INFINITY;
		
		if(balls.size() > 1){
			collisionBall1 = balls.get(0);
			collisionBall2 = balls.get(1);
			for(int i = 0; i < balls.size() - 1; i++){
				for(int j = i + 1; j < balls.size(); j++){
					Ball ball1 = balls.get(i);
					Ball ball2 = balls.get(j);
					if(!ball1.getInAbsorber() && !ball2.getInAbsorber()){	
						double timeUntilCollision = ball1.impactCalc(ball2)[0];
						if (timeUntilCollision < minTimeUntilBallBallCollision){
							minTimeUntilBallBallCollision = timeUntilCollision;
							collisionBall1 = ball1;
							collisionBall2 = ball2;
						}
					}
				}
			}
		}
		
		//With the current velocities and positions determine the time for the next ball-gadget
		//collision and determine the objects involved in that collision
		double minTimeUntilBallGadgetCollision = Double.POSITIVE_INFINITY;
		if(balls.size() > 0 && gadgets.size() > 0){
			collisionBall3 = balls.get(0);
			collisionGadget = gadgets.get(0);
			for(Ball b : balls){
				if(!b.getInAbsorber()){
					for(Gadget g : gadgets){
						double timeUntilCollision = ((BoardObject) g).impactCalc(b)[0];
						//System.out.println(g.getID() + " " +timeUntilCollision);
						if (timeUntilCollision < minTimeUntilBallGadgetCollision){
							minTimeUntilBallGadgetCollision = timeUntilCollision;
							collisionBall3 = b;
							collisionGadget = g;
						}
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
		
		if(collisionGadget instanceof Absorber){
			collisionBall3.setVel(new Vect(0,0));
			Vect newPos = new Vect(collisionGadget.getX() + collisionGadget.getWidth() - 0.25, collisionGadget.getY() + collisionGadget.getHeight() - 0.25);
			collisionBall3.setPos(newPos);
			collisionBall3.setInAbsorber(true);
			((Absorber) collisionGadget).addBallToAbsorber(collisionBall3);
	    } else if(!(collisionGadget instanceof OuterWall) || ((OuterWall)collisionGadget).getConnectedBoard() == this && ((OuterWall)collisionGadget).getConnectedWall().equals(collisionGadget.getID())){
			collisionBall3.setVel(ball3Vel);
		} else{
			//TODO @DANA, this has to do with the client/server ball passing stuff
		}
		
		collisionGadget.trigger();

		
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
		for(Ball b : balls){
			((BoardObject) b).progress(timeStep);
		}
		
		for (Gadget g : gadgets){
			((BoardObject) g).progress(timeStep);
		}
		
		for(Ball ball : balls){
			if(!ball.getInAbsorber()){
				double vY = ball.getVel().y();
				double vX = ball.getVel().x();
			    double newVY = vY + GRAVITY * timeStep;
			    double newVX = vX * (1 - MU_1 * timeStep - MU_2 * Math.abs(vX) * timeStep);
			    newVY = newVY * (1 - MU_1 * timeStep - MU_2 * Math.abs(newVY) * timeStep);
			    
			    ball.setVel(new Vect(newVX, newVY));
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
		char[][] boardRep = new char[yDim + 2][xDim + 2];
		
		for(int i = 0; i < yDim + 2; i++){
			boardRep[i][0] = '.';
			boardRep[i][xDim + 1] = '.';
		}
		
		for(int i = 0; i < xDim + 2; i++){
			boardRep[0][i] = '.';
			boardRep[yDim + 1][i] = '.';
		}
		
		for (Gadget g : gadgets){
			if(g instanceof SquareBumper){
				boardRep[g.getY() + 1][g.getX() + 1]= '#';
			}else if(g instanceof TriangularBumper){
				if(((TriangularBumper) g).getOrientation() % 2 == 0)	
					boardRep[g.getY() + 1][g.getX() + 1]= '/';
				if(((TriangularBumper) g).getOrientation() % 2 == 1)	
					boardRep[g.getY() + 1][g.getX() + 1]= '\\';
			}else if(g instanceof CircularBumper){
				boardRep[g.getY() + 1][g.getX() + 1]= 'O';
			}else if(g instanceof Absorber){
				for(int i=g.getX(); i < g.getX() + g.getWidth(); i++){
					for(int j=g.getY(); j < g.getY() + g.getHeight(); j++){
						boardRep[j + 1][i + 1] = '=';
					}
				}
			}
		}
		
		for(Ball b : balls){
			boardRep[(int) (b.getY() + 1)][(int) (b.getX() + 1)]= '*';
		}
		
		StringBuffer boardString = new StringBuffer();
		for(char[] row : boardRep){
			for(char c : row){
				boardString.append(c);
			}
			boardString.append('\n');
		}
		
		return boardString.toString();
	}
}
