package boardPhysics;

import java.util.ArrayList;

public class Board {
	
	private int xMax;
	private int yMax;
	private ArrayList<Gadget> gadgets;
	private ArrayList<Ball> balls;
	
	public Board(int xMax, int yMax){
		this.xMax = xMax;
		this.yMax = yMax;
		this.gadgets = new ArrayList<Gadget>();
		this.balls = new ArrayList<Ball>();
	}
	
	public void addGadgetToBoard(Gadget gadget){
	}
	
	public void addBallToBoard(Ball ball){
	}
	
	public int getXMax(){
	}
	
	public int getYMax(){
	}
	
	public void step(double timeStep){
	}
	
	public String toString(){
	}
}
