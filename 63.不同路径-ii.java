/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class UniquePathsWithObstacles {
    public static void main(String[] args) {
        UniquePathsWithObstacles sl = new UniquePathsWithObstacles();
        int[][] obstacleGrid = new int[][]{
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(sl.uniquePathsWithObstacles(obstacleGrid));
    }

    int[][] memo;
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return -1;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m + 1][n + 1];
        return dfs(obstacleGrid, m, n);
    }

    /**
     * 动态规划--包含记忆
     * @param obstacleGrid
     * @return
     */
    public int dfs(int[][] obstacleGrid, int m , int n) {
        if (memo[m][n] > 0) return memo[m][n];
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        else if (m == 1 && n == 1) memo[m][n] = 1;
        else if (m == 1) memo[m][n] = dfs(obstacleGrid, m, n - 1);
        else if (n == 1) memo[m][n] = dfs(obstacleGrid, m - 1, n);
        else memo[m][n] = dfs(obstacleGrid, m - 1, n) + dfs(obstacleGrid, m, n - 1);
        return memo[m][n];
    }


    /**
     * 动态规划
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return -1;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if (i == 0 && j == 0) dp[i][j] = 1;
                else if (i == 0) dp[i][j] = dp[i][j - 1];
                else if (j == 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }


}
// @lc code=end

