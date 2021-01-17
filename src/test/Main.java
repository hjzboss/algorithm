package test;

import java.util.Scanner;

/*
* 问题描述
　　小蓝有一张黑白图像，由 n * m 个像素组成，其中从上到下共 n 行，每行从左到右 m 列。每个像素由一个 0 到 255 之间的灰度值表示。
　　现在，小蓝准备对图像进行模糊操作，操作的方法为：
　　对于每个像素，将以它为中心 3 * 3 区域内的所有像素（可能是 9 个像素或少于 9 个像素）求和后除以这个范围内的像素个数（取下整），得到的值就是模糊后的结果。
　　请注意每个像素都要用原图中的灰度值计算求和。
输入格式
　　输入的第一行包含两个整数 n, m。
　　第 2 行到第 n + 1 行每行包含 m 个整数，表示每个像素的灰度值，相邻整数之间用一个空格分隔。
输出格式
　　输出 n 行，每行 m 个整数，相邻整数之间用空格分隔，表示模糊后的图像。
样例输入
3 4
0 0 0 255
0 0 255 0
0 30 255 255
样例输出
0 42 85 127
5 60 116 170
7 90 132 191
数据规模和约定
　　对于所有评测用例，1 <= n, m <= 100。
* */
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = cin.nextInt();
            }
        }
        int[] mx = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] my = {-1, 1, 0, -1, 1, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = arr[i][j];
                int num = 1;
                for (int k = 0; k < 8; k++) {
                    int x = mx[k] + i;
                    int y = my[k] + j;
                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        sum += arr[x][y];
                        num++;
                    }
                }
                int temp = sum / num;
                System.out.print(temp);
                if (j != m - 1) {
                    System.out.print(" ");
                }
            }
            if (i != n - 1) {
                System.out.println();
            }
        }
    }
}
