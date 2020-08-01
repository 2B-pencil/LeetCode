/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class HammingDistance {
    public int hammingDistance(int x, int y) {
        //return Integer.toBinaryString(x ^ y).replace("0", "").length();
        return Integer.bitCount(x ^ y);
    }
}
// @lc code=end

