/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
import java.util.*;
class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle gs = new PascalTriangle();
        System.out.println(gs.generate1(7));
        System.out.println();
        System.out.println(gs.generate(7));
    }
    public List<List<Integer>> generate1(int numRows) {
        if (numRows <= 0) return Collections.emptyList();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for (int i=0;i<numRows;i++){
            ArrayList<Integer> sub=new ArrayList<Integer>();
            for (int j=0;j<=i;j++){
            	//第一个位置和最后一个位置的元素为1
                if (j==0 || j==i){
                    sub.add(1);
                }else {
                    //上一行的元素进行相加
                    sub.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(sub);
        }
        return result;
    }

    //按定义推算
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return Collections.emptyList();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            result.add(getNext(result.get(i - 1)));
        }
        return result;
    }

    public List<Integer> getNext(List<Integer> cur) {
        int len = cur.size();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < len - 1; i++) {
            res.add(cur.get(i) + cur.get(i + 1));
        }
        res.add(1);
        return res;
    }
}
// @lc code=end

