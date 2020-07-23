/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
import java.util.*;
class IsHappy {

    /**
     * 用 HashSet 检测循环
     * @param n 待求值
     * @return 是快乐数则返回{@code true}否则返回{@code false}
     */
    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;      
    }

    /**
     * 获取下一个数
     * @param n 原值
     * @return n 更新值
     */
    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }


    /**
     * 快慢指针法--链表找环问题
     * @param n 待求值
     * @return 是快乐数则返回{@code true}否则返回{@code false}
     */
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
// @lc code=end

