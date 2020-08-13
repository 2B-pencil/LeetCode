import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class MoveZeroes {
    public void moveZeroes1(int[] nums) {
		if(nums == null) return;
		//两个指针i和j
		int j = 0;
		for(int i = 0;i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            //如果右侧本来亦是0 这样是否表明有优化的空间---好像已经包含在内
			if(nums[i] != 0) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j++] = tmp;
            }
            //Arrays.fill(a, fromIndex, toIndex, val);
		}
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
		if(nums==null) {
			return;
		}
		//两个指针i和j
		int j = 0;
		for(int i = 0;i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            //如果右侧本来亦是0 这样是否表明有优化的空间---好像已经包含在内
			if(nums[i]!=0) {
				nums[j++] = nums[i];
            }
        }
        Arrays.fill(nums, j, nums.length, 0);
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int res = nums.length;
        while (i < res) {
            if (nums[i] == val) {
                nums[i] = nums[res - 1];
                // reduce array size by one
                res--;
            } else {
                i++;
            }
        }
        return res;
    }
}
// @lc code=end

