package boardPhysics;

public interface Gadget {
	
	/**
	 * Treats the activation of this gadget as a trigger for another gadget
	 * 
	 * @param g
	 * 			The gadget that needs to be connected to this
	 * 		
	 * @return
	 * 			A boolean representing a properly achieved connection
	 */
	public boolean connect(Gadget g);
	
	/**
	 * Removes a gadget from from the triggers of this gadget
	 * 
	 * @param g
	 * 			The gadget that needs to be disconnected from this
	 * @return
	 * 			A boolean representing whether disconnection was properly achieved
	 */
	public boolean disconnect(Gadget g);
	
	/**
	 * 	Returns the x-coordinate of the upper left corner of this gadget
	 * 
	 * @return
	 * 			an integer representing the x-coordinate of the gadget's origin
	 */
	public int getX();
	
	/**
	 * Returns the x-coordinate of the upper left corner of this gadget
	 * 
	 * @return
	 * 			an integer representing the y-coordinate of the gadget's origin
	 */
	public int getY();
	
	/**
	 * Returns the unique identifier for the gadget
	 * 
	 * @return
	 * 			a string representing a unique identifier for the gadget
	 */
	public String getID();
	
	/**
     * Returns the width of this gadget in units of L
     * 
     * @return
     * 			an integer representing the width of the gadget
     */
    public int getWidth();
    
    /**
     * Returns the height of this gadget in units of L
     * 
     * @return
     * 			an integer representing the height of the gadget
     */
    public int getHeight();
    
    /**
     * Returns the coefficient of reflection of this gadget
     * 
     * @return
     * 			an double between 0 (exclusive) and 1 (inclusive) representing the
     * 			coefficient of reflection
     */
    public double getReflec();
    

}
