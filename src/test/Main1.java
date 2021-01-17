package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main1 {
    private static final Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int t = cin.nextInt();
        int[][] plants = new int[n][m];
        for (int i = 0; i < t; i++) {
            int t1 = cin.nextInt();
            int t2 = cin.nextInt();
            plants[t1 - 1][t2 - 1] = 1;
            queue.offer(new Pair(t1 - 1, t2 - 1));
        }
        int k = cin.nextInt();
        int[] mx = {0, 0, -1, 1};
        int[] my = {1, -1, 0, 0};
        int num = t;
        for (; !queue.isEmpty() && k > 0; k--) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Pair poll = queue.poll();
                for (int v = 0; v < 4; v++) {
                    int x = poll.x + mx[v];
                    int y = poll.y + my[v];
                    if (x >= 0 && x < n && y >= 0 && y < m && plants[x][y] == 0) {
                        plants[x][y] = 1;
                        queue.offer(new Pair(x, y));
                        num++;
                    }
                }
            }
        }
        System.out.println(num);
    }
}
