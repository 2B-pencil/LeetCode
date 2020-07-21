/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

// @lc code=start
import java.util.*;
class CountSmaller {
    public static void main(String[] args) {
        CountSmaller sl = new CountSmaller();
        int[] nums = new int[] {5,2,6,1};
        System.out.println(sl.countSmaller(nums));
        
    }
    //暴力--时间复杂度
    public List<Integer> countSmaller1(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<Integer>();
        int nnums = nums.length; 
        List<Integer>list = new LinkedList<>();
        for (int i = 0; i < nnums; i++) {
            int count = 0;
            for (int j = i + 1; j < nnums; j++) {
                if (nums[i] > nums[j]) count++;
            }
            list.add(count);
        }
        return list;
    }

    //排序后，二分查找左侧第一个下表--即小于此元素个数
    int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return (left >= nums.length || nums[left] != target) ? -1 : left; 
    }

    public List<Integer> countSmaller2(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<Integer>();
        int len = nums.length; 
        List<Integer>list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int[] subnums = Arrays.copyOfRange(nums, i, len);
            Arrays.sort(subnums);
            int temp = leftBound(subnums,nums[i]);
            list.add(temp == -1 ? 0 : temp);
        }
        return list;
    }

    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        if(len == 0) return res;
        //将nums中的元素排序，记录每个元素对应的索引
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < len; i++){
            set.add(nums[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for(Integer n : set){
            map.put(n, index);
            index++;
        }
        //利用索引更新并统计
        FenwickTree fenwickTree = new FenwickTree(len + 1);
        for(int i = len - 1; i >= 0; i--){
            index = map.get(nums[i]);
            //在索引位置添加计数1
            fenwickTree.update(index, 1);
            //统计比索引对应元素小的个数
            res.addFirst(fenwickTree.query(index - 1));
        }
        return res;
    }

    //线段树，O(logn)实现单点更新和前缀和计算
    private class FenwickTree {

        private int[] tree;
        private int len;

        public FenwickTree(int n) {
            this.len = n;
            tree = new int[n + 1];
        }
        //更新本节点和父节点
        public void update(int i, int delta) {
            while (i <= this.len) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }
        //求和，找到对应树的节点
        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }
        //计算第一个非0的位置，2的幂
        public int lowbit(int x) {
            return x & (-x);
        }
    }
}
// @lc code=end

