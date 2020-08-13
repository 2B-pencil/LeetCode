/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class RemoveDuplicates {
    public int removeDuplicates1(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 3) return nums.length;
        int res = 1;
        int times = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) {
               if (times < 2) {
                   nums[res] = nums[i];
                   res++;
                   times++;
               }
            } else {
                nums[res] = nums[i];
                times = 1;
                res++;
            }
            cur = nums[i];
        }
        return res;
    }

    public int removeDuplicates(int[] nums) {
        int res = 1;
        int j = 2;
        while (j < nums.length) {
            if (nums[j] == nums[res] && nums[res] == nums[res-1]) j++;
            else nums[++res] = nums[j++];
        }
        return res + 1;
    }
}
// @lc code=end

