/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心索引
 */

// @lc code=start
class PivotIndex {

    /**
     * 遍历比较
     * @param nums
     * @return
     */
    public int pivotIndex1(int[] nums) {
        if (nums == null || nums.length < 3) return -1;
        int len = nums.length;
        int[] res = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            res[i] = res[i - 1] + nums[i - 1];
        }
        for (int index = 0; index < len;) {
            if (res[index++] + res[index] == res[len]) return index - 1;
        }
        return -1;
    }

    /**
     * 空间优化
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 3) return -1;
        int sum = 0, cur = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == 2 * cur) return i;
            cur += nums[i];
        }
        return -1;
    }
}
// @lc code=end

