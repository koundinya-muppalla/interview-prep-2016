package interviews.twitter.player.computer;

import interviews.twitter.board.Mark;
import interviews.twitter.player.Player;

public abstract class ComputerPlayer implements Player {

    protected final Mark mark;
    
    protected final String id;

    protected ComputerPlayer(String id, Mark mark) {
        this.id = id;
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }
}
