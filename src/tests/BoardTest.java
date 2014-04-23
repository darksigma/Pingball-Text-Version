package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

import physics.Vect;
import boardPhysics.*;

	/**
	 * TESTING STRATEGY:
	 * For each gadget [Circular bumper, square bumper, triangular bumper [4 orientations],
	 * flipper [2 options for right/left, 2 for initial position], outer wall[4 positions]], 
	 * we will test all of the functions found in the Gadget interface and the boardObject
	 * interface:
	 * 
	 * 	1) Connect
	 * 	2) Disconnect
	 * 	3) getX()
	 * 	4) getY()
	 * 	5) getID()
	 * 	6) getWidth()
	 * 	7) getHeight()
	 * 	8) getReflec()
	 * 	9) action()
	 * 	10) trigger()
	 * 	11) progress()
	 * 	12) impactCalc()
	 * 
	 * As well as some of the class-specific functions [TODO: further instructions]
	 * 
	 * Moreover, we will be testing ball and the following functions:
	 * 
	 * 	1) getX()
	 * 	2) getY()
	 * 	3) getMass()
	 * 	4) getPos()
	 * 	5) getVel()
	 * 	6) getInAbsorber()
	 * 	7) setPos()
	 * 	8) setVel()
	 * 	9) setInAbsorber()
	 * 	10) toCircle()
	 * 	11) getID()
	 * 	12) progress()
	 * 	13) impactCalc()
	 * 
	 * Afterwards, we will ensure that the display is working properly by looking 
	 * at the following simulations:
	 * 
	 *  1) Ball in an empty board
	 *  2) Ball in a board with
	 *  		- square bumper
	 *  		- triangular bumper
	 *  		- circular bumper
	 *  		- absorber
	 *  		- flipper
	 *  3) Test the triggers of:
	 *  		- absorber (self-triggered)
	 *  		- absorber (other-triggered)
	 *  		- flipper (other-triggered)
	 *  4) Multiple balls on a board
	 *  5) Multiple item board with one ball
	 *  6) Multiple item board with multiple balls
	 * 
	 * @author Nikhil, Dana
	 *
	 */

public class BoardTest {
	
	/**
	 * Test getID() when the ID is a non-empty string
	 */
	@Test public void testIDNonEmptyString(){
    	Ball test = new Ball("Hello", 1, 3, 0.5, 3, 0.5, 1);
    	
    	assertEquals("Hello", test.getID());
    }
	
	/**
	 * Test getID() when the ID is an empty string
	 */
	@Test public void testIDEmptyString(){
		Ball test = new Ball("", 1, 3, 0.5, 3, 0.5, 1);
    	
    	assertEquals("", test.getID());
	}
	
	/**
	 * Test getX() to make sure it returns the right value
	 */
	@Test public void testGetX(){
		Ball test = new Ball("Hello", 1, 3, 0.5, 3, 0.5, 1);
    	
    	assertTrue(1==test.getX());
	}
	
	/**
	 * Test getY() to make sure it returns the right value
	 */
	@Test public void testGetY(){
		Ball test = new Ball("Hello", 1, 3, 0.5, 3, 0.5, 1);
    	
    	assertTrue(3==test.getY());
	}
	
	/**
	 * Create an empty board
	 */
	@Test public void createEmptyBoard(){
		Board board = Board.newBoard(20,20);
		System.out.println(board.toString());
	}
	
	/**
	 * Simulate a board with only a single ball
	 */
	@Test public void createSingleBallBoard(){
		final Board board = Board.newBoard(20,20);
		Ball ball1 = new Ball("ball1", 1, 3, 1, 3, 0.5, 1);
		board.addBallToBoard(ball1);
		
//		System.out.println(board.toString());
//		System.out.println(ball1.getX() + " " + ball1.getY());
//		board.step(1);
//		System.out.println(board.toString());
//		System.out.println(ball1.getX() + " " + ball1.getY());
		
		Timer t = new Timer();
    	TimerTask task= new TimerTask(){
    		public void run(){
    	    	board.step(0.1);
    			System.out.println(board.toString());
    		}
    	};
    	
    	t.scheduleAtFixedRate(task, 0, 100);
		
	}
	
	/**
	 * Visual Test with all the knicknacks: to be split up
	 * for individual testing
	 */
	
	@Test public void visualTest(){
		final Board board = Board.newBoard(20,20);
		final Ball ball1 = new Ball("ball1", 5, 1, 0, 30, 0.5, 1);
		final Ball ball2 = new Ball("ball2", 4, 15, 10, -10, 0.5, 1);
		final Ball ball3 = new Ball("ball3", 7, 18, 50, -100, 0.5, 1);
		final SquareBumper s1 = new SquareBumper("s1", 5, 7);
		final CircularBumper c1 = new CircularBumper("s1", 2, 3);
		final CircularBumper c2 = new CircularBumper("s1", 17, 2);
		final TriangularBumper t1 = new TriangularBumper("t1", 3, 10, 270);
		final TriangularBumper t2 = new TriangularBumper("t2", 19, 0, 270);
		board.addBallToBoard(ball1);
		board.addBallToBoard(ball2);
		board.addBallToBoard(ball3);
		board.addGadgetToBoard(s1);
		board.addGadgetToBoard(t1);
		board.addGadgetToBoard(t2);
		board.addGadgetToBoard(c1);
		board.addGadgetToBoard(c2);
		
		final Absorber ab = new Absorber("ab", 0, 19, 19, 1, new Vect(0, -50));
		ab.connect(ab);
		s1.connect(ab);
		board.addGadgetToBoard(ab);
		
		final Flipper f1 = new Flipper("f1", 10, 8, true, 0);
		board.addGadgetToBoard(f1);
		s1.connect(f1);
		
		System.out.println(board.toString());
		
		Timer t = new Timer();
    	TimerTask task= new TimerTask(){
    		public void run(){
    	    	board.step(0.05);
    			System.out.println(board.toString());
    		}
    	};
    	
    	t.scheduleAtFixedRate(task, 0, 50);
	}
}
