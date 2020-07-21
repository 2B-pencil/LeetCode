/*
 * @lc app=leetcode.cn id=464 lang=java
 *
 * [464] 我能赢吗
 */

// @lc code=start
import java.util.*;
class CanIWin {

    /**
     * 记忆化回溯（也称为递归+备忘录），自顶向下
     * 采用记忆化后的时间复杂度为O(2^n)(如果不进行记忆的话，时间复杂度将是O(n!))，可以理解为已经缩成了只有一个分支了
     * 然后为什么要进行记忆化：
     * 因为我们发现，例如[2,3]和[3,2]之后的玩家选择状态都是一样的，都是可以从除了2,3之外的
     * 数字进行选择，那么就可以对选择2和3后第一个玩家能不能赢进行记忆存储
     * 这里采用state[]数组存储每个数字是否都被选过，选过则记录为1，然后我们将state.toString()
     * 使得[2,3]和[3,2]它们的结果都是一样的"0011"，作为key，存储在HashMap中，value是选了2和3
     * 之后第一个玩家是否稳赢
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin1(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false; //1,..maxChoosable数列总和都比目标和小
        int[] state = new int[maxChoosableInteger + 1];  //state[1]=1表示1被选了

        return backtraceWitMemo1(state, desiredTotal, new HashMap<String, Boolean>());
    }

    private boolean backtraceWitMemo1(int[] state, int desiredTotal, HashMap<String, Boolean> map) {
        String key = Arrays.toString(state); //这里比较关键，如何表示这个唯一的状态，例如[2,3]和[3,2]都是"0011"，状态一样
        if (map.containsKey(key)) return map.get(key);  //如果已经记忆了这样下去的输赢结果,记忆是为了防止如[2,3]，[3,2]之后的[1,4,5,..]这个选择区间被重复计算

        for (int i = 1; i < state.length; i++){
            if (state[i] == 0){ //如果这个数字i还没有被选中
                state[i] = 1;
                //如果当前选了i已经赢了或者选了i还没赢但是后面对方选择输了
                if (desiredTotal - i <= 0 || !backtraceWitMemo1(state, desiredTotal - i, map)) {
                    map.put(key, true);
                    state[i] = 0; //在返回之前回溯
                    return true;
                }
                //如果不能赢也要记得回溯
                state[i] = 0;
            }
        }
        //如果都赢不了
        map.put(key, false);
        return false;
    }

    Boolean[] dp=null; //用Boolean比较方便判断是否记忆化

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //小于最大值先手可以直接拿
        if(desiredTotal<=maxChoosableInteger) return true;
        //前N项和还不够desiredTotal
        if((1+maxChoosableInteger)*(maxChoosableInteger)/2<desiredTotal) return false;
        //20位二进制 1<<21
        dp=new Boolean[1<<21];
        return dfs(maxChoosableInteger,desiredTotal,0);
    }
    
    public boolean dfs(int max,int total,int state){
        if(total<=0) return false; //前人已经拿完了
        if(dp[state]!=null){
            return dp[state];
        }
        for (int i=max;i>=1;i--) {
            //参数传递的，就不用回溯了，代码变的简洁多了
            if((state>>i&1)==0 && !dfs(max,total-i,state|(1<<i))){
                return dp[state]=true;
            }
        }
        return dp[state]=false;
    }
}
// @lc code=end

