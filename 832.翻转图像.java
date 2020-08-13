/*
 * @lc app=leetcode.cn id=832 lang=java
 *
 * [832] 翻转图像
 */

// @lc code=start
class FlipAndInvertImage {
    /**
     * 在原始数组上求解
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A[0].length - 1;
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (n + 2) / 2; j++) {
                int temp = A[i][j];
                A[i][j] = 1 ^ A[i][n - j];
                A[i][n - j] = 1 ^ temp;
            }
        }
        return A;
    } 

    /**
     * 不改变原数组
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage2(int[][] A) {
        if (A == null) return new int[][]{};
        int m = A.length;
        int n = A[0].length - 1;
        int[][] res = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = n; j >= 0; j--) {
                res[i][n - j] = A[i][j] ^ 1;
            }
        }
        return res;
    } 
}
// @lc code=end

