/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
import java.util.*;
class NthUglyNumber {
    public static void main(String[] args) {
    }

    /**
     * 暴力求解
     * @param n
     * @return 第 {@code n} 个丑数
     */
    public int nthUglyNumber1(int n) {
        if (n < 1) return -1;
        if (n < 7) return n;
        int nums = 6;
        int i = 7;
        for (; nums < n; i++) {
            if (isUgly(i)) nums++;
        }
        return i - 1;
    }

    /**
     * 判断输入的数是否为丑数
     * @param num
     * @return 丑数返回 {@code true} 否则返回 {@code false}
     */
    public boolean isUgly(int num) {
        while (num % 3 == 0 || num % 2 == 0 || num % 5 == 0) {
            if (num % 3 == 0 ) num /= 3;
            if (num % 2 == 0 ) num /= 2;
            if (num % 5 == 0 ) num /= 5;
        }
        return num == 1;
    }

    /**
     * 由于所求数字为参数{@code X, Y, Z} 三数组合的 {@code 2^X * 3^Y * 5^Z} 
     * 此函数采用求出所有满足以上要求的数并排序，最后去第 {@code n} 个值。
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n) {
        Set<Integer> list = new LinkedHashSet<>();
        for (long i = 1; i < Integer.MAX_VALUE; i*=2) {
            for (long j = i; j < Integer.MAX_VALUE; j*=3) {
                for (long j2 = j; j2 < Integer.MAX_VALUE; j2*=5) {
                    list.add((int)j2);
                }
            }
        }
        int[] nums = new int[list.size()];
        int i = 0;
        for (int j : list) {
            nums[i++] = j;
        }
        Arrays.sort(nums);
        return nums[n - 1];
    }

    /**
     * 动态规划，所求数字基本结构同上采用三指针求解
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n];
        dp[0] = 1;
        int x, y, z;
        x = y = z = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(2*dp[x], Math.min(3*dp[y], 5*dp[z]));
            if (dp[i] == 2*dp[x]) ++x;
            if (dp[i] == 3*dp[y]) ++y;//此处分开写而不是写作 if() {...} else {...} 语句是为了防止出现重复值
            if (dp[i] == 5*dp[z]) ++z;
        }
        return dp[n - 1];
    }

}
// @lc code=end

