package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hjz
 * @version 1.0
 * @date 2021/4/7 22:58
 */
public class Draft {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        m = m % n;
        cin.nextLine();
        int[] ints = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ints[i] = cin.nextInt();
        }

        if(n == 1) {
            System.out.print(ints[0]);
            return;
        }

        if(m == 0) {
            for (int i = 0; i < n - 1; i++) {
                System.out.print(ints[i] + " ");
            }
            System.out.print(ints[n - 1]);
            return;
        }

        int head = 0;
        int rear = m;
        int pre, next = 1, temp;

        while (head != rear) {
            int i = head;
            pre = ints[i];
            while (true) {
                temp = ints[(i + m) % n];
                ints[(i + m) % n] = pre;
                i = (i + m) % n;
                if (i == head) {
                    ints[head] = pre;
                    break;
                }
                pre = temp;
            }
            head = next;
            next++;
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.print(ints[n - 1]);
    }
}
