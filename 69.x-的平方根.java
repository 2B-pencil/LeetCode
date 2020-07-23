/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class MySqrt {

    /**
     * 二分法
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        int lower = 0;
        int upper = x;
        int ans = -1;
        while (lower <= upper) {
            int medium = lower + (upper - lower) / 2;
            if ((long)medium * medium <= x) {
                ans = medium;
                lower = medium + 1;
            }
            else {
                upper = medium - 1;
            }
        }
        return ans;
    }

    /**
     * 牛顿迭代
     * @param a
     * @return
     */
    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }
}
// @lc code=end

