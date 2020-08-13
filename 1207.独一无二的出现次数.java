/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start
import java.util.*;
class UniqueOccurrences {
    /**
     * 
     * @param arr
     * @return boolean
     */
    public boolean uniqueOccurrences1(int[] arr) {
        int[] res = new int[2001];
        for (int i : arr) {
            res[i + 1000]++;
        }

        // 先排序从非零项开始判断前后两项是否相同即是否有重复值
        // Arrays.sort(res);
        // int index = rightBound(res, 0);
        // for (int i = index + 1; i < res.length - 1; i++) {
        //     if (res[i] == res[i + 1]) return false;
        // }
        HashSet<Integer> set = new HashSet<>();
        for(int c : res) {
            if(c != 0) {
                if(!set.add(c)) return false;
            }
        }
        return true;
    }

    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return (right < 0 || nums[right] != target) ? -1 : right; 
    }

    /**
     * 哈希表
     * @param arr
     * @return boolean
     */
    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> res = new HashMap<>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i : arr) {
            if (res.containsKey(i)) res.put(i, res.get(i) + 1);
            else res.put(i,1);
        }
        //采用set判断，亦可采用数组储存 map value 值后进行判断。
        for (int i : res.values()) {
            if (!set.add(i)) return false;
        }
        return true;
    }


    /**
     * 并不懂原理 -- 需学习
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.merge(i, 1, Integer::sum);
        
        int i1 = map.values().stream().distinct().mapToInt(i -> i).sum();
        int i2 = map.values().stream().mapToInt(i -> i).sum();
        return i1 == i2;
    }

}
// @lc code=end

