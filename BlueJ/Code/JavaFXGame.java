import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
        //sets text in top left 
        stage.setTitle("Chutes and Ladders: Created by Sushane and Darren ?");//lol emojis dont work maybe try to fix that
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(20);
        grid.setHgap(20);
        
        TextField name1 = new TextField();
        name1.setPromptText("Enter Player 1's Name: ");
        name1.setPrefColumnCount(15);
        name1.getText();
        GridPane.setConstraints(name1,0,0);
        grid.getChildren().add(name1);
        
        TextField name2 = new TextField();
        name2.setPromptText("Enter Player 2's Name: ");
        name2.setPrefColumnCount(15);
        name2.getText();
        GridPane.setConstraints(name2,0,1);
        grid.getChildren().add(name2);
        
        Scene startScene = new Scene(grid, 350,150);
        Stage startScreen = new Stage();
        startScreen.setTitle("Welcome to Chutes and Ladders!");
        
        
        Button startButton = new Button();
        startButton.setText("Play!");
        startButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override 
            public void handle(ActionEvent event) {
                startScreen.close();
                
                p1 = new Player(name1.getText());
                p2 = new Player(name2.getText());
                board = new Board();
                dice = new Dice();
                hasWon = false;
                currentTurn = 1;
                
                GridPane grid2 = new GridPane();
                grid2.setVgap(20);
                grid2.setHgap(20);
                
                //grid2.add(board.getSpace(0,0), 1,1,1,1);
                
                
                
                
                Stage main = new Stage();
                main.setTitle("Chutes and Ladders: " + p1.getName() + " vs. "+ p2.getName());
                
                Scene s = new Scene(grid2, 700,700);
                main.setScene(s);
                main.show(); 
                
                
            }
            
        });
        
        grid.add(startButton,2,0);
        startScreen.setScene(startScene);
        startScreen.show();

    }

    public static void main(String args[])
    {
        launch(args);
    }
    
    }
