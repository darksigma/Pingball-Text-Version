package warmup;

/**
 * TODO: put documentation for your class here
 */
public class Main {
    
    /**
     * TODO: describe your main function's command line arguments here
     */
    public static void main(String[] args) {
        
    	Board testBoard = new Board(20, 20);
    	Ball testBall = new Ball(testBoard, 0, 6, 1, 2);
    	
    	testBoard.addToBoard(testBall);
    	
    	System.out.println(testBoard.toString());
    	int counter = 35;
    	while (counter > 0){
	    	testBoard.step(1);
	    	System.out.println(testBoard.toString());
	    	counter--;
    	}
    	
    }
    
}