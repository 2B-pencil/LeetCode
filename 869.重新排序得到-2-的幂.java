/*
 * @lc app=leetcode.cn id=869 lang=java
 *
 * [869] 重新排序得到 2 的幂
 */

// @lc code=start
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        if ((N & N - 1) == 0) return true;
        Set<String> res = new HashSet<>();
        for (int i = 0; i < 31; i++) {
            char[] chars = String.valueOf(1<<i).toCharArray();
            Arrays.sort(chars);
            res.add(String.valueOf(chars));
        }
        char[] temp = String.valueOf(N).toCharArray();
        Arrays.sort(temp);
        return res.contains(String.valueOf(temp));
    }
}
// @lc code=end

