import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class MinPathSum {
    public static void main(String[] args) {
        MinPathSum sl = new MinPathSum();
        int[][] grid = new int[][]{{1,2},{5,6},{1,1}};
        System.out.println(sl.minPathSum(grid));
    }

    /**
     * 递归
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int row = grid.length - 1;
        int col = grid[0].length - 1;

        return dfs1(grid, row, col);
    }

    /**
     * 递归实现(deep-first-search)
     * @param grid
     * @param m 行
     * @param n 列
     * @return 最小路径值
     */
    public int dfs1(int[][] grid, int m, int n) {
        if (m == 0 && n == 0) return grid[0][0];
        if (m == 0) return grid[m][n] + dfs1(grid, m , n - 1);
        if (n == 0) return grid[m][n] + dfs1(grid, m - 1, n);
        return grid[m][n] + Math.min(dfs1(grid, m , n - 1), dfs1(grid, m - 1, n));
    }

    /**
     * 递归
     * @param grid
     * @return
     */
    int[][] memo;
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        memo = new int[row + 1][col + 1];    
        return dfs(grid, row, col);
    }

    /**
     * 递归实现(deep-first-search)包含记忆
     * @param grid
     * @param m 行
     * @param n 列
     * @return 最小路径值
     */
    public int dfs(int[][] grid, int m, int n) {
        if (m == 0 && n == 0) return grid[0][0];
        if (memo[m][n] > 0) return memo[m][n];
        if (m == 0) memo[m][n] = grid[m][n] + dfs(grid, m , n - 1);
        else if (n == 0) memo[m][n] = grid[m][n] + dfs(grid, m - 1, n);
        else memo[m][n] = grid[m][n] + Math.min(dfs(grid, m , n - 1), dfs(grid, m - 1, n));
        return memo[m][n];
    }


    /**
     * 动态规划
     * @param grid
     * @return
     */
    public int minPathSum3(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[1][1] = grid[0][0];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == 1 && j == 1) dp[i][j] = grid[0][0];
                else dp[i][j] = grid[i-1][j-1] + Math.min(dp[i-1][j], dp[i][j-1]);
            } 
        }
        return dp[m][n];
    }

    /**
     * 空间优化动态规划
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            } 
        }
        return grid[m - 1][n - 1];
    }


}
// @lc code=end

