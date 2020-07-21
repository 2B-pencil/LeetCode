/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class SearchInsert {
    public static void main(String[] args) {
        // int[] nums = new int[]{1,3,4,5,7};
        // int target = 8;
        // System.out.println(searchInsert(nums, target));       
    }

    //暴力
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target)
                return i;
        }
        return nums.length;
    }


    //二分法
    public int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (nums[0] > target) return 0;
        if (nums[len - 1] < target) return len;
        int lower = 0;
        int upper = len - 1;
        while (upper >= lower) {
            int medium = lower + (upper - lower) / 2;
            if (nums[medium] == target) return medium;
            else if (nums[medium] > target) upper = medium - 1;
            else lower = medium + 1;
        }
        return lower;
    }
}
// @lc code=end

