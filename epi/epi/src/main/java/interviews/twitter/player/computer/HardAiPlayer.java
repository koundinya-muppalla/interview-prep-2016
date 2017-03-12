package interviews.twitter.player.computer;

import interviews.twitter.Move;
import interviews.twitter.board.Board;
import interviews.twitter.board.Mark;

public class HardAiPlayer extends ComputerPlayer {

    public HardAiPlayer(String id,
                                Mark mark) {
        super(id, mark);
    }

    public Move nextMove(Board board) {
        return null;
    }
}
