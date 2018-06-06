
/**
 * Represents a dice, for the purpose of being used to return a random number in a specified range.
 *
 * @author Darren and Sushane
 * @version 6/6
 */
public class Dice
{
    private int min;
    private int max;
    
    /**
     * Default, which creates a dice which generates a value between 1 and 6, to represent a traditional chutes and ladders dice. 
     */
    public Dice()
    {
        min = 1;
        max = 6;
    }
    
    /**
     * Creates a dice with a custom specified range. 
     * @param Two integers, where the first int represents the minimum value and the second represents the maximum value. 
     * 
     */
    public Dice(int min, int max)
    {
        this.min = min;
        this.max = max;
    }
    
    /**
     * Returns a value that is between the dice's range, randomly, to represent rolling the dice irl.
     * @return A random value, which simulates the roll of a dice.
     */
    public int rollDice()
    {
        return (int) (Math.random() * max + min);
    }
}
