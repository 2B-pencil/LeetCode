/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class CountAndSay {
    String str;
    public static void main(String[] args) {
        CountAndSay sl = new CountAndSay();
        for (int i = 1; i < 10; i++) {
            System.out.println(sl.countAndSay(i));
        }   
    }
    public String countAndSay(int n) {
        if (n <= 0) return "";
        if (n == 1) return "1";
        str = new String("1");
        return count(n);

    }

    public String count(int n) {
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int count = 1;
                while (j + 1 < chars.length && chars[j] == chars[j + 1]) {
                    count++;
                    j++;
                }
                sb.append(count + Character.toString(chars[j]));
            }
            str = sb.toString();
        }
        return str;
    }


}
// @lc code=end

