import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class MinCostClimbingStairs {
    int[] memo;
    public static void main(String[] args) {
        MinCostClimbingStairs sl = new MinCostClimbingStairs();
        int[] cost = new int[]{0,0,1,1,2,3};
        System.out.println(sl.minCostClimbingStairs(cost));
    }
    public int minCostClimbingStairs(int[] cost) {

        int len = cost.length;
        memo = new int[len + 1];
        Arrays.fill(memo, -1);
        return dfs(cost);
        //return dynamicProgramming(cost);
    }


    //递归
    public int dfs1(int[] cost) {
        if (cost == null || cost.length < 2) return -1;
        int len = cost.length;
        if (cost.length < 3) return Math.min(cost[0], cost[1]);
        if (len == 3) return cost[0] + cost[2] > cost[1] ? cost[1] : cost[0] + cost[2];
        return Math.min(cost[len - 1] + dfs1(Arrays.copyOfRange(cost, 0, len - 1)), 
                cost[len - 2] + dfs1(Arrays.copyOfRange(cost, 0, len - 2)));
    }

    //包含记忆的递归
    public int dfs(int[] cost) {
        if (cost == null || cost.length < 2) return -1;
        int len = cost.length;
        if (cost.length < 3) memo[len] = Math.min(cost[0], cost[1]);
        if (len == 3) memo[len] = cost[0] + cost[2] > cost[1] ? cost[1] : cost[0] + cost[2];
        if (memo[len] > -1) return memo[len];

        memo[len] = Math.min(cost[len - 1] + dfs(Arrays.copyOfRange(cost, 0, len - 1)), 
                cost[len - 2] + dfs(Arrays.copyOfRange(cost, 0, len - 2)));
        return memo[len];
    }

    //动态规划--空间优化后--从前向后
    public int dynamicProgramming(int[] cost) {
        if (cost == null || cost.length < 2) return -1;
        int len = cost.length;
        if (cost.length < 3) return Math.min(cost[0], cost[1]);
        if (len == 3) return cost[0] + cost[2] > cost[1] ? cost[1] : cost[0] + cost[2];
        int[] dp = new int[2];
        dp[0] = Math.min(cost[0], cost[1]);
        dp[1] = Math.min(cost[0] + cost[2], cost[1]);
        for (int i = 4; i <= len; i++) {
            int temp = dp[1];
            dp[1] = Math.min(cost[i - 1] + dp[1], cost[i - 2] + dp[0]);
            dp[0] = temp;
        }
        return dp[1];
    }

    //动态规划--从前向后
    public int minCostClimbingStairs2(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

}
// @lc code=end

