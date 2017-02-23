package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<int[][]> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<int[][]> ret = new ArrayList<int[][]>();
        solveNQueensUtil(board, 0, n, ret);
        return ret;
    }

    public static void solveNQueensUtil(int[][] board, int col, int n, List<int[][]> ret) {
        if(col == n) {
            int[][] temp = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    temp[i][j] = board[i][j];
                }
            }
            ret.add(temp);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(isSafe(board, i, col, n)) {
                board[i][col] = 1;
                solveNQueensUtil(board, col + 1, n, ret);
                board[i][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        for(int i = 0; i < col; i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }

        for (int i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (int i=row, j=col; j>=0 && i<n; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    public static int[][] nQueens(int n) {
        if(n <= 0) {
            return new int[0][0];
        }
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int[][] board = new int[n][n];
        solve(board, 0, n, new ArrayList<Integer>(), ret);
        int[][] retArr = new int[ret.size()][n];
        
        int i = 0;
        for(List<Integer> list : ret) {
            int j = 0;
            for(int index : list) {
                retArr[i][j++] = index + 1;
            }
            i++;
        }
        return retArr;
    }

    private static void solve(int[][] board, int col, int n, List<Integer> rows, List<List<Integer>> ret) {
        if(col == n) {
            ret.add(new ArrayList<Integer>(rows));
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(isSafe2(board, i, col, n)) {
                board[i][col] = 1;
                rows.add(i);
                solve(board, col+1, n, rows, ret);
                board[i][col] = 0;
                rows.remove(rows.size() - 1);
            }
        }
    }

    private static boolean isSafe2(int[][] board, int row, int col, int n) {
        for(int i = 0; i < col; i++) {
                if(board[row][i] == 1) {
                    return false;
                }
            }

            for (int i=row, j=col; i>=0 && j>=0; i--, j--)
                if (board[i][j] == 1)
                    return false;

            /* Check lower diagonal on left side */
            for (int i=row, j=col; j>=0 && i<n; i++, j--)
                if (board[i][j] == 1)
                    return false;

            return true;
    }
    public static void main(String[] args) {
        int n = 4;
        

        int[][] board = nQueens(4);
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println();
            System.out.println();
            System.out.println();
    }
}
