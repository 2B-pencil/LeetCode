/*
 * @lc app=leetcode.cn id=1266 lang=java
 *
 * [1266] 访问所有点的最小时间
 */

// @lc code=start
class MinTimeToVisitAllPoints {

    /**
     * 必须按数组顺序访问
     * @param points
     * @return
     */
    public int minTimeToVisitAllPoints(int[][] points) {

        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            res += Math.max(Math.abs(points[i + 1][0] - points[i][0]), Math.abs(points[i + 1][1] - points[i][1]));
        }
        return res;
    }
}
// @lc code=end

