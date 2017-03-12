package interviews.twitter.board;

import interviews.twitter.Move;
import interviews.twitter.io.Printable;

import java.util.List;

public interface Board extends Printable {
    
    List<Cell> getUnOccupiedCells();
    
    List<Cell> getMarkedCells(Mark mark);
    
    List<Cell> getOccupiedCells();
    
    void reset();  
    
    int getSize();
    
    int getCapacity();
    
    int getPos(Cell cell);
    
    boolean isFull();
    
    boolean isValidMove(Move move);

    void add(Cell cell);
    
    List<Mark> getAvailableMarks();
}