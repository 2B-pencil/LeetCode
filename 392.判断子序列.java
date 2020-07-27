/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class IsSubsequence {

    /**
     * double pointer
     * check if {@code s} is subsequence of {@code t}.
     * @param s  
     * @param t 
     * @return if {@code s} is subsequence of {@code t} return {@code true}, if not return {@code false}
     */
    public boolean isSubsequence1(String s, String t) {
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        int index = 0;// s.charAt(index) 也可以
        for (int i = 0; i < chars_t.length && index < chars_s.length; i++) {
            if (chars_t[i] == chars_s[index]) index++;
        }
        return index==chars_s.length;
    }


    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            //index表示上一次查找的位置(第一次查找的时候为-1)，所以这里要从t的下标(index+1)开始查找
            index = t.indexOf(c, index + 1);
            //没找到，返回false
            if (index == -1)
                return false;
        }
        return true;
    }


    /**
     * Dynamic Programming
     * @param s
     * @param t
     * @return if {@code s} is subsequence of {@code t} return {@code true}, if not return {@code false}
     */
    public boolean isSubsequence3(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            //index表示上一次查找的位置(第一次查找的时候为-1)，所以这里要从t的下标(index+1)开始查找
            index = t.indexOf(c, index + 1);
            //没找到，返回false
            if (index == -1)
                return false;
        }
        return true;
    }

        // 编辑距离的子问题
        // 动态规划 
        // 状态的定义: dp[i][j] 表示 s 的子串[0, i - 1] 与 t 的子串[0, j - 1]是否为子序列
        // 状态转换方程: 
        // if s[i - 1] == t[j - 1], dp[i][j] = dp[i - 1][j - 1];
        // else dp[i][j] = dp[i][j - 1];
        // 初始化: dp[0][j] = true, dp[i][0] = false;
        // 循环: 双重循环, 从小到大遍历
        // 结果: dp[lenS][lenT];

        public boolean isSubsequence4(String s, String t) {
            if (s.length() == 0)
                return true;
            boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
            for (int i = 0; i < t.length(); i++) {
                dp[0][i] = true;
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[s.length()][t.length()];
        }



        // 动态规划II
        // 状态的定义: dp[i][j] 表示以字符串 t 中的字符t[i]为起始的子串中字符 j 首次出现的下标, 其中 j 表示小写字符'a' ~ 'z'
        // 状态转换方程:
        // if t[i] == j, dp[i][j] = i;
        // else dp[i][j] = dp[i + 1][j];
        // 循环: 两重循环, 第一重从大到小遍历, 第二重从小到大遍历
        // 结果: 不妨让 i 的取值可以到达 lenT 且 dp[lenT][j] 均为 lenT, 则指针一旦迭代到 lenT 且字符串 s 没被迭代完, 则返回 false, 否则, 返回 true
        public boolean isSubsequence5(String s, String t) {
            int n = s.length(), m = t.length();
    
            int[][] f = new int[m + 1][26];
            for (int i = 0; i < 26; i++) {
                f[m][i] = m;
            }
    
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < 26; j++) {
                    if (t.charAt(i) == j + 'a')
                        f[i][j] = i;
                    else
                        f[i][j] = f[i + 1][j];
                }
            }
            int add = 0;
            for (int i = 0; i < n; i++) {
                if (f[add][s.charAt(i) - 'a'] == m) {
                    return false;
                }
                add = f[add][s.charAt(i) - 'a'] + 1;
            }
            return true;
        }

}
// @lc code=end

