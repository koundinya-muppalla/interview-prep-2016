package interviews.twitter.player.computer;

import java.util.List;

import interviews.twitter.Move;
import interviews.twitter.board.Board;
import interviews.twitter.board.Cell;
import interviews.twitter.board.Mark;

public class EasyAiPlayer extends ComputerPlayer {

    public EasyAiPlayer(String id, Mark mark) {
        super(id, mark);
    }

    public Move nextMove(Board board) {
        List<Cell> unOccupied = board.getUnOccupiedCells();
        if(unOccupied.isEmpty()) {
            return null;
            // Should throw exception?
        }
        return new Move(board.getPos(unOccupied.get(0)));
    }
}