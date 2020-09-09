/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start


class RepeatedSubstringPattern {
    public static void main(String[] args) {
    }
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i != 0) continue;
            StringBuilder res = new StringBuilder();
            res.append(s.substring(i, s.length()));
            res.append(s.substring(0, i));
            if (res.toString().equals(s)) return true;
        }
        return false;
    }


    public boolean repeatedSubstringPattern2(String s) {
        StringBuilder res = new StringBuilder();
        res.append(s).append(s);
        return res.toString().substring(1, res.length() - 1).contains(s);
    }
}
// @lc code=end

