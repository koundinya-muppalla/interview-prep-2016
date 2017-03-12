package interviews.twitter;

import java.util.List;

import interviews.twitter.board.Board;
import interviews.twitter.player.Player;

public class Game {

    private final String name;

    private Board board;

    private List<Player> players;

    private int currentPlayerIndex;

    private Rules rules;

    private Stage stage = Stage.NOT_STARTED;

    public Game(String name) {
        this.name = name;
    }

    public enum Stage {
        NOT_STARTED, IN_PROGRESS, PAUSED, STOPPED, COMPLETED
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }
}
