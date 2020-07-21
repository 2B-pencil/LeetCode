import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start
class Tribonacci {
    int[] memo;
    public static void main(String[] args) {
        
    }
    public int tribonacci(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dynamicProgramming(n);
    }

    //递归
    public int dfs1(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        return dfs1(n - 1) + dfs1(n - 2) + dfs1(n - 3);
    }

    //包含记忆的递归
    public int dfs(int n) {
        if (n < 2) memo[n] = n;
        if (n == 2) memo[n] = 1;
        if (memo[n] > -1) return memo[n];
        memo[n] = dfs(n - 1) + dfs (n - 2) + dfs(n - 3);
        return memo[n];
    }

    //动态规划-直接最优化-只记录三个值
    public int dynamicProgramming(int n) {
        int[] dp = new int[]{0, 1, 1};
        for (int i = 3; i <= n; i++) {
            int temp = dp[2];
            dp[2] = dp[0] + dp[1] + dp[2];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[2];
    }




}
// @lc code=end

