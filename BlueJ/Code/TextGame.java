
/**
 * Write a description of class TextGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextGame
{
    public static void main(String args[]) 
    {
        Board board = new Board();
        Dice dice = new Dice();
        Player p1 = new Player("Darren");
        Player p2 = new Player("Sushane");
        boolean hasWon = false;
        int currentTurn = 1;
        //set up board
        
        while (hasWon == false)//can change to static for multiple players
        {
            currentTurn = 1;
            p1.move(dice.rollDice());
            
            if (board.findObstacle(p1.getLoc()) != 0)
            {
                p1.setLoc(board.findObstacle(p1.getLoc()));
            }
            
            if (p1.getLoc() >= 63)
            {
                p1.win();
                System.out.println(p1.getName() + " Wins!");
                hasWon = true;
            }
            
            
            currentTurn = 2;
            p2.move(dice.rollDice());
            
            if (board.findObstacle(p2.getLoc()) != 0)
            {
                p2.setLoc(board.findObstacle(p2.getLoc()));
            }
            
            if (p2.getLoc() >= 63)
            {
                if (hasWon == false) 
                {
                    p2.win();
                    System.out.println(p2.getName() + " Wins!");
                    hasWon = true;
                }
            }

        }
    }
}
