package tictactoe;
import java.io.*; 

public class TicTacToe extends Game{
    private int nextPlayer ; // 1= X , 2= O
    private static BufferedReader stdin ; // to read from console

    // remember : class Game has attribute " board "
    //X is player 1
    //O is player 2

    // constructor
    public TicTacToe () {
        nextPlayer =1; // X starts
    }

    // overriding abstract methods starts now
    @Override
    public void makeMove (Board b) {
        System.out.println( " Player " + nextPlayer + " , " +
        " make your move (0 -8)  : " );

        Boolean success = false ;
            do {
                try {
                    // read a line from console
                    String line = stdin.readLine();
                    // convert to integer
                    int index = Integer.parseInt(line);
                    
                    if (index <9 && index >=0 && b.getField(index) == 0 ) {
                        // found legal empty field
                        System.out.println ( " conditions met " );
                        b. setField (index , nextPlayer ); // set piece
                        b. printBoard (); // output to console
                        success = true ;
                        nextPlayer = 3 - nextPlayer ; // nice trick ; -)
                    }
                    else {
                        System.out.println ( " make a legal move (0-8) " );
                    }
                }
                // read might throw an exception
                catch (NumberFormatException ex) {
                    System.out.println("Input must be a valid integer.");
                }
                catch (Exception ex) { 
                    System.out.println ( " Wrong input " );
                }

        } while (! success );
    }

   @Override
    public Board startGame() {
        return getBoard();
    }
    //check conditions for winning
    @Override
    public Boolean isFinished(Board b) {
        for(int n = 1;n<= 2;n++){
            //horizontal 
            if((b.getField(0)  == n) && (b.getField(1)  == n) && (b.getField(2)  == n))
                return true;

            else if((b.getField(3)  == n) && (b.getField(4)  == n) && (b.getField(5)  == n))
                return true;

            else if((b.getField(6)  == n) && (b.getField(7)  == n) && (b.getField(8)  == n))
                return true;

            //vertical
            else if((b.getField(0)  == n) && (b.getField(3)  == n) && (b.getField(6)  == n))
                return true;

            else if((b.getField(1)  == n) && (b.getField(4)  == n) && (b.getField(7)  == n))
                return true;

            else if((b.getField(2)  == n) && (b.getField(5)  == n) && (b.getField(8)  == n))
                return true;

            //diagonal
            else if((b.getField(0)  == n) && (b.getField(4)  == n) && (b.getField(8)  == n))
                return true;

            else if((b.getField(2)  == n) && (b.getField(4)  == n) && (b.getField(6)  == n))
                return true;
        }
        if (b.checkTie() == true)
            return true;
        else 
            return false;
    }

    @Override
    public void declareResult(Board b) {
        System .out . println ("The Winner is...");
        if(b.checkTie()== true)
            System.out.println("it's a tie! Nobody won!"); 
        else if(this.nextPlayer == 2)
            System.out.println("Player 1,'X'!");
        else if(this.nextPlayer == 1)
            System.out.println("Player 2, 'O'!");

    }
    // overriding abstract methods ends here
    
    public static void main ( String [] args ) {
        // creating a buffer to read from console
        stdin = new BufferedReader(new InputStreamReader(System.in));
        TicTacToe ttt = new TicTacToe();
        ttt.play();
    }
}
