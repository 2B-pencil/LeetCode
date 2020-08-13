/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class RemoveElement {
    public int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[res++] = nums[i];
        }
        return res;
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int res = nums.length;
        while (i < res) {
            if (nums[i] == val) {
                nums[i] = nums[res - 1];
                // reduce array size by one
                res--;
            } else {
                i++;
            }
        }
        return res;
    }
}
// @lc code=end

