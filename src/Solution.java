
public class Solution {
	private int N = -1;
    private char[][] board = null;
    private int[][] mark = null;
    private int r = 0;
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		for (int n : nums) {
			Solution s = new Solution();
			System.out.println(s.totalNQueens(n));
		}
		//na.printBIT();
	}
    
    public int totalNQueens(int n) {
        if (n < 1) {
            return r;
        }
        N = n;
        board = new char[N][N];
        mark = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.';
                mark[i][j] = -1;
            }
        }
        bt(0);
        return r;
    }
    
    private void bt(int curRow) {
        if (curRow >= N) {
            r++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (mark[curRow][i] == -1) {
                board[curRow][i] = 'Q';
                markAll(curRow, i);
                bt(curRow + 1);
                board[curRow][i] = '.';
                unmarkAll(curRow);
            }
        }
    }
    
    private void markAll(int x, int y) {
        mark[x][y] = x;
        // horizontal, vertical lines
        for (int i = 0; i < N; i++) {
            if (mark[x][i] == -1) {
                mark[x][i] = x;
            }
            if (mark[i][y] == -1) {
                mark[i][y] = x;
            }
        }
        // two diagonal lines
        for (int i = -N; i <= N; i++) {
            if (x + i < N && x + i >= 0 && y + i < N && y + i >= 0 && mark[x + i][y + i] == -1) {
                mark[x + i][y + i] = x;
            }
            if (x + i < N && x + i >= 0 && y - i < N && y - i >= 0 && mark[x + i][y - i] == -1) {
                mark[x + i][y - i] = x;
            }
        }
    }
    
    private void unmarkAll(int x) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mark[i][j] == x) {
                    mark[i][j] = -1;
                }
            }
        }
    }
}
