import java.util.ArrayList; 
public class Board {
    //evaluates the value of the current board position
    public int evaluate(int[][] board){
        return 100;
    }
    //finds all possible moves
    //for efficiency moves are stored as int arrays
    //ex: B7-B8 = [1,1,1,0]
    public static ArrayList<int[]> moves(int[][] board, int color){
        ArrayList<int[]> moves = new ArrayList<int[]>();

        //choose which direction to go based on color
        int direction = (color==2) ? 1 : -1;
        //choose color of enemy
        int enemy = (color==2) ? 4 : 2;

        for(int col = 0; col<board.length; col++){
            for(int row = 0; row<board[0].length; row++){
                //check if the current position has a piece of player color
                if(board[col][row]==color){
                    //check if space in front is empty
                    if(board[col][row+direction]==0){
                        moves.add(new int[] {col,row,col,row+direction});
                    }
                    //check if space to front left is empty or an enemy
                    if(col!=0 && (board[col-1][row+direction]==0 || board[col-1][row+direction]==enemy)){
                        moves.add(new int[] {col,row,col-1,row+direction});
                    }
                    //check if space to front right is empty or an enemy
                    if(col !=7 && (board[col+1][row+direction]==0 || board[col+1][row+direction]==enemy)){
                        moves.add(new int[] {col,row,col+1,row+direction});
                    }
                }
            }
        }
        return moves;
    }

    public static String moveToString(int[] move){
        String text = "";
        text = text + colIntToChar(move[0]);
        text = text + rowIntToChar(move[1]);
        text = text + colIntToChar(move[2]);
        text = text + rowIntToChar(move[3]);
        return text;
    }


    private static char colIntToChar(int col){
        switch(col){
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            case 5:
                return 'F';
            case 6:
                return 'G';
            default:
                return 'H';
        }
    }

    private static char rowIntToChar(int row){
        return Character.forDigit(8-row,10);
    }
}
