/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs sl = new ClimbStairs();
        System.out.println(sl.climbStairs(4));
    }
    public int climbStairs(int n) {
        if (n < 0) return -1;
        if (n <= 2) return n;
        int[] nums = new int[]{1,2};
        for (int i = 3; i <= n; i++) {
            //交换两个数的值method1
            // int temp = nums[1];
            // nums[1] = nums[1] + nums[0];
            // nums[0] = temp;

            //交换两个数的值method2
            nums[0] += nums[1];
            //交换
            nums[1] += nums[0];
            nums[0] = nums[1] - nums[0];
            nums[1] -= nums[0];
        }
        return nums[1];
    }
}
// @lc code=end

