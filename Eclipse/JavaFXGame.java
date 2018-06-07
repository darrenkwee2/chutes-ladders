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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;;
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
    private static Board board;
    private static Dice dice;
    private static Player p1;
    private static Player p2;
    private static boolean p1HasWon;
    private static int currentTurn;
    private static Stage main = new Stage();
    private static ImageView diceDisplay = new ImageView();
    private static Image dice1 = new Image("file:dice1.png");
    private static Image dice2 = new Image("file:dice2.png");
    private static Image dice3 = new Image("file:dice3.png");
    private static Image dice4 = new Image("file:dice4.png");
    private static Image dice5 = new Image("file:dice5.png");
    private static Image dice6 = new Image("file:dice6.png");
    private static ImageView p1Icon = new ImageView();
    private static ImageView p2Icon = new ImageView();
    private static ImageView snake = new ImageView();
    private static ImageView ladder = new ImageView();
    private static StackPane diceView = new StackPane();

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
        
        Scene startScene = new Scene(grid, 350,100);
        Stage startScreen = new Stage();
        startScreen.setTitle("Welcome to Chutes and Ladders!");
         
        
        Button startButton = new Button();
        startButton.setText("Play!");
        startButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override 
            public void handle(ActionEvent event) {
                startScreen.close();

                p1 = new Player(name1.getText());//Initializes some fields
                p2 = new Player(name2.getText());
                board = new Board();
                dice = new Dice();
                p1HasWon = false;
                currentTurn = 1;
                
                GridPane grid2 = new GridPane();//creates board, change this to a method to apply to multiple board sizes
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
                
                
                //creates snake image
                
                Image snakeImage = new Image("file:snake.png");
                Image ladderImage = new Image("file:ladder.png");
                ladder.setImage(ladderImage);
                snake.setImage(snakeImage);
                
                //creates player pieces
                //ImageView p1Icon = new ImageView(); changed to field
                p1Icon.setFitWidth(30);
                p1Icon.setFitHeight(30);
                p1Icon.setPreserveRatio(true);
                Image blue = new Image("file:blue.png");
                p1Icon.setImage(blue); 
                
                //ImageView p2Icon = new ImageView(); changed to field
                p2Icon.setFitWidth(30);
                p2Icon.setFitHeight(30);
                p2Icon.setPreserveRatio(true);
                Image red = new Image("file:red.png");
                p2Icon.setImage(red);
                         
                //creates dice pane
                //StackPane diceView = new StackPane();
                diceView.setBackground(Background.EMPTY);
                diceDisplay.setFitWidth(100);
                diceDisplay.setFitHeight(100);
                diceDisplay.setPreserveRatio(true);
                diceDisplay.setImage(new Image("file:dicegif.gif"));
                
                //creates dice button
                Button diceButton = new Button();
                diceButton.setGraphic(diceDisplay);
                diceButton.setFont(new Font(15));
                diceButton.setText("Click to Roll Dice");
                diceButton.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent arg0) {
                        play();                    
                }
                });
                 
               
                diceButton.setGraphic(diceDisplay);//adds dice image and dice button
                diceView.getChildren().add(diceButton);
                
                BorderPane finalPane = new BorderPane();//final game pane
                BorderPane.setMargin(grid2, new Insets(30));
                BorderPane.setMargin(diceView, new Insets(50));
                //finalPane.setStyle("-fx-background-color: black;");
                finalPane.setPrefSize(1920,1080);
                finalPane.setCenter(grid2);
                finalPane.setLeft(diceView);
                
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
    
    
    public static void play()
    {
    	int i = new Dice().rollDice();//dice rolling
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
        
        
        if (currentTurn == 1) {
        board.getSpace(board.findLoc(p1.getLoc())[0], board.findLoc(p1.getLoc())[1]).getChildren().remove(p1Icon);//removes previous icon from previous space
        p1.move(i);//changes icon space and player location
        if (board.findObstacle(p1.getLoc()) != 0)//checks for obstacle
        {
            p1.setLoc(board.findObstacle(p1.getLoc()));
        }
        
        if (p1.getLoc() >= 63)//checks for winning
        {
            p1.win();
            System.out.println(p1.getName() + " Wins!");
            p1HasWon = true;
            win();
        }
        board.getSpace(board.findLoc(p1.getLoc())[0], board.findLoc(p1.getLoc())[1]).getChildren().add(p1Icon);//add icons
        board.getSpace(board.findLoc(p1.getLoc())[0], board.findLoc(p1.getLoc())[1]).setAlignment(p1Icon, Pos.BOTTOM_RIGHT);//changes to bottom right   
        changeTurn();
       }
        else {
        
        if (currentTurn == 2 ) { //same as player 1, but for player 2- might want to change to one variable to support multiple players
      	  p2.move(i);
            
            if (board.findObstacle(p2.getLoc()) != 0)
            {
                p2.setLoc(board.findObstacle(p2.getLoc()));
            }
            
            if (p2.getLoc() >= 63)
            {
                if (p1HasWon == false) 
                {
                    p2.win();
                    System.out.println(p2.getName() + " Wins!");
                    win();
                }
            }
            board.getSpace(board.findLoc(p2.getLoc())[0], board.findLoc(p2.getLoc())[1]).getChildren().add(p2Icon);
            board.getSpace(board.findLoc(p2.getLoc())[0], board.findLoc(p2.getLoc())[1]).setAlignment(p2Icon, Pos.BOTTOM_RIGHT);
            changeTurn();
        }
  	 }
    }
    
    public static void changeTurn()
    {
        //adds player's turn on dice pane
        Text p1Name = new Text(p1.getName());
        Text p2Name = new Text(p2.getName());
        if (currentTurn == 1)
        {
            currentTurn = 2;
            diceView.getChildren().add(p2Name);
        }
        else 
        {
            currentTurn = 1;
            diceView.getChildren().add(p1Name);
        }
    }
    
    
    public static void win()
    {
    	Stage winStage = new Stage();
    	VBox winBox = new VBox();
    	
    	if(p1HasWon) {
    		winStage.setTitle("Congrats " + p1.getName() + " has won!");
    		Text t = new Text();
    		t.setText(p1.getName() + "wins yay");
    		t.setFont(new Font(175));
    		winBox.getChildren().add(t);
    		winBox.setAlignment(Pos.CENTER);
    	}
    	else 
    	{
    		winStage.setTitle("Congrats " + p2.getName() + " has won!");
    		Text t1 = new Text();
    		t1.setText(p2.getName() + " wins yay");
    		t1.setFont(new Font(175));
    		//add animated color with set fill
    		winBox.getChildren().add(t1);
    		winBox.setAlignment(Pos.CENTER);
    	}
    	
    	Scene winScene = new Scene(winBox, 1100, 720);
    	winStage.setScene(winScene);
        winStage.show();
        main.close();
    }

    
    public static void main(String args[])
    {
        launch(args);
    }
    
    }
