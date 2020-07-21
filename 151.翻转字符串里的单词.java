/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
import java.util.*;
class ReverseWords {
    public static void main(String[] args) {
        ReverseWords st = new ReverseWords();
       String str = new String("      ");
       System.out.println("\"" + st.reverseWords(str)+ "\"");
       //st.reverseWords(str);
    }
    public String reverseWords1(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i > 0; i--) {
            if(!strs[i].equals(""))
                sb.append(strs[i] + " ");
        }
        sb.append(strs[0]);//第一个一定不是空格
        return sb.toString();
    }

    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

}
// @lc code=end

