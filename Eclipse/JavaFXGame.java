
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
                grid2.setBackground(Background.EMPTY);
                //String style = "-fx-background-color:rgba(255,255,0,1);";
                //grid2.setStyle(style);
                grid2.setVgap(30);
                grid2.setHgap(30);                
                for(int row = 0; row < board.getBoard().length; row++)
                {
                	for(int col = 0; col < board.getBoard()[0].length; col++)
                	{
                		grid2.add(board.getSpace(row,col), col, row);
                	}
                }
                
                ImageView p1Icon = new ImageView();
                p1Icon.setFitWidth(30);
                p1Icon.setFitHeight(30);
                p1Icon.setPreserveRatio(true);
                Image blue = new Image("file:blue.png");
                p1Icon.setImage(blue);
                board.getSpace(0,0).setAlignment(p1Icon, Pos.BOTTOM_RIGHT);
                board.getSpace(0,0).getChildren().add(p1Icon);
                
                StackPane diceView = new StackPane();
                diceView.setBackground(Background.EMPTY);
                Image dice1 = new Image("file:dice1.png");
                Image dice2 = new Image("file:dice2.png");
                Image dice3 = new Image("file:dice3.png");
                Image dice4 = new Image("file:dice4.png");
                Image dice5 = new Image("file:dice5.png");
                Image dice6 = new Image("file:dice6.png");
                ImageView diceDisplay = new ImageView();
                diceDisplay.setFitWidth(100);
                diceDisplay.setFitHeight(100);
                diceDisplay.setPreserveRatio(true);
                
                 diceDisplay.setImage(new Image("file:dicegif.gif"));
                 Button diceButton = new Button();
                 diceButton.setGraphic(diceDisplay);
                 diceButton.setFont(new Font(15));
                 diceButton.setText("Click to Roll Dice");
                 diceButton.setOnAction(new EventHandler<ActionEvent>(){
                	 @Override
 					public void handle(ActionEvent arg0) {
                		 
                      int i = new Dice().rollDice();
                      if(i == 1) 
                      {
                          diceDisplay.setImage(dice1);
                      } 
                      else if(i == 2) 
                      {
                          diceDisplay.setImage(dice2);
                      } 
                      else if(i ==3) 
                      {
                          diceDisplay.setImage(dice3);
                      }
                      else if(i == 4)
                      {
                          diceDisplay.setImage(dice4);
                      }
                      else if(i == 5) 
                      {
                          diceDisplay.setImage(dice5);
                      }
                      else if(i == 6) 
                      {
                          diceDisplay.setImage(dice6);
                      }
                	 }

				
                 });
                
                diceButton.setGraphic(diceDisplay);
                diceView.getChildren().add(diceButton);
                
                BorderPane finalPane = new BorderPane();
                BorderPane.setMargin(grid2, new Insets(30));
                BorderPane.setMargin(diceView, new Insets(50));
                //finalPane.setStyle("-fx-background-color: black;");
                finalPane.setPrefSize(1920,1080);
                finalPane.setCenter(grid2);
                finalPane.setLeft(diceView);
                
                Stage main = new Stage();
                main.setTitle("Chutes and Ladders: " + p1.getName() + " vs. "+ p2.getName());
                
                Scene s = new Scene(finalPane, 1100,720);
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
