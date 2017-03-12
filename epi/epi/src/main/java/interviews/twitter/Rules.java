package interviews.twitter;

import interviews.twitter.board.Board;
import interviews.twitter.board.Mark;

public interface Rules {

    boolean isValidMove(Board board, Move move);
    
    boolean isGameOver(Board board);
    
    Mark winner(Board board);
    
    boolean isDraw(Board board);
}
