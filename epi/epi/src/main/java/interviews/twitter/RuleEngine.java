package interviews.twitter;

import interviews.twitter.board.Board;
import interviews.twitter.board.Mark;

public class RuleEngine implements Rules {

    public boolean isValidMove(Board board, Move move) {
        if(board == null || move == null) {
            return false;
        }
        return board.isValidMove(move);
    }

    public boolean isGameOver(Board board) {
        return winner(board) != null || board.isFull();
    }

    public Mark winner(Board board) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isDraw(Board board) {
        return board.isFull() && winner(board) == null;
    }
}