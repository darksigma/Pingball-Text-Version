package boardPhysics;

import physics.Vect;

public class Ball {
	private Vect pos; 
	private Vect vel;
	private Board board;
	
	public Ball(Board board, double x, double y, double xVel, double yVel){
		this.pos = new Vect(x, y);
		this.vel = new Vect(xVel, yVel);
		this.board = board;
	}
	
	public int getX(){
	}
	
	public int getY(){
	}
	
	public void step(double timeStep){
	}
}

