import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1436 lang=java
 *
 * [1436] 旅行终点站
 */

// @lc code=start
import java.util.*;
class DestCity {
    public String destCity(List<List<String>> paths) {
        Map<String, String> res = new HashMap<>();
        for (List<String> list : paths) {
            res.put(list.get(0), list.get(1));
        }
        for (String str1 : res.values()) {
            if (!res.containsKey(str1)) return str1;
        }
        
        // for (String str : res.keySet()) {
        //     if (!res.containsKey(res.get(str))) return res.get(str);
        // }
        return "";
    }
}
// @lc code=end

