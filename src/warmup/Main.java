package warmup;

import java.util.Timer;
import java.util.TimerTask;

/**
 * TODO: put documentation for your class here
 */
public class Main {
    
    /**
     * TODO: describe your main function's command line arguments here
     */
    public static void main(String[] args) {
        
    	final Board testBoard = new Board(20, 20);
    	Ball testBall = new Ball(testBoard, 0, 6, 10, 20);
    	
    	testBoard.addToBoard(testBall);
    	
    	Timer t = new Timer();
    	TimerTask task= new TimerTask(){
    		public void run(){
    	    	testBoard.step(0.1);
    			System.out.println(testBoard.toString());
    		}
    	};
    	
    	t.scheduleAtFixedRate(task, 0, 100);
    	
//    	System.out.println(testBoard.toString());
//    	int counter = 35;
//    	while (counter > 0){
//	    	testBoard.step(0.1);
//	    	System.out.println(testBoard.toString());
//	    	counter--;
//    	}
    	
    }
    
}