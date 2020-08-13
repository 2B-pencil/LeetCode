/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 */

// @lc code=start
class FindDiagonalOrder {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int[] res = new FindDiagonalOrder().findDiagonalOrder(matrix);
        System.out.println(res);
    }

    /**
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};
        int level = 0, count = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        while (level < m + n - 1 && count < m * n) {
            int i = level < m ? level : m - 1;
            int j = level - i;
            while (i >= 0 && j < n) {
                res[count++] = matrix[i--][j++];
            }
            level++;
            if (level > m + n - 1) break;
            int j2 = level < n ? level : n - 1;
            int i2 = level - j2;
            while (j2 >= 0 && i2 < m) {
                res[count++] = matrix[i2++][j2--];
            }
            level++;
        }
        return res;
    }

    /**
     * 合并优化
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};
        int count = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        boolean isOddLevel = true;
        for (int level = 0; level < m + n - 1; level++) {
            int m_temp = isOddLevel ? m : n;
            int n_temp = isOddLevel ? n : m;

            int i = level < m_temp ? level : m_temp - 1;
            int j = level - i;

            while (i >= 0 && j < n_temp) {
                res[count++] = isOddLevel ? matrix[i--][j++] : matrix[j++][i--];
            }
            isOddLevel = !isOddLevel;
        }
        return res;
    }
}
// @lc code=end

