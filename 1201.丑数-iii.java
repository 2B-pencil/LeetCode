/*
 * @lc app=leetcode.cn id=1201 lang=java
 *
 * [1201] 丑数 III
 */

// @lc code=start
class NthUglyNumber {
    public int nthUglyNumber(int n, int a, int b, int c) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int x, y, z;
        x = y = z = 0;
        for (int i = 0; i <= n; i++) {
            dp[i] = Math.min((1 + x)*dp[x], Math.min((y + 1)*dp[y], (z + 1)*dp[z]));
            if (dp[i] == (1 + x) * dp[x]) ++x;
            if (dp[i] == (y + 1)*dp[y]) ++y;//此处分开写而不是写作 if() {...} else {...} 语句是为了防止出现重复值
            if (dp[i] == (z + 1)*dp[z]) ++z;
        }
        return dp[n];
    }
}
// @lc code=end

