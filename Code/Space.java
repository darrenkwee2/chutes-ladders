
/**
 * Write a description of class Space here.
 *
 * @author Darren and Sushane
 * @version 5/24
 */
public class Space
{
    private boolean hasObstacle;
    private Obstacle o;
    private int val;
    
    public Space(int val)
    {
        hasObstacle = false;
        o = null;
        this.val = val;
    }
    
    public Space(int val, Obstacle o)
    {
        this.hasObstacle = true;
        this.val = val;
        this.o = o;
    }
    
    
    public int getVal()
    {
        return val;
    }
    
    public boolean hasObstacle()
    {
        return hasObstacle;
    }
    
    public Obstacle getObstacle()
    {
        return o;
    }
    
}