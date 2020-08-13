/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeightByString(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();   
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }


}
// @lc code=end

