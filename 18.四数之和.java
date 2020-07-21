/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
import java.util.*;
class FourSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        System.out.println(fourSum2(nums,-11));
    }

    //暴力
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        if (nums == null || nums.length < 4) return Collections.emptyList();
        Arrays.sort(nums);
        Set<List<Integer>> value = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == 0) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            value.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(value);
    }

    //利用threeSum(nums)函数
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        if (nums == null || nums.length < 4) return Collections.emptyList();
        Arrays.sort(nums);
        Set<List<Integer>> ans = new LinkedHashSet<>();
        for (int w = 0; w < nums.length - 3; w++) {
            if (w > 0 && nums[w] == nums[w - 1]) continue;
            int[] subnums = Arrays.copyOfRange(nums, w + 1, nums.length);
            int len = subnums.length;
            for (int i = 0; i < len ; i++) {
                if(subnums[i] > Math.floor((target - nums[w])/3.0)) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                if(i > 0 && subnums[i] == subnums[i-1]) continue; // 去重
                int L = i+1;
                int R = len-1;
                while(L < R){
                    int sum = subnums[i] + subnums[L] + subnums[R] + nums[w];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(nums[w], subnums[i], subnums[L], subnums[R]);
                        ans.add(temp);
                        while (L<R && subnums[L] == subnums[L+1]) L++; // 去重
                        while (L<R && subnums[R] == subnums[R-1]) R--; // 去重
                        L++;
                        R--;
                    }
                    else if (sum < target) L++;
                    else if (sum > target) R--;
                }
            }        
        }
        return new ArrayList<>(ans);
    }

    //简化利用方法
    public static List<List<Integer>> fourSum3(int[] nums, int target) {
        if (nums == null || nums.length < 4) return Collections.emptyList();
        Arrays.sort(nums);
        int len = nums.length;
        Set<List<Integer>> ans = new LinkedHashSet<>();
        for (int w = 0; w < nums.length - 3; w++) {
            if (w > 0 && nums[w] == nums[w - 1]) continue;
            for (int i = w + 1; i < len - 2 ; i++) {
                if(nums[i] > Math.floor((target - nums[w])/3.0)) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                if(i > w + 1 && nums[i] == nums[i-1]) continue; // 去重
                int L = i+1;
                int R = len-1;
                while(L < R){
                    int sum = nums[i] + nums[L] + nums[R] + nums[w];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(nums[w], nums[i], nums[L], nums[R]);
                        ans.add(temp);
                        while (L<R && nums[L] == nums[L+1]) L++; // 去重
                        while (L<R && nums[R] == nums[R-1]) R--; // 去重
                        L++;
                        R--;
                    }
                    else if (sum < target) L++;
                    else if (sum > target) R--;
                }
            }        
        }
        return new ArrayList<>(ans);
    }

    public List<List<Integer>> fourSum(int[] nums,int target){
        /*定义一个返回值*/
        List<List<Integer>> result=new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length=nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for(int k=0;k<length-3;k++){
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for(int i=k+1;i<length-2;i++){
                /*当i的值与前面的值相等时忽略*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*定义指针j指向i+1*/
                int j=i+1;
                /*定义指针h指向数组末尾*/
                int h=length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                       j++;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

