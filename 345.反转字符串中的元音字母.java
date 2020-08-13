import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
import java.util.*;
class ReverseVowels {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String vowel = "AEIOUaeiou";
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (vowel.indexOf(chars[i]) != -1) index.add(i);
        }
        for (int i = 0; i < index.size() / 2; i++) {
            char temp = chars[index.get(i)];
            chars[index.get(i)] = chars[index.get(index.size() - i - 1)];
            chars[index.get(index.size() - i - 1)] = temp;
            
        }
        return String.valueOf(chars);

    }
}
// @lc code=end

