
/**
 * Write a description of class Player here.
 *
 * @author Darren and Sushane
 * @version 6/6
 */
public class Player
{
    private String name;
    private int loc;
    private static int numPlayers = 0;
    private boolean hasWon;
    private int playerNum;
    
    public Player(String name)
    {
        numPlayers++;
        this.loc = 0;
        this.name = name;
        this.hasWon = false;
        this.playerNum = numPlayers;
    }
    
    //accessors
    public static int getNumPlayers()
    {
        return numPlayers;
    }
    
    public int getPlayerNum()
    {
        return playerNum; 
    }
    
    public boolean getHasWon()
    {
        return hasWon;
    }
    
    public int getLoc()
    {
        return loc;
    }
    
    public String getName()
    {
        return name;
    }

    //mutators
    public void move(int numPlaces)
    {
        loc += numPlaces;
    }
        
    public void win()
    {
        hasWon = true;
    }
    
    public void setLoc(int val)
    {
        loc = val;
    }
    
}
