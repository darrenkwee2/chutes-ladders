import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

/**
 * Write a description of class Space here.
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
    
    public Space(int val)
    {
        hasObstacle = false;
        o = null;
        this.val = val;
        
        Rectangle r = new Rectangle(50,50);
        r.setStroke(Color.BLUE);
        r.setFill(null);
        
        t.setText(Integer.toString(val));
        t.setFont(Font.font(50));
        
        setAlignment(Pos.CENTER);
    }
    
    public Space(int val, Obstacle o)
    {
        this.hasObstacle = true;
        this.val = val;
        this.o = o;
        
        Rectangle r = new Rectangle(50,50);
        r.setStroke(Color.BLUE);
        r.setFill(null);
        
        t.setText(Integer.toString(val));
        t.setFont(Font.font(50));
        
        setAlignment(Pos.CENTER);
        getChildren().addAll(r,t);
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
    
    public String toString()
    {
        Integer i = new Integer(val);
        return i.toString();
    }
}