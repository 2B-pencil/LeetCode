/*
 * @lc app=leetcode.cn id=989 lang=java
 *
 * [989] 数组形式的整数加法
 */

// @lc code=start
import java.util.*;
class AddToArrayForm {
    public List<Integer> addToArrayForm1(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList<>();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }


    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        for(int i = A.length-1 ; i >= 0 || K > 0 ; i--){
            if(i >= 0)
                K += A[i]; 
            res.addFirst(K % 10);
            K = K/10; 
        }
        return res;
    }
}
// @lc code=end

