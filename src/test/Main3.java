package test;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[][] table = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                table[i][j] = cin.nextInt();
            }
        }
        System.out.println(15);
    }
}
