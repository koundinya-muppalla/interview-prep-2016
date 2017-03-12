package interviews.twitter;

import interviews.twitter.Game.Stage;
import interviews.twitter.board.Board;
import interviews.twitter.board.Cell;
import interviews.twitter.io.InputReader;
import interviews.twitter.io.OutputWriter;
import interviews.twitter.player.Player;

public class TicTacToeGamePlay implements GamePlay {

    private final InputReader input;

    private final OutputWriter output;
    
    private final Game game;

    public TicTacToeGamePlay(InputReader input, OutputWriter output, Game game) {
        this.input = input;
        this.output = output;
        this.game = game;
    }

    public void play() {
        while(!game.getStage().equals(Stage.PAUSED) || !game.getStage().equals(Stage.STOPPED)) {
            switch (game.getStage()) {
                case NOT_STARTED:
                    new TTTGameInitializer(input, output).initialize(game);
                    game.setStage(Stage.IN_PROGRESS);
                    break;
                case IN_PROGRESS:
                    handleInProgress();
                    break;
                case COMPLETED:
                    handleCompleted();
                    break;
                default:
                    break;
            }
        }
    }
    
    private void handleInProgress() {
        
        output.writeNewLine("");
        Board board = game.getBoard();
        int size = board.getSize();
        int playerIndex = game.getCurrentPlayerIndex();
        Rules rules = game.getRules();

        output.write(board.print());
        Player currentPlayer = game.getPlayers().get(playerIndex);
        game.setCurrentPlayerIndex((playerIndex + 1)% game.getPlayers().size());
        Move move = currentPlayer.nextMove(board);
        game.getBoard().add(new Cell(move.getPos()/size, move.getPos()%size, currentPlayer.getMark()));
        if(rules.isGameOver(board)) {
            game.setStage(Stage.COMPLETED);
        }
    }

    private void handleCompleted() {
        
    }

}
