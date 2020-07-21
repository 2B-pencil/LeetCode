/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome sl = new ValidPalindrome();
        String str = "leaadadel";
        System.out.println(sl.validPalindrome1(str));
        System.out.println(sl.validPalindrome(str));
    }

    public boolean validPalindrome1(String s) {
        if (s == null || s == "") return false;
        char[] chars = s.toCharArray();
        int lower = 0;
        int upper = chars.length - 1;
        while(lower < upper) {
            if (chars[lower] == chars[upper]) {
                lower++;
                upper--;
            } else {
                StringBuilder temp1 = new StringBuilder().append(s).deleteCharAt(lower);
                StringBuilder temp2 = new StringBuilder().append(s).deleteCharAt(upper);
                String str1 = temp1.toString();
                String str2 = temp2.toString();
                if (!(str1.equals(temp1.reverse().toString()) || str2.equals(temp2.reverse().toString()))) return false; 
                return true;

                //亦可用 isPalindrome 函数
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s == "") return false;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - 1 - i]) return false;
        }
        return true;
    }


    /**
     * 判断字符串的子串是否为回文字符串
     * @param s 字符串
     * @param i 起始索引
     * @param j 终点索引
     * @return {@code true}表示为回文字符串，{@code false}表非回文字符串
     */
    public boolean isPalindrome(String s, int i, int j) {
        char[] chars = s.toCharArray();
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if (s == null || s == "") return false;
        char[] chars = s.toCharArray();
        int lower = 0;
        int upper = chars.length - 1;
        while(lower < upper) {
            if (chars[lower++] != chars[upper--]) {
                return isPalindrome(chars, lower - 1, upper) || isPalindrome(chars, lower, upper + 1);
            }
        }
        return true;
    }
}
// @lc code=end

