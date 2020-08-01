/*
 * @lc app=leetcode.cn id=1313 lang=java
 *
 * [1313] 解压缩编码列表
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;
class DecompressRLElist {

    //利用List中转
    public int[] decompressRLElist1(int[] nums) {
        if (nums == null || nums.length < 2 || nums.length % 2 != 0) return new int[]{};
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = nums[i]; j > 0; j--) {
                res.add(nums[i + 1]);
            }
        }
        //List 转 数组
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    //直接求解
    public int[] decompressRLElist(int[] nums) {
        if (nums == null || nums.length < 2 || nums.length % 2 != 0) return new int[]{};
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int[] res = new int[len];
        int temp = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = nums[i]; j > 0; j--) {
                res[temp++] = nums[i + 1];
            }
        }
        return res;
    }



    //Java中List, Integer[], int[]的相互转换
    int[] data = {4, 5, 3, 6, 2, 5, 1};
 
    // int[] 转 List<Integer>
    List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());
    // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
    // 1.使用Arrays.stream将int[]转换成IntStream。
    // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
    // 3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。

    // int[] 转 Integer[]
    Integer[] integers1 = Arrays.stream(data).boxed().toArray(Integer[]::new);
    // 前两步同上，此时是Stream<Integer>。
    // 然后使用Stream的toArray，传入IntFunction<A[]> generator。
    // 这样就可以返回Integer数组。
    // 不然默认是Object[]。

    // List<Integer> 转 Integer[]
    Integer[] integers2 = list1.toArray(new Integer[0]);
    //  调用toArray。传入参数T[] a。这种用法是目前推荐的。
    // List<String>转String[]也同理。

    // List<Integer> 转 int[]
    int[] arr1 = list1.stream().mapToInt(Integer::valueOf).toArray();
    // 想要转换成int[]类型，就得先转成IntStream。
    // 这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
    // 而IntStream中默认toArray()转成int[]。

    // Integer[] 转 int[]
    int[] arr2 = Arrays.stream(integers1).mapToInt(Integer::valueOf).toArray();
    // 思路同上。先将Integer[]转成Stream<Integer>，再转成IntStream。

    // Integer[] 转 List<Integer>
    List<Integer> list2 = Arrays.asList(integers1);
    // 最简单的方式。String[]转List<String>也同理。
}
// @lc code=end

