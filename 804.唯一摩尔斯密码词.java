/*
 * @lc app=leetcode.cn id=804 lang=java
 *
 * [804] 唯一摩尔斯密码词
 */

// @lc code=start
import java.util.HashSet;
import java.util.Set;

class UniqueMorseRepresentations {

    /**
     * 使用Set集合， 摩斯密码也可使用字典记录
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) return 0;
        String[] MORSE = new String[] {
            ".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--","-.",
            "---",".--.","--.-",".-.","...","-","..-",
            "...-",".--","-..-","-.--","--.."
        };
        Set<String> res = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char ichar : word.toCharArray()) {
                sb.append(MORSE[ichar - 'a']);
            }
            res.add(sb.toString());
        }
        return res.size();
    } 
}
// @lc code=end

