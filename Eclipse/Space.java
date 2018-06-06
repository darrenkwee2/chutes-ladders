import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 * Represents a space on the board, which knows whether it is the starting location of an "obstacle" and it's value. 
 * It is a subclass of StackPane and contains a rectangle for the purpose of it being able to by visually represented in JavaFX's GridPane, which we use for the board. 
 *
 * @author Darren and Sushane
 * @version 5/24
 */
public class Space extends StackPane
{
    private boolean hasObstacle;
    private Obstacle o;
    private int val;
    Text t = new Text();
    Rectangle r = new Rectangle(55,55);
    
    /**
     * Constructor that creates a space object with a given value.
     * @param An integer which will represent the value of the space, where the values are used to label them on the board. 
     * 
     */
    public Space(int val)
    {
        hasObstacle = false;
        o = null;
        this.val = val;
        
        r.setStroke(Color.BLUE);
        r.setFill(null);
        
        t.setText(Integer.toString(val));
        t.setFont(Font.font(17));
        t.setFill(Color.BLACK);
        
        setAlignment(Pos.TOP_LEFT);
        getChildren().addAll(r,t);
    }
    
    /**
     * A second constructor which creates a space object with an obstacle. 
     * @param An integer, which represents the value of the space.
     * @param An obstacle object, which represents if a space holds an obstacle.
     */
    public Space(int val, Obstacle o)
    {
        this.hasObstacle = true;
        this.val = val;
        this.o = o;
        
        r.setStroke(Color.BLUE);
        r.setFill(null);
        
        t.setText(Integer.toString(val));
        t.setFont(Font.font(17));
        t.setFill(Color.BLACK);
        
        setAlignment(Pos.TOP_LEFT);
        getChildren().addAll(r,t);
    }
    
    /**
     * Returns the value of the space. 
     * @return An integer, which represents the value of the space. 
     */
    public int getVal()
    {
        return val;
    }
     
    
    /**
     * Returns if the space has an obstacle.
     * @return A boolean variable, where true represents an obstacle.
     */
    public boolean hasObstacle()
    {
        return hasObstacle;
    }
    
    /**
     * Returns a reference to the obstacle object. 
     * @return An obstacle object, which represents the obstacle that is located on the space. 
     */
    public Obstacle getObstacle()
    {
        return o;
    }
    
    /**
     * Returns a string representation of a space object, which is it's value. 
     */
    public String toString()
    {
        Integer i = new Integer(val);
        return i.toString();
    }
    
    
}