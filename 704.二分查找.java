/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Search {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (end >= start) {
            int middle = start + (end - start)/2;//防止溢出
            if (target == nums[middle]) {
                return middle;
            } else if (target< nums[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

