package boardPhysics;

import physics.*;

public class Ball implements BoardObject{
	
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
	 * A vector to the center of the ball describing its position
	 */
	private Vect pos; 
	
	/**
	 * A double representing the length of a ball's radius
	 */
	private final double radius;
	
	/**
	 * A vector representing the velocity of the ball
	 */
	private Vect vel;
	
	/**
	 * A double representing the mass of the ball, to be used as needed
	 */
	private final double mass;
	
	/**
     * The unique identifier of this ball
     */
    protected final String id;
	
	public Ball(String id, double x, double y, double xVel, double yVel, double radius, double mass){
		this.id = id;
		this.pos = new Vect(x, y);
		this.vel = new Vect(xVel, yVel);
		this.radius = radius;
		this.mass = mass;
	}
	
	/**
	 * Determine the x-coordinate of the center of the ball
	 * 
	 * @return
	 * 		returns a double representing the x-coordinate of the ball
	 */
	public double getX(){
		return pos.x();
	}
	
	/**
	 * Determine the y-coordinate of the center of the ball
	 * 
	 * @return
	 * 		returns a double representing the y-coordinate of the ball
	 */
	public double getY(){
		return pos.y();
	}
	
	/**
	 * Determine the mass of the ball
	 * 
	 * @return
	 * 		returns a double representing the mass of the ball
	 */
	public double getMass(){
		return mass;
	}
	
	/**
	 * Determine the position of the ball
	 * 
	 * @return
	 * 			returns a vector representing the position of the ball
	 */
	public Vect getPos(){
		return pos;
	}
	
	/**
	 * Determine the velocity of the ball
	 * 
	 * @return
	 * 			returns a vector representing the velocity of the ball
	 */
	public Vect getVel(){
		return vel;
	}
	
	/**
	 * Changes the velocity of the ball
	 * 
	 * @param vector
	 * 			the vector representing the new velocity of the ball
	 */
	public void setVel(Vect vel){
		this.vel = vel;
	}
	
	/**
	 * Changes the position of the ball
	 * 
	 * @param pos
	 * 			the pos representing the new position of the ball
	 */
	public void setPos(Vect pos){
		this.pos = pos;
	}

	
	/**
	 * Create a circle representing the ball at its given position
	 * 
	 * @return
	 * 			returns Circle object representing the ball
	 */
	public Circle toCircle(){
		return new Circle(pos, radius);
	}
	
	@Override
    public double secondsUntilImpact(Ball ball){
		return Geometry.timeUntilBallBallCollision(this.toCircle(), this.vel, ball.toCircle(), ball.getVel());
    }
	
	@Override
	public void step(double timeStep){
		// TODO Auto-generated method stub
	}

	@Override
	public Vect recalculateBallVelocity(Ball ball) {
		return Geometry.reflectBalls(this.pos, this.mass, this.vel, ball.getPos(), ball.getMass(), ball.getVel()).v2;
	}
}

