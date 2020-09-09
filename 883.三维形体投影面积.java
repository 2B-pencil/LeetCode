/*
 * @lc app=leetcode.cn id=883 lang=java
 *
 * [883] 三维形体投影面积
 */

// @lc code=start
class ProjectionArea {
    public int projectionArea(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        //俯视 & 左视
        for (int[] is : grid) {
            for (int is2 : is) {
                if (is2 != 0) res++;
            }
            res += getMax(is);
        }

        //正视
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(grid[j][i], max); 
            }
            res += max;
        }
        return res;
    }

    public int getMax(int[] nums) {
        int res = nums[0];
        for (int i : nums) {
            res = res > i ? res : i;
        }
        return res;
    }

}
// @lc code=end

