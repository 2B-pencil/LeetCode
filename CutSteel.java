public class CutSteel {
    public static void main(String[] args) {
        int[] p = new int[]{1,5,8,9,10,17,17,20,24,30};
        System.out.println(cut2(p,9000));
        System.out.println(buttom_up_cut(p,9000));
    }

    //递归
    public static int cut1 (int[] p, int n) {
        if (n == 0) return 0;
        int benefits = Integer.MIN_VALUE;
        for (int i = 1; i <= p.length && i <= n; i++) {
            benefits = Math.max(benefits, p[i -1] + cut1(p,n-i));
        }
        return benefits;
    }

    //自顶向下的备忘录法
    public static int cut2 (int[] p, int n) {
        if (n < 0) return  -1;
        if (n==0) return 0;
        int[] temp=new int[n +1];
        for (int i=0; i <= n; i++) temp[i]=-1;
        return calculate(p,n,temp);
    }

    public static int calculate (int[] p, int n, int[] temp) {
        if (temp[n] >= 0) return temp[n];
        int benefits = Integer.MIN_VALUE;
        if (n==0) benefits = 0;
        else {
            for (int i = 1; i <= p.length && i <= n; i++) {
                benefits = Math.max(benefits, p[i -1] + calculate(p,n-i,temp));
            }
        }
        temp[n] = benefits;
        return benefits;
    }

    //动态规划法
    public static int buttom_up_cut(int []dp, int n) {
        int []r=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            int q=-1;
            for(int j=1;j<=i&&j<=dp.length;j++)
                q=Math.max(q, dp[j-1]+r[i-j]);
            r[i]=q;
        }
        return r[n];
    }

}
