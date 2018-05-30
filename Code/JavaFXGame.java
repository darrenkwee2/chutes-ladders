import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Write a description of JavaFX class JavaFXGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JavaFXGame extends Application
{
    private Board board;
    private Dice dice;
    private Player p1;
    private Player p2;
    private boolean hasWon;
    private int currentTurn;

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Chutes and Ladders: Created by Sushane and Darren ?");//lol emojis dont work maybe try to fix that
        //sets text in top left 
        
        board = new Board();
        dice = new Dice();
        
        //add a "popup" for text input, also need to account for number of players
        p1 = new Player("Darren");//can add text fields later, https://docs.oracle.com/javafx/2/ui_controls/text-field.htm
        p2 = new Player("Sushane");
        
        GridPane gp = new GridPane();
        gp.setVgap(10.0);
        gp.setHgap(10.0);
        
        //add board
        
        Scene s = new Scene(gp, 700,700);
        stage.setScene(s);
        stage.show();
        
        
    }

    public static void main(String args[])
    {
        launch(args);
    }
    
    }
