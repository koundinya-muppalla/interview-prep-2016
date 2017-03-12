package interviews.twitter;

import interviews.twitter.io.ConsoleInputReader;
import interviews.twitter.io.ConsoleOutputWriter;

public class MyTicTacToe {

    public static void main(String[] args) {
        Game game = new Game("Game1");
        game.setRules(new RuleEngine());
        GamePlay gamePlay = new TicTacToeGamePlay(new ConsoleInputReader(), new ConsoleOutputWriter(), game);
        gamePlay.play();
    }
}