/*
 * @lc app=leetcode.cn id=792 lang=java
 *
 * [792] 匹配子序列的单词数
 */

// @lc code=start
class NumMatchingSubseq {

    public static void main(String[] args) {
        NumMatchingSubseq sl = new NumMatchingSubseq();
        String S = "abcde";
        String[] words = new String[]{"a", "bb", "acd", "ace"};
        System.out.println(sl.numMatchingSubseq(S, words));

    }

    public int numMatchingSubseq1(String S, String[] words) {
        int res = 0;
        for (String string : words) {
            if(isSubsequence(string, S)) res++;
        }
        return res;
    }

    /**
     * 双指针--超时
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        int index = 0;// s.charAt(index) 也可以
        for (int i = 0; i < chars_t.length && index < chars_s.length; i++) {
            if (chars_t[i] == chars_s[index]) index++;
        }
        return index==chars_s.length;
    }

    /**
     * 动态规划
     * @param S
     * @param words
     * @return
     */
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        int m = S.length();
    
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (S.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }

        for (String word : words) {
            int add = 0;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                if (f[add][word.charAt(i) - 'a'] == m) {
                    res--;
                    break;
                };
                add = f[add][word.charAt(i) - 'a'] + 1;
            }
            res++;
        }
        return res;
    }

}
// @lc code=end

