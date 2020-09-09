/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] data = new int[58];
        int res = 0;
        for (char i : s.toCharArray()) {
            data[i - 'A']++;
        }
        for (int i : data) {
            res += i - (i & 1);
            //if (i % 2 == 0) res += i;
        }
        return res < s.length() ? res + 1 : res;
    }
}
// @lc code=end

