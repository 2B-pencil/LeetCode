/*
 * @lc app=leetcode.cn id=1351 lang=java
 *
 * [1351] 统计有序矩阵中的负数
 */

// @lc code=start
class CountNegatives {
    /**
     * 无脑暴力
     * @param grid
     * @return
     */
    public int countNegatives1(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = grid[i][j] >= 0 ? res : ++ res;
            }
        }
        return res;
    }

    /**
     * 优化列，当一行中出现负数则本行中此列之后的数都为负
     * @param grid
     * @return
     */
    public int countNegatives2(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    res += grid[0].length - j;
                    break;
                }
            }
        }
        return res;
    }

    public int countNegatives3(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        int n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    res += (grid.length - i) * (n - j);
                    n = j;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 二分查找
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            int[] row = grid[i];
            if (row[n - 1] >= 0) continue; // 整行非负，跳过
            if (row[0] < 0) { // 整行负数
                count += (m - i) * n; // 后面的行也计入
                break; // 无需再继续遍历
            }
            // 当前行二分查找第一个小于 0 的数的索引
            count += n - binarySearch(row);
        }
        return count;
    }

    /**
     * 查找第一个负数的索引，如果没有则返回数组长度
     * @param nums
     * @return
     */
    public int binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < 0) {
                if (nums[mid - 1] >= 0) return mid;
                right = mid;
            }
            else left = mid + 1;
        }
        return left;
    }

}
// @lc code=end

