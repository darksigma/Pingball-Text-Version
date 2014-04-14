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
	
	private Board(int xDim, int yDim){
		this.xDim = xDim;
		this.yDim = yDim;
		this.gadgets = new ArrayList<Gadget>();
		this.balls = new ArrayList<Ball>();
	}
	
	public Board newBoard(int xDim, int yDim, boolean[] wallsReflec){
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
	 * advances the whole board one step forward
	 */
	public void step(){
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
