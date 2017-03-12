package interviews.twitter.player.human;

import interviews.twitter.Move;
import interviews.twitter.RuleEngine;
import interviews.twitter.Rules;
import interviews.twitter.board.Board;
import interviews.twitter.board.TicTacToeBoard;
import interviews.twitter.board.Mark;
import interviews.twitter.board.XMark;
import interviews.twitter.io.ConsoleInputReader;
import interviews.twitter.io.ConsoleOutputWriter;
import interviews.twitter.io.InputReader;
import interviews.twitter.io.OutputWriter;
import interviews.twitter.player.Player;

import java.io.IOException;

public class HumanPlayer implements Player {

    private final Person person;

    private final Mark mark;

    private final InputReader input;

    private final OutputWriter output;

    private final Rules rules;

    public HumanPlayer(Person person, Mark mark, InputReader input, OutputWriter output, Rules rules) {
        this.person = person;
        this.mark = mark;
        this.input = input;
        this.output = output;
        this.rules = rules;
    }

    public Move nextMove(Board board) {
        while(true) {
            try {
                output.write(person.getName() + " enter move position to place " + mark.getMark() + " >> ");
                String text = this.input.readInput();
                int pos = Integer.parseInt(text);
                Move move = new Move(pos-1);
                if(this.rules.isValidMove(board, move)) {
                    return move;
                }
            } catch (NumberFormatException e) {
                output.writeNewLine("Not a valid number.");
            } catch (IOException e) {
                output.writeNewLine("Unable to read input, try again");
            }

            output.writeNewLine("Invalid Move");
        }
    }

    public Mark getMark() {
        return this.mark;
    }

    public Person getPerson() {
        return person;
    }

    public InputReader getInput() {
        return input;
    }

    public OutputWriter getOutput() {
        return output;
    }

    public static void main(String[] args) {
        Person person = new Person("Koundinya");
        HumanPlayer player = new HumanPlayer(person, new XMark(), new ConsoleInputReader(), new ConsoleOutputWriter(), new RuleEngine());
        player.nextMove(new TicTacToeBoard(3));
    }
}