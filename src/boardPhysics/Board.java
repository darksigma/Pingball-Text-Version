package boardPhysics;

import java.util.ArrayList;

public class Board {
	
	private int xDim;
	private int yDim;
	private ArrayList<Gadget> gadgets;
	private ArrayList<Ball> balls;
	
	public Board(int xDim, int yDim){
		this.xDim = xDim;
		this.yDim = yDim;
		this.gadgets = new ArrayList<Gadget>();
		this.balls = new ArrayList<Ball>();
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
