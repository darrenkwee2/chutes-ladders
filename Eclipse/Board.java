
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    private Space[][] board;
    
    public Board()//default constructor
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
    
    public Board(int row, int col, int numObstacles)//not complete, use math random for obstacles
    {
        board = new Space[row][col];
        int count = 0;
        for (int a = board.length - 1; a >= 0; a--)
        {
            for (int b = board[0].length - 1; b >= 0; b--) 
            {
                board[a][b] = new Space(count);
                count++;
            }
        }
    }
    
    public Space getSpace(int val1, int val2)
    {
        return board[val1][val2];
    }

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
    
    public Space[][] getBoard()
    {
    	return board;
    }
    
    public int getNumSpaces()
    {
        return board.length * board[0].length;
    }
    
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

