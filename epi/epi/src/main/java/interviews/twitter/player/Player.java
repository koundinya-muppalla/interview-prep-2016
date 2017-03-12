package interviews.twitter.player;

import interviews.twitter.Move;
import interviews.twitter.board.Board;
import interviews.twitter.board.Mark;

public interface Player {
    Move nextMove(Board board);
    Mark getMark();
}
