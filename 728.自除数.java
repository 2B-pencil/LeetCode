import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=728 lang=java
 *
 * [728] 自除数
 */

// @lc code=start
import java.util.*;
class SelfDividingNumbers {
    
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) res.add(i);
        }
        return res;
    }

    /**
     * 通过转化为字符串判断是否为 {@code 自除数}
     * @param num
     * @return
     */
    public boolean isSelfDividingNumberByString(int num) {
        if (num < 10) return true;
        char[] chars = String.valueOf(num).toCharArray();
        for (char c : chars) {
            if (c == '0' || num % (c - '0') != 0) return false;
        }
        return true;
    }

    public boolean isSelfDividingNumber(int num) {
        if (num < 10) return true;
        int res = num;
        while (res > 0) {
            int tmp = res % 10;
            if (tmp == 0 || num % tmp != 0) return false;
            res /= 10;
        }
        return true;
    }

}
// @lc code=end

