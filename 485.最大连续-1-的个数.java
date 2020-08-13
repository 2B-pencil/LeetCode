/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes1(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
          if(nums[i] == 1) {
            // Increment the count of 1's by one.
            count += 1;
          } else {
            // Find the maximum till now.
            maxCount = Math.max(maxCount, count);
            // Reset count of 1.
            count = 0;
          }
        }
        //compare the maxcount and last count
        return Math.max(maxCount, count);
      }

      public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        int maxSize = 0;
         
        //好像 while 效率比 for 高 可能是 for 进行了三步运算吧
        while(right < length){
            //当窗口中所有元素为 1 时，右指针向右移，扩大窗口。
            if (nums[right++] == 0){
                //当窗口中存在 0 时，计算连续序列长度，左指针指向右指针。
                maxSize = Math.max(maxSize, right - left - 1);
                left = right;
            }
        }
        // 因为最后一次连续序列在循环中无法比较，所以在循环外进行比较
        return Math.max(maxSize, right - left);
    }
}
// @lc code=end

