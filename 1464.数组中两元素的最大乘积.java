/*
 * @lc app=leetcode.cn id=1464 lang=java
 *
 * [1464] 数组中两元素的最大乘积
 */

// @lc code=start
//import java.util.*;
class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        // Arrays.sort(nums);
        // return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
        int maxNum = 0;
        int secNum = 0;
        for(int i : nums)
            if(i > maxNum) {
                secNum = maxNum;
                maxNum = i;
            } else if (i > secNum) secNum = i;
        return (maxNum - 1) * (secNum - 1);
    }
}
// @lc code=end

