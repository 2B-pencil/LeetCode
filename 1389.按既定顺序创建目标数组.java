/*
 * @lc app=leetcode.cn id=1389 lang=java
 *
 * [1389] 按既定顺序创建目标数组
 */

// @lc code=start
import java.util.*;
class CreateTargetArray {
    public int[] createTargetArray1(int[] nums, int[] index) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            //由于 0 < index[i] < i, 故下式运算不会有异常 
            res.add(index[i], nums[i]);
        }
        int[] target = new int[nums.length];
        for (int i = 0; i < target.length; i++) {
            target[i] = res.get(i);
        }
        return target;
        //return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        for(int i=0; i < index.length; i++) {
            if (i > index[i]) {
                int t = nums[i];
                for(int j = i-1; j >= index[i]; j--) {
                    nums[j+1] = nums[j];
                }
                nums[index[i]] = t;
            }
        }
        return nums;
     }
}
// @lc code=end

