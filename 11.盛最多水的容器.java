/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class MaxArea {
    /**
     * 暴力
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        if (height == null || height.length < 2) return 0;
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tmp = Math.min(height[j], height[i]) * (j - i);
                res = res > tmp ? res : tmp;
            }
        }
        return res;
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            // int temp = Math.min(height[left], height[right]) * (right - left);
            // res = res > temp ? res : temp;
            // if (height[left] > height[right]) right--; 
            // else left++;
            res = height[left] > height[right]
             ? Math.max(res, (right - left) * height[right--])
             : Math.max(res, (right - left) * height[left++]);
        }
        return res;
    }
}
// @lc code=end

