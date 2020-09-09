/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */

// @lc code=start
class RangeBitwiseAnd {
    /**
     * 暴力--遍历
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd1(int m, int n) {
        // if (m >= n) return 0;
        int res = m;
        while (m < n) {
            res &= (++m);
        }
        return res;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        int res = 0;
        while (m != n) {
            n >>= 1;
            m >>= 1;
            ++res;
        }
        return n << res;
    }

    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n &= (n - 1);
        }
        return n;
    }

}
// @lc code=end

