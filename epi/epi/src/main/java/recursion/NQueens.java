package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static List<List<Integer>> solve(int n) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		solve(n, 0, new ArrayList<Integer>(), ret);
		return ret;
	}
	
	private static void solve(int n, int row, List<Integer> cols, List<List<Integer>> ret) {
		if(row == n) {
			ret.add(new ArrayList<Integer>(cols));
			return;
		}
		
		for(int col = 0; col < n; col++) {
			cols.add(col);
			if(isValid(cols)) {
				solve(n, row + 1, cols, ret);
			}
			cols.remove(cols.size() - 1);
		}
	}
	
	private static boolean isValid(List<Integer> cols) {
		int rows = cols.size() - 1;
		for(int i = 0; i < rows; i++) {
			
		}
		return true;
	}
	
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
	
	public static void main(String[] args) {
		int n = 4;
		List<int[][]> ret = solveNQueens(n);
		
		for(int[][] board : ret) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
}
