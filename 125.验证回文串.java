/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        IsPalindrome pd = new IsPalindrome();
        System.out.println(pd.isPalindrome(s));
    }
    /**
     * 先转为小写，再转字符数组并删除非字母和数字的元素
     * @param s
     * @return
     */
    public boolean isPalindrome1(String s) {
        if (s == null || s == "") return false;
        char[] chars = s.toLowerCase().toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (('a' <= c && c <= 'z') || '0' <= c&& c <= '9') sb.append(c);
        }
        String temp = sb.toString();

        /**
         * 一下和以上效果一项
         */
        //String actual = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        return temp.equals(sb.reverse().toString());
    }

    /**
     * double pointer 
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s == "") return false;
        char[] chars = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - 1 - i]) return false;
        }
        return true;
    }
}
// @lc code=end

