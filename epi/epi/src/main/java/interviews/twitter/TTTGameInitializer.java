package interviews.twitter;

import java.io.IOException;
import java.util.Arrays;

import interviews.twitter.Game.Stage;
import interviews.twitter.board.Board;
import interviews.twitter.board.OMark;
import interviews.twitter.board.TicTacToeBoard;
import interviews.twitter.board.XMark;
import interviews.twitter.io.InputReader;
import interviews.twitter.io.OutputWriter;
import interviews.twitter.player.Player;
import interviews.twitter.player.computer.EasyAiPlayer;
import interviews.twitter.player.human.HumanPlayer;
import interviews.twitter.player.human.Person;

public class TTTGameInitializer implements GameInitializer {

    private final InputReader reader;

    private final OutputWriter writer;

    public TTTGameInitializer(InputReader input, OutputWriter output) {
        this.reader = input;
        this.writer = output;
    }

    public void initialize(Game game) {
        if(!game.getStage().equals(Game.Stage.NOT_STARTED)) {
            writer.writeNewLine("Game already initialized");
            return;
        }

        try {
            writer.writeNewLine(OutputMessages.WELCOME_MESSAGE);
            String name = requestResponse(OutputMessages.ASK_NAME);
            Person person1 = new Person(name);
            String sizeStr = requestResponse(OutputMessages.BOARD_SIZE);
            int size = Integer.parseInt(sizeStr);
            Board board = new TicTacToeBoard(size);
            game.setBoard(board);

            Player computerPlayer = new EasyAiPlayer("EasyAI", new OMark());
            Player humanPlayer = new HumanPlayer(person1, new XMark(), reader, writer, game.getRules());
            game.setPlayers(Arrays.asList(humanPlayer, computerPlayer));
            game.setCurrentPlayerIndex(0);
            game.setStage(Stage.IN_PROGRESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String requestResponse(String question) throws IOException {
        writer.write(question);
        return reader.readInput();
    }

}
