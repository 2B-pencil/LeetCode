/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class SearchRange {
    public static void main(String[] args) {
        SearchRange test = new SearchRange();
        int[] nums = new int[]{5, 7,7,8,8,10};
        int target = 8;
        System.out.println(test.searchRange(nums, target));
        
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1}; 
        return new int[] {leftBound(nums, target), rightBound(nums, target)};
    }

    int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return (left >= nums.length || nums[left] != target) ? -1 : left; 
    }

    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return (right < 0 || nums[right] != target) ? -1 : right; 
    }
}
// @lc code=end

