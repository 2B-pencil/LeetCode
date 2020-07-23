import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class UniquePaths {

    public int uniquePaths1(int m, int n) {
        return dfs1(m, n);
    }

    /**
     * 递归
     * @param m
     * @param n
     * @return
     */
    public int dfs1(int m, int n) {
        if (m == 1 || n == 1) return 1;
        else return dfs1(m - 1, n) + dfs1(m, n - 1);
    }


    int[][] memo;
    public int uniquePaths2(int m, int n) {
        memo = new int[m][n];
        return dfs(m, n);
    }

    /**
     * 递归优化（包含记忆）
     * @param m
     * @param n
     * @return
     */
    public int dfs(int m, int n) {
        if (memo[m - 1][n - 1] > 0) return memo[m - 1][n - 1]; 
        if (m == 1 || n == 1) memo[m - 1][n - 1] = 1;
        else memo[m - 1][n - 1] = dfs(m - 1, n) + dfs(m, n - 1);
        return memo[m - 1][n - 1];
    }

    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {
        if (m == 0 || n == 0) return -1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 可旋转{@code45°}，看做杨辉三角的一部分处理
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

}
// @lc code=end

