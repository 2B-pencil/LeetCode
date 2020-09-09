/*
 * @lc app=leetcode.cn id=1385 lang=java
 *
 * [1385] 两个数组间的距离值
 */

// @lc code=start
import java.util.Arrays;

class FindTheDistanceValue {
    /**
     * 暴力
     * @param arr1
     * @param arr2
     * @param d
     * @return
     */
    public int findTheDistanceValue1(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int i : arr1) {
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    res--;
                    break;
                }
            }
            res++;
        }
        return res;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int hi = arr2.length - 1;
        int count = 0;
        for(int i : arr1){
            int index = binarySearch(arr2, 0, hi, i);
            if(index == 0){
                if(Math.abs(arr2[index] - i) > d)
                    count++;
            } else if(index == hi + 1) {
                if(Math.abs(arr2[hi] - i) > d)
                    count++;
            } else {
                if(Math.abs(arr2[index] - i) > d && Math.abs(arr2[index - 1] - i) > d)
                    count++;
            }
        }
        return count;
    }

    private int binarySearch(int[] arr, int lo, int hi, int target){
        while(lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            if(arr[mid] < target) lo = mid + 1;
            else if(arr[mid] > target) hi = mid - 1;
            else return mid;
        }
        return lo;
    }
}
// @lc code=end

