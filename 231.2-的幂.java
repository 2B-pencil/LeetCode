/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));

    }

    /**
     * 基于位运算
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n) {
        char[] chars = Integer.toBinaryString(n).replaceAll("0", "").toCharArray();
        return n > 0 && chars.length == 1 ? true : false;
    }

    /**
     * 基于位运算2
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
// @lc code=end

