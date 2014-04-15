package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import boardPhysics.Ball;

public class BallTest {
	
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
	
}
