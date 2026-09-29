import java.util.Arrays;

class Solution {
    private int[][][] memo;
    private char[][] grid;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        // Early checks
        if ((m + n - 1) % 2 != 0) return false;
        if (grid[0][0] == ')') return false;
        if (grid[m - 1][n - 1] == '(') return false;
        
        // Memoization table: T[i][j][openCount]
        memo = new int[m][n][201];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        return solve(0, 0, 0);
    }
    
    private boolean solve(int i, int j, int openCount) {
        // Update openCount based on current cell
        if (grid[i][j] == '(') {
            openCount++;
        } else {
            openCount--;
        }
        
        // Prune immediately if balance goes negative
        if (openCount < 0) {
            return false;
        }
        
        // Base case: Reached bottom-right destination
        if (i == m - 1 && j == n - 1) {
            return openCount == 0;
        }
        
        // Check memoization table
        if (memo[i][j][openCount] != -1) {
            return memo[i][j][openCount] == 1;
        }
        
        // Try moving down
        if (i + 1 < m) {
            if (solve(i + 1, j, openCount)) {
                memo[i][j][openCount] = 1;
                return true;
            }
        }
        
        // Try moving right
        if (j + 1 < n) {
            if (solve(i, j + 1, openCount)) {
                memo[i][j][openCount] = 1;
                return true;
            }
        }
        
        memo[i][j][openCount] = 0; // false stored as 0
        return false;
    }
}