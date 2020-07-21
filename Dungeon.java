import java.util.Arrays;

public class Dungeon {

    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
        System.out.println(calculateMinimumHP2(dungeon));
        System.out.println(calculateMinimumHP3(dungeon));
    }

    //递归法
    public static int calculateMinimumHP(int[][] dungeon) {
        return calculate(dungeon, 0, 0);
    }

    public static int calculate(int[][] dungeon ,int i, int j) {
        int m = dungeon.length, n = dungeon[0].length;
        if (i == m - 1 && j == n - 1) return Math.max(1 - dungeon[i][j], 1);
        if (i == m - 1) return Math.max(calculate(dungeon,i,j+1) - dungeon[i][j], 1);
        if (j == n - 1) return Math.max(calculate(dungeon,i+1,j) - dungeon[i][j], 1);
        else return Math.max(Math.min(calculate(dungeon,i+1,j) - dungeon[i][j],
                calculate(dungeon,i,j + 1) - dungeon[i][j]), 1);
    }

    //自上而下备忘录法
    public static int calculateMinimumHP2(int[][] dungeon) {
        int[][] value = new int[dungeon.length + 1][dungeon[0].length + 1];
        return calculate2(dungeon, 0, 0,value);
    }

    public static int calculate2(int[][] dungeon ,int i, int j, int[][] value) {
        int res = 0;
        int m = dungeon.length, n = dungeon[0].length;
        if (i == m - 1 && j == n - 1) return Math.max(1 - dungeon[i][j], 1);
        if (value[i][j] > 0) return value[i][j];
        if (i == m - 1) res = Math.max(calculate2(dungeon,i,j+1, value) - dungeon[i][j], 1);
        else if (j == n - 1) res = Math.max(calculate2(dungeon,i+1,j, value) - dungeon[i][j], 1);
        else res = Math.max(Math.min(calculate2(dungeon,i+1,j, value) - dungeon[i][j],
                calculate2(dungeon,i,j + 1, value) - dungeon[i][j]), 1);
        value[i][j] = res;
        return res;
    }

    public static int calculateMinimumHP3(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n-1] = dp[m-1][n] = 1;
        for (int i = m-1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int temp = Math.min(dp[i +1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(temp - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
