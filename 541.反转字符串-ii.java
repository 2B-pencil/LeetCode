/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class ReverseStr {
    public String reverseStr1(String s, int k) {
        //if (s == null || k <= 0) return "";
        char[] chars = s.toCharArray();
        //if (s.length() <= k) return new StringBuilder(s).reverse().toString();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int pos = i + k - 1 < chars.length ? i + k - 1 : chars.length - 1;
            for (int j = 0; j < (pos - i + 1) / 2; j++) {
                char temp = chars[i + j];
                chars[i + j] = chars[pos - j];
                chars[pos - j] = temp;
            }
        }

        return new String(chars);
    }

    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        // 每2k个元素为一组进行反转
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = (i + k - 1 < n) ? i + k -1 : n - 1; //判断下标是否越界
            while (left < right) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        String str = new String(ch);
        return str;

    }
}
// @lc code=end

