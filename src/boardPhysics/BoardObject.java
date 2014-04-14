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
	public double secondsUntilImpact(Ball ball);
	
	/**
     *Allows the object to move about the board. If the item encounters other objects in the board,
     *the item is reflected appropriately. If the item does not move, step does not change the position
     *position
     *
     *@param timeStep 
     *			a double representing the time increment by which we change the object's state
    **/
	public void step(double timeStep);
	
	
	/**
	 * Recalculate a ball's velocity assuming it collided with this board object
	 * 
	 * @param ball
	 * 			a ball that collided with this board object
	 * @return
	 * 			a vector representing the new velocity of the ball
	 */
	public Vect recalculateBallVelocity(Ball ball);
}
