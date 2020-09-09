/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int pre = Integer.MIN_VALUE;
        int count = 0;
        for (int i : nums) {
            count = pre < i ? ++count : 1;
            pre = i;
            res = res > count ? res : count;
        }
        return res;
    }
}
// @lc code=end

