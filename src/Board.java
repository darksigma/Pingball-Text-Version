    /*
     * Thread safety strategy:
     *-Synchronize everything!
     *-Make sure each board object only belongs to one board at a time
     *-Make everything immutable that can possibly be immutable
    */

//specs for Board class
public abstract class Board{
    
    /**
     *Returns the width of the board
     *@return integer representing the width of the board
    **/
    public abstract int getXMax();
    
    /**
     *Returns the length of the board
     *@return integer representing the length of the board
    **/
    public abstract int getYMax();
    
    /**
     *adds an item to the board
     *@param item BoardItem to be added to the board
     **/
    public abstract void addToBoard();
    
    /**
     *Updates the board after one timestep
    **/
    public abstract void step();
}