/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class FindMinII {

    /**
     * 暴力 时间复杂度{@code O(n)}
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int len = nums.length;
        if (len == 1) return nums[0];
        int value = nums[0];
        for (int i : nums) {
            if (i >= value) value = i;
            if (i < value) return i;
        }
        return nums[0];
    }

    /**
     * 二分查找 时间复杂度{@code O(log2 n)}
     * @param nums
     * @return
     * @help https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/154-find-minimum-in-rotated-sorted-array-ii-by-jyd/
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int lower = 0;
        int upper = nums.length - 1;
        while (lower < upper) {
            int middle = lower + (upper - lower) / 2;
            if (nums[middle] == nums[upper]) {
                upper--;
            } else if (nums[middle] < nums[upper]) {
                // middle可能是最小值
                upper = middle;
            } else {
                // middle肯定不是最小值
                lower = middle + 1;
            }
        }
        return nums[lower];
    }

}
// @lc code=end

