/*
 * Thread safety strategy:
 *-Synchronize everything!
 *-Make sure each board object only belongs to one board at a time
 *-Make everything immutable that can possibly be immutable
*/
//specs for Board class

getXMax()
/**
 *Returns the width of the board
 *@return integer representing the width of the board
**/

getYMax()
/**
 *Returns the length of the board
 *@return integer representing the length of the board
**/

addToBoard()
/**
 *adds an item to the board
 *@param item BoardItem to be added to the board
 **/

step()
/**
 *Updates the board after one timestep
**/