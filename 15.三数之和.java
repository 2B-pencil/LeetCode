/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */
/*
首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
当 sum = 0 时，nums[L] = nums[L+1] 则会导致结果重复，应该跳过，L++
当 sum = 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
时间复杂度：O(n^2)，n为数组长度
*/
// @lc code=start
import java.util.*;
class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,2,-2,-5,-7};
        System.out.println(threeSum2(nums));
    }
    //暴力解法--超时
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3) {
           return Collections.emptyList(); 
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(temp);
                    } 
                }
            }
        }
        return new ArrayList<>(result);
    }

    //双指针
    public static List<List<Integer>> threeSum2(int[] nums) {
        if(nums == null || nums.length < 3) return Collections.emptyList();
        Set<List<Integer>> ans = new LinkedHashSet<>();
        int len = nums.length; 
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    List<Integer> temp = Arrays.asList(nums[i],nums[L],nums[R]);
                    ans.add(temp);
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }        
        return new ArrayList<>(ans);
    }


    public List<List<Integer>> twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return Collections.emptyList();
        Set<List<Integer>> res = new LinkedHashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                res.add(Arrays.asList(map.get(complement), i));
                //return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new ArrayList<>(res);
    }


    //利用twoSum
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        Set<List<Integer>> ans = new LinkedHashSet<>();
        int len = nums.length; 
        for (int j = 0; j < nums.length - 2; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) continue;
            for (var temp : twoSum(Arrays.copyOfRange(nums, j + 1, len), 0 -nums[j])) {
                ans.add(Arrays.asList(nums[j], nums[j + 1 + temp.get(0)], nums[j + 1 + temp.get(1)]));
            }
            // TwoSumSolution.twoSum(Arrays.copyOfRange(nums, j + 1, len), 0);
            // ans.addAll(TwoSumSolution.twoSum(Arrays.copyOfRange(nums, j + 1, len), 0)); 
        }
        return new ArrayList<>(ans);
    }

}
// @lc code=end

