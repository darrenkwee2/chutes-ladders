
/**
 * Represents a player, where the player knows it's location on the board, it's name, number, and whether it has won or not. 
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
    
    /**
     * Creates a player object at the first space and has a player number based on a static variable.
     * 
     * @param A string, which represents the name of the player
     */
    public Player(String name)
    {
        numPlayers++;
        this.loc = 0;
        this.name = name;
        this.hasWon = false;
        this.playerNum = numPlayers;
    }
    
    //accessors
    /**
     * Accesses the number of players in a game.
     * @return An integer which represents the number of players in the game, based on a static variable of the player class. 
     */
    public static int getNumPlayers()
    {
        return numPlayers;
    }
    
    /**
     * Accesses the player number of the player.
     * @return An integer which represents the player number.
     */
    public int getPlayerNum()
    {
        return playerNum; 
    }
    
    /**
     * Accesses whether the player has won or not.
     * @return a boolean which is true if the player has won, false otherwise.
     */
    public boolean getHasWon()
    {
        return hasWon;
    }
    
    /**
     * Accesses the location of the player, corresponding to the value of each space on the board.
     * @return An integer, which represents the value of the space on the board at which the player is located at. 
     */
    public int getLoc()
    {
        return loc;
    }
    
    /**
     * Accesses the name of the player.
     * @return A string, which represents the name of the player. 
     */
    public String getName()
    {
        return name;
    }

    //mutators
    /**
     * Resets the number of players in the game, used in conjunction with the other reset methods.
     * 
     */
    public void resetPlayers()
    {
        numPlayers = 0;
    }
    
    /**
     * Moves the player in a forward direction on the board.
     * @param An integer, which represents the number of spaces to be moved by the player. 
     */
    public void move(int numPlaces)
    {
        loc += numPlaces;
    }
    
    /**
     * Moves the player to a certain location on the board directly. 
     * @param An integer, which represents the value on the board the player is to be moved to. 
     */
    public void setLoc(int val)
    {
        loc = val;
    }
    
}
