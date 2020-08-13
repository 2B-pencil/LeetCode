/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Rob {
    /**
     * pre | cur | cur'(num)  其中，pre, cur, cur', 表示当前位置最大可得利益，num 表示此处的可偷取利益，
     * 则可知，{@code cur' = max(cur, pre + num)} 以此为转移方程求解
     * @param nums 
     * @return int
     */
    public int rob(int[] nums) {
        int res = 0;
        int pre = res;
        for (int num : nums) {
            int tmp = res;
            res = Math.max(pre + num, res);
            pre = tmp;
        }
        return res;
    }
}
// @lc code=end

