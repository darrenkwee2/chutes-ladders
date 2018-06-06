
/**
 * Represents an obstacle on the playing board, where the Space class contains a has-a relationship with this class.
 * An obstacle knows it's start value and end value, where the start value represents the space at which it is located at, and the end value represents the result value of the space which the player will land on if they land on this space. 
 * 
 * @author Darren and Sushane
 * @version 6/6
 */
public class Obstacle
{
    private int startVal;
    private int endVal;
    
    /**
     * Used to create an obstacle that has a specified start and end value.
     * @param Two integers, where the first one represents the start value, and the second represents the end value. 
     */
    public Obstacle(int startVal, int endVal)
    {
        this.startVal = startVal;
        this.endVal = endVal;
    }
    
    /**
     * Accesses this obstacle's end value, for the purpose of determining the player's next location if they land on this space. 
     * @return An integer which represents the obstacle's end value. 
     */
    public int getEndVal()
    {
        return endVal; 
    }
}
