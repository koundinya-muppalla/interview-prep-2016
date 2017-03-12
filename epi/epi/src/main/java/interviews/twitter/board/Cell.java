package interviews.twitter.board;


public class Cell {

    private Mark mark;
    
    private int row;

    private int col;
    
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Cell(int row, int col, Mark mark) {
        this.row = row;
        this.col = col;
        this.mark = mark;
    }
    
    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isOccupied() {
        return mark != null;
    }
}
