package POJ.dfs;

import java.util.Scanner;

/**
 * 2386:Lake Counting
 * 总时间限制: 1000ms 内存限制: 65536kB
 * 描述
 * Due to recent rains, water has pooled in various places in Farmer John's field,
 * which is represented by a rectangle of N x M (1 <= N <= 100; 1 <= M <= 100) squares.
 * Each square contains either water ('W') or dry land ('.').
 * Farmer John would like to figure out how many ponds have formed in his field.
 * A pond is a connected set of squares with water in them,
 * where a square is considered adjacent to all eight of its neighbors.
 * <p>
 * Given a diagram of Farmer John's field, determine how many ponds he has.
 * 输入
 * * Line 1: Two space-separated integers: N and M
 * <p>
 * * Lines 2..N+1: M characters per line representing one row of Farmer John's field.
 * Each character is either 'W' or '.'. The characters do not have spaces between them.
 * 输出
 * * Line 1: The number of ponds in Farmer John's field.
 * 样例输入
 * 10 12
 * W........WW.
 * .WWW.....WWW
 * ....WW...WW.
 * .........WW.
 * .........W..
 * ..W......W..
 * .W.W.....WW.
 * W.W.W.....W.
 * .W.W......W.
 * ..W.......W.
 * 样例输出
 * 3
 * 提示
 * OUTPUT DETAILS:
 * <p>
 * There are three ponds: one in the upper left, one in the lower left,and one along the right side.
 */
public class LakeCounting {
    private static int N;
    private static int M;
    private static int res;
    private static char[][] field;

    /**
     * 方法：dfs，将遍历到的w变为.，继续dfs
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        N = cin.nextInt();
        M = cin.nextInt();
        field = new char[N][M + 1];
        cin.nextLine();//读取换行符
        for (int i = 0; i < N; i++) {
            field[i] = cin.nextLine().toCharArray();
        }
        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 'W') {
                    dfs(i, j);
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    public static void dfs(int x, int y) {
        field[x][y] = '.';

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx, ny = y + dy;
                if (nx > -1 && ny > -1 && nx < N && ny < M && field[nx][ny] == 'W') dfs(nx, ny);
            }
        }
    }
}
