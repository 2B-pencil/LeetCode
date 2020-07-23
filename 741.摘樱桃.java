/*
 * @lc app=leetcode.cn id=741 lang=java
 *
 * [741] 摘樱桃
 */

// @lc code=start
import java.util.*;
class CherryPickup {
    public static void main(String[] args) {
        CherryPickup sl = new CherryPickup();
        int[][] grid = {
            {0,1,-1},
            {1,0,-1},
            {1,1,1}
        };
        System.out.println(sl.cherryPickup(grid));
    }

    /**
     * 单向待修改--不可行
     */
    int memo[][];
    public int cherryPickup1(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m + 1][n + 1];
        int value = dfs(grid, m, n) == -1 ? 0 : dfs(grid, m, n);//第一条路 
        //重置memo数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[m][n] = 0;
            }
        }
        value += dfs(grid, m, n) == -1 ? 0 : dfs(grid, m, n);//第二条路
        return value;

    }

    public int dfs(int[][] grid, int m, int n) {
        if (grid[m - 1][n - 1] == -1) return -1;
        if (memo[m][n] > 0) return memo[m][n];
        if (m == 1 && n == 1) {
            memo[1][1] = grid[0][0];
            grid[0][0] = 0;
            return memo[1][1];
        }
        if (m == 1) {
            if (grid[0][n - 1] == -1 || dfs(grid, m, n - 1) == -1) memo[m][n] = -1;
            else {
                memo[m][n] = dfs(grid, m, n - 1) + grid[0][n - 1];
                grid[0][n - 1] = 0;//会造成数据丢失
            }
        } 
        else if(n == 1) {
            if (grid[m - 1][0] == -1 || dfs(grid, m - 1, n) == -1) memo[m][n] = -1;
            else {
                memo[m][n] = dfs(grid, m - 1, n) + grid[m - 1][0];
                grid[m - 1][0] = 0;
            }
        }
        else {
            if (grid[m - 1][n - 1] == -1 || Math.max(dfs(grid, m - 1, n), dfs(grid, m, n - 1)) == -1) memo[m][n] = -1;
            else {
                memo[m][n] = grid[m - 1][n - 1] + Math.max(dfs(grid, m - 1, n), dfs(grid, m, n - 1));
                grid[m - 1][n - 1] = 0;
            }
        }
        // memo[m][n] = grid[m - 1][n - 1] == -1 || Math.max(dfs(grid, m - 1, n), dfs(grid, m, n - 1)) == -1 ?
        //  -1 : grid[m - 1][n - 1] + Math.max(dfs(grid, m - 1, n), dfs(grid, m, n - 1));
        return memo[m][n];
    }

    /**
     * 动态规划
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];
        for (int[] row: dp) Arrays.fill(row, Integer.MIN_VALUE);
        dp[0][0] = grid[0][0];

        for (int t = 1; t <= 2*N - 2; ++t) {
            int[][] dp2 = new int[N][N];
            for (int[] row: dp2) Arrays.fill(row, Integer.MIN_VALUE);

            for (int i = Math.max(0, t-(N-1)); i <= Math.min(N-1, t); ++i) {
                for (int j = Math.max(0, t-(N-1)); j <= Math.min(N-1, t); ++j) {
                    if (grid[i][t-i] == -1 || grid[j][t-j] == -1) continue;
                    int val = grid[i][t-i];
                    if (i != j) val += grid[j][t-j];
                    for (int pi = i-1; pi <= i; ++pi)
                        for (int pj = j-1; pj <= j; ++pj)
                            if (pi >= 0 && pj >= 0)
                                dp2[i][j] = Math.max(dp2[i][j], dp[pi][pj] + val);
                }
            }
            dp = dp2;
        }
        return Math.max(0, dp[N-1][N-1]);
    }
}
// @lc code=end

