import java.util.Arrays;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start
import java.util.*;
class KidsWithCandies {
    /**
     * 排序取最大值与各项与额外糖果之和比较
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        // int[] tempcan = candies.clone();
        // Arrays.sort(tempcan);
        // max = tempcan[tempcan.length - 1];
        for (int i : candies) {
            max = max >= i ? max : i;
        }
        // for(int i = 0 ; i < candies.length ; i++){
		// 	max = Math.max(max, candies[i]);
		// }
        List<Boolean> res = new LinkedList<>();
        for (int can : candies) {
            res.add(can + extraCandies >= max);
        }
        return res;
    }
}
// @lc code=end

