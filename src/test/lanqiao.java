package test;

/**
 * @author hjz
 * @version 1.0
 * @date 2021/3/31 23:29
 *
 *
 * 3.标题: 振兴中华
 *
 *     小明参加了学校的趣味运动会，其中的一个项目是：跳格子。
 *
 *     地上画着一些格子，每个格子里写一个字，如下所示：（也可参见p1.jpg）
 *
 * 从我做起振
 * 我做起振兴
 * 做起振兴中
 * 起振兴中华
 *
 *
 *     比赛时，先站在左上角的写着“从”字的格子里，可以横向或纵向跳到相邻的格子里，但不能跳到对角的格子或其它位置。一直要跳到“华”字结束。
 *
 *
 *     要求跳过的路线刚好构成“从我做起振兴中华”这句话。
 *
 *     请你帮助小明算一算他一共有多少种可能的跳跃路线呢？
 *
 * 答案是一个整数，请通过浏览器直接提交该数字。
 * 注意：不要提交解答过程，或其它辅助说明类的内容。
 */
public class lanqiao {
    static final int[] dx = {-1, 0, 0, 1};
    static final int[] dy = {0, 1, -1, 0};
    static final int[][] cn = {
            {0, 1, 2, 3, 4},
            {1, 2, 3, 4, 5},
            {2, 3, 4, 5, 6},
            {3, 4, 5, 6, 7}
    };
    static int sum = 0;

    public static void main(String[] args) {
        dfs(1, 1, 0);
        dfs(1, 0, 1);
        System.out.println(sum);
    }

    public static void dfs(int i, int nx, int ny) {
        if (i == 7) {
            sum++;
            return;
        }
        for (int j = 0; j < 4; j++) {
            int x = nx + dx[j];
            int y = ny + dy[j];
            if (x > -1 && x < 4 && y > -1 && y < 5 && cn[x][y] == i + 1) {
                dfs(i + 1, x, y);
            }
        }
    }
}
