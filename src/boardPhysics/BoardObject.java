package boardPhysics;

import physics.*;

public interface BoardObject {
	
	/**
     * Returns the number of seconds it will take for a ball moving at a constant
     * velocity to hit this boardObject given its position and orientation
     * 
     * @return
     * 			a double representing the time until another ball collides with this object
     */
	
	public void step(double timeStep);
	
	
	/**
	 * Determine the time it will take until this object collides with a given ball
	 * and recalculate a ball's velocity assuming it collided with this board object
	 * 
	 * @param ball
	 * 			a ball that collided with this board object
	 * @return
	 * 			a array of doubles with components:
	 * 				0. Time until impact with the ball
	 * 				1. x-component of the ball's new velocity post-impact
	 * 				2. y-component of the ball's new velocity post-impact
	 */
	public double[] impactCalc(Ball ball);
}
