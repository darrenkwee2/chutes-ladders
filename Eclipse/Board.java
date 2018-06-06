
/**
 * Represents the playing board which will hold a 2D array of space objects.
 *
 * @author Darren and Sushane
 * @version 6/5
 */
public class Board
{
    private Space[][] board;
    
    /**
     * Default constructor which creates an 8x8 board with various obstacles optimized for a "fair" game, inspired by some boards from google images. 
     */
    public Board()
    {
        board = new Space[8][8];
        int label = 0;
        int counter = 0;
        
        //fills with empty spaces
        for (int a = board.length - 1; a >= 0; a--)
        {
            if (counter % 2 == 0) 
            {
                for (int c = 0; c < board[0].length; c++)
                {
                    board[a][c] = new Space(label);
                    label++;
                }
            } 
            else
            {
                for (int c = board[0].length - 1; c >= 0; c--)
                {
                    board[a][c] = new Space(label);
                    label++;
                }
            }
            counter++;
        }
        
        //ladders
        board[7][4] = new Space(4, new Obstacle(4,55));
        board[6][5] = new Space(10, new Obstacle(10,38));
        board[6][2] = new Space(13, new Obstacle(13, 59));
        board[5][4] = new Space(20, new Obstacle(20, 45));
        board[5][6] = new Space(22, new Obstacle(22, 25));
        
        //chutes
        board[2][5] = new Space(42, new Obstacle(42, 1));
        board[5][0] = new Space(16, new Obstacle(16, 6));
        board[0][1] = new Space(62, new Obstacle(62, 7));
        board[2][0] = new Space(47, new Obstacle(47, 28));
    }
    
    // public Board(int row, int col, int numObstacles)//not complete
    // {
        // board = new Space[row][col];
        // int count = 0;
        // for (int a = board.length - 1; a >= 0; a--)
        // {
            // for (int b = board[0].length - 1; b >= 0; b--) 
            // {
                // board[a][b] = new Space(count);
                // count++;
            // }
        // }
    // }
    
    /**
     * Accesses a certain location on the board. 
     * @param Two integers which represent the row and column at which the desired space is located at.
     * @return A reference to the space object which is at the location specified. 
     */
    public Space getSpace(int loc1, int loc2)
    {
        return board[loc1][loc2];
    }
    
    /**
     * Accesses a certain value on the board by returning an array by sequential search. 
     * @param An integer, which represents the value that is being searched for 
     * @return A 1D array, where the first index represents the row and the second index represents the columns. 
     */
    public int[] findLoc(int val)
    {
    	for (int a = 0; a < board.length; a++) {
    		for(int b = 0; b < board[0].length; b++) {
    			if (board[a][b].getVal() == val)
    				return new int[]{a,b};
    		}
    	}
    	return new int[]{0,0};
    }
    
    /**
     * Accesses the board, represented by a 2D array. 
     * @return A reference to the board. 
     */
    public Space[][] getBoard()
    {
    	return board;
    }
    
    // public int getNumSpaces()
    // {
        // return board.length * board[0].length;
    // }
    
    /**
     * Prints out the board, as it will appear in game, similar to the matrix view of a 2D array.
     * Used for testing purposes. 
     */
    public void printBoard()
    {
    	for(Space[] s : board)
    	{
    		for (Space s1 : s)
    		{
    			System.out.print(s1.getVal() + " ");
    		}
    		System.out.println();
    	}
    }
    
    /**
     * Checks if a certain space's value contians an obstacle.
     * @param An integer which represents the value.
     * @return An integer which represents the obstacle's end value.
     */
    public int findObstacle(int value)//can change to a better searching, maybe mergesort
    {
        for(int a = 0; a < board.length; a++)
        {
            for(int b = 0; b < board[0].length; b++)
            {
                if (board[a][b].getVal() == value)
                {
                    if (board[a][b].hasObstacle() == true)
                    {
                        return board[a][b].getObstacle().getEndVal();
                    }
                }
            } 
        }
        
        return 0;//placeholder, only works if 0 is not an obstacle
    }
 
    }

