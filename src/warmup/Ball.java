package warmup;

import physics.Vect;

public class Ball implements BoardItem {
	private Vect pos; 
	private Vect vel;
	private Board board;
	
	public Ball(Board board, double x, double y, double xVel, double yVel){
		this.pos = new Vect(x, y);
		this.vel = new Vect(xVel, yVel);
		this.board = board;
	}
	
	public int getX(){
		return (int) (pos.x()-board.EPSILON);
	}
	
	public int getY(){
		return (int) (pos.y()-board.EPSILON);
	}
	
	public void step(double timeStep){
		pos = pos.plus(vel.times(timeStep));
		
		if (pos.x() >= board.getXMax()){
			System.out.println("BOUNCE!");

			vel = new Vect(-vel.x(), vel.y());
			pos = new Vect(2*board.getXMax()-pos.x(), pos.y());
		}
		
		if(pos.x() <= 0){
			System.out.println("BOUNCE!");
			vel = new Vect(-vel.x(), vel.y());
			pos = new Vect(-pos.x(), pos.y());
		}
		
		if (pos.y() >= board.getYMax()){
			System.out.println("BOUNCE!");
			vel = new Vect(vel.x(), -vel.y());
			pos = new Vect(pos.x(), 2*board.getYMax()-pos.y());

		}
		
		if(pos.y() <= 0){
			System.out.println("BOUNCE!");
			vel = new Vect(vel.x(), -vel.y());
			pos = new Vect(pos.x(), -pos.y());
		}
		
		System.out.println(getY());
		System.out.println(getX());
	}
	
	public char charRep(){
		return '*';
	}

}

