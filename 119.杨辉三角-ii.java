/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
import java.util.*;
class PascalTriangle_II {
    public static void main(String[] args) {
        PascalTriangle_II sl = new PascalTriangle_II();
        System.out.println(sl.getRow(4));
    }
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(1);
            for (int j = i - 1 ; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
}
// @lc code=end

