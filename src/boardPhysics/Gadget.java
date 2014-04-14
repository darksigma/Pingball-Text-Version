package boardPhysics;

public interface Gadget {
	
	/**
	 * Treats the activation of this gadget as a trigger for another gadget
	 * 
	 * @param g
	 * 		The gadget that needs to be connected to this
	 * 		
	 * @return
	 * 		A boolean representing a properly achieved connection
	 */
	public boolean connect(Gadget g);
	
	/**
	 * Removes a gadget from from the triggers of this gadget
	 * 
	 * @param g
	 * 		The gadget that needs to be disconnected from this
	 * @return
	 * 		A boolean representing whether disconnection was properly achieved
	 */
	public boolean disconnect(Gadget g);
	
	/**
	 * 	Returns the x-coordinate of the upper left corner of this gadget
	 * 
	 * @return
	 * 		an integer representing the x-coordinate of the gadget's origin
	 */
	public int getX();
	
	/**
	 * Returns the x-coordinate of the upper left corner of this gadget
	 * 
	 * @return
	 * 		an integer representing the y-coordinate of the gadget's origin
	 */
	public int getY();
	
	/**
	 * Returns the unique identifier for the gadget
	 * 
	 * @return
	 * 		a string representing a unique identifier for the gadget
	 */
	public String getID();
	
	/**
     * Returns the width of this gadget in units of L
     * 
     * @return
     * 		an integer representing the width of the gadget
     */
    public int getWidth();
    
    /**
     * Returns the height of this gadget in units of L
     * 
     * @return
     * 		an integer representing the height of the gadget
     */
    public int getHeight();
    
    /**
     * Returns the number of seconds it will take for a ball moving at a constant
     * velocity to hit this gadget given its position and orientation
     * 
     * @return
     * 		a double representing the time until a ball collides with this gadget
     */
    public double secondsUntilImpact(Ball ball);
    
    /**
     *Allows the gadget to move about the board. If the gadget does not move, step does not change
     *the object's position.
     *
     *@param timeStep 
     *		a double representing the time increment by which we change the object state
    **/
    public void step();
    
	
	
}
