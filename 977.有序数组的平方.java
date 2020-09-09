/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
import java.util.Arrays;
class SortedSquares {
    /**
     * 暴力
     * @param A
     * @return
     */
    public int[] sortedSquares1(int[] A) {
        int[] res = new int[A.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }

    /**
     * 双指针  由于原数组是有序数组
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int i = 0, j = A.length-1, k = A.length-1;
        while(i <= j){
            if(A[i] + A[j] < 0){
                res[k--] = A[i]*A[i++];
            }else{
                res[k--] = A[j]*A[j--];
            }
        }
        return res;
    }
}
// @lc code=end

