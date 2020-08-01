/*
 * @lc app=leetcode.cn id=1450 lang=java
 *
 * [1450] 在既定时间做作业的学生人数
 */

// @lc code=start
class BusyStudent {
    public int busyStudent1(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < endTime.length; i++) {
            if (endTime[i] >= queryTime && startTime[i] <= queryTime) res++;
        }
        return res;
    }


    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        BIT bit = new BIT(1000);
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            bit.update(startTime[i], 1);
            bit.update(endTime[i] + 1, -1);
        }
        return bit.getPrefix(queryTime);
    }

    class BIT {
        int[] bit;
        int n;

        public BIT(int n) {
            this.n = n + 1;
            bit = new int[this.n];
        }

        public int lowBit(int i) {
            return i & (-i);
        }

        public void update(int i, int val) {
            while (i < n) {
                bit[i] += val;
                i += lowBit(i);
            }
        }

        public int getPrefix(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= lowBit(i);
            }
            return sum;
        }
    }
}
// @lc code=end

