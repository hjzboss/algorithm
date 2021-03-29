package leetcode.DP;

import java.util.Scanner;

/**
 * @author hjz
 * @version 1.0
 * @date 2021/3/23 22:47
 */
public class Bag {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int K, V, N;
        K = cin.nextInt();
        V = cin.nextInt();
        N = cin.nextInt();
        int[] goods = new int[N];
        for (int i = 0; i < N; i++) {
            int temp = cin.nextInt();
            int value = cin.nextInt();
            goods[temp] = value;
        }


    }
}
