package test;

/**
 * @author hjz
 * @version 1.0
 * @date 2021/3/31 23:09
 */
public class shit {
    public static void main(String[] args) {

        int[][] dp = new int[15][15];

        for (int i = 1; i <= 5; i++) //预处理
            dp[i][1] = dp[1][i] = 1;

        for (int i = 2; i <= 5; i++)
            for (int j = 2; j <= 5; j++)
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        System.out.println(dp[4][5]);
        System.out.println(f(4, 5));
    }

    static int f(int x, int y) {
        if (x == 1 && y == 1)
            return 1;
        if (x == 1)
            return f(x, y - 1);
        if (y == 1)
            return f(x - 1, y);

        return f(x - 1, y) + f(x, y - 1);
    }
}
