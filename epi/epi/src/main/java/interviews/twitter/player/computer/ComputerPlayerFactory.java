package interviews.twitter.player.computer;

import interviews.twitter.board.Mark;

public class ComputerPlayerFactory {

    public ComputerPlayer getPlayer(ComputerPlayerDifficulty difficulty, String id, Mark mark) {
        switch(difficulty) {
            case EASY:
                return new EasyAiPlayer(id, mark);
            case MEDIUM:
                return new MediumAiPlayer(id, mark);
            case HARD:
                return new HardAiPlayer(id, mark);
            default:
                return new EasyAiPlayer(id, mark);
        }
    }

    public enum ComputerPlayerDifficulty {
        EASY, MEDIUM, HARD
    }
}
