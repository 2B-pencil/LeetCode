/*
 * @lc app=leetcode.cn id=553 lang=java
 *
 * [553] 最优除法
 */

// @lc code=start
class OptimalDivision {
    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        int len = nums.length;
        StringBuilder sb = new StringBuilder();
        if (len == 1)  sb.append(nums[0]);
        else if (len == 2) sb.append(nums[0] + "/" + nums[1]) ;
        else {
            sb.append(nums[0] + "/(");
            for (int i = 1; i < nums.length - 1; i++) {
                sb.append(nums[i] + "/");
            }
            sb.append(nums[nums.length - 1] + ")");
        }
        return sb.toString();
    }
}
// @lc code=end

