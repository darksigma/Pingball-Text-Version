/*
 * Thread safety strategy:
 *-Synchronize everything!
 *-Make sure each board object only belongs to one board at a time
 *-Make everything immutable that can possibly be immutable
*/

//specs for boardItem interface

getX()
/**
 *Returns the x-coordinate of the center of the item
 *@return integer representing the x-coordinate
**/

getY()
/**
 *Returns the y-coordinate of the center of the item
 *@return integer representing the y-coordinate
**/

step()
/**
 *Allows the item to move about the board. If the item encounters the wall of the board,
 *the item is reflected appropriately. If the item does not move, step returns the item's current
 *position
 *@param timeStep a double representing the time increment by which the velocity changes; cannot be null
**/

charRep()
/**
 *return a character representation of the board item for printing
 *@return a character representation of the board item
**/
