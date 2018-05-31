
/**
 * Write a description of class Dice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dice
{
    private int min;
    private int max;
    
    public Dice()
    {
        min = 1;
        max = 6;
    }
    
    public Dice(int min, int max)
    {
        this.min = min;
        this.max = max;
    }
    
    public int rollDice()
    {
        return (int) (Math.random() * max + min);
    }
}
