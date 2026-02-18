public class Board {
    //evaluates the value of the current board position
    public int evaluate(int[][] board){
        return 100;
    }
    //finds all possible moves
    //for efficiency moves are stored as char arrays
    //ex: B7-B8 = [B,7,B,8]
    public char[][] moves(int[][] board, Space color){
        return new char[16][4];
    }
}
