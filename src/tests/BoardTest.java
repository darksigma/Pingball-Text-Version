package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

import boardPhysics.*;

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
	
}
