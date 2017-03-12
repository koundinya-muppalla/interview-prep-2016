package interviews.twitter.board;

import interviews.twitter.Move;
import interviews.twitter.io.ConsoleInputReader;
import interviews.twitter.io.ConsoleOutputWriter;
import interviews.twitter.io.InputReader;
import interviews.twitter.io.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeBoard implements Board {

    private final int size;

    private List<Cell> cells;

    public TicTacToeBoard(int size) {
        this.size = size;
        init();
    }

    private void init() {
        cells = new ArrayList<Cell>(size * size);

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                Cell cell = new Cell(i, j);
                cells.add(cell);
            }
        }
    }

    public List<Cell> getUnOccupiedCells() {
        List<Cell> unOccupied = new ArrayList<Cell>();
        for(Cell cell : cells) {
            if(!cell.isOccupied()) {
                unOccupied.add(cell);
            }
        }
        return unOccupied;
    }

    public List<Cell> getMarkedCells(Mark mark) {
        List<Cell> markedCells = new ArrayList<Cell>();
        for(Cell cell : cells) {
            if(cell.getMark() != null && cell.getMark().equals(mark)) {
                markedCells.add(cell);
            }
        }
        return markedCells;
    }

    public List<Cell> getOccupiedCells() {
        List<Cell> occupied = new ArrayList<Cell>();
        for(Cell cell : cells) {
            if(cell.isOccupied()) {
                occupied.add(cell);
            }
        }
        return occupied;
    }

    public void reset() {
        init();
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return size * size;
    }

    public int getPos(Cell cell) {
        if(cell == null) return -1;
        return cell.getRow() * size + cell.getCol();
    }

    public boolean isFull() {
        return getUnOccupiedCells().isEmpty();
    }

    public boolean isValidMove(Move move) {
        if(move == null) return false;
        if(move.getPos() < 0 || move.getPos() >= size * size) {
            return false;
        }
        List<Cell> occupied = getOccupiedCells();
        for(Cell cell : occupied) {
            if(getPos(cell) == move.getPos()) {
                return false;
            }
        }
        return true;
    }

    public void add(Cell cell) {
        int pos = getPos(cell);
        this.cells.set(pos, cell);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                Cell cell = cells.get(index(i, j));
                sb.append(cell.getMark() == null ? " " : cell.getMark().getMark());
                if(j != size - 1) {
                    sb.append("|");
                }
            }

            sb.append(String.format("%20s", ""));
            for(int j = 0; j < size; j++) {
                sb.append(index(i, j) + 1);
                if(j != size - 1) {
                    sb.append("|");
                }
            }
            sb.append("\n");            
        }
        return sb.toString();
    }

    private int index(int row, int col) {
        return size * row + col;
    }

    public static void main(String[] args) throws IOException {
        Board board = new TicTacToeBoard(3);
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        writer.write(board.print());
        while(true) {
            writer.write("Enter pos: ");
            String line = reader.readInput();
            int pos = Integer.parseInt(line)-1;
            board.add(new Cell(pos/3, pos%3, new XMark()));
            writer.writeNewLine(board.print());
        }
    }

    public List<Mark> getAvailableMarks() {
        return Arrays.asList(new XMark(), new OMark());
    }
}
