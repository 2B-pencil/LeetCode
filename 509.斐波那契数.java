import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class FibSolution {
    int[] memo;
    public static void main(String[] args) {
        FibSolution fs = new FibSolution();
        System.out.println(fs.fib(30));
        System.out.println(fs.dfs1(30));

    }
    public int fib(int N) {
        if (N < 0) return -1;
        memo = new int[N + 1];
        Arrays.fill(memo, -1);
        return dfs(N);
    }

    //动态规划
    public int dp(int N) {
        if (N <= 1) return N;
        int[] nums = new int[]{0,1};
        for (int i = 2; i <= N; i++) {
            //交换两个数的值method1
            // int temp = nums[1];
            // nums[1] = nums[1] + nums[0];
            // nums[0] = temp;

            //交换两个数的值method2
            nums[0] += nums[1];
            //交换
            nums[1] += nums[0];
            nums[0] = nums[1] - nums[0];
            nums[1] -= nums[0];
        }
        return nums[1];
    }

    //递归--存在重复计算
    public int dfs1(int n) {
        if (n < 2) return n;
        return dfs1(n - 1) + dfs1(n - 2);
    }

    //带记忆的递归
    public int dfs(int n) {
        if (n < 2) memo[n] = n;
        if (memo[n] >= 0) return memo[n];
        memo[n] = dfs(n - 1) + dfs(n - 2);
        return memo[n];
    }

}
// @lc code=end

