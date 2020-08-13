
/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class ReverseWords {

    public String reverseWords1(String s) {
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            res.append(new StringBuilder(strs[i]).reverse().toString() + " ") ;
        }
        return res.toString().trim();
    }

    /**
     * 自写翻转方法
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.length - 1; i++) {
            res.append(myReverse(strs[i]) + " ") ;
        }
        return res.append(myReverse(strs[strs.length - 1])).toString().trim();
    }

    public String myReverse(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return String.valueOf(chars);
    }

    /**
     * 1. 可以直接字符串转字符数组，遍历获取空的所在位置
     * 2. 用双指针法对中间字符进行翻转
     */
    public String reverseWords(String s) {
        char[] sentence = s.toCharArray();
        String res;
        int i = 0, j = 0;
        while(j < sentence.length) {
            //while(i < sentence.length && sentence[i] == ' ') ++i;
            while(j < sentence.length && sentence[j] != ' ') ++j;
            reverse(sentence, i, j - 1);
            i = ++j;
            //++j;
        }
        res = String.valueOf(sentence);
        return res;
    }
    
    private void reverse(char[] arr, int start, int end) {
        if (arr.length == 0) return;
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }
    }
}
// @lc code=end

